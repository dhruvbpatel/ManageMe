//package com.example.myapplication1.Activities;
//
///*
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainToDo extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_todo);
//    }
//
//
//}
//*/
//
//import android.app.AlertDialog;
//import android.support.annotation.NonNull;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//
//import com.example.myapplication1.Adapter.MoneyItemAdapter;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.EventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
//import com.google.firebase.firestore.QuerySnapshot;
//import com.rengwuxian.materialedittext.MaterialEditText;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import  com.example.myapplication1.Adapter.ListItemAdapter;
//import com.example.myapplication1.Model.ToDo;
//import com.example.myapplication1.R;
//
//
//import dmax.dialog.*;
//
//
//public class MainMoney extends AppCompatActivity {
//
//    List<ToDo> Money = new ArrayList<>();
//    FirebaseFirestore db;
//
//
//    RecyclerView listItem;
//    RecyclerView.LayoutManager layoutManager;
//
//    FloatingActionButton fab;
//
//    public MaterialEditText category,money;
//
//    public boolean isUpdate =false;  // flag
//    public String idUpdate="";
//    ListItemAdapter adapter;
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_money);
//
//        //Init firestore
//        db= FirebaseFirestore.getInstance() ;
//
//        // view
//        AlertDialog dialog ;
//        dialog= new SpotsDialog(this);
//        category = (MaterialEditText)findViewById(R.id.category);
//        money = (MaterialEditText)findViewById(R.id.money);
//        fab = (FloatingActionButton)findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //add new
//                if(!isUpdate)
//                {
//                    setData(category.getText().toString(),money.getText().toString());
//                }
//                else{
//                    updateData(category.getText().toString(),money.getText().toString());
//                    isUpdate = !isUpdate;  // reset flag
//                }
//
//            }
//        });
//
//        listItem = (RecyclerView)findViewById(R.id.listTodo);
//        listItem.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        listItem.setLayoutManager(layoutManager);
//
//        loadData();
//
//
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        if(item.getTitle().equals("DELETE") )
//            deleteItem(item.getOrder());
//        return super.onContextItemSelected(item);
//    }
//
//    private void deleteItem(int index) {
//        db.collection("MoneyList")
//                .document(Money.get(index).getId())
//                .delete()
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        loadData();
//                    }
//                });
//    }
//
//    private void updateData(String title, String description){
//        db.collection("MoneyList").document(idUpdate)
//                .update("category",category,"money",money)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(MainMoney.this,"Updated !",Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        // realtime update refresh data
//
//        db.collection("MoneyList").document(idUpdate)
//                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
//                    @Override
//                    public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
//                        loadData();
//                    }
//                });
//
//
//
//    }
//
//    private void setData(String title, String description) {
//        //radnom id
//        String id = UUID.randomUUID().toString();
//        Map<String,Object> todo = new HashMap<>();
//
//        if(title.equals("") || description.equals(""))    // if content is empty then it will not add
//        {
//            Toast.makeText(MainMoney.this,"Enter Title and Description",Toast.LENGTH_SHORT).show();
//        }
//        else {
//            todo.put("id", id);
//            todo.put("category", category);
//            todo.put("money", money);
//
//            db.collection("MoneyList").document(id)
//                    .set(todo).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void aVoid) {
//                    //refresh data
//                    loadData();
//                }
//            });
//        }
//
//
//
//    }
//
//    private void loadData() {
//        //dialog.show();
//
//        if(Money.size()>0)
//            Money.clear();    // removing values
//
//        db.collection("MoneyList")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        for (DocumentSnapshot doc : task.getResult()) {
//                            ToDo todo = new ToDo(doc.getString("id"),
//                                    doc.getString("title"),
//                                    doc.getString("description"));
//                            Money.add(todo);
//                        }
//                        adapter = new MoneyItemAdapter(MainMoney.this,Money);
//                        listItem.setAdapter(adapter);
//                        //   dialog.dismiss();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainMoney.this,""+e.getMessage(),Toast.LENGTH_LONG).show();
//                    }
//                });
//
//    }
//}


package com.example.myapplication1.Activities;

/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainToDo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
    }


}
*/

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication1.Adapter.MoneyItemAdapter;
import com.example.myapplication1.Model.MoneyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import  com.example.myapplication1.Adapter.ListItemAdapter;
import com.example.myapplication1.Model.ToDo;
import com.example.myapplication1.Model.MoneyModel;
import com.example.myapplication1.R;


import dmax.dialog.*;


public class MainMoney extends AppCompatActivity {

    List<MoneyModel> toDoList = new ArrayList<>();
    FirebaseFirestore db;


    RecyclerView listItem;
    RecyclerView.LayoutManager layoutManager;

    FloatingActionButton fab;

    public MaterialEditText category,money;

    public boolean isUpdate =false;  // flag
    public String idUpdate="";
        MoneyItemAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_money);

        //Init firestore
        db= FirebaseFirestore.getInstance() ;

        // view
        AlertDialog dialog ;
        dialog= new SpotsDialog(this);
        category = (MaterialEditText)findViewById(R.id.category);
        money = (MaterialEditText)findViewById(R.id.money);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add new
                if(!isUpdate)
                {
                    setData(category.getText().toString(),money.getText().toString());
                }
                else{
                    updateData(category.getText().toString(),money.getText().toString());
                    isUpdate = !isUpdate;  // reset flag
                }

            }
        });

        listItem = (RecyclerView)findViewById(R.id.listTodo);
        listItem.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listItem.setLayoutManager(layoutManager);

        loadData();


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("DELETE") )
            deleteItem(item.getOrder());
        return super.onContextItemSelected(item);
    }

    private void deleteItem(int index) {
        db.collection("MoneyList")
                .document(toDoList.get(index).getId())
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loadData();
                    }
                });
    }

    private void updateData(String title, String description){
        db.collection("MoneyList").document(idUpdate)
                .update("category",category,"money",money)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainMoney.this,"Updated !",Toast.LENGTH_SHORT).show();
                    }
                });

        // realtime update refresh data

        db.collection("MoneyList").document(idUpdate)
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                        loadData();
                    }
                });



    }

    private void setData(String category, String money) {
        //radnom id
        String id = UUID.randomUUID().toString();
        Map<String,Object> todo = new HashMap<>();

        if(category.equals("") || money.equals(""))    // if content is empty then it will not add
        {
            Toast.makeText(MainMoney.this,"Enter Title and Description",Toast.LENGTH_SHORT).show();
        }
        else {
            todo.put("id", id);
            todo.put("category", category);
            todo.put("money", money);

            db.collection("MoneyList").document(id)
                    .set(todo).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    //refresh data
                    loadData();
                }
            });
        }



    }

    private void loadData() {
        //dialog.show();

        if(toDoList.size()>0)
            toDoList.clear();    // removing values

        db.collection("MoneyList")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot doc : task.getResult()) {
                            MoneyModel mm1 = new MoneyModel(doc.getString("id"),
                                    doc.getString("category"),
                                    doc.getString("money"));
                            toDoList.add(mm1);
                        }
                        adapter = new MoneyItemAdapter(MainMoney.this , toDoList);
                        listItem.setAdapter(adapter);
                        //   dialog.dismiss();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainMoney.this,""+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

    }
}

