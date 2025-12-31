package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonelEkle extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    JTextField isimAlani, yasAlani, maasAlani, telefonAlani, tcNoAlani, epostaAlani;
    JRadioButton radyoErkek, radyoKadin;
    JComboBox<String> gorevKutusu;
    JButton butonEkle, butonGeri;

    PersonelEkle() {
        // --- Ana Panel Ayarları ---
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 440, 540);
        panel.setLayout(null);
        panel.setBackground(SystemColor.controlShadow);
        getContentPane().add(panel);

        // --- Başlık ---
        JLabel baslik = new JLabel("PERSONEL EKLE");
        baslik.setBounds(40, 20, 350, 40);
        baslik.setFont(new Font("Tahoma", Font.BOLD, 22));
        baslik.setForeground(SystemColor.desktop);
        panel.add(baslik);

        // --- Ad Soyad ---
        JLabel etiketIsim = new JLabel("AD SOYAD:");
        etiketIsim.setBounds(40, 80, 120, 27);
        etiketIsim.setFont(new Font("serif", Font.BOLD, 15));
        etiketIsim.setForeground(SystemColor.desktop);
        panel.add(etiketIsim);
        
        isimAlani = new JTextField();
        isimAlani.setBounds(180, 80, 200, 27);
        isimAlani.setBackground(SystemColor.text);
        isimAlani.setForeground(Color.BLACK); // Yazı rengi siyah yapıldı
        panel.add(isimAlani);

        // --- Yaş ---
        JLabel etiketYas = new JLabel("YAŞ:");
        etiketYas.setBounds(40, 120, 120, 27);
        etiketYas.setFont(new Font("serif", Font.BOLD, 15));
        etiketYas.setForeground(SystemColor.desktop);
        panel.add(etiketYas);
        
        yasAlani = new JTextField();
        yasAlani.setBounds(180, 120, 200, 27);
        yasAlani.setBackground(SystemColor.text);
        yasAlani.setForeground(Color.BLACK); // Yazı rengi siyah yapıldı
        panel.add(yasAlani);

        // --- Cinsiyet ---
        JLabel etiketCinsiyet = new JLabel("CİNSİYET:");
        etiketCinsiyet.setBounds(40, 160, 120, 27);
        etiketCinsiyet.setFont(new Font("serif", Font.BOLD, 15));
        etiketCinsiyet.setForeground(SystemColor.desktop);
        panel.add(etiketCinsiyet);

        radyoErkek = new JRadioButton("ERKEK");
        radyoErkek.setBounds(180, 160, 90, 27);
        radyoErkek.setBackground(SystemColor.text);
        radyoErkek.setForeground(SystemColor.desktop);
        panel.add(radyoErkek);

        radyoKadin = new JRadioButton("KADIN");
        radyoKadin.setBounds(280, 160, 90, 27);
        radyoKadin.setBackground(SystemColor.text);
        radyoKadin.setForeground(SystemColor.desktop);
        panel.add(radyoKadin);

        ButtonGroup cinsiyetGrubu = new ButtonGroup();
        cinsiyetGrubu.add(radyoErkek);
        cinsiyetGrubu.add(radyoKadin);

        // --- Görev ---
        JLabel etiketGorev = new JLabel("GÖREV:");
        etiketGorev.setBounds(40, 200, 120, 27);
        etiketGorev.setFont(new Font("serif", Font.BOLD, 15));
        etiketGorev.setForeground(SystemColor.desktop);
        panel.add(etiketGorev);

        String[] gorevler = {"Resepsiyon", "Temizlik", "Mutfak", "Oda Servisi", "Yönetici", "Muhasebe", "Şef"};
        gorevKutusu = new JComboBox<>(gorevler);
        gorevKutusu.setBounds(180, 200, 200, 30);
        gorevKutusu.setBackground(SystemColor.text);
        gorevKutusu.setForeground(Color.BLACK); // Seçim kutusu yazı rengi siyah yapıldı
        panel.add(gorevKutusu);

        // --- Maaş ---
        JLabel etiketMaas = new JLabel("MAAŞ:");
        etiketMaas.setBounds(40, 245, 120, 27);
        etiketMaas.setFont(new Font("serif", Font.BOLD, 15));
        etiketMaas.setForeground(SystemColor.desktop);
        panel.add(etiketMaas);
        
        maasAlani = new JTextField();
        maasAlani.setBounds(180, 245, 200, 27);
        maasAlani.setBackground(SystemColor.text);
        maasAlani.setForeground(Color.BLACK); // Yazı rengi siyah yapıldı
        panel.add(maasAlani);

        // --- Telefon ---
        JLabel etiketTelefon = new JLabel("TELEFON:");
        etiketTelefon.setBounds(40, 285, 120, 27);
        etiketTelefon.setFont(new Font("serif", Font.BOLD, 15));
        etiketTelefon.setForeground(SystemColor.desktop);
        panel.add(etiketTelefon);
        
        telefonAlani = new JTextField();
        telefonAlani.setBounds(180, 285, 200, 27);
        telefonAlani.setBackground(SystemColor.text);
        telefonAlani.setForeground(Color.BLACK); // Yazı rengi siyah yapıldı
        panel.add(telefonAlani);

        // --- TC No ---
        JLabel etiketTC = new JLabel("TC NO:");
        etiketTC.setBounds(40, 325, 120, 27);
        etiketTC.setFont(new Font("serif", Font.BOLD, 15));
        etiketTC.setForeground(SystemColor.desktop);
        panel.add(etiketTC);
        
        tcNoAlani = new JTextField();
        tcNoAlani.setBounds(180, 325, 200, 27);
        tcNoAlani.setBackground(SystemColor.text);
        tcNoAlani.setForeground(Color.BLACK); // Yazı rengi siyah yapıldı
        panel.add(tcNoAlani);

        // --- E-posta ---
        JLabel etiketEmail = new JLabel("E-POSTA:");
        etiketEmail.setBounds(40, 365, 120, 27);
        etiketEmail.setFont(new Font("serif", Font.BOLD, 15));
        etiketEmail.setForeground(SystemColor.desktop);
        panel.add(etiketEmail);
        
        epostaAlani = new JTextField();
        epostaAlani.setBounds(180, 365, 200, 27);
        epostaAlani.setBackground(SystemColor.text);
        epostaAlani.setForeground(Color.BLACK); // Yazı rengi siyah yapıldı
        panel.add(epostaAlani);

        // --- Butonlar ---
        butonEkle = new JButton("KAYDET");
        butonEkle.setBounds(80, 440, 110, 35);
        butonEkle.setBackground(SystemColor.text);
        butonEkle.setForeground(SystemColor.desktop);
        butonEkle.addActionListener(this);
        panel.add(butonEkle);

        butonGeri = new JButton("GERİ");
        butonGeri.setBounds(230, 440, 110, 35);
        butonGeri.setBackground(SystemColor.text);
        butonGeri.setForeground(SystemColor.desktop);
        butonGeri.addActionListener(this);
        panel.add(butonGeri);

        // --- Pencere Ayarları ---
        setUndecorated(true);
        setSize(450, 550);
        setLocationRelativeTo(null); 
        getContentPane().setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butonEkle) {
            String isim = isimAlani.getText();
            String yas = yasAlani.getText();
            String maas = maasAlani.getText();
            String telefon = telefonAlani.getText();
            String email = epostaAlani.getText();
            String tcno = tcNoAlani.getText();
            String gorev = (String) gorevKutusu.getSelectedItem();
            String cinsiyet = null;

            if (radyoErkek.isSelected()) cinsiyet = "Erkek";
            else if (radyoKadin.isSelected()) cinsiyet = "Kadın";

            if (isim.isEmpty() || tcno.isEmpty() || cinsiyet == null) {
                JOptionPane.showMessageDialog(null, "Lütfen gerekli alanları doldurun!");
                return;
            }

            try {
                baglanti b = new baglanti();
                String sorgu = "insert into employee values('"+tcno+"', '"+isim+"', '"+yas+"', '"+cinsiyet+"', '"+gorev+"', '"+telefon+"', '"+email+"', '"+maas+"')";
                b.s.executeUpdate(sorgu);
                
                JOptionPane.showMessageDialog(null, "Personel Başarıyla Eklendi");
                setVisible(false);
                new Yonetici(); 

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Veritabanı Hatası!");
            }

        } else if (e.getSource() == butonGeri) {
            setVisible(false);
            new Yonetici();
        }
    }

    public static void main(String[] args) {
        new PersonelEkle();
    }
}