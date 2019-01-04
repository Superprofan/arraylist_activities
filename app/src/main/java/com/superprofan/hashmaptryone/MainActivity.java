package com.superprofan.hashmaptryone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnGo;
    EditText etText;


    ArrayList cards = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnGo = findViewById(R.id.btn_cards);
        etText = findViewById(R.id.tv_text);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              cards.add(etText.getText().toString());


            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("GUTEN TAG", ""+cards);
              Intent i = new Intent(MainActivity.this, SecondActivity.class);
              i.putExtra("card-list", cards);
              startActivity(i);
            }
        });



    }
}
