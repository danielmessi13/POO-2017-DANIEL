/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeiraquestao;
// AUMENTAR VELOCIDADEW DO VENTILADOR NO FRIO NAO DA CERTO
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Split {
    private String estado = "Off";
    private String modo = "Frio";
    private int ventilador = 0;
    private int temperatura = 24;
    
    
    
    int mostrar(){
        int opcao;
        opcao = Integer.valueOf(JOptionPane.showInputDialog("Estado: " + this.estado + "\nModo: " + this.modo + "\nVentilador: " + this.ventilador + "\nTemperatura: " + this.temperatura + "\n1 - Liga/Desliga Split\n2 - Alterar Temperatura\n3 - Alterar Modo\n4 - Mudar Velocidade Ventilador\n 0 - Guardar Controle"));
        return opcao;
    }
        
    void ligarDesligar(){
        if (this.estado == "On"){
            this.estado = "Off";
            JOptionPane.showMessageDialog(null, "Split Desligado");
        } else{
            this.estado = "On";
            JOptionPane.showMessageDialog(null, "Split Ligado");
        }
    }
    
    void temperaturaAlvo(){
        int valor;
        valor = Integer.valueOf(JOptionPane.showInputDialog("Temperatura desejada: "));
        
        if (this.estado == "On"){
            
            if (valor < 15){
                JOptionPane.showMessageDialog(null, "Valor alterado para temperatura minima (15° C)");
                valor = 15;
            }else if (valor > 24){
                JOptionPane.showMessageDialog(null, "Valor alterado para temperatura maxima (24° C)");
                valor = 24;
            }
            
            this.temperatura = valor;
        }
    }
    
    void alterarModo(){
        
        if(this.estado == "On"){
            if (this.modo == "Frio"){
                this.modo = "Ventilador";
                this.ventilador = 1;
            }else{
                this.modo = "Frio";
                this.ventilador = 0;
            }
        }
    }
    
    
    void velocidadeVentilador(){
        
        int valor;
        valor = Integer.valueOf(JOptionPane.showInputDialog("Velocidade desejada: "));
        
        if (this.estado == "On" && this.modo == "Ventilador"){
            if (valor < 1){
                JOptionPane.showMessageDialog(null, "Valor alterado para velocidade minima (1)");
                valor = 1;
            }else if (valor > 3){
                JOptionPane.showMessageDialog(null, "Valor alterado para velocidade maxima (3)");
                valor = 3;
            }
            
            this.ventilador = valor;
        }else if (this.modo == "Frio"){
            JOptionPane.showMessageDialog(null, "Altere para o modo ventilador para mudar a velocidade");
        }  
    } 
    
    
}

