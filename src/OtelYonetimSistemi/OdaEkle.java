package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdaEkle extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    
    // Değişken isimlerini daha anlaşılır hale getirdik
    JTextField odaNoAlani, fiyatAlani;
    JComboBox<String> durumKutusu, temizlikKutusu, yatakKutusu;
    JButton butonEkle, butonGeri;

    public OdaEkle() {
        // Ana Panel Ayarları
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 770, 440); // Boyut optimize edildi
        panel.setBackground(SystemColor.controlShadow);
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- Başlık ---
        JLabel baslik = new JLabel("YENİ ODA EKLE");
        baslik.setBounds(250, 15, 200, 30);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 22));
        baslik.setForeground(Color.BLACK);
        panel.add(baslik);

        // --- Oda Numarası ---
        JLabel l2 = new JLabel("Oda Numarası");
        l2.setBounds(64, 70, 152, 22);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.BLACK);
        panel.add(l2);
        
        odaNoAlani = new JTextField();
        odaNoAlani.setBounds(200, 70, 156, 25);
        odaNoAlani.setFont(new Font("Tahoma", Font.PLAIN, 14));
        odaNoAlani.setForeground(Color.BLACK);
        odaNoAlani.setBackground(SystemColor.text);
        panel.add(odaNoAlani);

        // --- Uygunluk ---
        JLabel l3 = new JLabel("Durum");
        l3.setBounds(64, 110, 152, 22);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.BLACK);
        panel.add(l3);

        durumKutusu = new JComboBox<>(new String[] {"Uygun", "Dolu"});
        durumKutusu.setBounds(200, 110, 156, 25);
        durumKutusu.setBackground(SystemColor.text);
        durumKutusu.setForeground(Color.BLACK);
        panel.add(durumKutusu);

        // --- Fiyat ---
        JLabel l4 = new JLabel("Fiyat");
        l4.setBounds(64, 150, 152, 22);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.BLACK);
        panel.add(l4);

        fiyatAlani = new JTextField();
        fiyatAlani.setBounds(200, 150, 156, 25);
        fiyatAlani.setBackground(SystemColor.text);
        fiyatAlani.setForeground(Color.BLACK);
        panel.add(fiyatAlani);

        // --- Temizlik ---
        JLabel l5 = new JLabel("Temizlik");
        l5.setBounds(64, 190, 152, 22);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(Color.BLACK);
        panel.add(l5);

        temizlikKutusu = new JComboBox<>(new String[]{"Temiz", "Kirli"});
        temizlikKutusu.setBounds(200, 190, 156, 25);
        temizlikKutusu.setBackground(SystemColor.text);
        temizlikKutusu.setForeground(Color.BLACK);
        panel.add(temizlikKutusu);

        // --- Yatak Tipi ---
        JLabel l6 = new JLabel("Yatak Tipi");
        l6.setBounds(64, 230, 152, 22);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setForeground(Color.BLACK);
        panel.add(l6);

        yatakKutusu = new JComboBox<>(new String[]{"Tek Kişilik", "Çift Kişilik", "King Size Bed"});
        yatakKutusu.setBounds(200, 230, 156, 25);
        yatakKutusu.setBackground(SystemColor.text);
        yatakKutusu.setForeground(Color.BLACK);
        panel.add(yatakKutusu);

        // --- Butonlar ---
        butonEkle = new JButton("EKLE");
        butonEkle.setBounds(64, 321, 111, 33);
        butonEkle.setBackground(Color.white);
        butonEkle.setForeground(Color.BLACK);
        butonEkle.addActionListener(this);
        panel.add(butonEkle);

        butonGeri = new JButton("GERİ");
        butonGeri.setBounds(198, 321, 111, 33);
        butonGeri.setBackground(Color.white);
        butonGeri.setForeground(Color.BLACK);
        butonGeri.addActionListener(this);
        panel.add(butonGeri);

        try {
            // Dosya adını OdaEkle.jpg olarak güncelledik
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/OdaEkle.jpg"));
            Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            JLabel labelGorsel = new JLabel(new ImageIcon(image));
            labelGorsel.setBounds(420, 60, 300, 300);
            panel.add(labelGorsel);
        } catch (Exception ex) {
            System.out.println("Görsel yüklenemedi: Dosya yolunu kontrol edin.");
        }

        // --- Pencere Ayarları ---
        setUndecorated(true);
        setSize(780, 450); // Sayfayı küçülttük
        setLocationRelativeTo(null); // SAYFAYI EKRANIN TAM ORTASINA ALIR
        getContentPane().setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butonEkle) {
            try {
                baglanti b = new baglanti(); // "con" yerine projenle uyumlu "baglanti"
                String odaNo = odaNoAlani.getText();
                String durum = (String) durumKutusu.getSelectedItem();
                String temizlik = (String) temizlikKutusu.getSelectedItem();
                String fiyat = fiyatAlani.getText();
                String tip = (String) yatakKutusu.getSelectedItem();

                String sorgu = "insert into room values('"+odaNo+"', '"+durum+"', '"+temizlik+"', '"+fiyat+"', '"+tip+"')";
                b.s.executeUpdate(sorgu); // b.statement yerine b.s (bağlantı sınıfına göre)

                JOptionPane.showMessageDialog(null, "Oda Başarıyla Eklendi");
                setVisible(false);
                new Yonetici(); // Kayıt sonrası yönetici paneline döner

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Hata: Kaydedilemedi!");
            }
        } else if (e.getSource() == butonGeri) {
            setVisible(false);
            new Yonetici(); // Geri tuşuyla yönetici paneline döner
        }
    }

    public static void main(String[] args) {
        new OdaEkle(); // Hatalı olan 'AddRoom' ismi 'OdaEkle' yapıldı
    }
}