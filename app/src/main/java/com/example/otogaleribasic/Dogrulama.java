package com.example.otogaleribasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Models.Guncelleresult;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dogrulama extends AppCompatActivity {
    EditText dogrulamakod,dogrulamaemail;
    AppCompatButton dogrulabutton;
    String gelenkod,gelenemail;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogrulama);
        sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
        tanimlama();
        kodal();
        dogrulabutton.setOnClickListener(new View.OnClickListener() {
            String kodd=dogrulamakod.getText().toString();
            String emaill=dogrulamaemail.getText().toString();
            @Override
            public void onClick(View v) {
                dogrula(kodd,emaill);
            }
        });

    }
    public void tanimlama(){
        dogrulamakod=findViewById(R.id.dogrulamakod);
        dogrulabutton=findViewById(R.id.dogrulabtn);
        dogrulamaemail=findViewById(R.id.dogrulamaemail);
    }
    public  void kodal(){
        Bundle intent=getIntent().getExtras();
        gelenkod=intent.getString("kod");
        gelenemail=intent.getString("email");
        dogrulamakod.setText(gelenkod);
        dogrulamaemail.setText(gelenemail);


    }
    public void dogrula(String kod,String email){
        ManagerAll managerAll=new ManagerAll();

        Log.i("kodd",kod);
        Call<Guncelleresult> guncelleresultCall=managerAll.guncelleresultt(kod,email);
        guncelleresultCall.enqueue(new Callback<Guncelleresult>() {
            @Override
            public void onResponse(Call<Guncelleresult> call, Response<Guncelleresult> response) {
                Toast.makeText(getApplicationContext(),""+response.body().getGresult(),Toast.LENGTH_LONG).show();
                Log.i("dogrulama",response.body().getGresult());
                if(response.body().getEmail()!=null){
                    sharedPreferences=getApplicationContext().getSharedPreferences("giris",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    String emailv=response.body().getEmail();

                    editor.putString("email",emailv);
                    editor.commit();
                    Intent intent=new Intent(Dogrulama.this,MainActivity.class);
                    startActivity(intent);
                }



            }

            @Override
            public void onFailure(Call<Guncelleresult> call, Throwable t) {

            }
        });
    }
}