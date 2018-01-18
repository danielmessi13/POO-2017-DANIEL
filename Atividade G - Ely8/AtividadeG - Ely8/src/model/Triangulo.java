package model;

/**
 * Created by aluno on 14/12/17.
 */
public class Triangulo extends FiguraGeometrica{

    private double base;
    private double altura;
    private double raio;

    @Override
    public double calcularArea() {
        return (this.base * this.altura) / 2;
    }

    @Override
    public double perimetro(double lado) {
        return 3 * this.lado;
    }
}
