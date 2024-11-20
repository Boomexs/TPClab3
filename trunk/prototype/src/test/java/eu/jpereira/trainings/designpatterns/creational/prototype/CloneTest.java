package eu.jpereira.trainings.designpatterns.creational.prototype;

import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CannotHaveZeroPartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.CouldNotCloneLastObjectException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.NeedToPackLastVehicleException;
import eu.jpereira.trainings.designpatterns.creational.prototype.exception.VehicleDoesNotHavePartsException;
import eu.jpereira.trainings.designpatterns.creational.prototype.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CloneTest extends Vehicle {
    @Test
    public void testClone() throws CloneNotSupportedException, NeedToPackLastVehicleException, VehicleDoesNotHavePartsException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
        Client client = new Client();

        Properties tiresProps = new Properties();
        tiresProps.put(VehiclePartPropertiesEnumeration.SIZE,10);

        Vehicle vehicle = client.vehicleBuilder()
                .createVehicle()
                .with(new Tire(tiresProps)).times(1)
                .packIt();

        Vehicle clonedVehicle = (Vehicle) vehicle.clone();

        clonedVehicle.setParts(new ArrayList<VehiclePart>());

        List<VehiclePart> one_tire = vehicle.getParts(VehiclePartEnumeration.TIRE);

        List<VehiclePart> zero_tire = clonedVehicle.getParts(VehiclePartEnumeration.TIRE);

        assert(one_tire.size() == 1 && zero_tire.isEmpty());
    }
    @Test
    public void testIfClonedthrows() throws CloneNotSupportedException, NeedToPackLastVehicleException, VehicleDoesNotHavePartsException, CouldNotCloneLastObjectException, CannotHaveZeroPartsException {
        Client client = new Client();

        Properties tiresProps = new Properties();
        tiresProps.put(VehiclePartPropertiesEnumeration.SIZE,10);

        Vehicle vehicle = client.vehicleBuilder()
                .createVehicle()
                .with(new Tire(tiresProps)).times(1)
                .packIt();

        Vehicle clonedVehicle = (Vehicle) vehicle.clone();

        List<VehiclePart> one_tire = vehicle.getParts(VehiclePartEnumeration.TIRE);

        List<VehiclePart> zero_tire = clonedVehicle.getParts(VehiclePartEnumeration.TIRE);

        assert(one_tire.size() == 1 && zero_tire.size() == 1);
    }
}
