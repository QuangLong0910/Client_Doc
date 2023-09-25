package quanglong.ph27075.demo1212;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import quanglong.ph27075.demo1212.Interface.Chitietadapter;
import quanglong.ph27075.demo1212.Interface.InterfaceTruyen;
import quanglong.ph27075.demo1212.Interface.ItemblOnclick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chitiettruyen extends AppCompatActivity {
    RecyclerView recyclerViewns;
    RecyclerView  listndbl;
ImageView addbl;
EditText edtbl;
ImageView anhnd;
Chitietadapter chitietadapter;
Binhluanadapter binhluanadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chitiettruyen);
        InterfaceTruyen apiService = Ketnoidb.getRetrofitInstance().create(InterfaceTruyen.class);
        recyclerViewns = findViewById(R.id.ndtruyen);
         listndbl = findViewById(R.id.listndbl);
         addbl = findViewById(R.id.addbl);
         edtbl = findViewById(R.id.edtbinhluan);
         anhnd = findViewById(R.id.anhnd);


      Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String id = bundle.getString("id");
        String name = bundle.getString("truyen");
        String anh = bundle.getString("and");
        Glide.with(getApplicationContext()).load(anh).into(anhnd);
        Log.d("hello", "onClick: "+ id);


        Call<List<NoiDung>> call = apiService.getChitiet(id);
        call.enqueue(new Callback<List<NoiDung>>() {
            @Override
            public void onResponse(Call<List<NoiDung>> call, Response<List<NoiDung>> response) {

                    List<NoiDung> list =  response.body();



                recyclerViewns.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                chitietadapter = new Chitietadapter(list, getBaseContext());

                Log.d("Lấy dữ liệu", "onResponse: " + list );


                recyclerViewns.setAdapter(chitietadapter);


            }

            @Override
            public void onFailure(Call<List<NoiDung>> call, Throwable t) {
                Toast.makeText(Chitiettruyen.this, "Hiển thị lỗi"  , Toast.LENGTH_SHORT).show();
            }
        });



        addbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                String noiDung = edtbl.getText().toString();
              String ten= bundle.getString("tnd");
              String anh = bundle.getString("and");
                String name = bundle.getString("truyen");
                BinhLuan binhLuan = new BinhLuan(noiDung,ten,anh,name);
                Call<BinhLuan> call = apiService.postBl(binhLuan);
                call.enqueue(new Callback<BinhLuan>() {
                    @Override
                    public void onResponse(Call<BinhLuan> call, Response<BinhLuan> response) {
                        Toast.makeText(Chitiettruyen.this, "Bình luận thành công", Toast.LENGTH_SHORT).show();
                        edtbl.setText("");
getBL(name);

                    }

                    @Override
                    public void onFailure(Call<BinhLuan> call, Throwable t) {
                        Toast.makeText(Chitiettruyen.this, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        getBL(name);


    }
    private void getBL(String name){
        InterfaceTruyen apiService = Ketnoidb.getRetrofitInstance().create(InterfaceTruyen.class);
        Call<List<BinhLuan>> call1 = apiService.getAll(name);
        call1.enqueue(new Callback<List<BinhLuan>>() {
            @Override
            public void onResponse(Call<List<BinhLuan>> call, Response<List<BinhLuan>> response) {
                List<BinhLuan> list =  response.body();



                listndbl.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                binhluanadapter = new Binhluanadapter(list, getBaseContext(), new ItemblOnclick() {
                    @Override
                    public void ItemblOnclick(BinhLuan binhLuan) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Chitiettruyen.this);
                        builder.setMessage(R.string.tuychon)
                                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(Chitiettruyen.this);
                                        builder.setMessage(R.string.dialog_start_game)
                                                .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {

                                                        Intent intent = getIntent();
                                                        Bundle bundle = intent.getExtras();

                                                        String ten= bundle.getString("tnd");
                                                        String id3 = binhLuan.get_id();
                                                        if(ten.equals(binhLuan.getTenTaiKhoan())){
                                                            Call<BinhLuan> call = apiService.delete(id3);

                                                            call.enqueue(new Callback<BinhLuan>() {
                                                                @Override
                                                                public void onResponse(Call<BinhLuan> call, Response<BinhLuan> response) {

                                                                    Toast.makeText(Chitiettruyen.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                                                                    list.remove(id);




                                                                }

                                                                @Override
                                                                public void onFailure(Call<BinhLuan> call, Throwable t) {

                                                                }
                                                            });
                                                        }else {
                                                            Toast.makeText(Chitiettruyen.this, "Bạn không thể xóa cmt của người khác", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                })
                                                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                        // Create the AlertDialog object and return it

                                        builder.create().show();
                                    }
                                })
                                .setNegativeButton(R.string.update, new DialogInterface.OnClickListener() {
                                    @SuppressLint("MissingInflatedId")
                                    public void onClick(DialogInterface dialog, int id) {
                                       EditText editText;
                                        Button btnUpdate, btnCancel;
                                        AlertDialog.Builder dialogBuilder =	new AlertDialog.Builder(Chitiettruyen.this);
                                        LayoutInflater inflater	= getLayoutInflater();
                                        @SuppressLint("ResourceType") View dialogView	=	inflater.inflate(R.layout.updatebl, (ViewGroup)findViewById(R.layout.activity_chitiettruyen));
                                        editText	=	(EditText)	dialogView.findViewById(R.id.bl);
                                        editText.setText(binhLuan.getNoiDung());
                                        btnUpdate	=	(Button)	dialogView.findViewById(R.id.btnUpdate);
                                        btnCancel	=	(Button)	dialogView.findViewById(R.id.btnCancel);
                                        btnUpdate.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent intent = getIntent();
                                                Bundle bundle = intent.getExtras();
                                                String id3 = binhLuan.get_id();
                                                String ten= bundle.getString("tnd");
                                                if(ten.equals(binhLuan.getTenTaiKhoan())){
                                                    String tenTK = binhLuan.getTenTaiKhoan();
                                                    String tent = binhLuan.getName();
                                                    String nd = editText.getText().toString();
                                                    String anh = binhLuan.getImage();


                                                    Call<BinhLuan> call = apiService.update(id3,new BinhLuan(nd,tenTK,anh,tent));
                                                    call.enqueue(new Callback<BinhLuan>() {
                                                        @Override
                                                        public void onResponse(Call<BinhLuan> call, Response<BinhLuan> response) {
                                                            Toast.makeText(Chitiettruyen.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                                                            list.set(id, new BinhLuan(nd,tenTK,anh,tent,id3));

                                                             finish();
                                                        }

                                                        @Override
                                                        public void onFailure(Call<BinhLuan> call, Throwable t) {
                                                            Toast.makeText(Chitiettruyen.this, "Bạn không thể chỉnh sửa ?", Toast.LENGTH_SHORT).show();
finish();
                                                        }
                                                    });
                                                }


                                            }
                                        });
                                        btnCancel.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
finish();
                                            }
                                        });
                                        dialogBuilder.setView(dialogView);

                                       dialogBuilder.create().show();


                                    }
                                });


                        builder.create().show();
                    }
                });




                listndbl.setAdapter(binhluanadapter);
                binhluanadapter.notifyDataSetChanged();

                Toast.makeText(Chitiettruyen.this, "Hiển thị " + list, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<BinhLuan>> call, Throwable t) {

            }
        });
    }

}