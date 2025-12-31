package OtelYonetimSistemi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class OdaAra extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    JCheckBox musaitlikKutusu;
    Choice yatakSecimi;
    JTable tablo;
    DefaultTableModel model;
    JButton butonAra, butonGeri;

    OdaAra() {
        // --- Ana Panel Ayarları ---
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.controlShadow); // Oda sınıfıyla aynı koyu tema
        panel.setBounds(0, 0, 700, 500);
        panel.setLayout(null);
        setContentPane(panel);

        // --- Başlık ---
        JLabel baslik = new JLabel("ODA ARA");
        baslik.setBounds(280, 11, 186, 31);
        baslik.setForeground(Color.WHITE);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(baslik);
        
        // --- Sağ Üst İkon ---
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/OdaAra.jpg"));
            Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel ikonEtiketi = new JLabel(i3);
            ikonEtiketi.setBounds(620, 10, 50, 50); 
            panel.add(ikonEtiketi);
        } catch (Exception e) {
            System.out.println("İkon yolu bulunamadı.");
        }

        // --- Yatak Tipi Seçimi ---
        JLabel labelYatak = new JLabel("Yatak Tipi:");
        labelYatak.setBounds(50, 73, 120, 20);
        labelYatak.setForeground(Color.WHITE);
        labelYatak.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelYatak);

        yatakSecimi = new Choice();
        yatakSecimi.add("Tek Kişilik");
        yatakSecimi.add("Çift Kişilik");
        yatakSecimi.add("King Size Bed");
        yatakSecimi.setBounds(170, 70, 150, 25);
        panel.add(yatakSecimi);

        // --- Müsaitlik Filtresi (CheckBox) ---
        musaitlikKutusu = new JCheckBox("Sadece Müsait Olanları Göster");
        musaitlikKutusu.setBounds(400, 73, 250, 23);
        musaitlikKutusu.setForeground(Color.WHITE);
        musaitlikKutusu.setBackground(SystemColor.controlShadow);
        musaitlikKutusu.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(musaitlikKutusu);

        // --- Tablo Yapılandırması ---
        String[] sutunlar = {"Oda No", "Müsaitlik", "Temizlik", "Ücret", "Yatak Tipi"};
        model = new DefaultTableModel(sutunlar, 0);
        tablo = new JTable(model);
        
        // Renklendirme Renderer'ı (Müsait: Yeşil, Dolu: Kırmızı)
        tablo.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (value != null) {
                    String durum = value.toString();
                    if (durum.equalsIgnoreCase("Müsait")) {
                        c.setForeground(new Color(39, 174, 96)); // Yeşil
                    } else if (durum.equalsIgnoreCase("Dolu")) {
                        c.setForeground(new Color(192, 57, 43)); // Kırmızı
                    } else {
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        });

        tablo.setBackground(Color.WHITE);
        tablo.setRowHeight(25);

        JTableHeader header = tablo.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 13));

        JScrollPane scrollPane = new JScrollPane(tablo);
        scrollPane.setBounds(10, 150, 680, 230);
        panel.add(scrollPane);

        // İlk açılışta verileri çek
        verileriGetir("select * from room");

        // --- Butonlar ---
        butonAra = new JButton("ARA");
        butonAra.setBounds(200, 420, 120, 30);
        butonAra.setBackground(Color.BLACK);
        butonAra.setForeground(Color.WHITE);
        butonAra.addActionListener(this);
        panel.add(butonAra);

        butonGeri = new JButton("GERİ");
        butonGeri.setBounds(380, 420, 120, 30);
        butonGeri.setBackground(Color.BLACK);
        butonGeri.setForeground(Color.WHITE);
        butonGeri.addActionListener(this);
        panel.add(butonGeri);

        // Pencere Ayarları
        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void verileriGetir(String sorgu) {
        try {
            baglanti b = new baglanti();
            ResultSet rs = b.s.executeQuery(sorgu);
            model.setRowCount(0); // Eski verileri temizle

            while (rs.next()) {
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
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butonAra) {
            // SQL sorgusunu dinamik oluştur (SQL uyumlu kolon isimleri ile)
            String sorgu = "select * from room where bed_type = '" + yatakSecimi.getSelectedItem() + "'";
            
            if (musaitlikKutusu.isSelected()) {
                // "Uygun" yerine veritabanındaki "Müsait" verisiyle eşleştirdik
                sorgu += " AND availability = 'Müsait'";
            }
            
            verileriGetir(sorgu);
        } else if (e.getSource() == butonGeri) {
            new Resepsiyon();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new OdaAra();
    }
}