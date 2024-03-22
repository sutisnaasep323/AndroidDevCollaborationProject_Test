package tugasKelompokPekan5;

import java.util.*;

public class DataList {
    private List<Data> dataList;

    public DataList() {
        this.dataList = new ArrayList<>();
    }

    public void tambahData(Data data) {
        dataList.add(data);
    }

    public void hapusData(Data data) {
        dataList.remove(data);
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    // Pencarian Linear
    public Data linearSearchByValue(int targetValue) {
        for (Data data : dataList) {
            if (data.getNilai() == targetValue) {
                return data;
            }
        }
        return null;
    }

    public Data linearSearchByDescription(String targetDescription) {
        for (Data data : dataList) {
            if (data.getDeskripsi().equals(targetDescription)) {
                return data;
            }
        }
        return null;
    }

    // Pencarian Biner (Data harus diurutkan terlebih dahulu)
    public Data binarySearchByValue(int targetValue) {
        Collections.sort(dataList, (a, b) -> Integer.compare(a.getNilai(), b.getNilai()));
        int left = 0;
        int right = dataList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dataList.get(mid).getNilai() == targetValue) {
                return dataList.get(mid);
            }
            if (dataList.get(mid).getNilai() < targetValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void selectionSort(Data[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getNilai() < arr[minIndex].getNilai()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Data temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
