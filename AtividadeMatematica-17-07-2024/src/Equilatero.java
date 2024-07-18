public class Equilatero extends Triangulo{

    private double lado;

    public Equilatero(double lado){
        this.lado = lado;
        setArea(calcularArea());
        setPerimetro(calcularPerimetro());
    }
    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double calcularPerimetro() {
        double area = (Math.sqrt(3)/4)*(lado*lado);
        return 0;
    }
    @Override
    public double calcularArea() {
        double perimetro = lado*3;
        return perimetro;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nlado: " + lado;
    }
}
