public class Retangulo extends FormaGeometrica{

    private double altura;
    private double largura;

    Retangulo(double altura, double largura){
        this.altura = altura;
        this.largura = largura;

        if(!(altura>0)||!(largura>0)){
            throw new IllegalArgumentException("VALORES NÂO PODEM SER IGUAIS OU MENORES QUE 0");
        }
        if(altura==largura){
            throw new IllegalArgumentException("VALORES INSERIDOS NÃO CONDIZEM COM AS PROPRIEDADOS DE UM RETÂNGULO");
        }
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getLargura() {
        return largura;
    }

    public double calcularPerimetro(){
        double perimetro = altura*2+largura*2;
        return perimetro;
    }
    public double calcularArea(){
        double area = altura*largura;
        return area;
    }

    @Override
    public String toString() {
        return super.toString()+
                "altura=" + altura +
                ", largura=" + largura +
                '}';
    }
}
