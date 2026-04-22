package com.example.casebased3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    // Inlined Intent Keys
    public static final String EXTRA_EDIT_DATA = "edit_data";
    public static final String EXTRA_EDIT_POSITION = "edit_position";
    private static final String DEFAULT_VALUE = "-";

    private EditText etNama;
    private EditText etUmur;
    private RadioGroup rgGender;
    private RadioButton rbLaki;
    private RadioButton rbPerempuan;
    private CheckBox cbMakan, cbTidur, cbGaming, cbMembaca;
    private CheckBox cbOlahraga, cbMusik, cbTraveling, cbCoding;
    private CheckBox cbFotografi, cbMelukis, cbMenulis, cbMemasak;
    private Spinner spinnerKategori;
    private Spinner spinnerMinat;
    private Spinner spinnerJurusan;
    private Spinner spinnerTujuan;
    private Button btnSubmit;

    private DataRepository repository;
    private boolean isEditMode = false;
    private int editPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        repository = new DataRepository(this);

        etNama = findViewById(R.id.etNama);
        etUmur = findViewById(R.id.etUmur);
        rgGender = findViewById(R.id.rgGender);
        rbLaki = findViewById(R.id.rbLaki);
        rbPerempuan = findViewById(R.id.rbPerempuan);
        cbMakan = findViewById(R.id.cbMakan);
        cbTidur = findViewById(R.id.cbTidur);
        cbGaming = findViewById(R.id.cbGaming);
        cbMembaca = findViewById(R.id.cbMembaca);
        cbOlahraga = findViewById(R.id.cbOlahraga);
        cbMusik = findViewById(R.id.cbMusik);
        cbTraveling = findViewById(R.id.cbTraveling);
        cbCoding = findViewById(R.id.cbCoding);
        cbFotografi = findViewById(R.id.cbFotografi);
        cbMelukis = findViewById(R.id.cbMelukis);
        cbMenulis = findViewById(R.id.cbMenulis);
        cbMemasak = findViewById(R.id.cbMemasak);
        spinnerKategori = findViewById(R.id.spinnerKategori);
        spinnerMinat = findViewById(R.id.spinnerMinat);
        spinnerJurusan = findViewById(R.id.spinnerJurusan);
        spinnerTujuan = findViewById(R.id.spinnerTujuan);
        btnSubmit = findViewById(R.id.btnSubmit);

        setupSpinners();

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_EDIT_DATA) && intent.hasExtra(EXTRA_EDIT_POSITION)) {
            isEditMode = true;
            editPosition = intent.getIntExtra(EXTRA_EDIT_POSITION, -1);
            String editData = intent.getStringExtra(EXTRA_EDIT_DATA);

            try {
                DataModel dm = DataModel.fromString(editData);
                isiFormDariModel(dm);
                btnSubmit.setText("Update Data");
            } catch (Exception e) {
                Toast.makeText(this, "Data corrupt dan tak bisa digunakan.", Toast.LENGTH_SHORT).show();
            }
        }

        btnSubmit.setOnClickListener(v -> prosesData());
    }

    private void setupSpinners() {
        String[] kategoriList = {"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
        ArrayAdapter<String> katAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, kategoriList);
        katAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKategori.setAdapter(katAdapter);

        String[] minatList = {"Teknologi", "Seni", "Bisnis", "Sosial", "Kesehatan", "Sains"};
        ArrayAdapter<String> minatAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, minatList);
        minatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinat.setAdapter(minatAdapter);

        String[] jurusanList = {
                "Informatika", "Sistem Informasi", "Teknik Elektro", "Manajemen", "Akuntansi", "Hukum",
                "Kedokteran", "Psikologi", "Desain Komunikasi Visual", "Sastra", "Pendidikan", "Ilmu Komunikasi",
                "Hubungan Internasional", "Teknik Sipil", "Arsitektur", "Farmasi", "Matematika", "Biologi",
                "Fisika", "Kimia", "Teknik Mesin", "Teknik Industri", "Lainnya"
        };
        ArrayAdapter<String> jurAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, jurusanList);
        jurAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJurusan.setAdapter(jurAdapter);

        String[] tujuanList = {"Pengembangan Skill", "Persiapan Karir", "Sekadar Hobi", "Mencari Komunitas"};
        ArrayAdapter<String> tujuanAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, tujuanList);
        tujuanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTujuan.setAdapter(tujuanAdapter);
    }

    private void isiFormDariModel(DataModel dm) {
        if (!dm.getNama().equals(DEFAULT_VALUE)) etNama.setText(dm.getNama());
        if (dm.getUmur() > 0) etUmur.setText(String.valueOf(dm.getUmur()));
        if ("Laki-laki".equals(dm.getGender())) rbLaki.setChecked(true);
        else if ("Perempuan".equals(dm.getGender())) rbPerempuan.setChecked(true);

        String hobi = dm.getHobi();
        if (hobi != null) {
            if (hobi.contains("Makan")) cbMakan.setChecked(true);
            if (hobi.contains("Tidur")) cbTidur.setChecked(true);
            if (hobi.contains("Gaming")) cbGaming.setChecked(true);
            if (hobi.contains("Membaca")) cbMembaca.setChecked(true);
            if (hobi.contains("Olahraga")) cbOlahraga.setChecked(true);
            if (hobi.contains("Musik")) cbMusik.setChecked(true);
            if (hobi.contains("Traveling")) cbTraveling.setChecked(true);
            if (hobi.contains("Coding")) cbCoding.setChecked(true);
            if (hobi.contains("Fotografi")) cbFotografi.setChecked(true);
            if (hobi.contains("Melukis")) cbMelukis.setChecked(true);
            if (hobi.contains("Menulis")) cbMenulis.setChecked(true);
            if (hobi.contains("Memasak")) cbMemasak.setChecked(true);
        }

        setSpinnerSelection(spinnerKategori, dm.getKategori());
        setSpinnerSelection(spinnerMinat, dm.getMinat());
        setSpinnerSelection(spinnerJurusan, dm.getJurusan());
        setSpinnerSelection(spinnerTujuan, dm.getTujuan());
    }

    private void setSpinnerSelection(Spinner spinner, String value) {
        if (value == null || value.isEmpty() || value.equals(DEFAULT_VALUE)) return;
        ArrayAdapter adapter = (ArrayAdapter) spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).toString().equals(value)) {
                spinner.setSelection(i);
                return;
            }
        }
    }

    private void prosesData() {
        String nama = etNama.getText().toString().trim();
        if (nama.isEmpty() || nama.length() < 3 || nama.matches(".*\\d.*")) {
            Toast.makeText(this, "⚠ Nama tidak valid!", Toast.LENGTH_SHORT).show();
            return;
        }

        String umurStr = etUmur.getText().toString().trim();
        if (umurStr.isEmpty()) {
            Toast.makeText(this, "⚠ Umur tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        int umur;
        try {
            umur = Integer.parseInt(umurStr);
            if (umur < 10 || umur > 100) {
                Toast.makeText(this, "⚠ Umur tidak valid!", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "⚠ Umur tidak valid!", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "⚠ Pilih gender!", Toast.LENGTH_SHORT).show();
            return;
        }
        String gender = (selectedGenderId == R.id.rbLaki) ? "Laki-laki" : "Perempuan";

        ArrayList<String> hobiList = new ArrayList<>();
        if (cbMakan.isChecked()) hobiList.add("Makan");
        if (cbTidur.isChecked()) hobiList.add("Tidur");
        if (cbGaming.isChecked()) hobiList.add("Gaming");
        if (cbMembaca.isChecked()) hobiList.add("Membaca");
        if (cbOlahraga.isChecked()) hobiList.add("Olahraga");
        if (cbMusik.isChecked()) hobiList.add("Musik");
        if (cbTraveling.isChecked()) hobiList.add("Traveling");
        if (cbCoding.isChecked()) hobiList.add("Coding");
        if (cbFotografi.isChecked()) hobiList.add("Fotografi");
        if (cbMelukis.isChecked()) hobiList.add("Melukis");
        if (cbMenulis.isChecked()) hobiList.add("Menulis");
        if (cbMemasak.isChecked()) hobiList.add("Memasak");
        String hobi = hobiList.isEmpty() ? DEFAULT_VALUE : String.join(", ", hobiList);

        String kategori = spinnerKategori.getSelectedItem() != null ? spinnerKategori.getSelectedItem().toString() : DEFAULT_VALUE;
        String minat = spinnerMinat.getSelectedItem() != null ? spinnerMinat.getSelectedItem().toString() : DEFAULT_VALUE;
        String jurusan = spinnerJurusan.getSelectedItem() != null ? spinnerJurusan.getSelectedItem().toString() : DEFAULT_VALUE;
        String tujuan = spinnerTujuan.getSelectedItem() != null ? spinnerTujuan.getSelectedItem().toString() : DEFAULT_VALUE;

        DataModel dataModel = new DataModel(nama, gender, hobi, umur, kategori, minat, jurusan, tujuan);

        try {
            if (isEditMode && editPosition >= 0) {
                repository.update(editPosition, dataModel);
                Toast.makeText(this, "✓ Data berhasil diupdate!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                repository.save(dataModel);
                Toast.makeText(this, "✓ Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                resetForm();
            }
        } catch(Exception e) {
            Toast.makeText(this, "Gagal memproses data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetForm() {
        etNama.setText(""); etUmur.setText(""); rgGender.clearCheck();
        cbMakan.setChecked(false); cbTidur.setChecked(false); cbGaming.setChecked(false);
        cbMembaca.setChecked(false); cbOlahraga.setChecked(false); cbMusik.setChecked(false);
        cbTraveling.setChecked(false); cbCoding.setChecked(false); cbFotografi.setChecked(false);
        cbMelukis.setChecked(false); cbMenulis.setChecked(false); cbMemasak.setChecked(false);
        if (spinnerKategori.getAdapter() != null) spinnerKategori.setSelection(0);
        if (spinnerMinat.getAdapter() != null) spinnerMinat.setSelection(0);
        if (spinnerJurusan.getAdapter() != null) spinnerJurusan.setSelection(0);
        if (spinnerTujuan.getAdapter() != null) spinnerTujuan.setSelection(0);
    }
}
