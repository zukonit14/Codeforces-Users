package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.http.GET;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn;
    public String username;
    public String getUsername() {
        return username;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editText=findViewById(R.id.username);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendusername();
            }
        });


    }

    public void sendusername()
    {
        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
        intent.putExtra("fullurl",editText.getText().toString());
        startActivity(intent);
    }
}
