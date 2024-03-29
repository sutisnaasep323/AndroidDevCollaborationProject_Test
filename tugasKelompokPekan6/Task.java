package tugasKelompokPekan6;

public class Task {
    private String judul;
    private String deskripsi;

    public Task(String judul, String deskripsi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Deskripsi: " + deskripsi;
    }

}
