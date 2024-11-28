public class Isosceles extends Triangulo{

    private double ladosIgual;
    private double ladoDiferente;

    public Isosceles(double ladosIgual, double ladoDiferente){
        this.ladoDiferente = ladoDiferente;
        this.ladosIgual = ladosIgual;
        setArea(calcularArea());
        setPerimetro(calcularPerimetro());
    }
    public void setLadoDiferente(double ladoDiferente) {
        this.ladoDiferente = ladoDiferente;
    }

    public double getLadoDiferente() {
        return ladoDiferente;
    }

    public void setLadosIgual(double ladosIgual) {
        this.ladosIgual = ladosIgual;
    }

    public double getLadosIgual() {
        return ladosIgual;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = ladoDiferente+2*ladosIgual;
        return 0;
    }

    @Override
    public double calcularArea() {
        double altura = Math.sqrt(ladosIgual*ladosIgual - (ladoDiferente*ladoDiferente)/4);
        double area = ladoDiferente*altura/2;
        return area;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nladosIgual: " + ladosIgual +
                "\nladoDiferente: " + ladoDiferente;
    }
}
