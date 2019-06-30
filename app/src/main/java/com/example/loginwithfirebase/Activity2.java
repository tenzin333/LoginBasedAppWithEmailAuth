package com.example.loginwithfirebase;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity2 extends AppCompatActivity {
    EditText etmail;
    EditText etname;
    EditText etcpassword;
    EditText etnpassword;
    Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mAuth = FirebaseAuth.getInstance();
        etname=findViewById(R.id.etname);
        etcpassword=findViewById(R.id.etcpassword);
        etmail=findViewById(R.id.etmail);
        etnpassword=findViewById(R.id.etnpassword);
        btnRegister=findViewById(R.id.btnRegister)  ;
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etname.getText().toString().isEmpty() || etcpassword.getText().toString().isEmpty() || etname.getText().toString().isEmpty() || etnpassword.getText().toString().isEmpty() ){
                    Toast.makeText( Activity2.this,"Field is empty",Toast.LENGTH_SHORT).show();

                }
                else {
                    String name = etname.getText().toString();
                    String mail = etmail.getText().toString();
                    String npassword = etnpassword.getText().toString();
                    String cpassword = etcpassword.getText().toString();
                    final Intent intent = new Intent(Activity2.this, MainActivity.class);

                    mAuth.createUserWithEmailAndPassword(mail, cpassword)
                            .addOnCompleteListener(Activity2.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(intent);


                                        Toast.makeText(Activity2.this, "ok working", Toast.LENGTH_SHORT).show();

                                    }
                                    else {

                                        Toast.makeText(Activity2.this, "Somethings wring", Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });

                }
            }
        });



    }
}
