class BasicEmailSender {
    public void send(String msg) {
        System.out.println("Sending SMTP: " + msg);
    }
}

class SecureEmailSender extends BasicEmailSender {
    @Override
    public void send(String msg) {
        super.send(encrypt(msg));
    }
}
interface MessageSender {
    void send(String msg);
}

class SecureEmailSender implements MessageSender {
    @Override
    public void send(String msg) {
        System.out.println("Sending Encrypted: " + msg);
    }
}