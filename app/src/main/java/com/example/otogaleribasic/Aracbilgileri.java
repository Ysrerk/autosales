package com.example.otogaleribasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import Models.Resultilankayit;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Aracbilgileri extends AppCompatActivity {
    EditText marka,model,tarih,baslik,aciklama,fiyat;
    AppCompatButton ileributon;
    String markav,modelv,baslikv,tarihv,fiyatv,memberv,aciklamav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aracbilgileri);
        tanimlama();
        memberidal();
        ileributon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gecisyap();
            }
        });
    }

    public void tanimlama(){

        marka=findViewById(R.id.marka);
        model=findViewById(R.id.model);
        tarih=findViewById(R.id.tarih);
        ileributon=findViewById(R.id.ileributon);
        baslik=findViewById(R.id.baslik);
        aciklama=findViewById(R.id.aciklama);
        fiyat=findViewById(R.id.fiyat);


    }


    public void memberidal(){

        Bundle bundle=getIntent().getExtras();
        memberv=bundle.getString("memberid");
    }

    public void gecisyap(){

        Intent intent=new Intent(Aracbilgileri.this,Resimekle.class);
        markav=marka.getText().toString();
        modelv=model.getText().toString();
        tarihv=tarih.getText().toString();
        baslikv=baslik.getText().toString();
        aciklamav=aciklama.getText().toString();
        fiyatv=fiyat.getText().toString();


        intent.putExtra("marka",markav);
        intent.putExtra("model",modelv);
        intent.putExtra("tarih",tarihv);
        intent.putExtra("baslik",baslikv);
        intent.putExtra("aciklama",aciklamav);
        intent.putExtra("fiyat",fiyatv);
        intent.putExtra("memberid",memberv);



        ManagerAll managerAll=new ManagerAll();
        Call<Resultilankayit>resultilankayitCall=managerAll.resultilankayitCalltt(memberv,baslikv,markav,modelv,fiyatv,aciklamav,tarihv);
        resultilankayitCall.enqueue(new Callback<Resultilankayit>() {
            @Override
            public void onResponse(Call<Resultilankayit> call, Response<Resultilankayit> response) {
               Log.i("xxxx","gyyy");
            }

            @Override
            public void onFailure(Call<Resultilankayit> call, Throwable t) {

                Log.i("xxxx","saasa");

            }
        });


        startActivity(intent);
    }
}