package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnaPanel extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JButton adminButonu, resepsiyonButonu;

    public AnaPanel() {
        super("OTEL YÖNETİM SİSTEMİ - ANA PANEL");
        
        getContentPane().setLayout(null); 

        // --- RESEPSİYON BUTONU ---
        resepsiyonButonu = new JButton("RESEPSİYON");
        resepsiyonButonu.setBounds(425, 510, 160, 40);
        resepsiyonButonu.setFont(new Font("Tahoma", Font.BOLD, 15));
        resepsiyonButonu.setBackground(Color.white);
        resepsiyonButonu.setForeground(Color.black);
        resepsiyonButonu.addActionListener(this);
        getContentPane().add(resepsiyonButonu);

        // --- YÖNETİCİ BUTONU ---
        adminButonu = new JButton("YÖNETİCİ");
        adminButonu.setBounds(880, 510, 160, 40);
        adminButonu.setFont(new Font("Tahoma", Font.BOLD, 15));
        adminButonu.setBackground(Color.white);
        adminButonu.setForeground(Color.black);
        adminButonu.addActionListener(this);
        getContentPane().add(adminButonu);

        // İkonları ve Arkaplanı Yükleme
        try {
            yükleVeEkle("icon/boss.png", 850, 300, 200, 195);
            yükleVeEkle("icon/resepsiyon.jpg", 400, 300, 200, 195);

            URL bgUrl = ClassLoader.getSystemResource("icon/Dashboard.gif");
            if (bgUrl != null) {
                ImageIcon i5 = new ImageIcon(bgUrl);
                Image i6 = i5.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
                JLabel l3 = new JLabel(new ImageIcon(i6));
                l3.setBounds(0, 0, 1550, 850); 
                getContentPane().add(l3);
                
                // Arkaplanın en arkada kalmasını sağlar
                getContentPane().setComponentZOrder(l3, getContentPane().getComponentCount() - 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
 
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(this, popupMenu);
        setVisible(true);
    }

    private void yükleVeEkle(String yol, int x, int y, int w, int h) {
        URL imgUrl = ClassLoader.getSystemResource(yol);
        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
            JLabel label = new JLabel(new ImageIcon(img));
            label.setBounds(x, y, w, h);
            getContentPane().add(label);
            getContentPane().setComponentZOrder(label, 0);
        }
    }

    // --- BUTON TIKLAMA OLAYLARI ---
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resepsiyonButonu) {
            // Resepsiyon sınıfına yönlendirme
            new Resepsiyon();
            this.setVisible(false); // Ana paneli gizle
            
        } else if (e.getSource() == adminButonu) {
            // YÖNETİCİ EKRANINA BAĞLANTI BURADA YAPILDI
            new Yonetici(); 
            this.setVisible(false); // Ana paneli gizle
        }
    }

    public static void main(String[] args) {
        new AnaPanel();
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) showMenu(e);
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) showMenu(e);
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}