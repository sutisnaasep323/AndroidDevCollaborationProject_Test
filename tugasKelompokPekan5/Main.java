package tugasKelompokPekan5;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataList dataList = new DataList();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Pencarian Linear");
            System.out.println("3. Pencarian Biner");
            System.out.println("4. Pengurutan");
            System.out.println("5. Tampilkan Data");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nilai data: ");
                    int nilai = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("Masukkan deskripsi data: ");
                    String deskripsi = scanner.nextLine();
                    dataList.tambahData(new Data(nilai, deskripsi));
                    break;
                case 2:
                    System.out.print("Masukkan nilai yang ingin dicari: ");
                    int targetValueLinear = scanner.nextInt();
                    Data linearResult = dataList.linearSearchByValue(targetValueLinear);
                    if (linearResult != null) {
                        System.out.println("Data ditemukan: " + linearResult.getNilai() + ", " + linearResult.getDeskripsi());
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nilai yang ingin dicari: ");
                    int targetValueBinary = scanner.nextInt();
                    Data binaryResult = dataList.binarySearchByValue(targetValueBinary);
                    if (binaryResult != null) {
                        System.out.println("Data ditemukan: " + binaryResult.getNilai() + ", " + binaryResult.getDeskripsi());
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("Pengurutan...");
                    Data[] dataArray = dataList.getDataList().toArray(new Data[0]);
                    dataList.selectionSort(dataArray);
                    dataList.setDataList(List.of(dataArray));
                    System.out.println("Data telah diurutkan:");
                    for (Data data : dataArray) {
                        System.out.println(data.getNilai() + ", " + data.getDeskripsi());
                    }
                    break;
                case 5:
                    System.out.println("Data saat ini:");
                    for (Data data : dataList.getDataList()) {
                        System.out.println(data.getNilai() + ", " + data.getDeskripsi());
                    }
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        }

        scanner.close();
        System.out.println("Program selesai.");
    }
}