package com.example.declanualmei;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editTextText2);
        button = findViewById(R.id.button2);

        button.setOnClickListener(v -> {
            String nomeEmpresa = editText.getText().toString();

            if(!nomeEmpresa.isEmpty()) {
                getSharedPreferences(MainActivity.MEUS_DADOS, MODE_PRIVATE)
                        .edit()
                        .putString("nomeEmpresa", nomeEmpresa)
                        .apply();
            }
        });
    }
}