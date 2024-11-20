package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.*;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

public class DefaultBookstoreFacade implements BookstoreFacade {
    private BookDBService bookDBService;
    private CustomerDBService customerDBService;
    private CustomerNotificationService customerNotificationService;
    private OrderingService orderingService;
    private WharehouseService wharehouseService;

    public void setBookDBService(BookDBService bookDBService) {
        this.bookDBService = bookDBService;
    }
    public void setCustomerDBService(CustomerDBService customerDBService) {
        this.customerDBService = customerDBService;
    }
    public void setCustomerNotificationService(CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;
    }
    public void setOrderingService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }
    public void setWharehouseService(WharehouseService wharehouseService) {
        this.wharehouseService = wharehouseService;
    }

    @Override
    public void placeOrder(String customerId, String isbn) {
        Customer customer = customerDBService.findCustomerById(customerId);
        Book book = bookDBService.findBookByISBN(isbn);
        Order order = orderingService.createOrder(customer, book);
        DispatchReceipt dispatchReceipt = wharehouseService.dispatch(order);
        customerNotificationService.notifyClient(dispatchReceipt);
    }
}
