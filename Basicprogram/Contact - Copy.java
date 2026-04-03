class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void display() {
        System.out.printf("Contact: %-15s | Phone: %s%n", name, phoneNumber);
    }
}

class BusinessContact extends Contact {
    String companyName;

    public BusinessContact(String name, String phoneNumber, String companyName) {
        super(name, phoneNumber);
        this.companyName = companyName;
    }
    @Override
    public void display() {
        String upperName = name.toUpperCase();
        System.out.printf("BUSINESS: %-14s | Phone: %-12s | Company: %s%n", 
                          upperName, phoneNumber, companyName);
    }
}

public class ContactApp {
    public static void main(String[] args) {
        Contact[] directory = {
            new Contact("Sarah Jenkins", "98765-43210"),
            new BusinessContact("Michael Scott", "12345-67890", "Dunder Mifflin"),
            new Contact("Jim Halpert", "555-0199")
        };

        System.out.println("--- Phone Directory ---");
        for (Contact c : directory) {
            c.display();
        }
    }
}