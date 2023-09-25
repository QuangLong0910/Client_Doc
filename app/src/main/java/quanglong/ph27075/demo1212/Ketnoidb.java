package quanglong.ph27075.demo1212;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ketnoidb extends MainActivity {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.2.12:3000/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
