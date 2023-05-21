package com.dimasnoufal.bukucatatanpermateri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.dimasnoufal.bukucatatanpermateri.databinding.ActivityRecylerViewBinding;

import java.util.ArrayList;
import java.util.Collection;

public class RecylerViewActivity extends AppCompatActivity {

    private ActivityRecylerViewBinding binding;
    private ArrayList<DataModel> dataModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecylerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvList.setHasFixedSize(true);
        dataModels.addAll(getListData());
        showRecylerView();

    }

    private void showRecylerView() {
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(dataModels);
        binding.rvList.setAdapter(adapter);
    }

    private ArrayList<DataModel> getListData() {
        String[] namaList = {"dimas", "dimas", "dimas", "dimas", "dimas", "dimas","dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas"};
        String[] deskripsiList = {"dimas", "dimas", "dimas", "dimas", "dimas", "dimas","dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas", "dimas"};

        ArrayList<DataModel> dataModel = new ArrayList<>();
        for (int i = 0; i < namaList.length; i++) {
            DataModel data = new DataModel();
            data.setNama(namaList[i]);
            data.setDeskripsi(deskripsiList[i]);
            dataModel.add(data);
        }

        return dataModel;
    }


}