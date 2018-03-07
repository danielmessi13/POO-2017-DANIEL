package com.example.wesleybrandolee.bibliotech.app;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.App;
import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.adapters.ListaLivrosAdapter;
import com.example.wesleybrandolee.bibliotech.modelos.Usuario;
import com.example.wesleybrandolee.bibliotech.modelos.Livros;
import com.example.wesleybrandolee.bibliotech.modelos.Livros_;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;

public class MainActivity extends AppCompatActivity{

    private Box<Livros> boxLivros;
    private Box<Usuario> usuarioBox;
    private RecyclerView rvLivros;
    private Usuario usuarioLogado;
    private ListaLivrosAdapter adapter;
    private CardView card;
    SharedPreferences preferences;
    private NavigationView navigationView;
    private TextView txtApelido;
    private TextView txtEmail;
    private int itemId;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoxStore store = ((App) getApplication()).getBoxStore();
        boxLivros = store.boxFor(Livros.class);
        usuarioBox = store.boxFor(Usuario.class);
        usuarioLogado = obterUsuarioLogado();

        setupViews();

        handlerIntent(getIntent());

        if (!logado()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                itemId = item.getItemId();
                switch (item.getItemId()) {
                    case R.id.menu_desejo:
                        List<Livros> desejo = boxLivros.query()
                                .equal(Livros_.donoId, obterUsuarioLogado().getId())
                                .contains(Livros_.estado, "Desejo ler")
                                .build()
                                .find();
                        adapter.setLivros(desejo);
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.menu_sair:
                        logout();
                        return true;
                    case R.id.menu_lendo:
                        List<Livros> lendo = boxLivros.query()
                                .equal(Livros_.donoId, obterUsuarioLogado().getId())
                                .contains(Livros_.estado, "Lendo")
                                .build()
                                .find();
                        adapter.setLivros(lendo);
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.menu_lido:
                        List<Livros> lido = boxLivros.query()
                                .equal(Livros_.donoId, obterUsuarioLogado().getId())
                                .contains(Livros_.estado, "Lido")
                                .build()
                                .find();
                        adapter.setLivros(lido);
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.menu_parados:
                        List<Livros> parados = boxLivros.query()
                                .equal(Livros_.donoId, obterUsuarioLogado().getId())
                                .contains(Livros_.estado, "Parado")
                                .build()
                                .find();
                        adapter.setLivros(parados);
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.menu_todos:
                        List<Livros> livros = boxLivros.query()
                                .equal(Livros_.donoId, obterUsuarioLogado().getId())
                                .build()
                                .find();
                        adapter.setLivros(livros);
                        adapter.notifyDataSetChanged();
                        return true;
                }
                return false;


            }
        });

        boolean firstTimeRun = getFirstTimeRun();

        if (firstTimeRun) {
            startActivity(new Intent(this, SplashActivity.class));
        }else{
            storeFirstTimeRun();
        }




    }

    private boolean getFirstTimeRun() {
        SharedPreferences prefs = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        return prefs.getBoolean("firstRun", true);
    }

    private void storeFirstTimeRun() {
        SharedPreferences prefs = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstRun", false);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.busca, menu);


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.busca).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }


    @Override
    protected void onResume() {

        super.onResume();

        List<Livros> livros = boxLivros.query()
                .equal(Livros_.donoId,usuarioLogado.getId())
                .build()
                .find();

        reloadData(livros);



        txtEmail.setText(usuarioLogado.getEmail());
        txtApelido.setText(usuarioLogado.getApelido());



    }


    private boolean logado() {
        preferences = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioId != -1;
    }


    private void reloadData(List<Livros> data) {

        final List<Livros> livros = data;
        adapter = new ListaLivrosAdapter(this, livros, boxLivros);
        rvLivros.setAdapter(adapter);
        rvLivros.setLayoutManager(new LinearLayoutManager(this));
        rvLivros.setHasFixedSize(true);

    }

    private void logout() {

        preferences.edit().clear();
        preferences.edit().apply();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }



    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handlerIntent(intent);
    }

    private void handlerIntent(Intent intent) {


        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            final QueryBuilder<Livros> queryBuilder = boxLivros.query();
            queryBuilder.contains(Livros_.tag, query);

            Query<Livros> queryLivros = queryBuilder.build();
            List<Livros> livros = queryLivros.find();

            adapter.setLivros(livros);
            adapter.notifyDataSetChanged();

            if (livros.size() == 0){
                Toast.makeText(this, "Não foram encontrados resultados", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Foram achados " + livros.size() + " livro(s)!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setupViews() {

        rvLivros = findViewById(R.id.rv_livros);
        card = findViewById(R.id.card);
        navigationView = findViewById(R.id.nav_view);

        View header = navigationView.getHeaderView(0);

        txtEmail = header.findViewById(R.id.email);
        txtApelido = header.findViewById(R.id.apelido);


    }



    public void novoLivro(View view) {
        startActivity(new Intent(this,AdicionarLivrosActivity.class));
    }


    //reclamação, se eu conseguir resolver, ai está a oportunidade
}
