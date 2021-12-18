package com.ameypandit.farmerbuddy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    TextView goToRegister;
    EditText etemail;
    EditText etpass;
    private static final String url = "https://pvc-caused-closed-personals.trycloudflare.com/login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        goToRegister = findViewById(R.id.goToRegister);
        etemail = findViewById(R.id.et_email_login);
        etpass = findViewById(R.id.et_password_login);

        btn_login = findViewById(R.id.btn_login);
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etemail.getText().toString().isEmpty() && etpass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Kindly Fill All Credentials", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(etemail.getText().toString(),etpass.getText().toString());
                }

            }
        });
    }
    public void loginUser( final String email, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Integer resStr = Integer.valueOf(response);
                if(resStr== 0){
                    Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();

                }
               else{

                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent (LoginActivity.this, DashboardActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String, String>();
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}