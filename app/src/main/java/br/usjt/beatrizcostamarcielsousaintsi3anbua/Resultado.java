package br.usjt.beatrizcostamarcielsousaintsi3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Resultado extends AppCompatActivity {

    private TextView bemVindoTextView;
    private TextView labelListaTextView;
    private TextView labelResultadoTextView;
    private String[] listaLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        this.mostrarResultado();
    }

    protected void mostrarResultado(){
        Intent origemIntent = getIntent();
        Bundle b = origemIntent.getExtras();
        String nome = b.getString("nome");
        bemVindoTextView = (TextView) findViewById(R.id.bemVindoTextView);
        String bemVindo = getString(R.string.label_bemvindo);
        bemVindoTextView.setText(bemVindo + ", " + nome);

        labelListaTextView = (TextView) findViewById(R.id.labelListaTextView);
        labelListaTextView.setText( getString(R.string.label_listalivros) );

        long selecao = b.getLong("selecao");
        labelResultadoTextView = (TextView) findViewById(R.id.labelResultadoTextView);

        if ( selecao == 0 ){
            listaLivros = getResources().getStringArray(R.array.array_livros_tecnicos);
            populaLista(listaLivros);
        }else if( selecao == 1 ){
            listaLivros = getResources().getStringArray(R.array.array_livros_literatura);
            populaLista(listaLivros);
        }
    }

    protected void populaLista(String[] lista){
        String livros = "";
        for(String str : lista){
            livros += "\n" + str;
        }
        labelResultadoTextView.setText(livros);
    }
}
