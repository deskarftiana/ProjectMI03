package com.example.projectmi03.room;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.projectmi03.R;
import com.example.projectmi03.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.projectmi03.AppAplication.db;

public class DetailActivity extends AppCompatActivity {
     RecyclerView myRecycleview;
     RecycleAdapter recycleAdapter;
     List<Mahasiswa> listMahasiswa = new ArrayList<>( );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myRecycleview = findViewById(R.id.myRecycleview);
        fetchDataFromRoom();
        initRecycleview( );
        setAdapter();
    }
    private void fetchDataFromRoom ( ) {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswa = db.userDao().getAll();

        for (int i = 0 ; i <listMahasiswa.size();i++){
            Log.e("Aplikasi",listMahasiswa.get(i).getAlamat()+i);
            Log.e("Aplikasi",listMahasiswa.get(i).getKejuruan()+i);
            Log.e("Aplikasi",listMahasiswa.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswa.get(i).getAlamat()+i);
        }
        Log.e("cek list",""+listMahasiswa.size());
    }
    private void initRecycleview() {
        myRecycleview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecycleview.setLayoutManager(llm);
        recycleAdapter = new RecycleAdapter(this,listMahasiswa);
    }
    private void setAdapter(){
        myRecycleview.setAdapter(recycleAdapter);
    }
}
