package OtelYonetimSistemi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class MusteriBilgi extends JFrame {
    private static final long serialVersionUID = 1L;
    JTable tablo;

    public MusteriBilgi() {
        // --- Ana Panel Ayarları (Senin Düzenin) ---
        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 890, 590);
        panel.setBackground(SystemColor.controlShadow);
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- 1. ADIM: Tablo Hazırlama (Soyisim Eklenmiş Hali) ---
        String[] sutunlar = {"ID Türü", "ID No", "İsim", "Soyisim", "Cinsiyet", "Ülke", "Oda No", "Giriş Zamanı", "Depozito"};
        DefaultTableModel model = new DefaultTableModel(sutunlar, 0);
        tablo = new JTable(model);
        
        tablo.setBackground(Color.white);
        tablo.setForeground(Color.black); // Verilerin okunması için siyah yapıldı
        tablo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(tablo);
        scrollPane.setBounds(10, 40, 870, 450);
        panel.add(scrollPane);

        // --- 2. ADIM: Veritabanından Verileri Çekme (SQL Yapına Göre) ---
        try {
            baglanti b = new baglanti(); 
            String sorgu = "select * from customer"; 
            ResultSet resultSet = b.s.executeQuery(sorgu);
            
            while (resultSet.next()) {
                Object[] satir = {
                    resultSet.getString("kimlik_turu"), 
                    resultSet.getString("kimlik_no"),  
                    resultSet.getString("isim"),       
                    resultSet.getString("soyisim"),    // Veritabanındaki yeni kolon
                    resultSet.getString("cinsiyet"),   
                    resultSet.getString("ulke"),       
                    resultSet.getString("oda_no"),     
                    resultSet.getString("giris_saati"),
                    resultSet.getString("depozito")    
                };
                model.addRow(satir);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veritabanı bağlantı hatası!");
            e.printStackTrace();
        }

        // --- 3. ADIM: Geri Dönüş Butonu (Senin Düzenin) ---
        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(380, 510, 120, 30);
        butonGeri.setBackground(Color.white);
        butonGeri.setForeground(Color.black);
        butonGeri.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(butonGeri);
        
        butonGeri.addActionListener(e -> {
            setVisible(false);    
            new Resepsiyon();     
        });

        // --- Pencere Ayarları (Senin Düzenin) ---
        setUndecorated(true);
        getContentPane().setLayout(null);
        setSize(900, 600);
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MusteriBilgi();
    }
}