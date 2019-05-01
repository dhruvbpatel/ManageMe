package com.example.myapplication1.Activities;

import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.RangeValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUs extends AppCompatActivity {

    int backpress;
    TextView t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

//
        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.mipmap.ic_launcher)
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("managemeapp04@gmail.com.com")
                .addWebsite("dhruvbpatel.github.io/")

                .addTwitter("dhruvhimself")
                .addYoutube("youtube.com")

                .addInstagram("dhruvhimself")
                .addGitHub("dhruvbpatel/ManageMe")
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrightString = String.format("CopyRight %d by Dhruv Patel", Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrightString);



        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this, copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }


    /*    private Element createCopyright(){

            Element copyright  = new Element();
            final String copyrightString  = new String("Copyright %d by DhruvPatel", Calendar.getInstance().get(Calendar.YEAR));
            copyright.setTitle(copyrightString);
            copyright.setIcon(R.mipmap.ic_launcher);
            copyright.setGravity(Gravity.CENTER);
            copyright.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                                Toast.makeText(AboutUs.this,copyrightString,Toast.LENGTH_SHORT).show();

                }
            });*/

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(AboutUs.this, Money.class);
        startActivity(intent);
    }

}





