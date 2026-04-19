package com.example.casebased3;

public class DataModel {
    // Inlined constants
    private static final String DEFAULT_VALUE = "-";
    private static final String FILE_SEPARATOR = "|";
    private static final String FILE_SEPARATOR_REGEX = "\\|";

    private String nama;
    private String gender;
    private String hobi;
    private int umur;
    private String kategori;
    private String minat;
    private String jurusan;
    private String tujuan;

    public DataModel(String nama, String gender, String hobi, int umur,
                     String kategori, String minat, String jurusan, String tujuan) {
        this.nama = nama != null ? nama.trim() : DEFAULT_VALUE;
        this.gender = gender != null ? gender.trim() : DEFAULT_VALUE;
        this.hobi = hobi != null ? hobi.trim() : DEFAULT_VALUE;
        this.umur = umur;
        this.kategori = kategori != null ? kategori.trim() : DEFAULT_VALUE;
        this.minat = minat != null ? minat.trim() : DEFAULT_VALUE;
        this.jurusan = jurusan != null ? jurusan.trim() : DEFAULT_VALUE;
        this.tujuan = tujuan != null ? tujuan.trim() : DEFAULT_VALUE;
    }

    public DataModel(String nama, String gender, String hobi) {
        this(nama, gender, hobi, 0, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    public static DataModel fromString(String data) {
        if (data == null || data.trim().isEmpty()) {
            return new DataModel(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
        }

        try {
            String[] parts = data.split(FILE_SEPARATOR_REGEX, -1);

            String nama = safeGet(parts, 0);
            String gender = safeGet(parts, 1);
            String hobi = safeGet(parts, 2);

            int umur = 0;
            if (parts.length > 3 && !parts[3].trim().isEmpty()) {
                try {
                    umur = Integer.parseInt(parts[3].trim());
                } catch (NumberFormatException ignored) {}
            }

            String kategori = safeGet(parts, 4);
            String minat = safeGet(parts, 5);
            String jurusan = safeGet(parts, 6);
            String tujuan = safeGet(parts, 7);

            return new DataModel(nama, gender, hobi, umur, kategori, minat, jurusan, tujuan);
        } catch (Exception e) {
            return new DataModel("Data Corrupt", DEFAULT_VALUE, DEFAULT_VALUE);
        }
    }

    private static String safeGet(String[] parts, int index) {
        if (parts.length > index && !parts[index].trim().isEmpty()) {
            return parts[index].trim();
        }
        return DEFAULT_VALUE;
    }

    public String toStorageString() {
        return nama + FILE_SEPARATOR
             + gender + FILE_SEPARATOR
             + hobi + FILE_SEPARATOR
             + umur + FILE_SEPARATOR
             + kategori + FILE_SEPARATOR
             + minat + FILE_SEPARATOR
             + jurusan + FILE_SEPARATOR
             + tujuan;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(nama);
        if (!isDefault(jurusan)) {
            sb.append(" — ").append(jurusan);
        }
        if (!isDefault(minat)) {
            sb.append(" (").append(minat).append(")");
        }
        return sb.toString();
    }

    public String getPersonalSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mahasiswa");
        if (!isDefault(jurusan)) sb.append(" jurusan ").append(jurusan);
        if (!isDefault(kategori)) sb.append(" (").append(kategori).append(")");
        if (!isDefault(minat)) sb.append(" dengan minat ").append(minat);
        if (!isDefault(tujuan)) sb.append(" yang bertujuan ").append(getTujuanNatural());
        if (!isDefault(hobi)) sb.append(", serta memiliki hobi ").append(hobi.replace(",", " dan"));
        sb.append(".");
        return sb.toString();
    }

    private String getTujuanNatural() {
        if (isDefault(tujuan)) return "";
        switch (tujuan) {
            case "Pengembangan Skill": return "mengembangkan skill dan kompetensi";
            case "Persiapan Karir": return "mempersiapkan karir profesional";
            case "Sekadar Hobi": return "mendalami hobi dan kesenangan pribadi";
            case "Mencari Komunitas": return "mencari komunitas dan relasi baru";
            default: return tujuan.toLowerCase();
        }
    }

    private boolean isDefault(String val) {
        return val == null || val.isEmpty() || val.equals(DEFAULT_VALUE);
    }

    public String getNama() { return nama; }
    public String getGender() { return gender; }
    public String getHobi() { return hobi; }
    public int getUmur() { return umur; }
    public String getKategori() { return kategori; }
    public String getMinat() { return minat; }
    public String getJurusan() { return jurusan; }
    public String getTujuan() { return tujuan; }

    @Override
    public String toString() { return toStorageString(); }
}
