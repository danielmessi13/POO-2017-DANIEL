/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaquestao;

/**
 *
 * @author aluno
 */
public class TestarCirculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcao = 1;
        Circulo circulo1 = new Circulo(10);
        while (opcao != 0){
            opcao = circulo1.mostrar();
            if (opcao == 1){
                circulo1.calcularCircunferencia();
            }else if (opcao == 2){
                circulo1.areaCirculo();
            }else if (opcao == 3){
                circulo1.movimentarCirculo();
            }else if (opcao == 4){
                circulo1.alterarRaio();
            }else if (opcao == 5){
                circulo1.pertenceCirculo();
            }else if (opcao == 6){
                circulo1.choqueDeCirculo();
            }else{
                opcao = 0;
            }
    }
    }
    
}
