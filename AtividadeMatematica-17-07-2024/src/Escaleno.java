public class Escaleno extends Triangulo{

    private double hipotenusa;
    private double cateto1;
    private double cateto2;

    public Escaleno(double hipotenusa, double cateto1, double cateto2){
        this.hipotenusa = hipotenusa;
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
        setArea(calcularArea());
        setPerimetro(calcularPerimetro());
    }

    public void setCateto1(double cateto1) {
        this.cateto1 = cateto1;
    }

    public double getCateto1() {
        return cateto1;
    }

    public void setCateto2(double cateto2) {
        this.cateto2 = cateto2;
    }

    public double getCateto2() {
        return cateto2;
    }

    public void setHipotenusa(double hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    public double getHipotenusa() {
        return hipotenusa;
    }

    @Override
    public double calcularArea() {
        //fazer a checagem//////////////////////////////////////////////////////////////////////////////////
        return 0;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = hipotenusa+cateto2+cateto1;
        setPerimetro(perimetro);
        return perimetro;

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nhipotenusa: " + hipotenusa +
                "\ncateto1: " + cateto1 +
                "\ncateto2: " + cateto2;
    }
}
