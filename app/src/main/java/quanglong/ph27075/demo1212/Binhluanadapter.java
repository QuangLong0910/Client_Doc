package quanglong.ph27075.demo1212;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.List;

import quanglong.ph27075.demo1212.Interface.InterfaceTruyen;
import quanglong.ph27075.demo1212.Interface.ItemblOnclick;
import quanglong.ph27075.demo1212.NoiDung;
import quanglong.ph27075.demo1212.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Binhluanadapter extends RecyclerView.Adapter<Binhluanadapter.ViewHolder>{
    public   List<BinhLuan> list;
    public Context context;
    private ItemblOnclick itemblOnclick;


    public Binhluanadapter(List<BinhLuan> list, Context context, ItemblOnclick itemblOnclick) {
        this.list = list;
        this.context = context;
        this.itemblOnclick = itemblOnclick;
    }

    @NonNull
    @Override
    public Binhluanadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_bl,null);
        return new Binhluanadapter.ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Binhluanadapter.ViewHolder holder, int position) {

      final BinhLuan binhLuan = list.get(position);

       holder.tv.setText(binhLuan.getNoiDung());
       holder.tennguoidung.setText(binhLuan.getTenTaiKhoan());

        Glide.with(context).load(binhLuan.getImage()).into(holder.anhnguoidung);

holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        itemblOnclick.ItemblOnclick(binhLuan);
    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       TextView tv;
       ImageView  anhnguoidung;
       TextView tennguoidung;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvbl);
            anhnguoidung = itemView.findViewById(R.id.anhnguoidung);
            tennguoidung = itemView.findViewById(R.id.tennguoidung);
            linearLayout = itemView.findViewById(R.id.binhluanitem);

        }
    }

}

