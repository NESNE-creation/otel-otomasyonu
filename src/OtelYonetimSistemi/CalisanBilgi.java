package OtelYonetimSistemi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; // Manuel tablo yönetimi için gerekli
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CalisanBilgi extends JFrame {
    
    private static final long serialVersionUID = 1L;
    JTable veriTablosu; // Global tanımladık

    CalisanBilgi() {
        JPanel anaPanel = new JPanel();
        anaPanel.setBounds(5, 5, 990, 590);
        anaPanel.setBackground(SystemColor.controlShadow);
        anaPanel.setLayout(null);
        getContentPane().add(anaPanel);

        // 1. ADIM: Tablo Modeli Oluşturma (Sütun Başlıkları)
        String[] sutunlar = {"TC No", "Ad Soyad", "Yaş", "Görev", "Maaş", "Telefon", "E-posta"};
        DefaultTableModel model = new DefaultTableModel(sutunlar, 0);
        veriTablosu = new JTable(model);
        
        // Tabloyu kaydırılabilir yapmak için JScrollPane içine koyuyoruz
        JScrollPane scrollPane = new JScrollPane(veriTablosu);
        scrollPane.setBounds(10, 40, 980, 450);
        anaPanel.add(scrollPane);

        // 2. ADIM: Veritabanından Veri Çekme ve Tabloya Ekleme
        try {
            baglanti b = new baglanti(); 
            String sorgu = "select * from employee"; 
            ResultSet rs = b.s.executeQuery(sorgu);
            
            while(rs.next()) {
                Object[] satir = {
                    rs.getString("tc"),     // "TC No" sütununa gider
                    rs.getString("name"),   // "Ad Soyad" sütununa gider
                    rs.getString("age"),    // "Yaş" sütununa gider
                    rs.getString("job"),    // "Görev" sütununa gider
                    rs.getString("salary"), // "Maaş" sütununa gider (DOĞRU EŞLEME)
                    rs.getString("phone"),  // "Telefon" sütununa gider (DOĞRU EŞLEME)
                    rs.getString("email")   // "E-posta" sütununa gider (DOĞRU EŞLEME)
                };
                model.addRow(satir);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton butonGeri = new JButton("GERİ DÖN");
        butonGeri.setBounds(435, 510, 120, 30);
        butonGeri.setBackground(Color.white);
        butonGeri.setForeground(Color.black);
        anaPanel.add(butonGeri);
        
        butonGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Resepsiyon();
                setVisible(false);
            }
        });

        // Pencere Ayarları
        setUndecorated(true);
        getContentPane().setLayout(null);
        setLocation(430, 100);
        setSize(1000, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalisanBilgi();
    }
}