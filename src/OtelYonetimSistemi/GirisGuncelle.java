package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class GirisGuncelle extends JFrame {
    
    private static final long serialVersionUID = 1L;
    Choice musteriSecimi;
    // idAlani'nı yeni ekledik, böylece Kimlik No kendi kutusunda görünecek
    JTextField idAlani, odaNoAlani, isimAlani, girisZamaniAlani, odenenAlani, kalanBorcAlani;

    public GirisGuncelle() {
        // --- Ana Panel Ayarları ---
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(SystemColor.controlShadow);
        panel.setLayout(null);
        getContentPane().add(panel);

        // --- Başlık ---
        JLabel baslik = new JLabel("MÜŞTERİ BİLGİLERİNİ GÜNCELLE");
        baslik.setBounds(100, 11, 450, 30);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 22));
        baslik.setForeground(Color.black);
        panel.add(baslik);

        // --- 1. SATIR: Oda Seçimi (Açılır Menü) ---
        JLabel labelSecim = new JLabel("Güncellenecek Oda No:");
        labelSecim.setBounds(25, 85, 180, 20);
        labelSecim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelSecim);

        musteriSecimi = new Choice();
        musteriSecimi.setBounds(248, 85, 140, 20);
        panel.add(musteriSecimi);

        // --- 2. SATIR: Müşteri ID (Görüntüleme) ---
        JLabel labelID = new JLabel("Müşteri ID (TC No):");
        labelID.setBounds(25, 126, 150, 20);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        idAlani = new JTextField();
        idAlani.setBounds(248, 126, 140, 20);
        idAlani.setEditable(false); // ID genelde değiştirilmez, sadece gösterilir
        panel.add(idAlani);

        // --- 3. SATIR: Oda No (Görüntüleme/Düzenleme) ---
        JLabel labelOda = new JLabel("Oda Numarası:");
        labelOda.setBounds(25, 165, 150, 20);
        labelOda.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelOda);

        odaNoAlani = new JTextField();
        odaNoAlani.setBounds(248, 165, 140, 20);
        panel.add(odaNoAlani);

        // --- 4. SATIR: İsim ---
        JLabel labelIsim = new JLabel("İsim :");
        labelIsim.setBounds(25, 205, 150, 20);
        labelIsim.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelIsim);

        isimAlani = new JTextField();
        isimAlani.setBounds(248, 205, 140, 20);
        panel.add(isimAlani);

        // --- 5. SATIR: Giriş Zamanı ---
        JLabel labelGiris = new JLabel("Giriş Zamanı :");
        labelGiris.setBounds(25, 245, 150, 20);
        labelGiris.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGiris);

        girisZamaniAlani = new JTextField();
        girisZamaniAlani.setBounds(248, 245, 140, 20);
        panel.add(girisZamaniAlani);

        // --- 6. SATIR: Ödenen Miktar ---
        JLabel labelOdenen = new JLabel("Ödenen (Depozito) :");
        labelOdenen.setBounds(25, 285, 150, 20);
        labelOdenen.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelOdenen);

        odenenAlani = new JTextField();
        odenenAlani.setBounds(248, 285, 140, 20);
        panel.add(odenenAlani);

        // --- 7. SATIR: Kalan Borç ---
        JLabel labelKalan = new JLabel("Kalan Borç (TL) :");
        labelKalan.setBounds(25, 325, 150, 20);
        labelKalan.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelKalan);

        kalanBorcAlani = new JTextField();
        kalanBorcAlani.setBounds(248, 325, 140, 20);
        kalanBorcAlani.setEditable(false); 
        kalanBorcAlani.setBackground(Color.LIGHT_GRAY);
        panel.add(kalanBorcAlani);

        // Choice kutusunu doldurma
        try {
            baglanti b = new baglanti();
            ResultSet rs = b.s.executeQuery("select * from customer");
            while (rs.next()) {
                musteriSecimi.add(rs.getString("oda_no"));
            }
        } catch (Exception e) { e.printStackTrace(); }

        // --- BUTONLAR ---

        JButton butonKontrol = new JButton("KONTROL ET");
        butonKontrol.setBounds(342, 400, 120, 30);
        butonKontrol.setBackground(Color.white);
        panel.add(butonKontrol);
        
        butonKontrol.addActionListener(e -> {
            String secilenOda = musteriSecimi.getSelectedItem();
            try {
                baglanti b = new baglanti();
                // 1. Müşteri bilgilerini çek
                ResultSet rs1 = b.s.executeQuery("select * from customer where oda_no = '" + secilenOda + "'");
                while (rs1.next()) {
                    // DÜZELTME: Her veri kendi kutusuna gidiyor
                    idAlani.setText(rs1.getString("kimlik_no"));
                    odaNoAlani.setText(rs1.getString("oda_no"));
                    isimAlani.setText(rs1.getString("isim"));
                    girisZamaniAlani.setText(rs1.getString("giris_saati"));
                    odenenAlani.setText(rs1.getString("depozito"));
                }

                // 2. Oda fiyatını çekip borç hesapla
                ResultSet rs2 = b.s.executeQuery("select * from room where roomnumber = '" + odaNoAlani.getText() + "'");
                while (rs2.next()) {
                    String fiyat = rs2.getString("price");
                    int kalan = Integer.parseInt(fiyat) - Integer.parseInt(odenenAlani.getText());
                    kalanBorcAlani.setText(String.valueOf(kalan));
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        });

        JButton butonGuncelle = new JButton("GÜNCELLE");
        butonGuncelle.setBounds(56, 400, 120, 30);
        butonGuncelle.setBackground(Color.white);
        panel.add(butonGuncelle);
        
        butonGuncelle.addActionListener(e -> {
            try {
                baglanti b = new baglanti();
                String secilenOda = musteriSecimi.getSelectedItem();
                // Güncelleme sorgusu (Seçilen odaya göre)
                String query = "update customer set oda_no = '" + odaNoAlani.getText() + "', isim = '" + isimAlani.getText() + 
                               "', giris_saati = '" + girisZamaniAlani.getText() + "', depozito = '" + odenenAlani.getText() + 
                               "' where oda_no = '" + secilenOda + "'";
                
                b.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Bilgiler Başarıyla Güncellendi");
                setVisible(false);
                new Resepsiyon();
            } catch (Exception ex) { ex.printStackTrace(); }
        });

        JButton butonGeri = new JButton("GERİ");
        butonGeri.setBounds(208, 400, 100, 30);
        butonGeri.setBackground(Color.white);
        panel.add(butonGeri);
        butonGeri.addActionListener(e -> {
            new Resepsiyon();
            setVisible(false);
        });

        setUndecorated(true);
        setSize(950, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GirisGuncelle();
    }
}