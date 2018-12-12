package com.otemainc.thevendor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    Button register, signin;
    private  Session session;
    private FirebaseAuth firebase;
    private static final String TAG = "EmailPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.btnRegister);
        signin = findViewById(R.id.btnSignIn);
        register.setOnClickListener(this);
        signin.setOnClickListener(this);
        session = new Session(this);
        firebase = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebase.getCurrentUser();
        updateUI(currentUser);

    }
    @Override
    public void onClick(View v) {
      String  uemail =  email.getText().toString();
        String upass = password.getText().toString();
        switch (v.getId()) {
            case R.id.btnSignIn:
                login(uemail, upass);
                break;
            case R.id.btnRegister:
                register(uemail, upass);
                break;
            default:
        }
    }

    private void login(String email, String password) {
        if( email == null | email == ""){
            Toast.makeText(getApplicationContext(), "Enter Your Email",Toast.LENGTH_SHORT).show();
        }
        else if(password == null | password == ""){
            Toast.makeText(getApplicationContext(), "Enter your Password",Toast.LENGTH_SHORT).show();
        }
        else{
             // [START sign_in_with_email]
            firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = firebase.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }

                        }
                    });
            // [END sign_in_with_email]
        }
    }
    private void register(final String email, String password){
        if( email == null | email == ""){
            Toast.makeText(getApplicationContext(), "Enter Your Email",Toast.LENGTH_SHORT).show();
        }
        else if(password == null | password == ""){
            Toast.makeText(getApplicationContext(), "Enter your Password",Toast.LENGTH_SHORT).show();
        }
        else{
            // [START create_user_with_email]
            firebase.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "User Created Successfully:success");
                                FirebaseUser user = firebase.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
            });
            // [END create_user_with_email]

        }
    }
    private void updateUI(FirebaseUser user) {
       if (user != null) {
            startActivity(new Intent(this, DrinksActivity.class));
            finish();
        }
    }
}
