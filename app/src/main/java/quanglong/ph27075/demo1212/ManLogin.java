package quanglong.ph27075.demo1212;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import quanglong.ph27075.demo1212.Interface.InterfaceTruyen;
import quanglong.ph27075.demo1212.Interface.ManDangki;
import quanglong.ph27075.demo1212.Interface.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManLogin extends AppCompatActivity {
    EditText edusername, edpass;
    Button button;
    TextView he;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_login);
        edusername = findViewById(R.id.etUsername);
        edpass = findViewById(R.id.etPassword);
        button = findViewById(R.id.btLogin);
        he = findViewById(R.id.he);
        he.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManLogin.this, ManDangki.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edusername.getText().toString())){
                    Toast.makeText(ManLogin.this, "DKM", Toast.LENGTH_SHORT).show();
                } else {
                    Users apiService = Ketnoidb.getRetrofitInstance().create(Users.class);
                    String tenTaiKhoan = edusername.getText().toString();
                    String matKhau = edpass.getText().toString();
                    Call<Nguoidung> call = apiService.getAllND(tenTaiKhoan,matKhau);
                    call.enqueue(new Callback<Nguoidung>() {
                        @Override
                        public void onResponse(Call<Nguoidung> call, Response<Nguoidung> response) {
Nguoidung nguoidung = response.body();

                             if(nguoidung.toString().isEmpty()){
                                 Toast.makeText(ManLogin.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();

                             }
                             else {
                                 Intent intent = new Intent(ManLogin.this,Mandstruyen.class);
                               intent.putExtra("idNguoiDung",nguoidung.get_id()+"");
                               intent.putExtra("tenNguoiDung",nguoidung.getTenTaiKhoan()+"");
                               intent.putExtra("anhnguoidung",nguoidung.getImage()+"");



                                 startActivity(intent);
                             }

                        }

                        @Override
                        public void onFailure(Call<Nguoidung> call, Throwable t) {
                            Toast.makeText(ManLogin.this, "Lỗi ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }


        });


    }
}