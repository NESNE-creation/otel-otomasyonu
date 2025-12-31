package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Yonetici extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JButton add_Employee, add_Room, logout, back;

    public Yonetici() {
        // Buton: Personel Ekle
        add_Employee = new JButton("PERSONEL EKLE");
        add_Employee.setBounds(250, 150, 200, 30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Employee.addActionListener(this);
        getContentPane().add(add_Employee);

        // Buton: Oda Ekle
        add_Room = new JButton("ODA EKLE");
        add_Room.setBounds(250, 280, 200, 30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Room.addActionListener(this);
        getContentPane().add(add_Room);

        // Buton: Çıkış
        logout = new JButton("ÇIKIŞ");
        logout.setBounds(10, 550, 95, 30);
        logout.setBackground(Color.white);
        logout.setForeground(Color.black);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        getContentPane().add(logout);

        // Buton: Geri
        back = new JButton("GERİ");
        back.setBounds(110, 550, 95, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        getContentPane().add(back);

        // Görseller
        try {
            ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
            Image l11 = l1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(l11));
            label.setBounds(70, 100, 120, 120);
            getContentPane().add(label);

            ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.jpg"));
            Image image = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel label1 = new JLabel(new ImageIcon(image));
            label1.setBounds(70, 240, 120, 120);
            getContentPane().add(label1);
        } catch (Exception e) {
            System.out.println("İkonlar yüklenemedi.");
        }

        // Pencere Ayarları
        getContentPane().setBackground(SystemColor.controlShadow);
        getContentPane().setLayout(null);
        setSize(550, 600); // Sayfa içeriğe göre daraltıldı
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_Employee) {
            new PersonelEkle(); 
            setVisible(false);
            
        } else if (e.getSource() == add_Room) {
            // --- BAĞLANTI BURADA YAPILDI ---
            new OdaEkle(); 
            setVisible(false); // Yönetici panelini gizler
             
        } else if (e.getSource() == logout) {
            System.exit(0);
        } else if (e.getSource() == back) {
            new AnaPanel(); // Ana giriş paneline döner
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Yonetici();
    }
}