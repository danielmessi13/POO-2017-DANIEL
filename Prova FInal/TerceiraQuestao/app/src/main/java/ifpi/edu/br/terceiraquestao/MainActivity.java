package ifpi.edu.br.terceiraquestao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    private Box<Usuario> usuarioBox;
    private Box<Tarefa> tarefaBox;
    private RecyclerView rv_tarefas;
    private TarefasAdapter adapter;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

        BoxStore store = ((App) getApplication()).getBoxStore();

        tarefaBox = store.boxFor(Tarefa.class);
        usuarioBox = store.boxFor(Usuario.class);

        usuarioLogado = obterUsuarioLogado();
    }

    private void setupViews() {
        rv_tarefas = findViewById(R.id.rv_tarefas);
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Tarefa> tarefas = tarefaBox.query()
                .equal(Tarefa_.donoId, usuarioLogado.getId())
                .build()
                .find();

        reloadData(tarefas);
    }



    private void reloadData(List<Tarefa> data) {

        final List<Tarefa> tarefas = data;
        adapter = new TarefasAdapter(this, tarefas, tarefaBox);
        rv_tarefas.setAdapter(adapter);
        rv_tarefas.setLayoutManager(new LinearLayoutManager(this));
        rv_tarefas.setHasFixedSize(true);

    }

    public void novoLivro(View view) {
        startActivity(new Intent(this, FormularioActivity.class));
    }
}
