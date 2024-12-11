package org.example;

public class EmailServiceStub {
    public boolean sendEmail(String recipient, String message){
        return recipient!=null && !recipient.isEmpty()&&message!=null&&!message.isEmpty();
    }
}
