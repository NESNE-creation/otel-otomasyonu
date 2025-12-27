package otelotomasyonu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class YoneticiBilgi extends JFrame {
    YoneticiBilgi(){
        // Ana Panel Ayarları
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        // Yönetici Verilerinin Listeleneceği Tablo
        JTable tablo = new JTable();
        tablo.setBounds(10,34,980,450);
        tablo.setForeground(Color.WHITE);
        tablo.setBackground(new Color(3,45,48));
        panel.add(tablo);

        try {
            // Senin verdiğin baglanti sınıfını kullanıyoruz
            baglanti b = new baglanti();
            
            // Sadece mesleği 'Manager' (Yönetici) olanları getiren sorgu
            String sorgu = "select * from Employee where job = 'Manager'";
            
            // baglanti classındaki 's' Statement nesnesi ile sorguyu çalıştırıyoruz
            ResultSet resultSet = b.s.executeQuery(sorgu);
            
            // Sonuçları tabloya aktarıyoruz
            //tablo.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e ){
            e.printStackTrace();
        }

        // Geri Dönüş Butonu
        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(350,500,120,30);
        butonGeri.setBackground(Color.BLACK);
        butonGeri.setForeground(Color.WHITE);
        panel.add(butonGeri);
        
        butonGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Pencereyi gizler
            }
        });

        // Tablo Sütun Başlıkları (Türkçe)
        JLabel adLabel = new JLabel("İsim");
        adLabel.setBounds(41,11,70,19);
        adLabel.setForeground(Color.WHITE);
        adLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(adLabel);

        JLabel yasLabel = new JLabel("Yaş");
        yasLabel.setBounds(159,11,70,19);
        yasLabel.setForeground(Color.WHITE);
        yasLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(yasLabel);

        JLabel cinsiyetLabel = new JLabel("Cinsiyet");
        cinsiyetLabel.setBounds(273,11,70,19);
        cinsiyetLabel.setForeground(Color.WHITE);
        cinsiyetLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(cinsiyetLabel);

        JLabel gorevLabel = new JLabel("Görev");
        gorevLabel.setBounds(416,11,70,19);
        gorevLabel.setForeground(Color.WHITE);
        gorevLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gorevLabel);

        JLabel maasLabel = new JLabel("Maaş");
        maasLabel.setBounds(536,11,70,19);
        maasLabel.setForeground(Color.WHITE);
        maasLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(maasLabel);

        JLabel telefonLabel = new JLabel("Telefon");
        telefonLabel.setBounds(656,11,70,19);
        telefonLabel.setForeground(Color.WHITE);
        telefonLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(telefonLabel);

        JLabel gmailLabel = new JLabel("Gmail");
        gmailLabel.setBounds(786,11,70,19);
        gmailLabel.setForeground(Color.WHITE);
        gmailLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gmailLabel);

        JLabel tcLabel = new JLabel("TC No");
        tcLabel.setBounds(896,11,70,19);
        tcLabel.setForeground(Color.WHITE);
        tcLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(tcLabel);

        // Pencere Genel Ayarları
        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new YoneticiBilgi();
    }
}