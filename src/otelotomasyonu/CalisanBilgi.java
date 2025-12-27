package otelotomasyonu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CalisanBilgi extends JFrame {
    
    CalisanBilgi() {
        // Ana Panel Ayarları
        JPanel anaPanel = new JPanel();
        anaPanel.setBounds(5, 5, 990, 590);
        anaPanel.setBackground(new Color(3, 45, 48));
        anaPanel.setLayout(null);
        add(anaPanel);

        // Verilerin Listeleneceği Tablo
        JTable veriTablosu = new JTable();
        veriTablosu.setBounds(10, 34, 980, 450);
        veriTablosu.setForeground(Color.WHITE);
        veriTablosu.setBackground(new Color(3, 45, 48));
        anaPanel.add(veriTablosu);

        // Veritabanından Veri Çekme İşlemi
        try {
            // Sizin verdiğiniz 'baglanti' sınıfından nesne oluşturuluyor
            baglanti b = new baglanti(); 
            
            // Veritabanı tablonuzun adı "employee" ise bu sorgu çalışır
            String sorgu = "select * from employee"; 
            
            // baglanti sınıfındaki 's' (Statement) kullanılıyor
            ResultSet sonucKumesi = b.s.executeQuery(sorgu);
            
            // Tabloyu veritabanından gelen verilerle doldurur
           // veriTablosu.setModel(DbUtils.resultSetToTableModel(sonucKumesi));
            
        } catch (Exception e) {
            System.out.println("Veri çekme hatası oluştu!");
            e.printStackTrace();
        }

        // Geri Dönüş Butonu
        JButton butonGeri = new JButton("GERİ DÖN");
        butonGeri.setBounds(350, 500, 120, 30);
        butonGeri.setBackground(Color.BLACK);
        butonGeri.setForeground(Color.WHITE);
        anaPanel.add(butonGeri);
        
        butonGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Tablo Başlık Etiketleri (Görsel Düzenleme İçin)
        JLabel etiketAd = new JLabel("İsim");
        etiketAd.setBounds(41, 11, 70, 19);
        etiketAd.setForeground(Color.WHITE);
        etiketAd.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketAd);

        JLabel etiketYas = new JLabel("Yaş");
        etiketYas.setBounds(159, 11, 70, 19);
        etiketYas.setForeground(Color.WHITE);
        etiketYas.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketYas);

        JLabel etiketCinsiyet = new JLabel("Cinsiyet");
        etiketCinsiyet.setBounds(273, 11, 70, 19);
        etiketCinsiyet.setForeground(Color.WHITE);
        etiketCinsiyet.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketCinsiyet);

        JLabel etiketGorev = new JLabel("Görev");
        etiketGorev.setBounds(416, 11, 70, 19);
        etiketGorev.setForeground(Color.WHITE);
        etiketGorev.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketGorev);

        JLabel etiketMaas = new JLabel("Maaş");
        etiketMaas.setBounds(536, 11, 70, 19);
        etiketMaas.setForeground(Color.WHITE);
        etiketMaas.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketMaas);

        JLabel etiketTelefon = new JLabel("Telefon");
        etiketTelefon.setBounds(656, 11, 70, 19);
        etiketTelefon.setForeground(Color.WHITE);
        etiketTelefon.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketTelefon);

        JLabel etiketEposta = new JLabel("E-posta");
        etiketEposta.setBounds(786, 11, 70, 19);
        etiketEposta.setForeground(Color.WHITE);
        etiketEposta.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketEposta);

        JLabel etiketTC = new JLabel("TC No");
        etiketTC.setBounds(896, 11, 70, 19);
        etiketTC.setForeground(Color.WHITE);
        etiketTC.setFont(new Font("Tahoma", Font.BOLD, 14));
        anaPanel.add(etiketTC);

        // Pencere Genel Ayarları
        setUndecorated(true);
        setLayout(null);
        setLocation(430, 100);
        setSize(1000, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalisanBilgi();
    }
}