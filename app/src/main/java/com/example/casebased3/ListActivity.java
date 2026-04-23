package com.example.casebased3;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {

    private ListView listViewData;
    private TextView tvStatistik;
    private LinearLayout layoutEmptyState;
    private TextView tvEmptyState;
    private TextView tvInsight;
    private EditText etSearch;
    private ChipGroup chipGroupMinat;
    private ChipGroup chipGroupTujuan;
    private PieChart pieChart;
    private HorizontalBarChart barChart;
    private MaterialCardView cardPieChart;
    private MaterialCardView cardBarChart;
    private MaterialCardView cardInsightGlobal;
    private ImageView ivExpandCharts;
    private LinearLayout containerCharts;

    private DataRepository repository;
    private List<DataModel> allData;
    private List<DataModel> filteredData;
    private DataAdapter adapter;

    private String currentFilterMinat = "Semua";
    private String currentFilterTujuan = "Semua";

    private static final int[] PIE_COLORS = {
            Color.parseColor("#6366F1"), Color.parseColor("#EC4899"),
            Color.parseColor("#F59E0B"), Color.parseColor("#10B981"),
            Color.parseColor("#EF4444"), Color.parseColor("#06B6D4")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        repository = new DataRepository(this);

        listViewData = findViewById(R.id.listViewData);
        tvStatistik = findViewById(R.id.tvStatistik);
        layoutEmptyState = findViewById(R.id.layoutEmptyState);
        tvEmptyState = findViewById(R.id.tvEmptyState);
        tvInsight = findViewById(R.id.tvInsight);
        etSearch = findViewById(R.id.etSearch);
        chipGroupMinat = findViewById(R.id.chipGroupMinat);
        chipGroupTujuan = findViewById(R.id.chipGroupTujuan);
        pieChart = findViewById(R.id.pieChart);
        barChart = findViewById(R.id.barChart);
        cardPieChart = findViewById(R.id.cardPieChart);
        cardBarChart = findViewById(R.id.cardBarChart);
        cardInsightGlobal = findViewById(R.id.cardInsightGlobal);
        ivExpandCharts = findViewById(R.id.ivExpandCharts);
        containerCharts = findViewById(R.id.containerCharts);

        cardInsightGlobal.setOnClickListener(v -> {
            boolean isVisible = containerCharts.getVisibility() == View.VISIBLE;
            containerCharts.setVisibility(isVisible ? View.GONE : View.VISIBLE);
            ivExpandCharts.animate().rotation(isVisible ? 0 : 180).setDuration(200).start();
        });

        tvEmptyState.setText("Belum ada data mahasiswa");

        setupFilterChips();
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

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void setupFilterChips() {
        String[] minatOptions = {"Semua", "Teknologi", "Seni", "Bisnis", "Sosial", "Kesehatan", "Sains"};
        for (int i = 0; i < minatOptions.length; i++) {
            Chip chip = new Chip(this);
            chip.setText(minatOptions[i]);
            chip.setCheckable(true);
            chip.setChecked(i == 0);
            chip.setChipBackgroundColorResource(R.color.card);
            chip.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            chipGroupMinat.addView(chip);
        }

        String[] tujuanOptions = {"Semua", "Pengembangan Skill", "Persiapan Karir", "Sekadar Hobi", "Mencari Komunitas"};
        for (int i = 0; i < tujuanOptions.length; i++) {
            Chip chip = new Chip(this);
            chip.setText(tujuanOptions[i]);
            chip.setCheckable(true);
            chip.setChecked(i == 0);
            chip.setChipBackgroundColorResource(R.color.card);
            chip.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            chipGroupTujuan.addView(chip);
        }

        chipGroupMinat.setOnCheckedStateChangeListener((group, checkedIds) -> {
            if (!checkedIds.isEmpty()) {
                Chip selected = group.findViewById(checkedIds.get(0));
                currentFilterMinat = selected != null ? selected.getText().toString() : "Semua";
            } else {
                currentFilterMinat = "Semua";
            }
            applyAllFilters();
        });

        chipGroupTujuan.setOnCheckedStateChangeListener((group, checkedIds) -> {
            if (!checkedIds.isEmpty()) {
                Chip selected = group.findViewById(checkedIds.get(0));
                currentFilterTujuan = selected != null ? selected.getText().toString() : "Semua";
            } else {
                currentFilterTujuan = "Semua";
            }
            applyAllFilters();
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
        updateCharts();
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
            layoutEmptyState.setVisibility(View.VISIBLE);
            listViewData.setVisibility(View.GONE);
            tvInsight.setVisibility(View.GONE);
            cardPieChart.setVisibility(View.GONE);
            cardBarChart.setVisibility(View.GONE);
        } else {
            layoutEmptyState.setVisibility(filteredData.isEmpty() ? View.VISIBLE : View.GONE);
            listViewData.setVisibility(filteredData.isEmpty() ? View.GONE : View.VISIBLE);
            tvInsight.setVisibility(View.VISIBLE);
            cardInsightGlobal.setVisibility(View.VISIBLE);
            tvEmptyState.setText(filteredData.isEmpty() ? "Tidak ada data sesuai filter" : "Belum ada data mahasiswa");
        }
        tvStatistik.setText(InsightAnalyzer.getQuickStats(allData));
        tvInsight.setText(InsightAnalyzer.getInsight(allData));
    }

    private void updateCharts() {
        if (allData == null || allData.isEmpty()) {
            cardPieChart.setVisibility(View.GONE);
            cardBarChart.setVisibility(View.GONE);
            return;
        }

        // Pie Chart - Minat Distribution
        Map<String, Integer> minatDist = InsightAnalyzer.getMinatDistribution(allData);
        if (!minatDist.isEmpty()) {
            cardPieChart.setVisibility(View.VISIBLE);
            List<PieEntry> pieEntries = new ArrayList<>();
            int colorIdx = 0;
            List<Integer> colors = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : minatDist.entrySet()) {
                pieEntries.add(new PieEntry(entry.getValue(), entry.getKey()));
                colors.add(PIE_COLORS[colorIdx % PIE_COLORS.length]);
                colorIdx++;
            }

            PieDataSet dataSet = new PieDataSet(pieEntries, "");
            dataSet.setColors(colors);
            dataSet.setValueTextSize(12f);
            dataSet.setValueTextColor(Color.WHITE);
            dataSet.setValueFormatter(new PercentFormatter(pieChart));
            dataSet.setSliceSpace(3f);

            PieData data = new PieData(dataSet);
            pieChart.setData(data);
            pieChart.setUsePercentValues(true);
            pieChart.setDrawHoleEnabled(true);
            pieChart.setHoleRadius(45f);
            pieChart.setTransparentCircleRadius(50f);
            pieChart.setHoleColor(Color.TRANSPARENT);
            pieChart.getDescription().setEnabled(false);
            pieChart.getLegend().setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            pieChart.getLegend().setTextSize(11f);
            pieChart.setEntryLabelColor(Color.WHITE);
            pieChart.setEntryLabelTextSize(10f);
            pieChart.animateY(800);
            pieChart.invalidate();
        } else {
            cardPieChart.setVisibility(View.GONE);
        }

        // Bar Chart - Semester Distribution
        Map<String, Integer> semDist = InsightAnalyzer.getSemesterDistribution(allData);
        if (!semDist.isEmpty()) {
            cardBarChart.setVisibility(View.VISIBLE);
            List<BarEntry> barEntries = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            int idx = 0;
            for (Map.Entry<String, Integer> entry : semDist.entrySet()) {
                barEntries.add(new BarEntry(idx, entry.getValue()));
                labels.add(entry.getKey());
                idx++;
            }

            BarDataSet barDataSet = new BarDataSet(barEntries, "Jumlah Mahasiswa");
            barDataSet.setColor(Color.parseColor("#6366F1"));
            barDataSet.setValueTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            barDataSet.setValueTextSize(11f);

            BarData barData = new BarData(barDataSet);
            barData.setBarWidth(0.6f);

            barChart.setData(barData);
            barChart.getDescription().setEnabled(false);
            barChart.getLegend().setEnabled(false);
            barChart.setFitBars(true);

            XAxis xAxis = barChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setGranularity(1f);
            xAxis.setDrawGridLines(false);
            xAxis.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
            xAxis.setTextSize(10f);

            barChart.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.textSecondary));
            barChart.getAxisLeft().setDrawGridLines(false);
            barChart.getAxisRight().setEnabled(false);
            barChart.animateY(800);
            barChart.invalidate();
        } else {
            cardBarChart.setVisibility(View.GONE);
        }
    }

    private void openDetail(int filteredPosition, View itemView) {
        DataModel dm = filteredData.get(filteredPosition);
        int originalPosition = allData.indexOf(dm);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("data", dm.toStorageString());
        intent.putExtra("position", originalPosition);

        View avatar = itemView.findViewById(R.id.tvAvatar);
        View nama = itemView.findViewById(R.id.tvNama);
        if (avatar != null && nama != null) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    new android.util.Pair<>(avatar, "transition_avatar"),
                    new android.util.Pair<>(nama, "transition_nama")
            );
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
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
                    updateCharts();
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
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private int getAvatarColor(String minat) {
        if (minat == null) return Color.parseColor("#6366F1");
        switch (minat) {
            case "Teknologi": return Color.parseColor("#6366F1");
            case "Seni": return Color.parseColor("#EC4899");
            case "Bisnis": return Color.parseColor("#F59E0B");
            case "Sosial": return Color.parseColor("#10B981");
            case "Kesehatan": return Color.parseColor("#EF4444");
            case "Sains": return Color.parseColor("#06B6D4");
            default: return Color.parseColor("#6366F1");
        }
    }

    private String getMinatEmoji(String minat) {
        if (minat == null) return "📌";
        switch (minat) {
            case "Teknologi": return "💻";
            case "Seni": return "🎨";
            case "Bisnis": return "💼";
            case "Sosial": return "🤝";
            case "Kesehatan": return "🏥";
            case "Sains": return "🔬";
            default: return "📌";
        }
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
            View avatarBg = convertView.findViewById(R.id.avatarBackground);
            com.google.android.material.button.MaterialButton btnEdit = convertView.findViewById(R.id.btnEdit);
            com.google.android.material.button.MaterialButton btnDelete = convertView.findViewById(R.id.btnDelete);

            DataModel dm = dataList.get(position);
            tvNama.setText(dm.getNama());
            if (dm.getNama() != null && !dm.getNama().isEmpty()) tvAvatar.setText(String.valueOf(dm.getNama().charAt(0)).toUpperCase());

            // Dynamic avatar color based on minat
            int color = getAvatarColor(dm.getMinat());
            GradientDrawable gradient = new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[]{color, adjustAlpha(color, 0.7f)}
            );
            gradient.setShape(GradientDrawable.OVAL);
            if (avatarBg != null) avatarBg.setBackground(gradient);

            // Shared element transition names
            tvAvatar.setTransitionName("transition_avatar_" + position);
            tvNama.setTransitionName("transition_nama_" + position);

            String subtitle = dm.getGender() != null ? dm.getGender() : "-";
            if (dm.getJurusan() != null && !dm.getJurusan().equals("-") && !dm.getJurusan().isEmpty()) subtitle += "  •  " + dm.getJurusan();
            tvGender.setText(subtitle);

            StringBuilder infoSb = new StringBuilder();
            String emoji = getMinatEmoji(dm.getMinat());
            if (dm.getMinat() != null && !dm.getMinat().equals("-") && !dm.getMinat().isEmpty()) infoSb.append(emoji).append(" ").append(dm.getMinat());
            if (dm.getTujuan() != null && !dm.getTujuan().equals("-") && !dm.getTujuan().isEmpty()) {
                if (infoSb.length() > 0) infoSb.append("  •  ");
                infoSb.append("🎯 ").append(dm.getTujuan());
            }
            if (infoSb.length() == 0) infoSb.append(dm.getHobi() != null ? dm.getHobi() : "-");
            tvHobi.setText(infoSb.toString());

            final View itemViewFinal = convertView;
            layoutItemContent.setOnClickListener(v -> openDetail(position, itemViewFinal));
            btnEdit.setOnClickListener(v -> editItem(position));
            btnDelete.setOnClickListener(v -> deleteItem(position));

            return convertView;
        }
    }

    private int adjustAlpha(int color, float factor) {
        int r = (int) (Color.red(color) * factor);
        int g = (int) (Color.green(color) * factor);
        int b = (int) (Color.blue(color) * factor);
        return Color.rgb(Math.min(r, 255), Math.min(g, 255), Math.min(b, 255));
    }
}
