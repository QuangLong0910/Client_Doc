package quanglong.ph27075.demo1212;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import quanglong.ph27075.demo1212.Interface.ItemClick;

public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.ViewHolder>{
    public List<Truyen> list ;

    private ItemClick itemClick;
    private Context context;

    public TruyenAdapter(List<Truyen> list, ItemClick itemClick, Context context) {
        this.list = list;
        this.itemClick = itemClick;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ryc,null);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
  final Truyen truyen =list.get(position);
   holder.name.setText(truyen.getName());
        Glide.with(context).load(truyen.getImage()).into(holder.image);

   holder.tacgia.setText(truyen.getTacgia());

   holder.linearLayout.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
       itemClick.onClickitem(truyen);
       }
   });



    }

    public   void release(){
        context = null;
    }

    @Override
    public int getItemCount() {
    return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView name,tacgia;
        ImageView image;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ten);
            image = itemView.findViewById(R.id.imgTruyen);
            tacgia = itemView.findViewById(R.id.tacgia);
            linearLayout = itemView.findViewById(R.id.layoutitem);


        }


    }
}
