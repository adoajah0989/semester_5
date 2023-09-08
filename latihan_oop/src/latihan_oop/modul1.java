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

        System.out.println("======================================================");
            System.out.println("NIM\t\tNama\t\tUTS\tUAS\tGrade");
            System.out.println(nim+"\t\t"+nama+"\t"+nilaiUTS+"\t"+nilaiUAS+"\t"+grade);
    }
}

public class modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nama,nim;
        double nilaiUTS,nilaiUAS;

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine();  // Menangani newline character

        Mahasiswa[] mahasiswaArray = new Mahasiswa[jumlahMahasiswa];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM: ");
            nim = scanner.nextLine();
            System.out.print("Nama: ");
            nama = scanner.nextLine();
            System.out.print("Nilai UTS: ");
            nilaiUTS = scanner.nextDouble();
            System.out.print("Nilai UAS: ");
            nilaiUAS = scanner.nextDouble();
            scanner.nextLine();  // Menangani newline character

            mahasiswaArray[i] = new Mahasiswa(nim, nama, nilaiUTS, nilaiUAS); //berfungsi untuk memasukan nilai ke dalam mahasiswaArray[i]
        }

        System.out.println("Data Mahasiswa:");
        for (Mahasiswa mahasiswa : mahasiswaArray) {
            mahasiswa.tampilData();
        }

        scanner.close();
    }
}
