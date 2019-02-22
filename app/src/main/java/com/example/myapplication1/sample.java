package com.example.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class sample extends AppCompatActivity {

     EditText et;
     Button bt;
     ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        et=(EditText)findViewById(R.id.et);
        bt=(Button)findViewById(R.id.bt);
        lv=(ListView)findViewById(R.id.lv);


        arrayList=new ArrayList<String>();

        arrayAdapter=new ArrayAdapter<String>(sample.this,android.R.layout.simple_list_item_1);
        lv.setAdapter(arrayAdapter);
        onBtnClick();

    }

    public void onBtnClick(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res=et.getText().toString();
                arrayList.add(res);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
