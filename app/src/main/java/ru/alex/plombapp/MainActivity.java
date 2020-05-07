package ru.alex.plombapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Seal> mSealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] sealTypes = getResources().getStringArray(R.array.seal_type);
        final String[] sealPlacement = getResources().getStringArray(R.array.seal_placement);
        mSealList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Seal seal = new Seal("Тип пломбы " + i, sealTypes[i], "Номер пломбы " + i,
                    (int) (Math.random() * 10000), "Местно установки пломбы " + i, sealPlacement[i]);
            mSealList.add(seal);
        }
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SealAdapter(this, mSealList));

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSealList.add(new Seal("Тип пломбы ", "", "Номер пломбы ",
                        0, "Местно установки пломбы ", ""));
                mRecyclerView.setAdapter(new SealAdapter(MainActivity.this, mSealList));
            }
        });

    }
}
