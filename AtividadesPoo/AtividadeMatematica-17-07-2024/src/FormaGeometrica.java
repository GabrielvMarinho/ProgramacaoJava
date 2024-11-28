public abstract class FormaGeometrica {


    private double area;
    private double perimetro;

    public void setArea(double area) {
        this.area = area;
    }
    public double getArea() {
        return area;
    }
    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    public double getPerimetro() {
        return perimetro;
    }

    @Override
    public String toString() {
        return "area: " + area +
                "\nperimetro: " + perimetro;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();


}
