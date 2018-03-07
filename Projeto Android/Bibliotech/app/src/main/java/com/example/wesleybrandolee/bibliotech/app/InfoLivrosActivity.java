package com.example.wesleybrandolee.bibliotech.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.App;
import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.adapters.AdapterCapitulos;
import com.example.wesleybrandolee.bibliotech.modelos.Capitulos;
import com.example.wesleybrandolee.bibliotech.modelos.Capitulos_;
import com.example.wesleybrandolee.bibliotech.modelos.Livros;

import org.w3c.dom.Text;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;

public class InfoLivrosActivity extends AppCompatActivity {

    private TextView ano;
    private TextView autor;
    private android.support.v7.widget.Toolbar toolbar;
    private RatingBar bar;
    private Box<Livros> livrosBox;
    private Box<Capitulos> capitulosBox;
    private long id;
    private TextView txtDataFim;

    private Livros livro;

    private EditText capNome;
    private EditText capComent;

    private RecyclerView rvCapitulos;
    private AdapterCapitulos adapter;
    private TextView pagFim;
    private TextView genero;
    private TextView estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_livros);

        setupViews();

        Intent i = getIntent();
        id = i.getLongExtra("livroId",-1);

        BoxStore store = ((App) getApplication()).getBoxStore();

        livrosBox = store.boxFor(Livros.class);
        capitulosBox = store.boxFor(Capitulos.class);

        livro = livrosBox.get(id);

        inicilizadores();

    }

    private void inicilizadores() {
        ano.setHint("" + livro.getAno());
        autor.setHint(livro.getAutor());
        toolbar.setTitle(livro.getTitulo());
        bar.setRating(livro.getRating());
        txtDataFim.setText(livro.getData() + " / " + livro.getDataFinal());
        pagFim.setText(livro.getPaginaAtual() + " / " + livro.getPaginas());
        genero.setText(livro.getGenero());
        estado.setText(livro.getEstado());
    }

    @Override
    protected void onResume() {
        super.onResume();
        QueryBuilder<Capitulos> builder = capitulosBox.query();
        builder.equal(Capitulos_.donoId, livro.getId());
        List<Capitulos> capitulos = builder.build().find();
        reloadData(capitulos);
    }

    private void setupViews() {

        ano = findViewById(R.id.ano_livro);
        autor = findViewById(R.id.autor_livro);
        toolbar = findViewById(R.id.toolbar_info);
        bar = findViewById(R.id.rating_bar);
        rvCapitulos = findViewById(R.id.rv_cap);
        txtDataFim = findViewById(R.id.data_final);

        pagFim = findViewById(R.id.fim_pag);
        genero = findViewById(R.id.genero_info);
        estado = findViewById(R.id.estado);

    }


    private void reloadData(List<Capitulos> data) {

        final List<Capitulos> capitulos = data;
        adapter = new AdapterCapitulos(this,capitulos, capitulosBox);
        rvCapitulos.setAdapter(adapter);
        rvCapitulos.setLayoutManager(new LinearLayoutManager(this));
        rvCapitulos.setHasFixedSize(true);

    }

    public void novoCapitulo(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.alert_coment, null);

        capNome = inflate.findViewById(R.id.nome);
        capComent = inflate.findViewById(R.id.comentario);

        builder.setTitle("Adicionar capitulo");
        builder.setIcon(getResources().getDrawable(R.mipmap.ic_livros_foreground));
        builder.setView(inflate)
                .setPositiveButton("Concluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                final String nome = capNome.getText().toString();
                                final String comentario = capComent.getText().toString();

                                Capitulos capitulo = new Capitulos();
                                capitulo.setNome(nome);
                                capitulo.setComentario(comentario);
                                capitulo.getDono().setTargetId(livro.getId());
                                capitulosBox.put(capitulo);

                                QueryBuilder<Capitulos> builder = capitulosBox.query();
                                builder.equal(Capitulos_.donoId, livro.getId());
                                List<Capitulos> capitulos = builder.build().find();
                                reloadData(capitulos);

                                Toast.makeText(InfoLivrosActivity.this, "" + nome, Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.create();
        builder.show();

    }
}
