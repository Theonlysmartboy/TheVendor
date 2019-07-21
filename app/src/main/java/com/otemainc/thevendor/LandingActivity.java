package com.otemainc.thevendor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {
    Button ecohim, agriculture, pbs, copyright, ourstand,btnhotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ecohim = findViewById(R.id.ecohim);
        agriculture = findViewById(R.id.agriculture);
        pbs = findViewById(R.id.pbs);
        copyright = findViewById(R.id.rights);
        ourstand = findViewById(R.id.stand);
        btnhotel=findViewById(R.id.btnHotel);
        ecohim.setOnClickListener(this);
        agriculture.setOnClickListener(this);
        pbs.setOnClickListener(this);
        copyright.setOnClickListener(this);
        ourstand.setOnClickListener(this);
        btnhotel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ecohim:
                startActivity(new Intent(this, DrinksActivity.class));
                break;
            case R.id.agriculture:
                startActivity(new Intent(this, SeedsActivity.class));
                break;
            case R.id.pbs:
                startActivity(new Intent(this, EcohimActivity.class));
                break;
            case R.id.stand:
                startActivity(new Intent(this, DisplayActivity.class));
                break;
            case R.id.rights:
                Uri uri = Uri.parse("https://otemainc.com"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btnHotel:
                startActivity(new Intent(this, HotelActivity.class));
                break;
                default:
        }
    }
}
