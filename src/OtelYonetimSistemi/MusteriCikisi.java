package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class MusteriCikisi extends JFrame {
    
    private static final long serialVersionUID = 1L;
    Choice musteriSecimi;

    public MusteriCikisi() {
        // --- Ana Panel Ayarları ---
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(SystemColor.controlShadow);
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- Başlık ---
        JLabel baslik = new JLabel("MÜŞTERİ ÇIKIŞI (CHECK-OUT)");
        baslik.setBounds(50, 20, 350, 30);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 20));
        baslik.setForeground(Color.black);
        panel.add(baslik);

        // --- Müşteri ID (TC/No) ---
        JLabel labelID = new JLabel("Müşteri ID:");
        labelID.setBounds(30, 80, 150, 30);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(SystemColor.desktop);
        panel.add(labelID);

        musteriSecimi = new Choice();
        musteriSecimi.setBounds(200, 85, 150, 25);
        panel.add(musteriSecimi);

        // --- Oda Numarası ---
        JLabel labelOdaNo = new JLabel("Oda Numarası:");
        labelOdaNo.setBounds(30, 130, 150, 30);
        labelOdaNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelOdaNo.setForeground(SystemColor.desktop);
        panel.add(labelOdaNo);

        JLabel odaNoGosterge = new JLabel();
        odaNoGosterge.setBounds(200, 130, 150, 30);
        odaNoGosterge.setFont(new Font("Tahoma", Font.BOLD, 14));
        odaNoGosterge.setForeground(Color.YELLOW); // Daha belirgin olması için
        panel.add(odaNoGosterge);

        // --- Giriş Zamanı ---
        JLabel labelGiris = new JLabel("Giriş Zamanı:");
        labelGiris.setBounds(30, 180, 150, 30);
        labelGiris.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGiris.setForeground(SystemColor.desktop);
        panel.add(labelGiris);

        JLabel girisZamaniGosterge = new JLabel();
        girisZamaniGosterge.setBounds(200, 180, 250, 30);
        girisZamaniGosterge.setFont(new Font("Tahoma", Font.BOLD, 14));
        girisZamaniGosterge.setForeground(SystemColor.desktop);
        panel.add(girisZamaniGosterge);

        // --- Çıkış Zamanı (Sistem Saati) ---
        JLabel labelCikis = new JLabel("Çıkış Zamanı:");
        labelCikis.setBounds(30, 230, 150, 30);
        labelCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCikis.setForeground(SystemColor.desktop);
        panel.add(labelCikis);

        Date tarih = new Date();
        JLabel cikisZamaniGosterge = new JLabel("" + tarih);
        cikisZamaniGosterge.setBounds(200, 230, 250, 30);
        cikisZamaniGosterge.setFont(new Font("Tahoma", Font.BOLD, 14));
        cikisZamaniGosterge.setForeground(Color.WHITE);
        panel.add(cikisZamaniGosterge);
        
        try {
            // Dosya adının MusteriCikis.jpg olduğundan emin ol
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/MusteriCikis.jpg"));
            // Görsel dikey olduğu için 300x350 boyutunda ölçekledik
            Image i2 = i1.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH);
            JLabel gorselEtiketi = new JLabel(new ImageIcon(i2));
            // Sağ tarafa, yazılara değmeyecek şekilde konumlandırma (x: 460)
            gorselEtiketi.setBounds(460, 20, 300, 350);
            panel.add(gorselEtiketi);
        } catch (Exception e) {
            System.out.println("Görsel yüklenemedi: icon/MusteriCikis.jpg yolunu kontrol et.");
        }

        // --- Veritabanından Müşterileri Çekme ---
        try {
            baglanti b = new baglanti();
            ResultSet rs = b.s.executeQuery("select * from customer");
            while (rs.next()) {
                musteriSecimi.add(rs.getString("oda_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- BUTONLAR ---

        // 1. ÇIKIŞ YAP (Veritabanı İşlemi)
        JButton butonCikisYap = new JButton("ÇIKIŞ YAP");
        butonCikisYap.setBounds(30, 300, 120, 30);
        butonCikisYap.setForeground(SystemColor.black);
        butonCikisYap.setBackground(Color.white);
        panel.add(butonCikisYap);

        butonCikisYap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    baglanti b = new baglanti();
                    String id = musteriSecimi.getSelectedItem();
                    String odaNo = odaNoGosterge.getText();

                    // Müşteriyi sil
                    b.s.executeUpdate("delete from customer where oda_no = '" + id + "'");
                    // Odayı boşalt (Uygun yap)
                    b.s.executeUpdate("update room set availability = 'Uygun' where roomnumber = '" + odaNo + "'");

                    JOptionPane.showMessageDialog(null, "Müşteri Çıkışı Başarıyla Yapıldı ve Oda Boşaltıldı.");
                    setVisible(false);
                    new Resepsiyon(); 

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 2. BİLGİLERİ GETİR (Seçili müşterinin oda ve giriş bilgilerini çeker)
        JButton butonKontrol = new JButton("KONTROL ET");
        butonKontrol.setBounds(300, 300, 120, 30);
        butonKontrol.setForeground(SystemColor.black);
        butonKontrol.setBackground(Color.white);
        panel.add(butonKontrol);

        butonKontrol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    baglanti b = new baglanti();
                    ResultSet rs = b.s.executeQuery("select * from customer where oda_no = '" + musteriSecimi.getSelectedItem() + "'");
                    while (rs.next()) {
                        odaNoGosterge.setText(rs.getString("oda_no"));
                        girisZamaniGosterge.setText(rs.getString("giris_saati"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 3. GERİ
        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(170, 300, 120, 30);
        butonGeri.setForeground(SystemColor.black);
        butonGeri.setBackground(Color.white);
        panel.add(butonGeri);

        butonGeri.addActionListener(e -> {
            new Resepsiyon();
            setVisible(false);
        });

        // --- Pencere Ayarları ---
        setUndecorated(true);
        getContentPane().setLayout(null);
        setSize(800, 400);
        setLocationRelativeTo(null); // Tam ortada açılması için
        setVisible(true);
    }

    public static void main(String[] args) {
        new MusteriCikisi();
    }
}