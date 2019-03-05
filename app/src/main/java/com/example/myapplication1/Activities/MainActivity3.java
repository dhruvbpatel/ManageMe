package com.example.myapplication1.Activities;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication1.Adapter.PagerAdapter;
import com.example.myapplication1.R;

public class MainActivity3 extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener {
                //private Button back;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);





        setUpToolbar();
        navigationView = (NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity3.this, "Clicked Home ", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_account:
                        Toast.makeText(MainActivity3.this, "Clicked Account", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_todo:
                        Toast.makeText(MainActivity3.this, "Clicked Todo", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(MainActivity3.this, "Clicked Settings", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;
                    case R.id.nav_about:
                        Toast.makeText(MainActivity3.this, " We're a team of Some Techies who love building Apps. !!", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);   // for closing drawer as soon as we click ot
                        break;


                }
                return false;
            }
        });


        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("To DO"));
        tabLayout.addTab(tabLayout.newTab().setText("Scheduler"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


         final ViewPager viewPager= (ViewPager)findViewById(R.id.pager );
            final PagerAdapter pagerAdapter= new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
            viewPager.setAdapter(pagerAdapter);
            viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

            tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });



//        back=(Button)findViewById(R.id.back);
//
//        back.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v3) {
//                openActivity5();
//            }
//            public void openActivity5(){
//
//                Intent intent2 = new Intent(MainActivity3.this, HomePage.class);
//                startActivity(intent2);
////            }
//
//        });


    }

    private void setUpToolbar() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  // as we have removed  Title bar , so this command tells android to consider our toolbar as action bar

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
