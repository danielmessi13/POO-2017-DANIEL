/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.*;


public class Editor extends Pessoa{
    
    private List<Noticia> ativas = new ArrayList<>();
    private String area;
    private boolean chefe;
    private Noticia principal;

    public Editor(String nome, String area, boolean chefe, String email, String senha) {
        super(nome, email, senha);
        this.area = area;
        this.chefe = chefe;
    }

    public Editor(String nome, String area, String email, String senha) {
        super(nome, email, senha);
        this.area = area;
    }
    
    
    boolean desativarNoticia(){
        // desativa a primeira noticia da list //
        if (!ativas.isEmpty()){
            Date data = new Date();
            String date = String.valueOf(data.getDay());
            ativas.get(0).addMovimentacao("Data: " + date + "Desativada por: " + this.getNome());
            ativas.remove(0);
            return true;
        }
        return false;
    }
    
    boolean aprovarNoticia(Noticia noticia){

        //seta noticia principal para usar
        this.principal = noticia;

        if (noticia.getArea().equals(this.area)){
            //outros criterios
            noticia.setEstado("Publicada");
            Date data = new Date();
            String date = String.valueOf(data.getDay());
            noticia.addMovimentacao("Data: " + date + "Aprovada por: " + this.getNome());
            ativas.add(noticia);
            return true;
        }return false;


    }

    public Noticia getPrincipal() {
        return principal;
    }

    public void setPrincipal(Noticia principal) {
        this.principal = principal;
    }

    public List<Noticia> getAtivas() {
        return ativas;
    }

    public void setAtivas(List<Noticia> ativas) {
        this.ativas = ativas;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isChefe() {
        return chefe;
    }

    public void setChefe(boolean chefe) {
        this.chefe = chefe;
    }
    
    
    
    
}
