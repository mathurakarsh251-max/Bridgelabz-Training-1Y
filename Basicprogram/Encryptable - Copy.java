interface Encryptable { }
class UserCredentials implements Encryptable {
    String username;
    String password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
} 
class PublicAnnouncement {
    String message = "Office is closed on Sunday.";
}
public class SecurityProcessor {
    public static void processData(Object data) {
        if (data instanceof Encryptable) {
            System.out.println("Processing: Sensitive data detected.");
            System.out.println("Action: Applying AES-256 encryption algorithm...");
        } else {
            System.out.println("Processing: Public data detected.");
            System.out.println("Action: Saving as plain text.");
        }
    }

    public static void main(String[] args) {
        UserCredentials secret = new UserCredentials("Akarsh", "P@ssw0rd123");
        PublicAnnouncement publicInfo = new PublicAnnouncement();

        System.out.println("--- Security Audit ---");
        processData(secret);     
        System.out.println();
        processData(publicInfo);  
    }
}