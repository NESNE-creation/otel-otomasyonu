package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;

public class Resepsiyon extends JFrame {

    private static final long serialVersionUID = 1L;

    public Resepsiyon() {
        setTitle("Otel Yönetim Sistemi - Resepsiyon");

        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280, 5, 1238, 820);
        panel.setBackground(new Color(255, 105, 180)); // Canlı Pembe
        getContentPane().add(panel);
        try {
       
            ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icon/hotel.jpg"));


            Image scaledImage = originalIcon.getImage().getScaledInstance(1238, 820, Image.SCALE_SMOOTH);
            ImageIcon finalIcon = new ImageIcon(scaledImage);

           
            JLabel imageLabel = new JLabel(finalIcon);
            imageLabel.setBounds(0, 0, 1238, 820); 
            panel.add(imageLabel);

        } catch (Exception e) {
            System.out.println("Hata: 'icon/hotel.jpg' görseli yüklenemedi.");
        }

      
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 270, 820);
        panel1.setBackground(new Color(255, 105, 180));
        getContentPane().add(panel1);

      

        JButton btnNCF = new JButton("Yeni Müşteri Formu");
        btnNCF.setBounds(30, 30, 200, 30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Yeni Müşteri Formu Yakında!");
        });

        JButton btnRoom = new JButton("Odalar");
        btnRoom.setBounds(30, 70, 200, 30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Odalar Listesi Yakında!");
        });

        JButton btnDepartment = new JButton("Departmanlar");
        btnDepartment.setBounds(30, 110, 200, 30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Departmanlar Ekranı Yakında!");
        });

        JButton btnAEI = new JButton("Tüm Çalışan Bilgileri");
        btnAEI.setBounds(30, 150, 200, 30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Çalışan Bilgileri Yakında!");
        });

        JButton btnCI = new JButton("Müşteri Bilgileri");
        btnCI.setBounds(30, 190, 200, 30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Müşteri Bilgileri Yakında!");
        });

        JButton btnMI = new JButton("Yönetici Bilgileri");
        btnMI.setBounds(30, 230, 200, 30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Yönetici Bilgileri Yakında!");
        });

        JButton btnCO = new JButton("Müşteri Çıkışı (Check Out)");
        btnCO.setBounds(30, 270, 200, 30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Müşteri Çıkış Sistemi Yakında!");
        });

        JButton btnUC = new JButton("Giriş Bilgilerini Güncelle");
        btnUC.setBounds(30, 310, 200, 30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        panel1.add(btnUC);
        btnUC.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Bilgi Güncelleme Yakında!");
        });

        JButton btnURS = new JButton("Oda Durumunu Güncelle");
        btnURS.setBounds(30, 350, 200, 30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Oda Güncelleme Yakında!");
        });

        JButton btnSR = new JButton("Oda Ara");
        btnSR.setBounds(30, 390, 200, 30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Oda Arama Ekranı Yakında!");
        });

        JButton logout = new JButton("Çıkış Yap");
        logout.setBounds(30, 470, 95, 30);
        logout.setBackground(new Color(220, 20, 60)); 
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(e -> System.exit(0));

        JButton back = new JButton("Geri");
        back.setBounds(140, 470, 95, 30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(e -> {
            setVisible(false);
            
        });
        getContentPane().setBackground(new Color(255, 240, 245)); 
        getContentPane().setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
    }

    public static void main(String[] args) {
        new Resepsiyon();
    }
}