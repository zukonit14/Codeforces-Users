package com.example.retrofitpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.service.carrier.CarrierMessagingClientService;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView handle,name,rating,rank,maxrating,organisation,city;
    private Context context=MainActivity.this;
    private String imgurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handle=findViewById(R.id.handle);
        name=findViewById(R.id.name);
        rating=findViewById(R.id.rating);
        rank =findViewById(R.id.rank);
        maxrating=findViewById(R.id.maxrating);
        organisation=findViewById(R.id.organisation);
        city=findViewById(R.id.city);
        imgurl=Api.BASE_URL;
        imgurl+="user.info?handles=";
        Intent intent=getIntent();
        imgurl+=intent.getStringExtra("fullurl");
        try {
            retrofit_thing();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrofit_thing() throws IOException {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        Api api1 = retrofit.create(Api.class);
//        Response <UserList> response = api1.getUsers(imgurl).execute();
        Api api = retrofit.create(Api.class);
        Call<UserList>call=api.getUsers(imgurl);
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if(!response.isSuccessful())
                {
                    String s="";
                    s="code: "+response.code();
                    s+="\nPlease Enter proper username!";
                    handle.setText(s);
                    return;
                }

                List<User> userList=response.body().getUsers();
                for(User u:userList)
                {
                    String s="";
                    s=u.getHandle();
                    handle.setText(s);s="";
                    s="Name: "+u.getFirstName()+" ";
                    if(u.getFirstName()==null)
                        s="Name: Not Provided";
                    else
                    s+=u.getLastName();
                    name.setText(s);s="";
                    s="Rating: "+u.getRating();
                    rating.setText(s);s="";
                    s="Rank: "+u.getRank();
                    rank.setText(s);s="";
                    s="Max Rating: "+u.getMaxRating();
                    maxrating.setText(s);s="";
                    s="Organisation: "+u.getOrganisation();
                    if(s==null)
                        s="Not Provided";
                    organisation.setText(s);s="";
                    s="Place: "+u.getCity()+","+u.getCountry();
                    if(s==null)
                        s="Not Provided";
                    city.setText(s);s="";

                }
            }
            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                handle.setText(t.getMessage());
            }
        });
    }

}
