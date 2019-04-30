package com.example.myapplication1.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication1.Model.ToDo;
import com.example.myapplication1.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Money extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    FirebaseAuth    mAuth;
    FirebaseUser currentUser;
    private Button todo;
    private Button money;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);




        setUpToolbar();
        navigationView = (NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(Money.this, "Clicked Home ", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_account:
                        Toast.makeText(Money.this, "Clicked Account", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                       // Intent intent = new Intent(getApplicationContext(),AboutUs.class);
                        //startActivity(intent);
                        //finish();
                        break;
                    case R.id.nav_todo:
                        // to open To-Do

                        Intent intent2 = new Intent(getApplicationContext(), MainToDo.class);
                        startActivity(intent2);
                        finish();

                        Toast.makeText(Money.this, "Clicked Todo", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_money:
                        // to open To-Do

                        Intent intent1 = new Intent(getApplicationContext(), MainMoney.class);
                        startActivity(intent1);
                        finish();

                        Toast.makeText(Money.this, "Clicked Money", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot

                        break;
                    case R.id.nav_settings:
                        Toast.makeText(Money.this, "Clicked Settings", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_about:

                        Intent intent5 = new Intent(getApplicationContext(),AboutUs.class);
                        startActivity(intent5);
                        finish();

                        Toast.makeText(Money.this, "Just a Bunch of Tech Geeks", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_logout:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent3 = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent3);
                        finish();
                        Toast.makeText(getApplicationContext(), "Logged Out", Toast.LENGTH_SHORT).show();

                        break;

                }
                return false;
            }
        });

//        todo = (Button) findViewById(R.id.todo);
//
//        todo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v2) {
//                openActivity3();
//            }
//
//            public void openActivity3() {
//
//                Intent intent1 = new Intent(Money.this, MainToDo.class);
//                startActivity(intent1);
//            }
//        });
//
//        money = (Button)findViewById(R.id.money);
//
//        money.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v3) {
//                openActivity4();
//            }
//
//            public void openActivity4() {
//
//                Intent intent2 = new Intent(Money.this, MainMoney.class);
//                startActivity(intent2);
//
//
//            }
//
//        });
        todo = (Button) findViewById(R.id.todo);

        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openActivity3();
            }

            public void openActivity3() {

                Intent intent1 = new Intent(Money.this, MainToDo.class);
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

                Intent intent2 = new Intent(Money.this, MainMoney.class);
                startActivity(intent2);


            }

        });


    }



    private void setUpToolbar() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  // as we have removed  Title bar , so this command tells android to consider our toolbar as action bar

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }



}


