package com.example.myapplication1;

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
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;



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
                        Toast.makeText(MainActivity5.this, "Clicked Home ", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_account:
                        Toast.makeText(MainActivity5.this, "Clicked Account", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_todo:
                        Toast.makeText(MainActivity5.this, "Clicked Todo", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity5.this, "Clicked Settings", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_about:
                        Toast.makeText(MainActivity5.this, "Sab Gandu Log hai !!", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;


                }
                return false;
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
