public class Quadrado extends FormaGeometrica{

    private double lado;

    public void setLado(double lado){
        this.lado = lado;

    }
    public Quadrado(double lado){
        this.lado = lado;
        if(!(lado>0)){
            throw new IllegalArgumentException("VALORES NÂO PODEM SER IGUAIS OU MENORES QUE 0");
        }
    }

    public double getLado() {
        return lado;
    }

    public double calcularPerimetro(){
        double perimetro = lado*4;
        return perimetro;
    }
    public double calcularArea(){
        double area = lado*lado;
        return area;
    }

    @Override
    public String toString() {
        return super.toString() +
                "lado=" + lado +
                '}';
    }
}
