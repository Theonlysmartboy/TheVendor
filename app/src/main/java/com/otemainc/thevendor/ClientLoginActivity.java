package com.otemainc.thevendor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ClientLoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText uname,upassword;
    Button login, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);
        uname = findViewById(R.id.txtUname);
        upassword = findViewById(R.id.txtPwd);
        login = findViewById(R.id.uSignInBtn);
        signUp = findViewById(R.id.uSignUpBtn);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uSignInBtn:

                break;
            case R.id.uSignUpBtn:

                break;
                default:

        }
    }
}
