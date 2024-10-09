package org.example;

public class OrderService {
    private PaymentService paymentService;
    private InvoiceService invoiceService;

    public OrderService(PaymentService paymentService, InvoiceService invoiceService){
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
    }
    public boolean processOrder(String accountNumber, double amount, String email){
        boolean paymentPrecessed = paymentService.processPayment(accountNumber, amount);
        if(paymentPrecessed){
            return invoiceService.sendInvoice(email, "Faura para o valor de "+amount);
        }
        return false;
    }
}
