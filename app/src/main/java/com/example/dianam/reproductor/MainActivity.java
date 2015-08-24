package com.example.dianam.reproductor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dianam.reproductor.services.ContadorService;
import com.example.dianam.reproductor.services.ContadorServiceStart;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn_action1);
        btn2 = (Button) findViewById(R.id.btn_action2);
        btn3 = (Button) findViewById(R.id.btn_action3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        intent = new Intent(this, ContadorServiceStart.class);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_action1:
                intent.setAction(ContadorServiceStart.ACTION1);
                break;
            case R.id.btn_action2:
                intent.setAction(ContadorServiceStart.ACTION2);
                break;
            case R.id.btn_action3:
                intent.setAction(ContadorServiceStart.ACTION3);
                break;
        }
        startService(intent);
    }
}
