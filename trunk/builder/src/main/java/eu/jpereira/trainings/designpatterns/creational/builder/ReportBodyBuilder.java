package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;

public interface ReportBodyBuilder {
    public void setSaleEntry(SaleEntry saleEntry);
    public Report buildReport();
}