package otelotomasyonu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MusteriBilgi extends JFrame {
    MusteriBilgi(){

        // Ana Panel Ayarları
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        // Müşteri Verilerinin Listeleneceği Tablo
        JTable tablo = new JTable();
        tablo.setBounds(10,40,900,450);
        tablo.setBackground(new Color(3,45,48));
        tablo.setForeground(Color.WHITE);
        panel.add(tablo);

        // --- VERİTABANI BAĞLANTISI ---
        try {
            // Senin paylaştığın baglanti class'ından nesne oluşturuyoruz
            baglanti b = new baglanti();
            
            // Müşteri tablosundaki tüm verileri çeken sorgu
            String sorgu = "select * from Customer"; 
            
            // Senin baglanti sınıfındaki 's' (Statement) nesnesini kullanıyoruz
            ResultSet resultSet = b.s.executeQuery(sorgu);
            
            // Gelen verileri tabloya aktarıyoruz
           // tablo.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e ){
            System.out.println("Müşteri bilgileri yüklenirken hata oluştu!");
            e.printStackTrace();
        }
        // ------------------------------

        // Tablo Sütun Başlıkları
        JLabel idEtiketi = new JLabel("Kimlik");
        idEtiketi.setBounds(31,11,100,14);
        idEtiketi.setForeground(Color.WHITE);
        idEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(idEtiketi);

        JLabel numaraEtiketi = new JLabel("Numara");
        numaraEtiketi.setBounds(150,11,100,14);
        numaraEtiketi.setForeground(Color.WHITE);
        numaraEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(numaraEtiketi);

        JLabel adEtiketi = new JLabel("İsim");
        adEtiketi.setBounds(270,11,100,14);
        adEtiketi.setForeground(Color.WHITE);
        adEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(adEtiketi);

        JLabel cinsiyetEtiketi = new JLabel("Cinsiyet");
        cinsiyetEtiketi.setBounds(360,11,100,14);
        cinsiyetEtiketi.setForeground(Color.WHITE);
        cinsiyetEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(cinsiyetEtiketi);

        JLabel ulkeEtiketi = new JLabel("Ülke");
        ulkeEtiketi.setBounds(480,11,100,25);
        ulkeEtiketi.setForeground(Color.WHITE);
        ulkeEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(ulkeEtiketi);

        JLabel odaEtiketi = new JLabel("Oda");
        odaEtiketi.setBounds(600,11,100,14);
        odaEtiketi.setForeground(Color.WHITE);
        odaEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(odaEtiketi);

        JLabel zamanEtiketi = new JLabel("Giriş Zamanı"); // CI Time = Check-In Time
        zamanEtiketi.setBounds(680,11,100,14);
        zamanEtiketi.setForeground(Color.WHITE);
        zamanEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(zamanEtiketi);

        JLabel depoEtiketi = new JLabel("Depozito");
        depoEtiketi.setBounds(800,11,100,25);
        depoEtiketi.setForeground(Color.WHITE);
        depoEtiketi.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(depoEtiketi);

        // Geri Dönüş Butonu
        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(450,510,120,30);
        butonGeri.setBackground(Color.BLACK);
        butonGeri.setForeground(Color.WHITE);
        panel.add(butonGeri);
        
        butonGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Pencereyi kapatır
            }
        });

        // JFrame Pencere Ayarları
        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MusteriBilgi();
    }
}