package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;

public class Resepsiyon extends JFrame {

    private static final long serialVersionUID = 1L;

    public Resepsiyon() {
        setTitle("Otel Yönetim Sistemi - Resepsiyon Paneli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 750); // Daha dengeli ve profesyonel bir boyut
        setLocationRelativeTo(null); // Ekranın tam ortasında açılır
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE); // Arka planı temiz beyaz yaptık

        // --- SOL PANEL (MENÜ) ---
        JPanel panelButonlar = new JPanel();
        panelButonlar.setLayout(null);
        panelButonlar.setBounds(0, 0, 280, 750);
        panelButonlar.setBackground(SystemColor.controlShadow); // Modern koyu antrasit tema
        getContentPane().add(panelButonlar);

        // Menü Başlığı
        JLabel menuBaslik = new JLabel("İŞLEMLER");
        menuBaslik.setForeground(Color.black);
        menuBaslik.setFont(new Font("Tahoma", Font.BOLD, 18));
        menuBaslik.setBounds(85, 20, 150, 30);
        panelButonlar.add(menuBaslik);

        // --- BUTONLARIN OLUŞTURULMASI ---
        // Butonları bir metod yardımıyla eklemek kodu temiz tutar ama senin yapına sadık kalarak düzenledim.
        
        JButton btnNCF = createMenuButton("Yeni Müşteri Formu", 70);
        panelButonlar.add(btnNCF);
        btnNCF.addActionListener(e -> { new YeniMusteriFormu(); setVisible(false); });

        JButton btnRoom = createMenuButton("Odalar", 115);
        panelButonlar.add(btnRoom);
        btnRoom.addActionListener(e -> { new Oda(); setVisible(false); });

        JButton btnDepartment = createMenuButton("Departmanlar", 160);
        panelButonlar.add(btnDepartment);
        btnDepartment.addActionListener(e -> { new Departman(); setVisible(false); });

        JButton btnAEI = createMenuButton("Tüm Çalışan Bilgileri", 205);
        panelButonlar.add(btnAEI);
        btnAEI.addActionListener(e -> { new CalisanBilgi(); setVisible(false); });

        JButton btnCI = createMenuButton("Müşteri Bilgileri", 250);
        panelButonlar.add(btnCI);
        btnCI.addActionListener(e -> { new MusteriBilgi(); setVisible(false); });

        JButton btnMI = createMenuButton("Yönetici Bilgileri", 295);
        panelButonlar.add(btnMI);
        btnMI.addActionListener(e -> { new YoneticiBilgi(); setVisible(false); });

        JButton btnCO = createMenuButton("Müşteri Çıkışı (Check Out)", 340);
        panelButonlar.add(btnCO);
        btnCO.addActionListener(e -> { new MusteriCikisi(); setVisible(false); });

        JButton btnUC = createMenuButton("Giriş Bilgilerini Güncelle", 385);
        panelButonlar.add(btnUC);
        btnUC.addActionListener(e -> { new GirisGuncelle(); setVisible(false); });

        JButton btnURS = createMenuButton("Oda Durumunu Güncelle", 430);
        panelButonlar.add(btnURS);
        btnURS.addActionListener(e -> { new OdaGuncelle(); setVisible(false); });

        JButton btnSR = createMenuButton("Oda Ara", 475);
        panelButonlar.add(btnSR);
        btnSR.addActionListener(e -> { new OdaAra(); setVisible(false); });

        // --- ALT BUTONLAR (ÇIKIŞ VE GERİ) ---
        JButton logout = new JButton("Çıkış Yap");
        logout.setBounds(30, 600, 100, 35);
        logout.setBackground(new Color(180, 0, 0));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 12));
        panelButonlar.add(logout);
        logout.addActionListener(e -> System.exit(0));

        JButton back = new JButton("Geri");
        back.setBounds(140, 600, 100, 35);
        back.setBackground(new Color(80, 80, 80));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 12));
        panelButonlar.add(back);
        back.addActionListener(e -> { new AnaPanel(); setVisible(false); });

        // --- SAĞ PANEL (GÖRSEL ALANI) ---
        JPanel panelGorsel = new JPanel();
        panelGorsel.setLayout(null);
        panelGorsel.setBounds(280, 0, 820, 750);
        panelGorsel.setBackground(Color.WHITE);
        getContentPane().add(panelGorsel);

        try {
            // "reception.jpg" görselini yüklüyoruz
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/reception.jpg"));
            // Görseli panel boyutuna göre ölçekliyoruz
            Image i2 = i1.getImage().getScaledInstance(820, 750, Image.SCALE_SMOOTH);
            JLabel l1 = new JLabel(new ImageIcon(i2));
            l1.setBounds(0, 0, 820, 750);
            panelGorsel.add(l1);
        } catch (Exception e) {
            System.out.println("Hata: icon/reception.jpg dosyası bulunamadı.");
        }

        setVisible(true);
    }

    // Buton tasarımını standartlaştırmak için yardımcı metod
    private JButton createMenuButton(String text, int yBound) {
        JButton btn = new JButton(text);
        btn.setBounds(30, yBound, 220, 35);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn.setFocusPainted(false); // Buton etrafındaki seçim çerçevesini kaldırır
        return btn;
    }

    public static void main(String[] args) {
        new Resepsiyon();
    }
}