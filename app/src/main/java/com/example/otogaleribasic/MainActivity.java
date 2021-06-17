package com.example.otogaleribasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView  gelenemail;
    String alinanemail,alinanmemberid;
    SharedPreferences sharedPreferences;
    AppCompatButton cikis,satilikbuton;
    SharedPreferences.Editor editor;//cikis yap icin gerekli



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Cikis yap icin gerekli
        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);

        tanimlama();
        emailal();

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cikisyap();
            }
        });

        //ilanver
       

        satilikbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilanver();
            }
        });
    }
    public void tanimlama(){
        gelenemail=findViewById(R.id.gelenemail);
        cikis=findViewById(R.id.cikis);
        satilikbuton=findViewById(R.id.satilikbutton);

    }
    public void emailal(){
        Bundle bundle=getIntent().getExtras();
        alinanemail=bundle.getString("email");
        alinanmemberid=bundle.getString("idv");
        //gelenemail.setText("Hos geldiniz "+ alinanemail);
    }
    public void cikisyap(){

        editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent intent =new Intent(MainActivity.this,Login.class);
        startActivity(intent);

    }
    public void ilanver(){

        Intent intent=new Intent(MainActivity.this,Aracbilgileri.class);
        intent.putExtra("memberid",alinanmemberid);
        startActivity(intent);
    }
}