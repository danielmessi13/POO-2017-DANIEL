/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaparte;

/**
 *
 * @author aluno
 */
public class SegundaQuestao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0, number = 1;
        sum += number;
        number++;
        while (sum <= 1000000){
            sum += number;
            number++;
        }
    }
}