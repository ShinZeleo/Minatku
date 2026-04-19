package com.example.casebased3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listViewData;
    private TextView tvStatistik;
    private TextView tvEmptyState;
    private TextView tvInsight;
    private EditText etSearch;
    private Spinner spinnerFilterMinat;
    private Spinner spinnerFilterTujuan;

    private DataRepository repository;
    private List<DataModel> allData;
    private List<DataModel> filteredData;
    private DataAdapter adapter;

    private String currentFilterMinat = "Semua";
    private String currentFilterTujuan = "Semua";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        repository = new DataRepository(this);

        listViewData = findViewById(R.id.listViewData);
        tvStatistik = findViewById(R.id.tvStatistik);
        tvEmptyState = findViewById(R.id.tvEmptyState);
        tvInsight = findViewById(R.id.tvInsight);
        etSearch = findViewById(R.id.etSearch);
        spinnerFilterMinat = findViewById(R.id.spinnerFilterMinat);
        spinnerFilterTujuan = findViewById(R.id.spinnerFilterTujuan);

        tvEmptyState.setText("Belum ada data mahasiswa");

        setupFilterSpinners();
        loadDataAndSetupAdapter();

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { applyAllFilters(); }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etSearch.setText("");
        loadDataAndSetupAdapter();
    }

    private void setupFilterSpinners() {
        String[] minatOptions = {"Semua", "Teknologi", "Seni", "Bisnis", "Sosial", "Kesehatan", "Sains"};
        ArrayAdapter<String> minatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, minatOptions);
        minatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFilterMinat.setAdapter(minatAdapter);

        String[] tujuanOptions = {"Semua", "Pengembangan Skill", "Persiapan Karir", "Sekadar Hobi", "Mencari Komunitas"};
        ArrayAdapter<String> tujuanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tujuanOptions);
        tujuanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFilterTujuan.setAdapter(tujuanAdapter);

        spinnerFilterMinat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentFilterMinat = parent.getItemAtPosition(position).toString();
                applyAllFilters();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerFilterTujuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentFilterTujuan = parent.getItemAtPosition(position).toString();
                applyAllFilters();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void loadDataAndSetupAdapter() {
        allData = repository.getAll();
        if (filteredData == null) {
            filteredData = new ArrayList<>();
        }
        applyAllFilters();
        if (adapter == null) {
            adapter = new DataAdapter(this, filteredData);
            listViewData.setAdapter(adapter);
        }
        updateUIBasedOnDataLength();
    }

    private void applyAllFilters() {
        if (filteredData == null) filteredData = new ArrayList<>();
        filteredData.clear();
        String keyword = etSearch.getText().toString().toLowerCase().trim();

        for (DataModel dm : allData) {
            boolean matchSearch = keyword.isEmpty() || (dm.getNama() != null && dm.getNama().toLowerCase().contains(keyword));
            
            String m = dm.getMinat() != null ? dm.getMinat().trim() : "-";
            boolean matchMinat = currentFilterMinat.equals("Semua") || m.equals(currentFilterMinat.trim());
            
            String t = dm.getTujuan() != null ? dm.getTujuan().trim() : "-";
            boolean matchTujuan = currentFilterTujuan.equals("Semua") || t.equals(currentFilterTujuan.trim());
            
            if (matchSearch && matchMinat && matchTujuan) filteredData.add(dm);
        }
        if (adapter != null) adapter.notifyDataSetChanged();
        updateUIBasedOnDataLength();
    }

    private void updateUIBasedOnDataLength() {
        if (allData.isEmpty()) {
            tvEmptyState.setVisibility(View.VISIBLE);
            listViewData.setVisibility(View.GONE);
            tvInsight.setVisibility(View.GONE);
        } else {
            tvEmptyState.setVisibility(filteredData.isEmpty() ? View.VISIBLE : View.GONE);
            listViewData.setVisibility(filteredData.isEmpty() ? View.GONE : View.VISIBLE);
            tvInsight.setVisibility(View.VISIBLE);
            tvEmptyState.setText(filteredData.isEmpty() ? "Tidak ada data sesuai filter" : "Belum ada data mahasiswa");
        }
        tvStatistik.setText(InsightAnalyzer.getQuickStats(allData));
        tvInsight.setText(InsightAnalyzer.getInsight(allData));
    }

    private void openDetail(int filteredPosition) {
        DataModel dm = filteredData.get(filteredPosition);
        int originalPosition = allData.indexOf(dm);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("data", dm.toStorageString());
        intent.putExtra("position", originalPosition);
        startActivity(intent);
    }

    private void deleteItem(int filteredPosition) {
        DataModel dm = filteredData.get(filteredPosition);
        int originalPosition = allData.indexOf(dm);
        new AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Yakin ingin menghapus data \"" + dm.getNama() + "\"?")
                .setPositiveButton("Hapus", (dialog, which) -> {
                    repository.delete(originalPosition);
                    allData.remove(originalPosition);
                    filteredData.remove(filteredPosition);
                    adapter.notifyDataSetChanged();
                    updateUIBasedOnDataLength();
                    Toast.makeText(this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Batal", null)
                .show();
    }

    private void editItem(int filteredPosition) {
        DataModel dm = filteredData.get(filteredPosition);
        int originalPosition = allData.indexOf(dm);
        Intent intent = new Intent(this, FormActivity.class);
        intent.putExtra(FormActivity.EXTRA_EDIT_DATA, dm.toStorageString());
        intent.putExtra(FormActivity.EXTRA_EDIT_POSITION, originalPosition);
        startActivity(intent);
    }

    private class DataAdapter extends BaseAdapter {
        private final Context context;
        private final List<DataModel> dataList;

        public DataAdapter(Context context, List<DataModel> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        @Override public int getCount() { return dataList.size(); }
        @Override public Object getItem(int position) { return dataList.get(position); }
        @Override public long getItemId(int position) { return position; }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);

            LinearLayout layoutItemContent = convertView.findViewById(R.id.layoutItemContent);
            TextView tvNama = convertView.findViewById(R.id.tvNama);
            TextView tvGender = convertView.findViewById(R.id.tvGender);
            TextView tvHobi = convertView.findViewById(R.id.tvHobi);
            TextView tvAvatar = convertView.findViewById(R.id.tvAvatar);
            Button btnEdit = convertView.findViewById(R.id.btnEdit);
            Button btnDelete = convertView.findViewById(R.id.btnDelete);

            DataModel dm = dataList.get(position);
            tvNama.setText(dm.getNama());
            if (dm.getNama() != null && !dm.getNama().isEmpty()) tvAvatar.setText(String.valueOf(dm.getNama().charAt(0)).toUpperCase());

            String subtitle = dm.getGender() != null ? dm.getGender() : "-";
            if (dm.getJurusan() != null && !dm.getJurusan().equals("-") && !dm.getJurusan().isEmpty()) subtitle += "  •  " + dm.getJurusan();
            tvGender.setText(subtitle);

            StringBuilder infoSb = new StringBuilder();
            if (dm.getMinat() != null && !dm.getMinat().equals("-") && !dm.getMinat().isEmpty()) infoSb.append("Minat: ").append(dm.getMinat());
            if (dm.getTujuan() != null && !dm.getTujuan().equals("-") && !dm.getTujuan().isEmpty()) {
                if (infoSb.length() > 0) infoSb.append("  •  ");
                infoSb.append("Tujuan: ").append(dm.getTujuan());
            }
            if (infoSb.length() == 0) infoSb.append(dm.getHobi() != null ? dm.getHobi() : "-");
            tvHobi.setText(infoSb.toString());

            layoutItemContent.setOnClickListener(v -> openDetail(position));
            btnEdit.setOnClickListener(v -> editItem(position));
            btnDelete.setOnClickListener(v -> deleteItem(position));

            return convertView;
        }
    }
}
