import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L; 
    String username;
    String email;

    public UserProfile(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
class TemporarySession {
    String sessionId;
}
public class BackupSystem {
    public static void runBackup(Object data) {
        if (data instanceof Serializable) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("backup.ser"))) {
                out.writeObject(data);
                System.out.println("Backup successful: Object state saved to storage.");
            } catch (IOException e) {
                System.out.println("Backup failed: " + e.getMessage());
            }
        } else {
            System.out.println("Backup rejected: This class is not marked for serialization.");
        }
    }

    public static void main(String[] args) {
        UserProfile myProfile = new UserProfile("Akarsh_CSE", "student@gla.edu");
        TemporarySession session = new TemporarySession();

        runBackup(myProfile);  
        runBackup(session);   
}