package model;

/**
 * Created by aluno on 14/12/17.
 */
public class Quadrado extends FiguraGeometrica {

    private double lado;

    @Override
    public double calcularArea(){
        return this.lado * this.lado;
    }

    @Override
    public double perimetro(double lado) {
        return 4 * this.lado;
    }

}
