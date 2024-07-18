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
                "\nlado: " + lado;
    }
}
