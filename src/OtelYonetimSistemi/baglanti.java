package OtelYonetimSistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class baglanti {
    
  
    public Connection c;
    public Statement s;

    public baglanti(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
         // Kendi MySQL şifrenizle burayı güncellemeyi unutmayın!
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/otelDB", "root", "Fee45bb1");
            
          
            s = c.createStatement();
            
            System.out.println("BAŞARDIN! Veritabanına bağlandın ");

        } catch (Exception e) {
            System.out.println("BAĞLANTI HATASI! - Şifreni veya Veritabanı ismini kontrol et!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new baglanti(); 
    }
}