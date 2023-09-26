/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newper5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author nurma
 */
public class NewPer5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Memuat kelas driver JDBC MySQL ke dalam memori
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String jdbcURL = "jdbc:mysql://localhost:3306/nurman";
            String username = "nurman";
            String password = "LS(*uT14Zj0735ix";

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            
            if (connection != null) {
                System.out.println("Koneksi berhasil!");
                 Statement statement = connection.createStatement();
                String sqlQuery = "SELECT * FROM mahasiswa";
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    // Gantilah nama kolom dengan nama kolom yang sesuai dalam tabel Anda
                    String kolom1 = resultSet.getString("NIM");
                    String kolom2 = resultSet.getString("NAMA");
                    
                    System.out.println("NIM : " + kolom1 + ", NAMA: " + kolom2);
                }

                // Tutup semua sumber daya
                resultSet.close();
                statement.close();
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Kelas driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal! Error: " + e.getMessage());
        }
    }
}
