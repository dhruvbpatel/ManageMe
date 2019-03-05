//package com.example.myapplication1.Activities;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.example.myapplication1.R;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText name;
//    private EditText pass;
//    private TextView info;
//    private  Button login;
//    private int counter=5;
//    private TextView info1;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        name =  (EditText)findViewById(R.id.et1);
//        pass=   (EditText)findViewById(R.id.et2);
//      //  info = (TextView)findViewById(R.id.tv1);
//        info1=(TextView)findViewById(R.id.tv2);
//        login = (Button)findViewById(R.id.bt1);
//      //  info.setText("Attempts Remaining :5");
//
//
//
//        login.setOnClickListener(new View.OnClickListener(){
//            @Override
////            public void onClick(View v1) {
////                openActivity3();
////            }
//            public void onClick(View view){
//
//                validate(name.getText().toString(),pass.getText().toString());
//
////          public void openActivity3(){
//
//
////                Intent intent = new Intent(MainActivity.this, HomePage.class);
////                startActivity(intent);
//
//            }
//
//        });
//
//    }
//    private void validate(String uname,String passwd){
//        if((uname.equals("")) && (passwd.equals(""))){
//            Intent intent = new Intent(MainActivity.this, HomePage.class);
//            startActivity(intent);
//        }
//        else{
//            counter--;
//                info1.setText("Incorrect Password !!");
//         //   info.setText("Attempts Remaining :"+String.valueOf(counter));
//
//
//            if(counter==0){
//                info1.setText("Too Many Wrong Attempts !!!! ");
//                login.setEnabled(false);
//            }
//        }
//    }
//}
package com.example.myapplication1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication1.R;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import  com.example.myapplication1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {


    private EditText userMail,userPassword;
    private Button btnLogin;
    private ProgressBar loginProgress;
    private FirebaseAuth mAuth;
    private Intent HomeActivity;
    private ImageView loginPhoto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userMail = findViewById(R.id.login_mail);
        userPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.loginBtn);
        loginProgress = findViewById(R.id.login_progress);
        mAuth = FirebaseAuth.getInstance();
        HomeActivity = new Intent(this,HomePage.class);
        loginPhoto = findViewById(R.id.login_photo);
        loginPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registerActivity = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(registerActivity);
                finish();


            }
        });

        loginProgress.setVisibility(View.INVISIBLE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginProgress.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.INVISIBLE);

                final String mail = userMail.getText().toString();
                final String password = userPassword.getText().toString();

                if (mail.isEmpty() || password.isEmpty()) {
                    showMessage("Please Verify All Field");
                    btnLogin.setVisibility(View.VISIBLE);
                    loginProgress.setVisibility(View.INVISIBLE);
                }
                else
                {
                    signIn(mail,password);
                }




            }
        });


    }

    private void signIn(String mail, String password) {


        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {

                    loginProgress.setVisibility(View.INVISIBLE);
                    btnLogin.setVisibility(View.VISIBLE);
                    updateUI();

                }
                else {
                    showMessage(task.getException().getMessage());
                    btnLogin.setVisibility(View.VISIBLE);
                    loginProgress.setVisibility(View.INVISIBLE);
                }


            }
        });



    }

    private void updateUI() {

        startActivity(HomeActivity);
        finish();

    }

    private void showMessage(String text) {

        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {
            //user is already connected  so we need to redirect him to home page
            updateUI();

        }



    }
}
