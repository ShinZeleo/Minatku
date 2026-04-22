package com.example.casebased3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btnInputData = findViewById(R.id.btnInputData);
        View btnLihatData = findViewById(R.id.btnLihatData);

        btnInputData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        btnLihatData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateDataCount();
    }

    private void updateDataCount() {
        TextView tvDataCount = findViewById(R.id.tvDataCount);
        if (tvDataCount != null) {
            DataRepository repo = new DataRepository(this);
            List<DataModel> all = repo.getAll();
            int count = all.size();
            if (count == 0) {
                tvDataCount.setText("Belum ada data terdaftar");
            } else {
                tvDataCount.setText(count + " mahasiswa terdaftar");
            }
        }
    }
}