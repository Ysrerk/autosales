package com.example.otogaleribasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import Models.Result;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText email,sifre;
    ImageButton loginbutton;
    String emailv,sifrev;
    SharedPreferences sharedPreferences;
    AppCompatButton uyeolbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        if (sharedPreferences.getString("emails", null) != null && sharedPreferences.getString("sifres", null) != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("email", emailv);
            startActivity(intent);
        }

            tanimlama();
            uyeol();
            loginbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emailv = email.getText().toString();
                    sifrev = sifre.getText().toString();
                    loginistekat(emailv, sifrev);
                }
            });
        }



    public void tanimlama(){

        email=findViewById(R.id.email);
        sifre=findViewById(R.id.password);
        loginbutton=findViewById(R.id.loginbutton);
        uyeolbutton=findViewById(R.id.uyeol);


    }


    public void loginistekat(String emailv,String sifrev){

        ManagerAll managerAll=new ManagerAll();
        Call<Result> resultCall=managerAll.alresult(emailv,sifrev);
        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Log.i("deger",response.body().toString());
                if((response.body().getSifre()!=null )&& response.body().getEmail()!=null ){
                    String idvv=response.body().getId().toString();
                    String emailvv=response.body().getEmail();
                    String sifrevv=response.body().getSifre();
                    Log.i("ssa",emailvv);

                    //session icin yapiyoruz baslangic
                    sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("emails",emailvv);
                    editor.putString("sifres",sifrevv);
                    editor.commit();
                    //session icin yapiyoruz bitis
                    Toast.makeText(getApplicationContext(),"Tenrikler login basarili",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("email",emailv);
                    intent.putExtra("idv",idvv);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Yeniden deneyiniz",Toast.LENGTH_LONG).show();
                    
                }
                /*else {
                    Toast.makeText(getApplicationContext(),"Yeniden deneyiniz",Toast.LENGTH_LONG).show();
                }*/

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Yeniden deneyiniz",Toast.LENGTH_LONG).show();

            }
        });

    }
    public  void uyeol(){
        uyeolbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Uyeol.class);
                startActivity(intent);
            }
        });
    }
}