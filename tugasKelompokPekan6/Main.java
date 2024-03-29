package tugasKelompokPekan6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Task");
            System.out.println("2. Hapus Task");
            System.out.println("3. Tampilkan Task");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul task: ");
                    scanner.nextLine(); // membersihkan buffer
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan deskripsi task: ");
                    String deskripsi = scanner.nextLine();
                    Task taskBaru = new Task(judul, deskripsi);
                    taskList.tambahTask(taskBaru);
                    break;
                case 2:
                    System.out.println("Daftar Task:");
                    taskList.tampilkanTask();
                    System.out.print("Masukkan nomor task yang ingin dihapus: ");
                    int nomor = scanner.nextInt();
                    if (nomor >= 1 && nomor <= taskList.jumlahTask()) {
                        taskList.hapusTask(nomor - 1);
                        System.out.println("Task berhasil dihapus.");
                    } else {
                        System.out.println("Nomor task tidak valid.");
                    }
                    break;
                case 3:
                    System.out.println("Daftar Task:");
                    taskList.tampilkanTask();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
