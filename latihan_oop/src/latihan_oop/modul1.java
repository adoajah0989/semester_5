package latihan_oop;
import java.util.Scanner;

class Mahasiswa {
    private String nim;
    private String nama;
    private double nilaiUTS;
    private double nilaiUAS;

    public Mahasiswa(String nim, String nama, double nilaiUTS, double nilaiUAS) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    public double hitungNilaiAkhir() {
        return (nilaiUTS + nilaiUAS) / 2;
    }

    public String tentukanGrade() {
        double nilaiAkhir = hitungNilaiAkhir();
        if (nilaiAkhir >= 80) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 60) {
            return "C";
        } else if (nilaiAkhir >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    public void tampilData() {
        double nilaiAkhir = hitungNilaiAkhir();
        String grade = tentukanGrade();

        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Nilai UTS: " + nilaiUTS);
        System.out.println("Nilai UAS: " + nilaiUAS);
        System.out.println("Nilai Akhir: " + nilaiAkhir);
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

public class modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine();  // Menangani newline character

        Mahasiswa[] mahasiswaArray = new Mahasiswa[jumlahMahasiswa];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Nilai UTS: ");
            double nilaiUTS = scanner.nextDouble();
            System.out.print("Nilai UAS: ");
            double nilaiUAS = scanner.nextDouble();
            scanner.nextLine();  // Menangani newline character

            mahasiswaArray[i] = new Mahasiswa(nim, nama, nilaiUTS, nilaiUAS);
        }

        System.out.println("Data Mahasiswa:");
        for (Mahasiswa mahasiswa : mahasiswaArray) {
            mahasiswa.tampilData();
        }

        scanner.close();
    }
}
