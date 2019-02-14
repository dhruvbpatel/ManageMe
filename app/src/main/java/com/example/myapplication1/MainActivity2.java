package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity2 extends AppCompatActivity {

    private Button button;
    private Button todo;
    private Button money;
    private ImageButton homebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button =(Button)findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1) {
                openActivity2();
            }
            public void openActivity2(){

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);


            }

        });

       todo=(Button)findViewById(R.id.todo);

        todo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2) {
                openActivity3();
            }
            public void openActivity3(){

                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent1);
            }
        });

        money=(Button)findViewById(R.id.money);

        money.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v3) {
                openActivity4();
            }
            public void openActivity4(){

                Intent intent2 = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent2);


            }

        });

        homebutton=(ImageButton) findViewById(R.id.homebutton);

        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();}
                public void openActivity5(){

                    Intent intent3=new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent3);
                }
            }
            );




    }
}
