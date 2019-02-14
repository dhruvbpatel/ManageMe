package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        back=(Button)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v3) {
                openActivity5();
            }
            public void openActivity5(){

                Intent intent2 = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent2);

            }

        });


    }
}
