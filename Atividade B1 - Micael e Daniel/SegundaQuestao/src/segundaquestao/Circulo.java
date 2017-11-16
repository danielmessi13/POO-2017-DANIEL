/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaquestao;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Circulo {
    double raio;
    double diametro;
    int centroX = 0;
    int centroY = 0;

    public Circulo(double raio) {
        this.raio = raio;
        this.diametro = raio * 2;
    }
    
    int mostrar(){
        int opcao;
        opcao = Integer.valueOf(JOptionPane.showInputDialog("Raio: " + this.raio + "\nDiametro: " + this.diametro + "\nX: " + this.centroX + "\nY: " + this.centroY + "\n1 - Calcular Circunferencia\n2 - Calcular area\n3 - Movimentar circulo\n4 - Alterar raio\n5 - Verificar se ponto pertence ao circulos\n6- Ver se circulos se tocam\n 0- Sair"));
        return opcao;
    }
    
    double calcularCircunferencia(){
        double circunferencia = 2 * 3.14 * this.raio;
        JOptionPane.showMessageDialog(null, "Circunferencia: " + circunferencia);
        return circunferencia;
    }
    
    double areaCirculo(){
        double area = 3.14 * this.raio * this.raio;
        JOptionPane.showMessageDialog(null, "Area: " + area);
        return area;
    }
    
    void movimentarCirculo(){
        int opcao = 1;
        while (opcao != 0){
            opcao = Integer.valueOf(JOptionPane.showInputDialog("Movimentar para onde?\n 1- esquerda\n2- direita\n3- acima\n4- abaixo\n 0- Cancelar: "));
            if (opcao == 1){
                this.centroX--;
            }else if (opcao == 2){
                this.centroX++;
            }else if (opcao == 3){
                this.centroY++;
            }else if (opcao == 4){
                this.centroY--;
            }else{
                opcao = 0;
            }
        }
    }
    
    void alterarRaio(){
        int opcao = 1;
        while (opcao != 0){
            opcao = Integer.valueOf(JOptionPane.showInputDialog("1- Aumentar\n2- Diminuir\n 0- Cancelar): "));
            if (opcao == 1){
                this.raio++;
            }else if (opcao == 2){
                this.raio--;
            }else{
                opcao = 0;
            }
        }
    }
    
    private double distanciaPontos(int x, int y){
        double distancia = ((this.centroX - x) * (this.centroX - x) + (this.centroY - y) * (this.centroY - y)) * (1/2);       
        return distancia;
    }
    
    void pertenceCirculo(){
        int X = Integer.valueOf(JOptionPane.showInputDialog("Digite o X: "));
        int Y = Integer.valueOf(JOptionPane.showInputDialog("Digite o Y: "));
        double distancia = this.distanciaPontos(X, Y);
        if (distancia > this.raio){
            JOptionPane.showMessageDialog(null, "O ponto não pertence ao circulo.");
        }else{
            JOptionPane.showMessageDialog(null, "O ponto pertence ao circulo.");
        }
    }
    
    void choqueDeCirculo(){
        int X = Integer.valueOf(JOptionPane.showInputDialog("Digite o X: "));
        int Y = Integer.valueOf(JOptionPane.showInputDialog("Digite o Y: "));
        int raio = Integer.valueOf(JOptionPane.showInputDialog("Digite o Y: "));
        double distancia = distanciaPontos(X, Y);
        if (distancia == this.raio + raio){
            JOptionPane.showMessageDialog(null, "Tangente");
        }else if (distancia < this.raio + raio){
            JOptionPane.showMessageDialog(null, "Secante");
        } else{
            JOptionPane.showMessageDialog(null, "Externos");
        }
    }
    
}
