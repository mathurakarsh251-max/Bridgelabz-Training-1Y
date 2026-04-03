class BasicUser {
    void login() {
        System.out.println("Verifying credentials...");
    }
}

class AdminUser extends BasicUser {
    @Override
    void login() {
        super.login(); 
        System.out.println("Granting admin dashboard access..."); 
    }
}