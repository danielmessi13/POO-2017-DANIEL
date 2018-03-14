package ifpi.edu.br.terceiraquestao;

import java.util.Calendar;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;


@Entity
public class Tarefa {
    private String titulo;
    private String descricao;
    private String data;
    private String estado;
    @Id private long id;
    ToOne<Usuario> dono;

    public Tarefa() {
    }

    public ToOne<Usuario> getDono() {
        return dono;
    }

    public void setDono(ToOne<Usuario> dono) {
        this.dono = dono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
