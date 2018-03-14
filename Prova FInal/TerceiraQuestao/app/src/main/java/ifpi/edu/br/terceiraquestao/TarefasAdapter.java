package ifpi.edu.br.terceiraquestao;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.objectbox.Box;


public class TarefasAdapter extends RecyclerView.Adapter<TarefasAdapter.ViewHolder> {

    private Context context;
    private List<Tarefa> tarefas;
    private Box<Tarefa> boxTarefas;


    public TarefasAdapter(Context context, List<Tarefa> tarefas, Box<Tarefa> boxTarefas){
        this.context = context;
        this.tarefas = tarefas;
        this.boxTarefas = boxTarefas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_cardview, parent,false);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Tarefa tarefa = this.tarefas.get(position);

        holder.tarefaNome.setText(tarefa.getTitulo());
        holder.tarefaEstado.setText(tarefa.getEstado());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AlterarActivity.class);
                intent.putExtra("tarefaId", boxTarefas.getId(tarefa));
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
                        if (menuItem.getItemId() == R.id.excluir){
                            TarefasAdapter.this.notifyItemRemoved(position);
                            boxTarefas.remove(tarefa.getId());
                            tarefas.remove(tarefa);
                            return true;
                        }else if (menuItem.getItemId() == R.id.change){
                            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle("Mudar estado");
                            String estado = tarefa.getEstado();
                            if (estado.equals("Fazendo")){
                                builder.setPositiveButton(R.string.terminar, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        tarefa.setEstado("Terminada");
                                        TarefasAdapter.this.notifyItemChanged(position);
                                        boxTarefas.put(tarefa);
                                    }
                                });

                            }else if (estado.equals("Iniciada")){
                                builder.setPositiveButton("Fazer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        tarefa.setEstado("Fazendo");
                                        TarefasAdapter.this.notifyItemChanged(position);
                                        boxTarefas.put(tarefa);
                                    }
                                });
                            }else if (estado.equals("A fazer")){
                                builder.setPositiveButton("Iniciar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        tarefa.setEstado("Iniciada");
                                        TarefasAdapter.this.notifyItemChanged(position);
                                        boxTarefas.put(tarefa);
                                    }
                                });

                            }else{
                                return false;
                            }

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
        return tarefas.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tarefaNome;
        protected TextView tarefaEstado;



        public ViewHolder(View itemView) {
            super(itemView);

            tarefaNome = itemView.findViewById(R.id.card_nome);
            tarefaEstado = itemView.findViewById(R.id.card_estado);
        }
    }
}
