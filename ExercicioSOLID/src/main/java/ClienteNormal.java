public class ClienteNormal implements CalculateDiscount {
    double total;
    public ClienteNormal(double total) {}

    @Override
    public double calcular() {
        if (total > 500) {
            return 0.1;
        }else{
            return 0;
        }
    }
}