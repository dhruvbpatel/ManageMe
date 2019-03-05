package com.example.myapplication1.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {


    private EditText  userName,userEmail , userPassword, userConfPassword;
    private ProgressBar loadingProgress;
    private Button regBtn;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


            // init  views  starts

        userName = findViewById(R.id.regName);
        userEmail = findViewById(R.id.regEmail);
        userPassword=  findViewById(R.id.regPass);
        userConfPassword=  findViewById(R.id.regConPass);
        loadingProgress= findViewById(R.id.progressBar);
        regBtn =  findViewById(R.id.regBtn);


        loadingProgress.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();

        // init closes

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regBtn.setVisibility(View.INVISIBLE);
                loadingProgress.setVisibility(View.VISIBLE);
                final String email=userEmail.getText().toString();
                final String password=userPassword.getText().toString();
                final String confPassword=userConfPassword.getText().toString();
                final String name=userName.getText().toString();

                if(email.isEmpty() || password.isEmpty()||confPassword.isEmpty()||name.isEmpty() || !password.equals(confPassword) ){

                    // checking if input is proper
                    showMessage("Please verify all Input");
                    regBtn.setVisibility(View.VISIBLE);
                    loadingProgress.setVisibility(View.INVISIBLE);


                }
                else{
                    // creating account if everything goes well
                    createAccount(email,name,password);
                }



            }
        });


    }

    private void createAccount(String email, String name, String password) {

        // creating account

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // account created
                            showMessage("Account Created !!");
                            //updateUserInfo(name,mAuth.getCurrentUser());
                            updateUI();

                        }
                        else
                        {
                            showMessage("Account Creation Failed !!"+task.getException().getMessage().toString());
                            regBtn.setVisibility(View.VISIBLE);
                            loadingProgress.setVisibility(View.INVISIBLE);
                        }
                    }
                });



    }

    private void updateUI() {
        Intent HomePage= new Intent(getApplicationContext(), com.example.myapplication1.Activities.HomePage.class);
        startActivity(HomePage);
        finish();
    }

    // update user info
    private  void  updateUserInfo(String name, FirebaseUser currentUser){




    }

    private void showMessage(String message) {
        // displaying if something goes wrong

        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }
}
