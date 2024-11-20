package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

public interface ReportFactory {
    public ReportBody makeBody();
    public ReportHeader makeHeader();
    public ReportFooter makeFooter();
}

class XMLReportFactory implements ReportFactory {

    @Override
    public ReportBody makeBody() {
        return new XMLReportBody();
    }

    @Override
    public ReportHeader makeHeader() {
        return new XMLReportHeader();
    }

    @Override
    public ReportFooter makeFooter() {
        return new XMLReportFooter();
    }
}

class JSONReportFactory implements ReportFactory {

    @Override
    public ReportBody makeBody() {
        return new JSONReportBody();
    }

    @Override
    public ReportHeader makeHeader() {
        return new JSONReportHeader();
    }

    @Override
    public ReportFooter makeFooter() {
        return new JSONReportFooter();
    }
}