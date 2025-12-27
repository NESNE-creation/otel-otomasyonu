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
        getContentPane().add(panel);

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
        adLabel.setBounds(212,5,70,19);
        adLabel.setForeground(Color.WHITE);
        adLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(adLabel);

        JLabel gorevLabel = new JLabel("Görev");
        gorevLabel.setBounds(400,5,70,19);
        gorevLabel.setForeground(Color.WHITE);
        gorevLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gorevLabel);

        JLabel maasLabel = new JLabel("Maaş");
        maasLabel.setBounds(895,5,70,19);
        maasLabel.setForeground(Color.WHITE);
        maasLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(maasLabel);

        JLabel telefonLabel = new JLabel("Telefon");
        telefonLabel.setBounds(585,5,70,19);
        telefonLabel.setForeground(Color.WHITE);
        telefonLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(telefonLabel);

        JLabel gmailLabel = new JLabel("Gmail");
        gmailLabel.setBounds(772,5,70,19);
        gmailLabel.setForeground(Color.WHITE);
        gmailLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gmailLabel);

        JLabel tcLabel = new JLabel("TC");
        tcLabel.setBounds(65,5,70,19);
        tcLabel.setForeground(Color.WHITE);
        tcLabel.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(tcLabel);

        // Pencere Genel Ayarları
        setUndecorated(true);
        getContentPane().setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new YoneticiBilgi();
    }
}