package eu.jpereira.trainings.designpatterns.creational.factorymethod;

interface ReportFactory {
    Report createReport();
}
class JSONReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new JSONReport();
    }
}

class XMLReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new XMLReport();
    }
}

class HTMLReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new HTMLReport();
    }
}

class PDFReportFactory implements ReportFactory {
    @Override
    public Report createReport() {
        return new PDFReport();
    }
}