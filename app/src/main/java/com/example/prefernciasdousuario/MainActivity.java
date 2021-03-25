package com.example.prefernciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editText;
    private TextView textView;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textUsuario);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = preferences.edit();

                //Validar o nome
                if(editText.getText().toString().equals("")){
                  Toast.makeText(getApplicationContext(),"Preencha o nome", Toast.LENGTH_LONG).show();
                } else{
                    String nome=editText.getText().toString();
                    editor.putString("nome",nome);
                    editor.commit();
                    textView.setText("Olá, "+nome);
                }
            }
        });

        //Recuperar dados Salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(preferences.contains("nome")){

            String nome = preferences.getString("nome","Olá, usuário não definido");
            textView.setText("Olá, "+nome);
        } else {
            textView.setText("Olá, usuário não definido");
        }

    }
}