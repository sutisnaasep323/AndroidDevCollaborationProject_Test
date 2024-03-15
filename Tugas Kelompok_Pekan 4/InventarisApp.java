import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventarisApp {
    public static <T extends Barang> void tambahBarang(ArrayList<T> inventaris, Scanner input) {
        try {
            System.out.println("Masukkan Jenis Barang (Pakaian/Elektronik): ");
            String jenisBarang = input.next();

            if (jenisBarang.equalsIgnoreCase(JenisBarang.ELEKTRONIK.toString())) {
                System.out.println("Masukkan kode barang elektronik: ");
                String kodeBarang = input.next();
                System.out.println("Masukkan nama barang elektronik: ");
                String namaBarang = input.next();
                System.out.println("Masukkan harga barang elektronik: ");
                double hargaBarang = input.nextDouble();
                System.out.println("Masukkan Tahun Produksi : ");
                int tahunProduksi = input.nextInt();
                
                BarangElektronik barangElektronik = new BarangElektronik(kodeBarang, namaBarang, hargaBarang, tahunProduksi);
                inventaris.add((T) barangElektronik);
                System.out.println("Barang Elektronik berhasil ditambahkan ke inventaris.");

            } else if (jenisBarang.equalsIgnoreCase(JenisBarang.PAKAIAN.toString())) {
                System.out.println("Masukkan kode barang pakaian: ");
                String kodeBarang = input.next();
                System.out.println("Masukkan nama barang pakaian: ");
                String namaBarang = input.next();
                input.nextLine();
                System.out.println("Masukkan ukuran pakaian: ");
                String ukuran = input.next();
                System.out.println("Masukkan harga barang pakaian: ");
                double hargaBarang = input.nextDouble();
                
                BarangPakaian barangPakaian = new BarangPakaian(kodeBarang, namaBarang, hargaBarang, ukuran);
                inventaris.add((T) barangPakaian);
                System.out.println("Barang Pakaian berhasil ditambahkan ke inventaris.");
            } else {
                throw new InputMismatchException("Jenis barang tidak valid");
            }
        } catch (InputMismatchException e) {
            System.out.println("Kesalahan: " + e.getMessage());
            input.nextLine(); 
        }
    }

    public static <T extends Barang> void tampilkanInventaris(ArrayList<T> inventaris) {
        System.out.println("Daftar Barang:");
        for (Barang barang : inventaris) {
            System.out.println(" --> " +barang.getNamaBarang() + " & Harga: " + barang.hitungNilai());
        }
    }

    public static <T extends Barang> double hitungTotalNilaiInventaris(ArrayList<T> inventaris) {
        double totalNilaiInventaris = 0;
        for (Barang barang : inventaris) {
            totalNilaiInventaris += barang.hitungNilai();
        }
        return totalNilaiInventaris;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Barang> inventaris = new ArrayList<>();

        while (true) {
            tambahBarang(inventaris, input);
            if (inventaris.isEmpty()) {
                System.out.println("Inventaris kosong.");
            } else {
                tampilkanInventaris(inventaris);
                System.out.println("Total Nilai Inventaris: " + hitungTotalNilaiInventaris(inventaris));
            }
            
            System.out.println("Masukkan 'selesai' untuk mengakhiri atau 'lanjut' memasukkan jenis barang:");
            String selesai = input.next();
            if (selesai.equalsIgnoreCase("selesai")) {
                break;
            }
        }
        input.close();
    }
}
