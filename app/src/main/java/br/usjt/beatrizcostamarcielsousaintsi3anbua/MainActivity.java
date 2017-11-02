package br.usjt.beatrizcostamarcielsousaintsi3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText buscaEditText;
    private Spinner interesseSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.searchButtonAction();
    }

    protected void searchButtonAction(){
        buscaEditText = (EditText) findViewById(R.id.editTextNome);
        Button searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = buscaEditText.getEditableText().toString();
                Intent intent = new Intent (MainActivity.this, Resultado.class);
                intent.putExtra("nome", nome);
                intent.putExtra("selecao", getSelecao());
                startActivity(intent);
            }
        });
    }

    protected long getSelecao(){
        interesseSpinner = (Spinner) findViewById(R.id.interesseSpinner);
        long saida = interesseSpinner.getSelectedItemId();
        return saida;
    }

}
