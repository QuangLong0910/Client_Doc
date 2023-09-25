package quanglong.ph27075.demo1212.Interface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import quanglong.ph27075.demo1212.Ketnoidb;
import quanglong.ph27075.demo1212.ManLogin;
import quanglong.ph27075.demo1212.Nguoidung;
import quanglong.ph27075.demo1212.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManDangki extends AppCompatActivity {
    EditText tk,mk,image,sdt,quequan,sinhnhat;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dangki);
        tk = findViewById(R.id.Tk);
        mk = findViewById(R.id.mk);
        image = findViewById(R.id.imagethem);
        sdt = findViewById(R.id.sdt);
        quequan =findViewById(R.id.quequan);
        sinhnhat = findViewById(R.id.sinhnhat);
        button = findViewById(R.id.luu);
        Users apiService = Ketnoidb.getRetrofitInstance().create(Users.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tkhoan = tk.getText().toString();
                String matkhau = mk.getText().toString();
                String imagee = image.getText().toString();
                int sdtt = Integer.parseInt(sdt.getText().toString());
                String qq = quequan.getText().toString();
                Date sn = new Date(sinhnhat.getText().toString());
                Nguoidung nguoidung = new Nguoidung(tkhoan,matkhau,imagee,sdtt,qq,sn);


                Call<Nguoidung> call = apiService.createUser(nguoidung);
                call.enqueue(new Callback<Nguoidung>() {
                    @Override
                    public void onResponse(Call<Nguoidung> call, Response<Nguoidung> response) {
                        Toast.makeText(ManDangki.this, "Teeem thành công", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(ManDangki.this, ManLogin.class);
                        startActivity(intent);



                    }

                    @Override
                    public void onFailure(Call<Nguoidung> call, Throwable t) {
                        Toast.makeText(ManDangki.this, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}