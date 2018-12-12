package com.otemainc.thevendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Profile2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnNext,btnPrev;
    ImageView adminbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        btnNext = findViewById(R.id.next);
        btnPrev = findViewById(R.id.previous);
        adminbtn = findViewById(R.id.adminbtn);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        adminbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next:

                break;
            case R.id.previous:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.adminbtn:
                startActivity(new Intent(this, UploadActivity.class));
            default:
        }
    }
}
