package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity2 extends AppCompatActivity {


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

                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
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

                Intent intent2 = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent2);


            }

        });


    }
}
