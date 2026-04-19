package com.example.casebased3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    private static final String TAG = "DataRepository";
    private final Context context;

    public DataRepository(Context context) {
        this.context = context;
    }

    public List<DataModel> getAll() {
        ArrayList<String> rawList = FileHelper.readFile(context);
        List<DataModel> result = new ArrayList<>();
        
        if (rawList == null || rawList.isEmpty()) {
            Log.d(TAG, "File empty or could not be read.");
            return result;
        }

        for (String raw : rawList) {
            try {
                result.add(DataModel.fromString(raw));
            } catch (Exception e) {
                Log.e(TAG, "Failed to parse row: " + raw, e);
            }
        }
        return result;
    }

    public DataModel getByPosition(int index) {
        List<DataModel> all = getAll();
        if (index >= 0 && index < all.size()) {
            return all.get(index);
        }
        return null;
    }

    public List<DataModel> getFilteredByMinat(String minat) {
        List<DataModel> all = getAll();
        List<DataModel> result = new ArrayList<>();
        if (minat == null || minat.equals("Semua")) return all;
        
        String lowerMinat = minat.toLowerCase();
        for (DataModel dm : all) {
            if (dm.getMinat() != null && dm.getMinat().toLowerCase().contains(lowerMinat)) {
                result.add(dm);
            }
        }
        return result;
    }

    public List<DataModel> getFilteredByTujuan(String tujuan) {
        List<DataModel> all = getAll();
        List<DataModel> result = new ArrayList<>();
        if (tujuan == null || tujuan.equals("Semua")) return all;

        for (DataModel dm : all) {
            if (dm.getTujuan() != null && dm.getTujuan().equals(tujuan)) {
                result.add(dm);
            }
        }
        return result;
    }

    public List<DataModel> getFiltered(String minat, String tujuan) {
        List<DataModel> all = getAll();
        List<DataModel> result = new ArrayList<>();

        boolean filterMinat = minat != null && !minat.equals("Semua");
        boolean filterTujuan = tujuan != null && !tujuan.equals("Semua");

        for (DataModel dm : all) {
            boolean matchMinat = !filterMinat || (dm.getMinat() != null && dm.getMinat().equals(minat));
            boolean matchTujuan = !filterTujuan || (dm.getTujuan() != null && dm.getTujuan().equals(tujuan));
            if (matchMinat && matchTujuan) {
                result.add(dm);
            }
        }
        return result;
    }

    public void save(DataModel data) {
        if (data == null) return;
        try {
            FileHelper.writeFile(context, data.toStorageString());
        } catch (Exception e) {
            Log.e(TAG, "Error saving data", e);
        }
    }

    public void update(int position, DataModel data) {
        if (data == null) return;
        ArrayList<String> rawList = FileHelper.readFile(context);
        if (position >= 0 && position < rawList.size()) {
            try {
                rawList.set(position, data.toStorageString());
                FileHelper.overwriteFile(context, rawList);
            } catch (Exception e) {
                Log.e(TAG, "Error updating data at " + position, e);
            }
        }
    }

    public void delete(int position) {
        ArrayList<String> rawList = FileHelper.readFile(context);
        if (rawList != null && position >= 0 && position < rawList.size()) {
            try {
                rawList.remove(position);
                FileHelper.overwriteFile(context, rawList);
            } catch (Exception e) {
                Log.e(TAG, "Error deleting data at " + position, e);
            }
        }
    }

    public List<DataModel> search(String keyword) {
        List<DataModel> all = getAll();
        List<DataModel> result = new ArrayList<>();
        if (keyword == null) return all;

        String lowerKeyword = keyword.toLowerCase();
        for (DataModel dm : all) {
            if (dm.getNama() != null && dm.getNama().toLowerCase().contains(lowerKeyword)) {
                result.add(dm);
            }
        }
        return result;
    }
}
