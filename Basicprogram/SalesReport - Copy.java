package com.company.analytics.sales;

public class SalesReport {
    public void printRegionSales() {
        System.out.println("--- Regional Sales Data ---");
        System.out.println("North: ₹4.5 Lakhs | South: ₹6.2 Lakhs | West: ₹3.8 Lakhs");
    }
}
package com.company.analytics.hr;

public class EmployeeReport {
    public void printPerformance() {
        System.out.println("--- HR Performance Summary ---");
        System.out.println("Avg Rating: 4.2/5 | Top Performer: Akarsh (CSE Dept)");
    }
}
import com.company.analytics.sales.SalesReport;
import com.company.analytics.hr.EmployeeReport;

public class CompanyDashboard {
    public static void main(String[] args) {
        SalesReport sales = new SalesReport();
        EmployeeReport hr = new EmployeeReport();

        System.out.println("================================");
        System.out.println("  ANNUAL COMPANY ANALYTICS 2026 ");
        System.out.println("================================\n");

        sales.printRegionSales();
        System.out.println();
        hr.printPerformance();
        
        System.out.println("\nCombined Analytics Generated Successfully.");
    }
}