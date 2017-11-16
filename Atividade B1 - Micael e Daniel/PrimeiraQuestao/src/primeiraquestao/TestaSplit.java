/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeiraquestao;

/**
 *
 * @author aluno
 */
public class TestaSplit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcao = 1;
        Split split1 = new Split();
        while (opcao != 0){
            opcao = split1.mostrar();
            if (opcao == 1){
                split1.ligarDesligar();
            }else if (opcao == 2){
                split1.temperaturaAlvo();
            }else if (opcao == 3){
                split1.alterarModo();
            }else if (opcao == 4){
                split1.velocidadeVentilador();
            }
        }
    }
}
