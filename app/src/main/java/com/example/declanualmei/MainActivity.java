package com.example.declanualmei;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String MEUS_DADOS = "MEUS_DADOS";

    public TextView textView;
    public NumberPicker numberPicker;
    public Button button;
    public RadioGroup radioGroup;
    public EditText editText;

    public Button buttonNomeEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textView4);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1998);
        numberPicker.setMaxValue(2023);

        button = findViewById(R.id.button);
        buttonNomeEmpresa = findViewById(R.id.buttonNomeEmpresa);

        radioGroup = findViewById(R.id.radioGroup);

        editText = findViewById(R.id.editTextText);

        numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            exibirResultado(newVal);
        });

        button.setOnClickListener(v -> {
            if(editText.getText().toString().isEmpty()) {
                Toast.makeText(this, "Informe um valor válido!", Toast.LENGTH_SHORT).show();
            } else{
                //Recupera o valor digitado e converte para float
                float valor = Float.parseFloat(editText.getText().toString());

                //Recupera o ano selecionado no NumberPicker
                int ano = numberPicker.getValue();

                //Verifica qual RadioButton está selecionado
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId == R.id.radioButton) {
                    adicionar(valor, ano);
                } else if (selectedId == R.id.radioButton2) {
                    excluir(valor, ano);
                }
                exibirResultado(ano);
            }
        });

        //quando clicar no botao irá inicializar a outra tela para inserir o nome da empresa
        buttonNomeEmpresa.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(MEUS_DADOS, MODE_PRIVATE);
        String nomeEmpresa = sharedPreferences.getString("nomeEmpresa", "");
        if(nomeEmpresa.isEmpty()) {
            setTitle(nomeEmpresa);
        }

        int ano = numberPicker.getValue();
        exibirResultado(ano);
    }

    private void adicionar(float valor, int ano) {
        SharedPreferences sharedPreferences = getSharedPreferences(MEUS_DADOS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano), 0);
        float novoValor = valorAtual + valor;
        editor.putFloat(String.valueOf(ano), novoValor).apply();
    }

    private void excluir(float valor, int ano) {
        SharedPreferences sharedPreferences = getSharedPreferences(MEUS_DADOS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano), 0);
        float novoValor = valorAtual - valor;
        if(novoValor < 0) {
            novoValor = 0;
        }
        editor.putFloat(String.valueOf(ano), novoValor).apply();
    }

    private void exibirResultado(int ano) {
        SharedPreferences sharedPreferences = getSharedPreferences(MEUS_DADOS, MODE_PRIVATE);
        float valor = sharedPreferences.getFloat(String.valueOf(ano), 0);
        textView.setText(String.format("R$ %.2f", valor));
    }
}