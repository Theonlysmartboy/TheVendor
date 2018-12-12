package com.otemainc.thevendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNext,btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnNext = findViewById(R.id.next);
        btnPrev = findViewById(R.id.previous);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next:
                startActivity(new Intent(this, Profile2Activity.class));
                break;
            case R.id.previous:
                startActivity(new Intent(this, DisplayActivity.class));
                break;
            default:
        }
    }
}
