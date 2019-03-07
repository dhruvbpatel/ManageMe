package com.example.myapplication1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication1.R;


public class HomePage extends AppCompatActivity {


    private Button todo;
    private Button money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        todo = (Button) findViewById(R.id.todo);

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openActivity3();
            }

            public void openActivity3() {

                Intent intent1 = new Intent(HomePage.this, MainToDo.class);
                startActivity(intent1);
            }
        });

        money = (Button) findViewById(R.id.money);

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openActivity4();
            }

            public void openActivity4() {

                Intent intent2 = new Intent(HomePage.this, Money.class);
                startActivity(intent2);


            }

        });


    }
}
