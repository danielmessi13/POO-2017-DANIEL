package com.example.wesleybrandolee.bibliotech.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.app.InfoLivrosActivity;
import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.app.AdicionarLivrosActivity;
import com.example.wesleybrandolee.bibliotech.modelos.Livros;

import java.util.List;

import io.objectbox.Box;

public class ListaLivrosAdapter extends RecyclerView.Adapter<ListaLivrosAdapter.ViewHolder> {

    private  Context context;
    private List<Livros> livros;
    private Box<Livros> box;


    public ListaLivrosAdapter(Context context, List<Livros> livros, Box<Livros> box){
        this.context = context;
        this.livros = livros;
        this.box = box;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_cardview, parent,false);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        final Livros livro = this.livros.get(position);

        holder.tvLivroAutor.setHint(livro.getAutor());
        holder.tvLivroTitulo.setText(livro.getTitulo());
        holder.progressBar.setMax(livro.getPaginas());
        holder.progressBar.setProgress(livro.getPaginaAtual());
        holder.rating.setRating(livro.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InfoLivrosActivity.class);
                intent.putExtra("livroId", box.getId(livro));
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                final MenuInflater menuInflater = popupMenu.getMenuInflater();

                menuInflater.inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.btn_editar:
                                Intent intent = new Intent(context, AdicionarLivrosActivity.class);
                                intent.putExtra("livroId", box.getId(livro));
                                context.startActivity(intent);
                                break;
                            case R.id.btn_excluir:
                                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Excluir livro");

                                builder.setMessage("Deseja realmente deletar " + livro.getTitulo() + "?");

                                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        ListaLivrosAdapter.this.notifyItemRemoved(position);
                                        box.remove(livro.getId());
                                        livros.remove(livro);
                                        Toast.makeText(context, "Livro removido!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        builder.setCancelable(true);
                                    }
                                });

                                AlertDialog dialog = builder.create();
                                dialog.show();
                        }
                        return false;
                    }
                });
                popupMenu.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvLivroAutor;
        protected TextView tvLivroTitulo;
        protected ProgressBar progressBar;
        protected RatingBar rating;


        public ViewHolder(View itemView) {
            super(itemView);

            tvLivroAutor = itemView.findViewById(R.id.tv_autor);
            tvLivroTitulo = itemView.findViewById(R.id.tv_titulo);
            progressBar = itemView.findViewById(R.id.progress_card);
            rating = itemView.findViewById(R.id.rating_card);

        }

    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }
}
