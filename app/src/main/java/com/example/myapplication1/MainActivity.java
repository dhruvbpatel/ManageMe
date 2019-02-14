package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private TextView info;
    private  Button login;
    private int counter=5;
    private TextView info1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =  (EditText)findViewById(R.id.et1);
        pass=   (EditText)findViewById(R.id.et2);
      //  info = (TextView)findViewById(R.id.tv1);
        info1=(TextView)findViewById(R.id.tv2);
        login = (Button)findViewById(R.id.bt1);
      //  info.setText("Attempts Remaining :5");



        login.setOnClickListener(new View.OnClickListener(){
            @Override
//            public void onClick(View v1) {
//                openActivity3();
//            }
            public void onClick(View view){

                validate(name.getText().toString(),pass.getText().toString());

//            public void openActivity3(){

//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                startActivity(intent);

            }

        });

    }
    private void validate(String uname,String passwd){
        if((uname.equals("admin")) && (passwd.equals("1234"))){
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
        else{
            counter--;
                info1.setText("Incorrect Password !!");
         //   info.setText("Attempts Remaining :"+String.valueOf(counter));


            if(counter==0){
                info1.setText("Too Many Wrong Attempts !!!! ");
                login.setEnabled(false);
            }
        }
    }
}
