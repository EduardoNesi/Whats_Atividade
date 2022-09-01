package com.example.whats_atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout text_input_layout_celular;
    private TextInputEditText text_input_edit_celular;
    private TextInputLayout text_input_layout_texto;
    private TextInputEditText text_input_edit_text_texto;
    private Button button;

    private String url_padrao = "https://wa.me/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_input_layout_celular = findViewById(R.id.text_input_layout_celular);
        text_input_edit_celular = findViewById(R.id.text_input_edit_celular);
        text_input_layout_texto = findViewById(R.id.text_input_layout_texto);
        text_input_edit_text_texto = findViewById(R.id.text_input_edit_text_texto);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celular = text_input_edit_celular.getText().toString();
                String mensageiro = text_input_edit_text_texto.getText().toString();

                String url = url_padrao + celular + "?" + "text=" + mensageiro;

                openWebPage(url);
            }
        });
    }
    public void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);


    }
}
