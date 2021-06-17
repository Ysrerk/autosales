package RestApi;

import Models.Guncelleresult;
import Models.Result;
import Models.Result2;
import Models.Resultilankayit;
import retrofit2.Call;
import retrofit2.Response;

public class ManagerAll extends  BaseManager{

    public Call<Result>alresult(String email,String sifre){

        Call<Result>resultCall=getrestapi().getresultt(email,sifre);
        return resultCall;
    }

    public Call<Result2>alresult2(String email,String sifre){
        Call<Result2> result2Call=getrestapi().getresultt2(email,sifre);
        return result2Call;
    }
    public Call<Guncelleresult>guncelleresultt(String kod, String email){
        Call<Guncelleresult> guncelleresultCall=getrestapi().guncelleresult(kod,email);
        return guncelleresultCall;
    }

    public Call<Resultilankayit>resultilankayitCalltt(String memberid,String baslik,String marka,String model,String fiyat, String aciklama,String tarih){
        Call<Resultilankayit>resultilankayitCall=getrestapi().ilankayitresult(memberid,baslik,marka,model,aciklama,tarih,fiyat);
        return  resultilankayitCall;
    }

}
