package com.example.wesleybrandolee.bibliotech.modelos;

import com.example.wesleybrandolee.bibliotech.modelos.Usuario;

import java.io.Serializable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;


@Entity
public class Livros{
    @Id
    private long id;
    private String autor;
    private String titulo;
    private String genero;
    private int paginaAtual;
    private int paginas;
    private int ano;
    private String tag;
    private String data;
    private String estado;
    private ToOne<Usuario> dono;
    private float rating;
    private String dataFinal;
    private ToMany <Capitulos> capitulos;

    public Livros(){
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public ToMany<Capitulos> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(ToMany<Capitulos> capitulos) {
        this.capitulos = capitulos;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public ToOne<Usuario> getDono() {
        return dono;
    }

    public void setDono(ToOne<Usuario> dono) {
        this.dono = dono;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
