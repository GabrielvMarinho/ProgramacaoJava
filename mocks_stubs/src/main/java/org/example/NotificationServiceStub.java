package org.example;

public class NotificationServiceStub {
    private EmailServiceStub emailServiceStub;
    public NotificationServiceStub(EmailServiceStub emailService){
        this.emailServiceStub = emailService;
    }
    public boolean notifyUser(String recipient, String notificationMessage){
        return emailServiceStub.sendEmail(recipient, notificationMessage);
    }
}
