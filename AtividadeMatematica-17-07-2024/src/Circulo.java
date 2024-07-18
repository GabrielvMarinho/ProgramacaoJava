public class Circulo extends FormaGeometrica{

    private double raio;
    private double diametro;

    public Circulo(double raio){
        this.raio = raio;
        this.diametro= raio*2;
        setArea(calcularArea());
        setPerimetro(calcularPerimetro());
        if(!(raio>0)){
            throw new IllegalArgumentException("VALORES NÂO PODEM SER IGUAIS OU MENORES QUE 0");
        }
    }
    public double getDiametro() {
        return diametro;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public double calcularPerimetro(){
        double perimetro = 3.14*raio*2;
        setPerimetro(perimetro);
        return perimetro;
    }
    public double calcularArea(){
        double area = 3.14*(raio*raio);
        setArea(area);
        return area;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nraio: " + raio +
                "\ndiametro: " + diametro;
    }
}
