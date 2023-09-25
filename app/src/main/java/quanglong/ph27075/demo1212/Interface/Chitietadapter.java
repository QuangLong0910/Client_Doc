package quanglong.ph27075.demo1212.Interface;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.List;

import quanglong.ph27075.demo1212.NoiDung;
import quanglong.ph27075.demo1212.R;

public class Chitietadapter extends RecyclerView.Adapter<Chitietadapter.ViewHolder>{
  public   List<NoiDung> list;
   public Context context;


    public Chitietadapter(List<NoiDung> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_noidung,null);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       NoiDung noiDung = list.get(position);
            Glide.with(context).load(noiDung.getUrl()).into(holder.imagend);
        Log.d("Noi dung ", "onBindViewHolder: " + noiDung.getUrl());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagend;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagend = itemView.findViewById(R.id.noidung);
        }
    }

}
