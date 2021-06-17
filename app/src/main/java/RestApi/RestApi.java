package RestApi;

import Models.Guncelleresult;
import Models.Result;
import Models.Result2;
import Models.Resultilankayit;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/galerilogin.php")
    Call<Result>getresultt(@Field("email") String email,@Field("sifre") String sifre);


    @FormUrlEncoded
    @POST("/galeriuyeol.php")
    Call<Result2>getresultt2(@Field("email") String email, @Field("sifre") String sifre);

    @FormUrlEncoded
    @POST("/galerikoddogrula.php")
    Call<Guncelleresult>guncelleresult(@Field("kod") String kod,@Field("email") String email);

    @FormUrlEncoded
    @POST("galeriilankaydet.php")
    Call<Resultilankayit>ilankayitresult(@Field("memberid") String memberid,@Field("baslik") String baslik,@Field("marka") String marka,@Field("model") String model,@Field("aciklama") String aciklama,@Field("tarih")String tarih,@Field("fiyat") String fiyat);
}
