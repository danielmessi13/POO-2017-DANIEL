/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.util.ArrayList;
import java.util.List;


public class Noticia implements Comparable<Noticia> {

    private int vizualizacoes;
    private String autor;
    private String titulo;
    private String estado;
    private String area;
    private Noticia noticiasAssociadas [] = new Noticia [10];
    private int pos;
    private String resumo;
    private String corpo;
    private String cor;
    private List<String> movimentacao = new ArrayList<>();
    

    public Noticia(String autor, String titulo, String area, String resumo, String corpo) {
        this.autor = autor;
        this.titulo = titulo;
        this.area = area;
        this.resumo = resumo;
        this.corpo  = corpo;
    }

    public void visualizar(){
        vizualizacoes++;
    }

    public int getVizualizacoes() {
        return vizualizacoes;
    }

    public void setVizualizacoes(int vizualizacoes) {
        this.vizualizacoes = vizualizacoes;
    }

    public void addMovimentacao(String movimentacao){
        this.movimentacao.add(movimentacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Noticia[] getNoticiasAssociadas() {
        return noticiasAssociadas;
    }

    public void setNoticiasAssociadas(Noticia[] noticiasAssociadas) {
        this.noticiasAssociadas = noticiasAssociadas;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<String> getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(List<String> movimentacao) {
        this.movimentacao = movimentacao;
    }
    

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    @Override
    public int compareTo(Noticia o) {
        if (this.getVizualizacoes() > o.getVizualizacoes()){
            return -1;
        }else if (this.getVizualizacoes() < o.getVizualizacoes()){
            return 1;
        }else{
            return 0;
        }
    }
}
