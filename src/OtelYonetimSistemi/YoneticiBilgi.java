package OtelYonetimSistemi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class YoneticiBilgi extends JFrame {
    
    private static final long serialVersionUID = 1L;
    JTable tablo;

    public YoneticiBilgi(){
        // Ana Panel Ayarları
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 600);
        panel.setBackground(SystemColor.controlShadow); // Resepsiyon ile aynı koyu tema
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- BAŞLIK ---
        JLabel baslik = new JLabel("YÖNETİCİ BİLGİLERİ");
        baslik.setBounds(380, 5, 300, 30);
        baslik.setForeground(SystemColor.desktop);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(baslik);

        // 1. ADIM: Tablo Modelini Tanımlama
        String[] sutunlar = {"TC", "İsim", "Yaş", "Cinsiyet", "Görev", "Maaş", "Telefon", "E-posta"};
        DefaultTableModel model = new DefaultTableModel(sutunlar, 0);
        tablo = new JTable(model);
        
        // Tablo Görsel Ayarları
        tablo.setForeground(Color.WHITE);
        tablo.setBackground(Color.white);
        tablo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tablo.setRowHeight(25);

        // Tablo Başlık (Header) Ayarları
        JTableHeader header = tablo.getTableHeader();
        header.setBackground(Color.white);
        header.setForeground(Color.black);
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

        // 2. ADIM: Tabloyu JScrollPane içine alma
        JScrollPane scrollPane = new JScrollPane(tablo);
        scrollPane.setBounds(10, 40, 980, 450);
        scrollPane.getViewport().setBackground(Color.white); // Boş alanların rengi
        panel.add(scrollPane);

        // 3. ADIM: Veritabanından Veri Çekme
        try {
            baglanti b = new baglanti();
            // Sadece 'Yönetici' olanları çekiyoruz
            String sorgu = "select * from employee where job = 'Yönetici'"; 
            ResultSet resultSet = b.s.executeQuery(sorgu);
            
            while (resultSet.next()) {
                Object[] satir = {
                    resultSet.getString("tc"),
                    resultSet.getString("name"),
                    resultSet.getString("age"),
                    resultSet.getString("gender"),
                    resultSet.getString("job"),
                    resultSet.getString("salary"),
                    resultSet.getString("phone"),
                    resultSet.getString("email")
                };
                model.addRow(satir);
            }
        } catch (Exception e ){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Veritabanı hatası!");
        }

        // 4. ADIM: Geri Dönüş Butonu
        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(440, 520, 120, 30);
        butonGeri.setBackground(Color.white);
        butonGeri.setForeground(Color.black);
        butonGeri.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(butonGeri);
        
        butonGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Resepsiyon(); // Resepsiyon ekranına geri döner
                setVisible(false); // Bu pencereyi kapatır
            }
        });

        // Pencere Genel Ayarları
        setUndecorated(true); // Çerçevesiz (Modern) görünüm
        getContentPane().setLayout(null);
        setSize(1000, 600);
        setLocationRelativeTo(null); // Ekranın ortasında açılır
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new YoneticiBilgi();
    }
}