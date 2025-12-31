package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class OdaGuncelle extends JFrame {
    
    private static final long serialVersionUID = 1L;
    Choice musteriSecimi;
    JTextField odaNoAlani, musaitlikAlani, temizlikAlani;

    public OdaGuncelle() {
        // --- Ana Panel Ayarları ---
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(SystemColor.controlShadow);
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- Başlık ---
        JLabel baslik = new JLabel("ODA DURUMUNU GÜNCELLE");
        baslik.setBounds(100, 20, 350, 30);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 22));
        baslik.setForeground(SystemColor.desktop);
        panel.add(baslik);

        // --- Müşteri Seçimi (ID) ---
        JLabel labelID = new JLabel("Müşteri ID :");
        labelID.setBounds(25, 88, 150, 20);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelID.setForeground(SystemColor.desktop);
        panel.add(labelID);

        musteriSecimi = new Choice();
        musteriSecimi.setBounds(200, 85, 150, 25);
        panel.add(musteriSecimi);

        // Veritabanından müşteri numaralarını çekip Choice içine doldurma
        try {
            baglanti b = new baglanti();
            ResultSet rs = b.s.executeQuery("select * from customer");
            while (rs.next()) {
                musteriSecimi.add(rs.getString("kimlik_no")); // Customer tablosundaki ID sütunu
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- Oda Numarası ---
        JLabel labelOdaNo = new JLabel("Oda Numarası:");
        labelOdaNo.setBounds(25, 130, 150, 20);
        labelOdaNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelOdaNo.setForeground(SystemColor.desktop);
        panel.add(labelOdaNo);

        odaNoAlani = new JTextField();
        odaNoAlani.setBounds(200, 130, 150, 25);
        odaNoAlani.setEditable(false); // Manuel girişi engelle (Kontrol Et butonu getirecek)
        panel.add(odaNoAlani);

        // --- Müsaitlik Durumu ---
        JLabel labelMusaitlik = new JLabel("Müsaitlik Durumu:");
        labelMusaitlik.setBounds(25, 175, 150, 20);
        labelMusaitlik.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelMusaitlik.setForeground(SystemColor.desktop);
        panel.add(labelMusaitlik);

        musaitlikAlani = new JTextField();
        musaitlikAlani.setBounds(200, 175, 150, 25);
        panel.add(musaitlikAlani);

        // --- Temizlik Durumu ---
        JLabel labelTemizlik = new JLabel("Temizlik Durumu:");
        labelTemizlik.setBounds(25, 220, 150, 20);
        labelTemizlik.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTemizlik.setForeground(SystemColor.desktop);
        panel.add(labelTemizlik);

        temizlikAlani = new JTextField();
        temizlikAlani.setBounds(200, 220, 150, 25);
        panel.add(temizlikAlani);

     // --- SAĞ TARAF GÖRSELİ (Küçültüldü ve Sağa Kaydırıldı) ---
        try {
            // Dosya adının klasördekiyle aynı olduğundan emin ol
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/OdaGüncelle.jpg"));
            
            // Boyut 300x300 kare olarak bir tık küçültüldü
            Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            JLabel gorselEtiketi = new JLabel(new ImageIcon(i2));
            
            // x: 520 (Daha sağa), y: 70 (Dikeyde ortalandı), genişlik/yükseklik: 300
            gorselEtiketi.setBounds(520, 70, 300, 300);
            panel.add(gorselEtiketi);
        } catch (Exception e) {
            System.out.println("Görsel yüklenemedi: icon/OdaGüncelle.jpg yolunu kontrol et.");
        }
        // --- BUTONLAR ---

        // 1. KONTROL ET BUTONU (Mevcut durumu getirir)
        JButton butonKontrol = new JButton("KONTROL ET");
        butonKontrol.setBounds(40, 320, 130, 30);
        butonKontrol.setBackground(Color.white);
        butonKontrol.setForeground(SystemColor.black);
        panel.add(butonKontrol);
        
        butonKontrol.addActionListener(e -> {
            String id = musteriSecimi.getSelectedItem();
            try {
                baglanti b = new baglanti();
                // 1. Müşterinin kaldığı odayı bul
                ResultSet rsMusteri = b.s.executeQuery("select * from customer where kimlik_no = '" + id + "'");
                if (rsMusteri.next()) {
                    odaNoAlani.setText(rsMusteri.getString("oda_no"));
                }

                // 2. O odanın detaylarını (müsaitlik ve temizlik) getir
                ResultSet rsOda = b.s.executeQuery("select * from room where roomnumber = '" + odaNoAlani.getText() + "'");
                if (rsOda.next()) {
                    musaitlikAlani.setText(rsOda.getString("availability"));
                    temizlikAlani.setText(rsOda.getString("clean_status"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 2. GÜNCELLE BUTONU (Veritabanına yazar)
        JButton butonGuncelle = new JButton("GÜNCELLE");
        butonGuncelle.setBounds(180, 320, 130, 30);
        butonGuncelle.setBackground(Color.white);
        butonGuncelle.setForeground(SystemColor.desktop);
        panel.add(butonGuncelle);
        
        butonGuncelle.addActionListener(e -> {
            try {
                baglanti b = new baglanti();
                String temizlik = temizlikAlani.getText();
                String musaitlik = musaitlikAlani.getText();
                String odaNo = odaNoAlani.getText();

                // SQL: Odayı temizlik ve müsaitlik durumuna göre güncelle
                b.s.executeUpdate("update room set clean_status = '" + temizlik + "', availability = '" + musaitlik + "' where roomnumber = '" + odaNo + "'");
                
                JOptionPane.showMessageDialog(null, "Oda Durumu Başarıyla Güncellendi");
                setVisible(false);
                new Resepsiyon(); 

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 3. GERİ BUTONU
        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(110, 370, 130, 30);
        butonGeri.setBackground(Color.white);
        butonGeri.setForeground(SystemColor.desktop);
        panel.add(butonGeri);
        
        butonGeri.addActionListener(e -> {
            new Resepsiyon();
            setVisible(false);
        });

        // --- Pencere Genel Ayarları ---
        setUndecorated(true);
        setSize(850, 450);
        setLocationRelativeTo(null); // Ekranın tam ortasında açılır
        getContentPane().setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OdaGuncelle();
    }
}