public abstract class Triangulo extends FormaGeometrica{

    public static FormaGeometrica retornarTipoEspecifico(double hipotenusa, double cateto1, double cateto2){
        if(hipotenusa>=cateto1+cateto2||cateto1>=cateto2+hipotenusa||cateto2>=cateto1+hipotenusa){
            throw new IllegalArgumentException("VALORES INSERIDOS NÃO CONDIZEM COM AS PROPRIEDADOS DE UM TRIÂNGULO");
        }
        if(cateto1==cateto2 && cateto2==hipotenusa){
            FormaGeometrica equilatero = new Equilatero(hipotenusa);
            return equilatero;
        }
        if(cateto1==cateto2 || cateto1==hipotenusa || cateto2==hipotenusa) {
            FormaGeometrica isosceles = new Isosceles(hipotenusa, cateto1);
            return isosceles;
        }

        else{
            FormaGeometrica escaleno = new Escaleno(hipotenusa, cateto1, cateto2);
            return escaleno;
        }

    }

}
