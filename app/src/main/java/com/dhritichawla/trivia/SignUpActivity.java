package com.dhritichawla.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etUserName, etEmail, etPassword;
    private Button btnSignIn, btnSignUp;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUI();

        firebaseAuth = FirebaseAuth.getInstance();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateCredentials()){
                    // user has entered all details
                    String email = etEmail.getText().toString().trim();
                    String pass = etPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Sign up successful", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                            }
                        }
                    });


                } else {
                    //
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }

    private void setupUI(){
        etFirstName = (EditText) findViewById(R.id.et_first_name);
        etLastName = (EditText) findViewById(R.id.et_last_name);
        etUserName = (EditText) findViewById(R.id.et_username);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSignIn = (Button) findViewById(R.id.btn_signin);
        btnSignUp = (Button) findViewById(R.id.btn_signup);



    }

    private boolean validateCredentials(){
        Boolean output = false;

        String fName = etFirstName.getText().toString();
        String lName = etLastName.getText().toString();
        String email = etEmail.getText().toString();
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please fill details in all the fields!", Toast.LENGTH_LONG).show();
        } else {
            output = true;
        }

        return output;
    }
}
