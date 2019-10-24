package com.example.theourgifts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {


    private Button SignUpBtn;
    private EditText InputName_SU, InputNumber_SU, InputPassword_SU;

    private ProgressDialog loadingBar;
    private ImageView backBtn_SU;
    private TextView loginTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        backBtn_SU = (ImageView) findViewById(R.id.imageView_BackbtnSU);

        loginTxt = (TextView) findViewById(R.id.textViewLogIn);

        SignUpBtn = (Button) findViewById(R.id.btn_signUp);
        InputName_SU = (EditText) findViewById(R.id.inputName);
        InputNumber_SU = (EditText) findViewById(R.id.inputMN_SU);
        InputPassword_SU = (EditText) findViewById(R.id.EdPSW_SU);
        loadingBar = new ProgressDialog(this);

        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        backBtn_SU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this, NewUserActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }

    private void CreateAccount() {

        String name = InputName_SU.getText().toString();
        String phone = InputNumber_SU.getText().toString();
        String password = InputPassword_SU.getText().toString();

        if (TextUtils.isEmpty(name)) {
            InputName_SU.setError("UserName field is empty");
            Toast.makeText(this, "Please enter your name... ", Toast.LENGTH_SHORT).show();
            return;


        } else if (TextUtils.isEmpty(password) || password.length() < 8) {
            Toast.makeText(getApplicationContext(), "Enter Valid Password", Toast.LENGTH_SHORT).show();
            InputPassword_SU.setError("Password field is empty");
            return;
        } else if (TextUtils.isEmpty(phone)) {
            InputNumber_SU.setError("Mobile Number field is empty");

            Toast.makeText(this, "Please enter your mobile number... ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please Wait, while checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            validatePhoneNumber(name, phone, password);


        }
    }

    private void validatePhoneNumber(final String name, final String phone, final String password) {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(phone).exists())) {
                    HashMap<String, Object> userdatamap = new HashMap<>();
                    userdatamap.put("phone", phone);
                    userdatamap.put("password", password);
                    userdatamap.put("name", name);


                    RootRef.child("Users").child(phone).updateChildren(userdatamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Congratulations, your account has been created", Toast.LENGTH_SHORT).show();

                                loadingBar.dismiss();

                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                loadingBar.dismiss();

                                Toast.makeText(SignUpActivity.this, "Network Error: Please try again after some time.....", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(SignUpActivity.this, "Please try again using another phone number .", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(SignUpActivity.this, NewUserActivity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w("Failed to read value.", databaseError.toException());
            }


        });
    }
}
