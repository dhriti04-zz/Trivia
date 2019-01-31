package com.dhritichawla.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnSignIn, btnSignUp;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        setupUI();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null){
            finish();
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
        }


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateCredentials()){
                    // user has entered all details
                } else {
                    //
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }

    private void setupUI(){

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSignIn = (Button) findViewById(R.id.btn_signin);
        btnSignUp = (Button) findViewById(R.id.btn_signup);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    private boolean validateCredentials(){
        Boolean output = false;

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please fill details in all the fields!", Toast.LENGTH_LONG).show();
        } else {
            output = true;
        }

        return output;
    }
}
