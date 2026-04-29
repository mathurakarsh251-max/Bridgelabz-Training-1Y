interface ReportExporter {
    void exportToCSV(String data);
    void exportToPDF(String data);
    default void exportToJSON(String data) {
        System.out.println("Default JSON Export: Converting data to basic JSON format...");
        System.out.println("{ \"data\": \"" + data + "\", \"status\": \"default_export\" }");
    }
}
class FinanceReport implements ReportExporter {
    @Override
    public void exportToCSV(String data) {
        System.out.println("Finance: Exporting to CSV (Excel compatible).");
    }

    @Override
    public void exportToPDF(String data) {
        System.out.println("Finance: Exporting to PDF (Secure/Encrypted).");
    }
}
class TechInventoryReport implements ReportExporter {
    @Override
    public void exportToCSV(String data) {
        System.out.println("Inventory: Exporting simple CSV list.");
    }

    @Override
    public void exportToPDF(String data) {
        System.out.println("Inventory: Exporting visual PDF layout.");
    }

    @Override
    public void exportToJSON(String data) {
        System.out.println("Inventory: Exporting optimized JSON for API integration.");
    }
}
public class ExportSystem {
    public static void main(String[] args) {
        ReportExporter oldReport = new FinanceReport();
        ReportExporter newReport = new TechInventoryReport();

        String sampleData = "Quarterly Results";

        System.out.println("--- Testing Old Finance Report ---");
        oldReport.exportToCSV(sampleData);
        oldReport.exportToJSON(sampleData); 

        System.out.println("\n--- Testing New Inventory Report ---");
        newReport.exportToJSON(sampleData); 
    }
}