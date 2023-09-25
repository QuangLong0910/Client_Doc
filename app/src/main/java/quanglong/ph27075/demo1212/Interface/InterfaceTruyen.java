package quanglong.ph27075.demo1212.Interface;

import java.util.List;

import quanglong.ph27075.demo1212.BinhLuan;
import quanglong.ph27075.demo1212.NoiDung;
import quanglong.ph27075.demo1212.Truyen;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterfaceTruyen {

    @GET("truyen")
    Call<List<Truyen>> getAlltruyen() ;

    @GET("truyen/noidung/{id}")
    Call<List<NoiDung>> getChitiet(@Path("id") String id);

    @GET("binhluan")
    Call<List<BinhLuan>> getAll(@Query("name") String name);

    @POST("binhluan/add")
    Call<BinhLuan> postBl(@Body BinhLuan binhLuan);

    @DELETE("binhluan/delete/{id}")
    Call<BinhLuan> delete(@Path("id") String id);
    @PUT("binhluan/edit/{id}")
    Call<BinhLuan> update(@Path("id") String id,@Body BinhLuan binhLuan);


}
