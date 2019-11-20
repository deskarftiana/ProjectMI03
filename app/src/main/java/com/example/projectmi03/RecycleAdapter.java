package com.example.projectmi03;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectmi03.room.Mahasiswa;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter <RecycleAdapter.MyViewHolder> {
    private Context mContext;
    private List<Mahasiswa> myList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvAlamat;
        public TextView tvKejuruan;
        public TextView tvNama;
        public TextView tvNim;

        public  class MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvKejuruan = itemView.findViewById(R.id.tvKejuruan);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i){
        View itemview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mahasiswa,viewGroup,false);

        return new MyViewHolder(itemview);
    }
   @Override
    public void onBindViewHolder (@NonNull MyViewHolder myViewHolder, int i){
        final  Mahasiswa album = myList.get(i);
        myViewHolder.tvAlamat.setText(album.getAlamat());
       myViewHolder.tvNama.setText(album.getNama());
       myViewHolder.tvNim.setText(album.getNim());
       myViewHolder.tvKejuruan.setText(album.getKejuruan());
   }

   @Override
    public int getItemCount(){
        return myList.size();
   }
}
