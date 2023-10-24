package com.example.digitaltech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class RegisterActivity extends AppCompatActivity {

    EditText username, phone, email, password;
    Button register;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username =(EditText) findViewById(R.id.inputUsername);
        phone = (EditText) findViewById(R.id.inputPhoneNo);
        email =(EditText) findViewById(R.id.inputEmail);
        password =(EditText) findViewById(R.id.inputPassword);
        register =(Button) findViewById(R.id.btnRegister);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String number = phone.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")|| number.equals("")|| mail.equals("") || pass.equals(""))
                    Toast.makeText(RegisterActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if (mail.equals(mail)){
                        Boolean checkuser= DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert= DB.insertData(user, number,mail, pass );
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(RegisterActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        TextView btn = findViewById(R.id.textViewSignup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}

