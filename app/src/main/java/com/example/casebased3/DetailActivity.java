package com.example.casebased3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetailNama;
    private TextView tvDetailGender;
    private TextView tvDetailHobi;
    private TextView tvDetailUmur;
    private TextView tvDetailKategori;
    private TextView tvDetailMinat;
    private TextView tvDetailJurusan;
    private TextView tvDetailTujuan;
    private TextView tvPersonalSummary;
    private LinearLayout containerRekomendasi;
    private LinearLayout containerJalur;
    private Button btnDetailEdit;
    private Button btnDetailKembali;

    private String rawData;
    private int editPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailNama = findViewById(R.id.tvDetailNama);
        tvDetailGender = findViewById(R.id.tvDetailGender);
        tvDetailHobi = findViewById(R.id.tvDetailHobi);
        tvDetailUmur = findViewById(R.id.tvDetailUmur);
        tvDetailKategori = findViewById(R.id.tvDetailKategori);
        tvDetailMinat = findViewById(R.id.tvDetailMinat);
        tvDetailJurusan = findViewById(R.id.tvDetailJurusan);
        tvDetailTujuan = findViewById(R.id.tvDetailTujuan);
        tvPersonalSummary = findViewById(R.id.tvPersonalSummary);
        containerRekomendasi = findViewById(R.id.containerRekomendasi);
        containerJalur = findViewById(R.id.containerJalur);
        btnDetailEdit = findViewById(R.id.btnDetailEdit);
        btnDetailKembali = findViewById(R.id.btnDetailKembali);

        rawData = getIntent().getStringExtra("data");
        editPosition = getIntent().getIntExtra("position", -1);

        if (rawData == null || rawData.trim().isEmpty()) {
            Toast.makeText(this, "Data tidak lengkap", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        try {
            DataModel dm = DataModel.fromString(rawData);
            populateViews(dm);
        } catch (Exception e) {
            Toast.makeText(this, "Gagal memuat profil data.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        btnDetailEdit.setOnClickListener(v -> {
            Intent editIntent = new Intent(DetailActivity.this, FormActivity.class);
            editIntent.putExtra(FormActivity.EXTRA_EDIT_DATA, rawData);
            editIntent.putExtra(FormActivity.EXTRA_EDIT_POSITION, editPosition);
            startActivity(editIntent);
            finish();
        });

        btnDetailKembali.setOnClickListener(v -> finish());
    }

    private void populateViews(DataModel dm) {
        tvDetailNama.setText(dm.getNama());
        tvPersonalSummary.setText(dm.getPersonalSummary());
        tvDetailGender.setText(formatEmptyValue(dm.getGender()));
        tvDetailHobi.setText(formatEmptyValue(dm.getHobi()));
        tvDetailUmur.setText(dm.getUmur() > 0 ? dm.getUmur() + " tahun" : "Belum diisi");
        tvDetailKategori.setText(formatEmptyValue(dm.getKategori()));
        tvDetailMinat.setText(formatEmptyValue(dm.getMinat()));
        tvDetailJurusan.setText(formatEmptyValue(dm.getJurusan()));
        tvDetailTujuan.setText(formatEmptyValue(dm.getTujuan()));

        buildStructuredSection(containerRekomendasi, RecommendationEngine.getRecommendations(dm),
                "Pengembangan & Rekomendasi", R.drawable.bg_section_indigo, ContextCompat.getColor(this, R.color.primary));

        buildStructuredSection(containerJalur, DevelopmentPathEngine.getPath(dm.getMinat(), dm.getTujuan()),
                "Jalur Karir & Aktivitas", R.drawable.bg_section_blue, Color.parseColor("#3B82F6"));
    }

    private void buildStructuredSection(LinearLayout container, List<String> items, String sectionTitle, int sectionBgRes, int accentColor) {
        container.removeAllViews();
        if (items == null || items.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("Belum ada data. Lengkapi minat dan tujuan Anda.");
            empty.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            empty.setTextColor(ContextCompat.getColor(this, R.color.textSecondary));
            container.addView(empty);
            return;
        }

        String jalurTitle = ""; String deskripsi = "";
        List<String> levels = new ArrayList<>(); List<String> activities = new ArrayList<>(); String outcome = "";

        for (String item : items) {
            if (item.startsWith("Jalur:")) jalurTitle = item.substring(item.indexOf(":") + 1).trim();
            else if (item.startsWith("Deskripsi:")) deskripsi = item.substring(item.indexOf(":") + 1).trim();
            else if (item.startsWith("Level ") || item.startsWith("Fase ")) levels.add(item);
            else if (item.startsWith("Aktivitas:") || item.startsWith("Tindakan Wajib")) activities.add(item.contains(":") ? item.substring(item.indexOf(":") + 1).trim() : item);
            else if (item.startsWith("Outcome:") || item.startsWith("Proyeksi Akhir:")) outcome = item.contains(":") ? item.substring(item.indexOf(":") + 1).trim() : item;
        }

        LinearLayout headerRow = new LinearLayout(this);
        headerRow.setOrientation(LinearLayout.HORIZONTAL);
        headerRow.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams hp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        hp.bottomMargin = dpToPx(16);
        headerRow.setLayoutParams(hp);

        View accentBar = new View(this);
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(dpToPx(4), dpToPx(28));
        bp.setMarginEnd(dpToPx(12));
        accentBar.setLayoutParams(bp);
        accentBar.setBackgroundColor(accentColor);
        headerRow.addView(accentBar);

        TextView headerTv = new TextView(this);
        headerTv.setText(sectionTitle);
        headerTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        headerTv.setTypeface(null, Typeface.BOLD);
        headerTv.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
        headerRow.addView(headerTv);
        container.addView(headerRow);

        if (!jalurTitle.isEmpty()) {
            TextView titleTv = new TextView(this);
            titleTv.setText(jalurTitle);
            titleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            titleTv.setTypeface(null, Typeface.BOLD);
            titleTv.setTextColor(accentColor);
            LinearLayout.LayoutParams tp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tp.bottomMargin = dpToPx(8);
            titleTv.setLayoutParams(tp);
            container.addView(titleTv);
        }

        if (!deskripsi.isEmpty()) {
            TextView descTv = new TextView(this);
            descTv.setText(deskripsi);
            descTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            descTv.setTextColor(ContextCompat.getColor(this, R.color.textSecondary));
            descTv.setLineSpacing(dpToPx(4), 1f);
            LinearLayout.LayoutParams dp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            dp.bottomMargin = dpToPx(20);
            descTv.setLayoutParams(dp);
            container.addView(descTv);
        }

        if (!levels.isEmpty()) {
            for (int i = 0; i < levels.size(); i++) container.addView(buildStepCard(levels.get(i), i + 1, accentColor));
        }

        if (!activities.isEmpty()) {
            LinearLayout actSection = new LinearLayout(this);
            actSection.setOrientation(LinearLayout.VERTICAL);
            actSection.setBackgroundResource(R.drawable.bg_section_teal);
            int pad = dpToPx(16);
            actSection.setPadding(pad, pad, pad, pad);
            LinearLayout.LayoutParams ap = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ap.bottomMargin = dpToPx(16);
            actSection.setLayoutParams(ap);

            TextView actTitle = new TextView(this);
            actTitle.setText("Aktivitas Praktis");
            actTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            actTitle.setTypeface(null, Typeface.BOLD);
            actTitle.setTextColor(Color.parseColor("#0F766E"));
            actSection.addView(actTitle);

            for (String act : activities) {
                TextView actText = new TextView(this);
                actText.setText("• " + act);
                actText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                actText.setTextColor(Color.parseColor("#134E4A"));
                actSection.addView(actText);
            }
            container.addView(actSection);
        }

        if (!outcome.isEmpty()) {
            LinearLayout outcomeCard = new LinearLayout(this);
            outcomeCard.setOrientation(LinearLayout.VERTICAL);
            outcomeCard.setBackgroundResource(R.drawable.bg_outcome_card);
            int pad = dpToPx(16);
            outcomeCard.setPadding(pad, pad, pad, pad);
            TextView label = new TextView(this);
            label.setText("Proyeksi Hasil Akhir");
            label.setTextColor(Color.parseColor("#CCFBF1"));
            outcomeCard.addView(label);
            TextView tv = new TextView(this);
            tv.setText(outcome);
            tv.setTextColor(Color.WHITE);
            tv.setTypeface(null, Typeface.BOLD);
            outcomeCard.addView(tv);
            container.addView(outcomeCard);
        }
    }

    private View buildStepCard(String stepText, int stepNumber, int accentColor) {
        String label = "Step " + stepNumber;
        String content = stepText;
        if (stepText.contains(":")) {
            label = stepText.substring(0, stepText.indexOf(":")).trim();
            content = stepText.substring(stepText.indexOf(":") + 1).trim();
        }

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundResource(R.drawable.bg_step_card);
        int pad = dpToPx(16);
        card.setPadding(pad, pad, pad, pad);
        LinearLayout.LayoutParams cp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        cp.bottomMargin = dpToPx(10);
        card.setLayoutParams(cp);

        TextView b = new TextView(this);
        b.setText(label);
        b.setTextColor(Color.WHITE);
        b.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        b.setTypeface(null, Typeface.BOLD);
        b.setPadding(dpToPx(12), dpToPx(4), dpToPx(12), dpToPx(4));
        b.setBackgroundResource(R.drawable.bg_step_badge);
        
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.bottomMargin = dpToPx(8);
        b.setLayoutParams(lp);
        
        card.addView(b);

        TextView c = new TextView(this);
        c.setText(content);
        c.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
        card.addView(c);

        return card;
    }

    private int dpToPx(int dp) { return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics()); }

    private String formatEmptyValue(String val) { return (val == null || val.isEmpty() || val.equals("-")) ? "Belum diisi" : val; }
}
