package com.example.healthcare_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare_app.ui.home.HomeFragment;

public class AutoScrollAdapter extends RecyclerView.Adapter<AutoScrollAdapter.ViewHolder> {
    View view;
    Context context;

    public AutoScrollAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.nv_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.position_tv.setText("Hãy Quan Tâm Đến Sức Khỏe Của Bạn");
        if(position==1){
            holder.imageView.setImageResource(R.drawable.doctors_physicians_silhouette);
            holder.position_tv.setText("Tìm Bác Sĩ Phù Hợp Với Bạn");
        } else if (position==2){
            holder.imageView.setImageResource(R.drawable.muathuocwall);
            holder.position_tv.setText("Mua Sắm Thuốc Nhanh Chóng");
        } else if (position==3){
            holder.imageView.setImageResource(R.drawable.healthnewswall);
            holder.position_tv.setText("Tìm Hiểu Thông Tin Về Sức Khỏe");
        } else if(position==4){
            holder.imageView.setImageResource(R.drawable.xetnghiemwal);
            holder.position_tv.setText("Xét Nghiệm Nhanh Chóng & Tiện Ích");
        } else if (position==5){
            holder.imageView.setImageResource(R.drawable.tienloiwall);
            holder.position_tv.setText("Đặt Thuốc Nhanh & Giao Hàng Ngay");
        }
        else if (position !=0){
            holder.imageView.setImageResource(R.drawable.hcwall);
        }



    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView position_tv;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            position_tv=itemView.findViewById(R.id.position_tv);
            imageView=itemView.findViewById(R.id.imgview);
        }
    }
}
