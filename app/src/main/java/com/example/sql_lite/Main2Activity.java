package com.example.sql_lite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;
    Database database_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        editText1 = findViewById( R.id.name2 );
        editText2 = findViewById( R.id.email2 );
        editText3 = findViewById( R.id.password2 );
        button = findViewById( R.id.bt2 );
        database_Login = new Database( Main2Activity.this );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText2.getText().toString();
                String password = editText3.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText( Main2Activity.this,
                                    "Please enter email", Toast.LENGTH_SHORT ).show();
                } else if (password.isEmpty()) {
                    Toast.makeText( Main2Activity
                                            .this,
                                    "Please enter password", Toast.LENGTH_SHORT ).show();
                } else {
                    boolean b = database_Login.checkUser( email, password );

                    if (b) {
                        Toast.makeText( Main2Activity.this,
                                        "Login Successfully", Toast.LENGTH_SHORT ).show();
                    } else {
                        Toast.makeText( Main2Activity.this,
                                        "Login Unsuccessfully", Toast.LENGTH_SHORT ).show();
                    }
                }
            }
        } );
    }
}
