package com.example.casebased3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.checkbox.MaterialCheckBox;

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
    private SharedPreferences progressPrefs;
    private String progressKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        progressPrefs = getSharedPreferences("dev_path_progress", MODE_PRIVATE);

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
            progressKey = (dm.getMinat() + "_" + dm.getTujuan()).replace(" ", "_");
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
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        });

        btnDetailKembali.setOnClickListener(v -> finishAfterTransition());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
                "Pengembangan & Rekomendasi", R.drawable.bg_section_indigo, ContextCompat.getColor(this, R.color.primary), false);

        buildStructuredSection(containerJalur, DevelopmentPathEngine.getPath(dm.getMinat(), dm.getTujuan()),
                "Jalur Karir & Aktivitas", R.drawable.bg_section_blue, Color.parseColor("#3B82F6"), true);
    }

    private void buildStructuredSection(LinearLayout container, List<String> items, String sectionTitle, int sectionBgRes, int accentColor, boolean withChecklist) {
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

        // Progress bar for checklist sections
        if (withChecklist && !levels.isEmpty()) {
            int totalSteps = levels.size();
            int completedSteps = 0;
            for (int i = 0; i < totalSteps; i++) {
                if (progressPrefs.getBoolean(progressKey + "_step_" + i, false)) completedSteps++;
            }

            LinearLayout progressRow = new LinearLayout(this);
            progressRow.setOrientation(LinearLayout.HORIZONTAL);
            progressRow.setGravity(Gravity.CENTER_VERTICAL);
            LinearLayout.LayoutParams prp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            prp.bottomMargin = dpToPx(16);
            progressRow.setLayoutParams(prp);

            TextView progressLabel = new TextView(this);
            progressLabel.setText(completedSteps + "/" + totalSteps + " Langkah Selesai");
            progressLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            progressLabel.setTypeface(null, Typeface.BOLD);
            progressLabel.setTextColor(completedSteps == totalSteps ? Color.parseColor("#16A34A") : ContextCompat.getColor(this, R.color.textSecondary));
            LinearLayout.LayoutParams plp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            progressLabel.setLayoutParams(plp);
            progressRow.addView(progressLabel);

            if (completedSteps > 0) {
                TextView resetBtn = new TextView(this);
                resetBtn.setText("Reset");
                resetBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                resetBtn.setTextColor(ContextCompat.getColor(this, R.color.errorRed));
                resetBtn.setTypeface(null, Typeface.BOLD);
                resetBtn.setPadding(dpToPx(12), dpToPx(4), dpToPx(12), dpToPx(4));
                resetBtn.setOnClickListener(v -> {
                    SharedPreferences.Editor editor = progressPrefs.edit();
                    for (int i = 0; i < totalSteps; i++) {
                        editor.remove(progressKey + "_step_" + i);
                    }
                    editor.apply();
                    DataModel dm = DataModel.fromString(rawData);
                    populateViews(dm);
                });
                progressRow.addView(resetBtn);
            }
            container.addView(progressRow);

            ProgressBar pb = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            pb.setMax(totalSteps);
            pb.setProgress(completedSteps);
            pb.setProgressTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#16A34A")));
            pb.setProgressBackgroundTintList(android.content.res.ColorStateList.valueOf(ContextCompat.getColor(this, R.color.divider)));
            LinearLayout.LayoutParams pbp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(6));
            pbp.bottomMargin = dpToPx(16);
            pb.setLayoutParams(pbp);
            container.addView(pb);
        }

        if (!levels.isEmpty()) {
            for (int i = 0; i < levels.size(); i++) container.addView(buildStepCard(levels.get(i), i + 1, accentColor, withChecklist, i));
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

    private View buildStepCard(String stepText, int stepNumber, int accentColor, boolean withChecklist, int stepIndex) {
        String label = "Step " + stepNumber;
        String content = stepText;
        if (stepText.contains(":")) {
            label = stepText.substring(0, stepText.indexOf(":")).trim();
            content = stepText.substring(stepText.indexOf(":") + 1).trim();
        }

        boolean isCompleted = withChecklist && progressPrefs.getBoolean(progressKey + "_step_" + stepIndex, false);

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundResource(isCompleted ? R.drawable.bg_step_card_completed : R.drawable.bg_step_card);
        int pad = dpToPx(16);
        card.setPadding(pad, pad, pad, pad);
        LinearLayout.LayoutParams cp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        cp.bottomMargin = dpToPx(10);
        card.setLayoutParams(cp);

        // Top row with badge and optional checkbox
        LinearLayout topRow = new LinearLayout(this);
        topRow.setOrientation(LinearLayout.HORIZONTAL);
        topRow.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams trp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        trp.bottomMargin = dpToPx(8);
        topRow.setLayoutParams(trp);

        TextView b = new TextView(this);
        b.setText(label);
        b.setTextColor(Color.WHITE);
        b.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        b.setTypeface(null, Typeface.BOLD);
        b.setPadding(dpToPx(12), dpToPx(4), dpToPx(12), dpToPx(4));
        b.setBackgroundResource(R.drawable.bg_step_badge);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        b.setLayoutParams(lp);
        topRow.addView(b);

        if (withChecklist) {
            MaterialCheckBox cb = new MaterialCheckBox(this);
            cb.setChecked(isCompleted);
            cb.setOnCheckedChangeListener((buttonView, checked) -> {
                progressPrefs.edit().putBoolean(progressKey + "_step_" + stepIndex, checked).apply();
                DataModel dm = DataModel.fromString(rawData);
                populateViews(dm);
            });
            topRow.addView(cb);
        }

        card.addView(topRow);

        TextView c = new TextView(this);
        c.setText(content);
        c.setTextColor(ContextCompat.getColor(this, R.color.textPrimary));
        if (isCompleted) {
            c.setPaintFlags(c.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            c.setAlpha(0.5f);
        }
        card.addView(c);

        return card;
    }

    private int dpToPx(int dp) { return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics()); }

    private String formatEmptyValue(String val) { return (val == null || val.isEmpty() || val.equals("-")) ? "Belum diisi" : val; }
}
