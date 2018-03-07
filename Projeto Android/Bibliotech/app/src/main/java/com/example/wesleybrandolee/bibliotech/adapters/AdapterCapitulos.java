package com.example.wesleybrandolee.bibliotech.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.modelos.Capitulos;

import java.util.List;

import io.objectbox.Box;


public class AdapterCapitulos extends RecyclerView.Adapter<AdapterCapitulos.ViewHolder> {

    private Context context;
    private List<Capitulos> capitulos;
    private Box<Capitulos> box;

    public AdapterCapitulos(Context context, List<Capitulos> capitulos, Box<Capitulos> box) {
        this.context = context;
        this.capitulos = capitulos;
        this.box = box;
    }


    @Override
    public AdapterCapitulos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.card_capitulo, parent, false);

        return new AdapterCapitulos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCapitulos.ViewHolder holder, final int position) {
        final Capitulos cap = this.capitulos.get(position);

        holder.comentario.setHint(cap.getComentario());
        holder.nomeCapitulo.setText(cap.getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.comentario.getVisibility() == View.VISIBLE){
                    holder.comentario.setVisibility(View.GONE);
                    holder.imgCard.setImageResource(R.drawable.ic_open);
                }else{
                    holder.comentario.setVisibility(View.VISIBLE);
                    holder.imgCard.setImageResource(R.drawable.ic_close);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                final MenuInflater menuInflater = popupMenu.getMenuInflater();

                menuInflater.inflate(R.menu.menu_excluir,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.exclui:
                                AdapterCapitulos.this.notifyItemRemoved(position);
                                capitulos.remove(cap);
                                box.remove(cap.getId());
                                Toast.makeText(context, "Capitulo removido!", Toast.LENGTH_SHORT).show();
                                return true;
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
        return capitulos.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView comentario;
        protected TextView nomeCapitulo;
        protected ImageView imgCard;


        public ViewHolder(View itemView) {
            super(itemView);

            comentario = itemView.findViewById(R.id.comentario);
            nomeCapitulo = itemView.findViewById(R.id.nome_capitulo);
            imgCard = itemView.findViewById(R.id.image_card);
        }
    }

    public void setCapitulos(List<Capitulos> capitulos) {
        this.capitulos = capitulos;
    }

    // 2 = 2 elevado a 2 - 1 = 2
    // 3 = 3 elecado a 3 - 1 = 4

    // altura, 2 elevado a altura - 1
    // no minimo h + 1 nos
    // altura minima
}
