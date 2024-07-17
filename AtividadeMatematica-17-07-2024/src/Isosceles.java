public class Isosceles extends Triangulo{

    private double ladosIgual;
    private double ladoDiferente;

    public Isosceles(double ladosIgual, double ladoDiferente){
        this.ladoDiferente = ladoDiferente;
        this.ladosIgual = ladosIgual;
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
        //fazer a checagem//////////////////////////////////////////////////////////////////////////////////
        return 0;
    }

    @Override
    public double calcularArea() {
        //fazer a checagem//////////////////////////////////////////////////////////////////////////////////
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+
                "ladosIgual=" + ladosIgual +
                ", ladoDiferente=" + ladoDiferente +
                '}';
    }
}
