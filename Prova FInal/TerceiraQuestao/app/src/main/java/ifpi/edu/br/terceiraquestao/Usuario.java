package ifpi.edu.br.terceiraquestao;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by aluno on 14/03/18.
 */
@Entity
public class Usuario {
    @Id
    private long id;
    private String nome;

    public Usuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
