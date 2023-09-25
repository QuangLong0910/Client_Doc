package quanglong.ph27075.demo1212;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import quanglong.ph27075.demo1212.Interface.InterfaceTruyen;
import quanglong.ph27075.demo1212.Interface.ItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mandstruyen extends AppCompatActivity {

    // Attach the layout manager to the recycler view
    RecyclerView recyclerView ;

    TruyenAdapter truyenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandstruyen);


        recyclerView = findViewById(R.id.lv);
        Intent intent = getIntent();
        String ten = intent.getStringExtra("tenNguoiDung");
        String anh = intent.getStringExtra("anhnguoidung");
        InterfaceTruyen apiService = Ketnoidb.getRetrofitInstance().create(InterfaceTruyen.class);

        Call<List<Truyen>> call = apiService.getAlltruyen();

       call.enqueue(new Callback<List<Truyen>>() {
           @Override
           public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
               GridLayoutManager gridLayoutManager =
                       new GridLayoutManager(getBaseContext(),2);

               List<Truyen> truyens = response.body();


               recyclerView.setLayoutManager(gridLayoutManager);
               truyenAdapter = new TruyenAdapter(truyens, new ItemClick() {
                   @Override
                   public void onClickitem(Truyen truyen) {
                       Intent intent = new Intent(Mandstruyen.this, Chitiettruyen.class);
                       Bundle bundle = new Bundle();
                       bundle.putString("tnd",ten);
                       bundle.putString("and",anh);
                       bundle.putString("id",truyen.get_id()+"");
                       bundle.putString("truyen",truyen.getName()+"");
                       intent.putExtras(bundle);

                       startActivity(intent);
                   }
               }, getBaseContext());
               recyclerView.setAdapter(truyenAdapter);



           }

           @Override
           public void onFailure(Call<List<Truyen>> call, Throwable t) {
               Toast.makeText(Mandstruyen.this, "Lỗi ", Toast.LENGTH_SHORT).show();
           }
       });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(truyenAdapter != null){
            truyenAdapter.release();
        }
    }
}