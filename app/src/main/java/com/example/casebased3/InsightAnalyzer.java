package com.example.casebased3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InsightAnalyzer {

    public static String getInsight(List<DataModel> list) {
        if (list == null || list.isEmpty()) return "Belum ada data untuk dianalisis.";

        Map<String, Integer> minatMap = new LinkedHashMap<>();
        Map<String, Integer> tujuanMap = new LinkedHashMap<>();
        Map<String, Integer> hobiMap = new LinkedHashMap<>();
        int total = list.size();

        for (DataModel dm : list) {
            if (isValidField(dm.getMinat())) minatMap.put(dm.getMinat(), minatMap.getOrDefault(dm.getMinat(), 0) + 1);
            if (isValidField(dm.getTujuan())) tujuanMap.put(dm.getTujuan(), tujuanMap.getOrDefault(dm.getTujuan(), 0) + 1);
            
            String hobiStr = dm.getHobi();
            if (isValidField(hobiStr)) {
                for (String h : hobiStr.split(",\\s*")) {
                    h = h.trim();
                    if (!h.isEmpty()) hobiMap.put(h, hobiMap.getOrDefault(h, 0) + 1);
                }
            }
        }

        String dMinat = getDominant(minatMap);
        String dTujuan = getDominant(tujuanMap);
        List<Map.Entry<String, Integer>> hSorted = new ArrayList<>(hobiMap.entrySet());
        hSorted.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        if (!dMinat.isEmpty() || !dTujuan.isEmpty()) {
            sb.append("Dari ").append(total).append(" mahasiswa");
            if (!dMinat.isEmpty()) sb.append(", mayoritas berminat pada ").append(dMinat).append(" (").append(minatMap.get(dMinat)).append(" orang)");
            if (!dTujuan.isEmpty()) sb.append(" dengan tujuan utama ").append(dTujuan).append(" (").append(tujuanMap.get(dTujuan)).append(" orang)");
            if (!hSorted.isEmpty()) {
                sb.append(". Hobi favorit: ").append(hSorted.get(0).getKey());
                if (hSorted.size() > 1) sb.append(" dan ").append(hSorted.get(1).getKey());
            }
            sb.append(".");
        } else {
            sb.append("Lengkapi profil minat dan tujuan untuk melihat insight mendalam dari ").append(total).append(" mahasiswa.");
        }
        return sb.toString();
    }

    public static String getQuickStats(List<DataModel> list) {
        if (list == null || list.isEmpty()) return "Belum ada data";
        int l = 0, p = 0;
        for (DataModel dm : list) {
            if ("Laki-laki".equals(dm.getGender())) l++;
            else if ("Perempuan".equals(dm.getGender())) p++;
        }
        return "Total: " + list.size() + "  |  Laki-laki: " + l + "  |  Perempuan: " + p;
    }

    /** Returns distribution of minat for Pie Chart */
    public static Map<String, Integer> getMinatDistribution(List<DataModel> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (list == null) return map;
        for (DataModel dm : list) {
            if (isValidField(dm.getMinat())) {
                map.put(dm.getMinat(), map.getOrDefault(dm.getMinat(), 0) + 1);
            }
        }
        return map;
    }

    /** Returns distribution of semester/kategori for Bar Chart */
    public static Map<String, Integer> getSemesterDistribution(List<DataModel> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (list == null) return map;
        for (DataModel dm : list) {
            if (isValidField(dm.getKategori())) {
                map.put(dm.getKategori(), map.getOrDefault(dm.getKategori(), 0) + 1);
            }
        }
        return map;
    }

    private static boolean isValidField(String f) { return f != null && !f.trim().isEmpty() && !f.equals("-"); }

    private static String getDominant(Map<String, Integer> map) {
        String d = ""; int max = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) { max = e.getValue(); d = e.getKey(); }
        }
        return d;
    }
}
