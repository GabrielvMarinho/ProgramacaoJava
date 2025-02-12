public class PaymentService {

    public double calculateDiscount(CalculateDiscount cliente) {
        return cliente.calcular();
    }

    public void processPayment(String order, double amount) {
        System.out.println("Processando pagamento de R$" + amount + " para o pedido: " + order);
    }

    public void generateInvoice(String order) {
        System.out.println("Gerando fatura para o pedido: " + order);
    }

}
