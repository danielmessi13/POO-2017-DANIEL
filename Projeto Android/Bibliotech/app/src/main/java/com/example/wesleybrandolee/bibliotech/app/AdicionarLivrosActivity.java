package com.example.wesleybrandolee.bibliotech.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleybrandolee.bibliotech.App;
import com.example.wesleybrandolee.bibliotech.R;
import com.example.wesleybrandolee.bibliotech.modelos.Usuario;
import com.example.wesleybrandolee.bibliotech.modelos.Livros;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.objectbox.Box;

public class AdicionarLivrosActivity extends AppCompatActivity {

    private EditText textTitulo;
    private EditText textAno;
    private EditText textGenero;
    private EditText textAutor;
    private EditText textTag;
    private EditText textPag;
    private EditText textPagAtual;

    private TextView editData;
    private int mYear, mMonth, mDay;

    private TextView editDataFinal;
    private int fimYear, fimMonth, fimDay;

    private RadioGroup radioGroup;
    private Switch tag;
    private LinearLayout linear_tag;

    private RadioButton lendo;
    private RadioButton lido ;
    private RadioButton parado ;
    private RadioButton desejo ;

    private Calendar calendar;
    private RatingBar ratingBar;



    private Calendar date_final;
    private Calendar date_inicial;


    private Livros livro;
    private Box<Livros> livrosBox;
    private Box<Usuario> usuarioBox;
    private Usuario usuarioLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_livros);

        setupView();

        livrosBox = ((App)getApplication()).getBoxStore().boxFor(Livros.class);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogado = obterUsuarioLogado();

        Intent intent = getIntent();
        long livroId = intent.getLongExtra("livroId",-1);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                livro.setRating(v);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (lido.isChecked()) {
                    ratingBar.setVisibility(View.VISIBLE);
                    ratingBar.isIndicator();

                }else{
                    ratingBar.setVisibility(View.GONE);
                }
            }
        });

        editData.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        editDataFinal.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));


        if (livroId == -1){
            livro = new Livros();
        }else{
            livro = livrosBox.get(livroId);
            this.setTitle("Editar");
            preencher(livro);
        }



    }

    public Calendar getData(String sData){
        Calendar data = new GregorianCalendar();

        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            data.setTime(sd.parse(sData));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("bibliotech.file", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }

    private void preencher(Livros livro){

        textTitulo.setText(livro.getTitulo());
        textAutor.setText(livro.getAutor());
        textAno.setText("" + livro.getAno());
        textGenero.setText(livro.getGenero());
        textTag.setText(livro.getTag());
        textPag.setText("" + livro.getPaginas());
        textPagAtual.setText("" + livro.getPaginaAtual());
        editData.setText(livro.getData());
        editDataFinal.setText(livro.getDataFinal());
        ratingBar.setRating(livro.getRating());


        if (livro.getEstado().equals("Lido")){
            lido.setChecked(true);
            editDataFinal.setText(livro.getDataFinal());
        }
        if (livro.getEstado().equals("Lendo")){
            lendo.setChecked(true);
        }
        if (livro.getEstado().equals("Parado")){
            parado.setChecked(true);
        }
        if (livro.getEstado().equals("Desejo ler")){
            desejo.setChecked(true);
        }

        if (textTag.getText().toString().trim().equals("")){
            tag.setChecked(false);
            linear_tag.setVisibility(View.GONE);
        }else{
            tag.setChecked(true);
            linear_tag.animate()
                    .alpha(1.0f)
                    .setDuration(300)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            linear_tag.setVisibility(View.VISIBLE);
                        }
                    });
        }

    }

    private void setupView() {
        //Binding
        textTitulo = findViewById(R.id.titulo);
        textAno = findViewById(R.id.ano);
        textGenero = findViewById(R.id.genero);
        textAutor = findViewById(R.id.autor);
        textTag = findViewById(R.id.tag);
        textPag = findViewById(R.id.paginas);
        textPagAtual = findViewById(R.id.pagina_atual);
        editData = findViewById(R.id.edit_data);
        tag = findViewById(R.id.switch_tag);

        ratingBar = findViewById(R.id.cadastro_bar);

        linear_tag = findViewById(R.id.linear_tag);
        linear_tag.setVisibility(View.INVISIBLE);

        radioGroup = findViewById(R.id.radio_group);

        lendo = findViewById(R.id.lendo);
        lido = findViewById(R.id.lido);
        parado = findViewById(R.id.parado);
        desejo = findViewById(R.id.desejo_ler);

        editDataFinal = findViewById(R.id.edit_data_fim);

    }


    public boolean concluir(View view) {

        try{
            String titulo = textTitulo.getText().toString();
            int ano = Integer.parseInt(textAno.getText().toString());
            String genero = textGenero.getText().toString();
            String autor = textAutor.getText().toString();
            String tag = textTag.getText().toString();
            int paginas = Integer.parseInt(textPag.getText().toString());
            int paginaAtual = Integer.parseInt(textPagAtual.getText().toString());
            String date = editData.getText().toString();
            String dateFinal = editDataFinal.getText().toString();


            String data_atual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            Calendar atual_date = getData(data_atual);

            date_final = getData(editDataFinal.getText().toString());
            date_inicial = getData(editData.getText().toString());


            if (verificaFimLivro(paginaAtual,paginas,lido,atual_date,date_inicial)){

                if (!atual_date.after(date_inicial) && lido.isChecked()){
                    Snackbar.make(view, "Datas incorretas", Snackbar.LENGTH_SHORT).show();
                    return false;
                }

                if (date_inicial.after(date_final)){
                    Snackbar.make(view, "Datas incorretas", Snackbar.LENGTH_SHORT).show();
                    return false;

                }else if (titulo.trim().isEmpty()
                        || genero.trim().isEmpty()
                        || autor.trim().isEmpty()) {
                    Snackbar.make(view, "Preencha todos os campos corretamente!", Snackbar.LENGTH_SHORT).show();
                    return false;

                }else if (textAno.getText().toString().length() != 4){
                    Snackbar.make(view, "Ano incorreto!", Snackbar.LENGTH_SHORT).show();
                    return false;

                }else if (paginaAtual > paginas) {
                    Snackbar.make(view, "Paginas não coincidem!", Snackbar.LENGTH_SHORT).show();
                    return false;

                }else if (tag.trim().isEmpty()){
                    livro.setAutor(autor);
                    livro.setTitulo(titulo);
                    livro.setGenero(genero);
                    livro.setPaginas(paginas);
                    livro.setAno(ano);
                    livro.setData(date);
                    livro.getDono().setTarget(usuarioLogado);
                    livro.setPaginaAtual(paginaAtual);
                    checkRadioButton();
                    if (lido.isChecked()){
                        livro.setDataFinal(dateFinal);

                    }

                }else{
                    livro.setAutor(autor);
                    livro.setTitulo(titulo);
                    livro.setGenero(genero);
                    livro.setPaginas(paginas);
                    livro.setAno(ano);
                    livro.setTag(tag);
                    livro.setData(date);
                    livro.setDataFinal(dateFinal);
                    livro.getDono().setTarget(usuarioLogado);
                    checkRadioButton();
                    if (lido.isChecked()){
                        livro.setDataFinal(dateFinal);

                    }
                }
            }else{
                Snackbar.make(view, "Paginas e/ou escolha de estado incorretos",Snackbar.LENGTH_SHORT).show();
                return false;
            }



        }catch (IllegalArgumentException e){
            Snackbar.make(view, "Valores incorretores!", Snackbar.LENGTH_SHORT).show();
            return false;
        }

        livrosBox.put(livro);
        Toast.makeText(this, "Concluido", Toast.LENGTH_SHORT).show();
        finish();
        return true;
    }

    private void checkRadioButton() {
        if (lendo.isChecked()){
            livro.setEstado("Lendo");
        }else if(lido.isChecked()){
            livro.setEstado("Lido");
        }else if (parado.isChecked()){
            livro.setEstado("Parado");
        }else{
            livro.setEstado("Desejo ler");
        }
    }

    public void showDate(View view) {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        editData.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        calendar = Calendar.getInstance();
                        Calendar date = getData(editData.getText().toString());

                        if (date.after(calendar)) {
                            desejo.setVisibility(View.VISIBLE);
                            desejo.setChecked(true);
                            parado.setVisibility(View.INVISIBLE);
                            lendo.setVisibility(View.INVISIBLE);
                            lido.setVisibility(View.INVISIBLE);
                        }else{
                            desejo.setVisibility(View.VISIBLE);
                            parado.setVisibility(View.VISIBLE);
                            lendo.setVisibility(View.VISIBLE);
                            lido.setVisibility(View.VISIBLE);
                            lido.setChecked(true);
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void showDateFim(View view) {

        final Calendar d = Calendar.getInstance();
        fimYear = d.get(Calendar.YEAR);
        fimMonth = d.get(Calendar.MONTH);
        fimDay = d.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog pickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        editDataFinal.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, fimYear, fimMonth, fimDay);
        pickerDialog.show();
    }

    public void show_tag(View view) {
        if (tag.isChecked()){
            linear_tag.animate()
                    .alpha(1.0f)
                    .setDuration(300)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            linear_tag.setVisibility(View.VISIBLE);
                        }
                    });
        }else{
            linear_tag.animate()
                    .alpha(0.0f)
                    .setDuration(300)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            linear_tag.setVisibility(View.GONE);
                        }
                    });
        }
    }

    private boolean verificaFimLivro(int inicio, int fim, RadioButton radio, Calendar atual, Calendar inicial){

        if (inicio == fim && radio.isChecked()){
            if (!radio.isChecked()){
                livro.setRating(0);
            }
            return true;
        }
        if (inicio == fim && !radio.isChecked()){
            if (!radio.isChecked()){
                livro.setRating(0);
            }
            return false;
        }

        if (!radio.isChecked()){
            livro.setRating(0);
        }
        return true;
    }
}
