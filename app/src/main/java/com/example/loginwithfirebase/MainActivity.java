package com.example.loginwithfirebase;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    EditText etname,etpassword;
    Button btnLogin,btnSignup;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.etname);
        etpassword=findViewById(R.id.etnpassword);
        btnLogin=findViewById(R.id.btnlogin);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    String Email = etname.getText().toString().trim();
                    String Password = etpassword.getText().toString().trim();

                    mAuth.signInWithEmailAndPassword(Email, Password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        currentUser = mAuth.getCurrentUser();
                                        finish();
                                        startActivity(new Intent(getApplicationContext(),
                                                Activity3.class));
                                    }else {
                                        Toast.makeText(MainActivity.this, "couldn't login",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }







        });
        btnSignup=findViewById(R.id.btnsignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,com.example.loginwithfirebase.Activity2.class );
                startActivity(intent);
            }
        });


    }
}
