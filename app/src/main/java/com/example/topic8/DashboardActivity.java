package com.example.topic8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button btnE, btnR, btnSE, btnUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnE = findViewById(R.id.btnShow);
        btnR = findViewById(R.id.btnReg);
        btnSE = findViewById(R.id.btnSearch);
        btnUD = findViewById(R.id.btnUpdateDel);

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this,RegisterActivity.class);
                        startActivity(intent);
                    }
                });

        btnSE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this,SearchActivity.class);
                        startActivity(intent);
                    }
                });

        btnUD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this,UpdateDeleteActivity.class);
                        startActivity(intent);
                    }
                });



    }
}
