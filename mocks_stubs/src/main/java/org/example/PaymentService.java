package org.example;

public class PaymentService {
    public boolean processPayment(String accountNumber, double amount){
        if(accountNumber==null|| accountNumber.isEmpty()||amount<=0){
            return false;
        }
        return true;
    }

}
