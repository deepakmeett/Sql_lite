package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;
    Database database_registration;
    Model model_registration;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.email);
        editText3 = findViewById(R.id.password);
        textView = findViewById(R.id.registration);
        button = findViewById(R.id.bt);
        
        database_registration = new Database(MainActivity.this);
        model_registration = new Model();
        
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText2.getText().toString();
                String password = editText3.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();

                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.
                                           this, "Please enter Password", Toast.LENGTH_SHORT).show();
                    
                }else {
                    model_registration.setEmail(email);
                    model_registration.setPassword(password);
                    database_registration.add_user(model_registration);
                    Toast.makeText(MainActivity
                                           .this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}