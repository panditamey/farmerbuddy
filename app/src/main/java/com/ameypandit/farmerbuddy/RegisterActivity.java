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

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    TextView goToLogin;
    EditText etemailr;
    EditText etnamer;
    EditText etpassr;
    private static final String url = "https://pvc-caused-closed-personals.trycloudflare.com/register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        goToLogin = findViewById(R.id.goToLogin);
        btn_register = findViewById(R.id.btn_register);
        etemailr = findViewById(R.id.et_email_register);
        etnamer = findViewById(R.id.et_email_register);
        etpassr = findViewById(R.id.et_password_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etemailr.getText().toString().isEmpty() && etpassr.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Kindly Fill All Credentials", Toast.LENGTH_SHORT).show();
                }else {
                    registerUser(etnamer.getText().toString(), etemailr.getText().toString(), etpassr.getText().toString());
                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void registerUser(final String name, final String email, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Successfully Registered "+ response, Toast.LENGTH_LONG).show();
                Intent intent = new Intent (RegisterActivity.this, DashboardActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
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
                map.put("name",name);
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}