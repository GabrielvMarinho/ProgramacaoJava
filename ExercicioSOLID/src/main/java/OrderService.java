import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<String> orders = new ArrayList<>();

    public void addOrder(String order) {
        orders.add(order);
        System.out.println("Pedido adicionado: " + order);
    }

    public void removeOrder(String order) {
        orders.remove(order);
        System.out.println("Pedido removido: " + order);
    }

    public void processOrders() {
        for (String order : orders) {
            System.out.println("Processando pedido: " + order);
        }
    }


}
