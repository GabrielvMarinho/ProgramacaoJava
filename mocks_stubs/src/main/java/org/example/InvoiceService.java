package org.example;

public class InvoiceService {

    public boolean sendInvoice(String email, String invoiceDetails){
        if(email==null||email.isEmpty()||invoiceDetails==null||invoiceDetails.isEmpty()){
            return false;
        }
        System.out.println("Fatura enviada para"+email);
        return true;
    }


}
