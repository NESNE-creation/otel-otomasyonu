package OtelYonetimSistemi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Oda extends JFrame {
    
    private static final long serialVersionUID = 1L;
    JTable tablo;
    DefaultTableModel model;

    public Oda() {
        // --- Ana Pencere Ayarları ---
        setTitle("Oda Listesi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null); 
        setUndecorated(true);
        getContentPane().setLayout(null); // Layout null olmalı

        // --- Ana Panel Ayarları ---
        JPanel panel = new JPanel();
        // Paneli pencerenin içine tam oturacak şekilde genişletiyoruz
        panel.setBounds(10, 10, 880, 580); 
        panel.setBackground(SystemColor.controlDkShadow);
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- Üst Başlık Etiketi ---
        JLabel baslik = new JLabel("ODA LİSTESİ");
        baslik.setHorizontalAlignment(SwingConstants.CENTER);
        baslik.setBounds(340, 10, 200, 30);
        baslik.setForeground(Color.WHITE);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(baslik);

        // 1. ADIM: Tablo Modelini Tanımlama
        String[] sutunlar = {"Oda No", "Müsaitlik", "Temizlik Durumu", "Ücret", "Yatak Tipi"};
        model = new DefaultTableModel(sutunlar, 0); 
        tablo = new JTable(model);
        
        // Tablo Görsel Ayarları
        tablo.setBackground(Color.WHITE);
        tablo.setRowHeight(25);

        // Tablo Başlıklarını Özelleştirme
        JTableHeader header = tablo.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));

        // 2. ADIM: JScrollPane Eklemek
        JScrollPane scrollPane = new JScrollPane(tablo);
        scrollPane.setBounds(20, 60, 840, 400); // Panelin içine tam sığacak şekilde
        panel.add(scrollPane);

        // 3. ADIM: Veritabanından Veri Çekme
        try {
            baglanti b = new baglanti(); 
            String sorgu = "select * from room";
            ResultSet rs = b.s.executeQuery(sorgu);
            
            while(rs.next()) {
                Object[] satir = {
                    rs.getString("roomnumber"),
                    rs.getString("availability"),
                    rs.getString("clean_status"),
                    rs.getString("price"),
                    rs.getString("bed_type")
                };
                model.addRow(satir);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Veritabanı bağlantı hatası: " + e.getMessage());
        }

        // --- Geri Butonu ---
        JButton back = new JButton("GERİ");
        back.setBackground(Color.WHITE);
        back.setBounds(380, 500, 120, 35);
        panel.add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Resepsiyon();
                setVisible(false);
                // new Resepsiyon(); // Resepsiyon sınıfın hazırsa burayı açabilirsin
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Oda();
    }
}