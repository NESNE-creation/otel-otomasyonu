package OtelYonetimSistemi; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Giris extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, b2;

    public Giris() {
        setTitle("Otel Yönetim Sistemi - Giriş");
        getContentPane().setLayout(null);

        JLabel label1 = new JLabel("Kullanıcı Adı");
        label1.setBackground(SystemColor.desktop);
        label1.setBounds(40, 20, 120, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(SystemColor.desktop);
        getContentPane().add(label1);

        JLabel label2 = new JLabel("Şifre");
        label2.setBounds(40, 81, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(SystemColor.desktop);
        getContentPane().add(label2);

        textField1 = new JTextField();
        textField1.setBounds(160, 20, 150, 30);
        textField1.setForeground(Color.BLACK); 
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField1.setBackground(Color.WHITE); 
        getContentPane().add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(160, 70, 150, 30);
        passwordField1.setForeground(Color.BLACK); 
        passwordField1.setBackground(Color.WHITE); 
        getContentPane().add(passwordField1);

        try {
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
            Image i1 = imageIcon.getImage().getScaledInstance(255, 300, Image.SCALE_DEFAULT);
            JLabel label = new JLabel(new ImageIcon(i1));
            label.setBounds(343, -1, 242, 264);
            getContentPane().add(label);
        } catch (Exception e) {
            System.out.println("Görsel yüklenemedi.");
        }

        b1 = new JButton("Giriş");
        b1.setBounds(40, 134, 120, 36);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK); 
        b1.addActionListener(this);
        getContentPane().add(b1);

        b2 = new JButton("İptal"); 
        b2.setBounds(177, 136, 129, 34);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK); 
        b2.addActionListener(this);
        getContentPane().add(b2);

        getContentPane().setBackground(SystemColor.controlShadow);
        setLocation(400, 270);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                baglanti c = new baglanti(); 
                String user = textField1.getText();
                String pass = new String(passwordField1.getPassword());

                String q = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet resultSet = c.s.executeQuery(q);
                
                if (resultSet.next()) {
               
                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
                    new AnaPanel();
                    setVisible(false); 
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Şifre");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            System.exit(0); 
        }
    }

    public static void main(String[] args) {
        new Giris();
    }
}