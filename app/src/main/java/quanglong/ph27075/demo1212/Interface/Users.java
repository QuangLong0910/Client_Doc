package quanglong.ph27075.demo1212.Interface;

import java.util.List;

import quanglong.ph27075.demo1212.Nguoidung;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Users {
    @GET("nguoidung/login")
    Call<Nguoidung> getAllND(@Query("tenTaiKhoan") String tenTaiKhoan  ,
                             @Query("matKhau") String matKhau
                             );
    @POST("nguoidung/add")
    Call<Nguoidung> createUser(@Body Nguoidung user);
}
