package com.example.otogaleribasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Models.Result2;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Uyeol extends AppCompatActivity {
    EditText uyeemail,uyesifre;
    AppCompatButton kayitbutton,temizlebuton;
    String uyeemailv,uyesifrev;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyeol);
        tanimla();
        kayitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uyeemailv=uyeemail.getText().toString();
                uyesifrev=uyesifre.getText().toString();
                kayitistek(uyeemailv,uyesifrev);


            }
        });

    }
    public void tanimla(){
        uyeemail=findViewById(R.id.uyeemail);
        uyesifre=findViewById(R.id.uyesifre);
        kayitbutton=findViewById(R.id.kayitolbtn);
        temizlebuton=findViewById(R.id.temizlebtn);
    }
    public void kayitistek(String email,String sifre){

        ManagerAll managerAll=new ManagerAll();
        Call<Result2>result2Call=managerAll.alresult2(uyeemailv,uyesifrev);
        result2Call.enqueue(new Callback<Result2>() {
            @Override
            public void onResponse(Call<Result2> call, Response<Result2> response) {
                uyeemail.setText("");
                uyesifre.setText("");
                Toast.makeText(getApplicationContext(),response.body().getResult(),Toast.LENGTH_LONG).show();
                for (int i=0; i < 2; i++) {
                    Toast.makeText(getApplicationContext(), "Aktivasyon kodunuz" + response.body().getDogrulamakodu(), Toast.LENGTH_LONG).show();
                }
                Intent intent=new Intent(getApplicationContext(),Dogrulama.class);
                intent.putExtra("kod",response.body().getDogrulamakodu());
                intent.putExtra("email",response.body().getEmail());
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Result2> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Uye olmaadiniz maalesef",Toast.LENGTH_LONG).show();

            }
        });
    }

}

