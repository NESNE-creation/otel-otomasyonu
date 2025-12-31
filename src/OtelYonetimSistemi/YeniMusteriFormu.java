package OtelYonetimSistemi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;       
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class YeniMusteriFormu extends JFrame implements ActionListener { 
	
	private static final long serialVersionUID = 1L;
	JComboBox<String> comboid;
	JTextField tfnumber, tfname, tfsurname, tfulke, tfdeposit;
	JRadioButton rmale, rfemale, rnon;
	Choice croom;
	JLabel checkintime;
	JButton kaydet, geridon;
    ButtonGroup genderGroup; 
	
	public YeniMusteriFormu(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text= new JLabel("YENİ MÜŞTERİ FORMU");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(text);
		
		JLabel etid= new JLabel("Kimlik Türü:");
		etid.setBounds(35,80,300,30);
		etid.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etid);
		
		String option[]= {"Kimlik", "Pasaport", "Ulusal Kimlik Kartı"};
		comboid =new JComboBox<>(option);
		comboid.setBounds(200, 80, 150,25);
		add(comboid);
		
		JLabel etno= new JLabel("Kimlik No:");
		etno.setBounds(35,120,140,20);
		etno.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etno);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(200,120,150,25); 
		add(tfnumber);
		
		JLabel etname= new JLabel("Misafir İsmi:");
		etname.setBounds(35,160,150,20);
		etname.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etname);
		
		tfname = new JTextField();
		tfname.setBounds(200,160,150,25); 
		add(tfname);
		
		JLabel etsur= new JLabel("Misafir Soyİsmi:");
		etsur.setBounds(35,200,150,20);
		etsur.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etsur);
		
		tfsurname = new JTextField();
		tfsurname.setBounds(200,200,150,25); 
		add(tfsurname);
		
		JLabel etcins= new JLabel("Cinsiyet:");
		etcins.setBounds(35, 240, 100, 20);
		etcins.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etcins);
		
		rmale =new JRadioButton("Erkek");
		rmale.setBackground(Color.WHITE);
		rmale.setBounds(200, 240, 60, 25);
		add(rmale);
		
		rfemale = new JRadioButton("Kadın");
		rfemale.setBackground(Color.WHITE);
		rfemale.setBounds(260, 240, 60, 25);
		add(rfemale);
		
		rnon =new JRadioButton("Belirtmek İstemiyor");
		rnon.setBackground(Color.WHITE);
		rnon.setBounds(200, 270, 140, 25);
		add(rnon);

        genderGroup = new ButtonGroup();
        genderGroup.add(rmale);
        genderGroup.add(rfemale);
        genderGroup.add(rnon);
		
		JLabel etulke= new JLabel("Ülke:");
		etulke.setBounds(35,300,150,20);
		etulke.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etulke);
		
		tfulke = new JTextField();
		tfulke.setBounds(200,300,150,25); 
		add(tfulke);
		
		JLabel etoda= new JLabel("Oda Seçiniz:");
		etoda.setBounds(35,330,150,20);
		etoda.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etoda);
		
		croom= new Choice();
		
		try {
			baglanti conn= new baglanti(); 
			// Hem 'Uygun' hem 'Boş' kelimelerini kontrol eder
			String query ="select * from room where availability = 'Uygun' OR availability = 'Boş'"; 
			ResultSet rs = conn.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		croom.setBounds(200,330,150,20);
		add(croom);
		
		JLabel etzmn= new JLabel("Giriş Saati:");
		etzmn.setBounds(35,360,150,20);
		etzmn.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etzmn);
		
		Date date= new Date();
		SimpleDateFormat sdf =new SimpleDateFormat( "dd MMM yyyy HH:mm" , new Locale("tr", "TR"));
		
		checkintime= new JLabel(sdf.format(date));
		checkintime.setBounds(200,360,180,25);
		checkintime.setFont(new Font("Raleway", Font.PLAIN, 16)); 
		add(checkintime);
		
		JLabel etdeposit= new JLabel("Depozito:");
		etdeposit.setBounds(35,400,150,20);
		etdeposit.setFont(new Font("Raleway", Font.PLAIN, 20)); 
		add(etdeposit);
		
		tfdeposit = new JTextField();
		tfdeposit.setBounds(200,400,150,25); 
		add(tfdeposit);
		
		kaydet =new JButton("Kaydet");
		kaydet.setBackground(Color.BLACK);
		kaydet.setForeground(Color.WHITE);
		kaydet.setBounds(50,440,120,30);
        kaydet.addActionListener(this); 
		add(kaydet);
		
		geridon = new JButton("Geri Dön");
		geridon.setBackground(Color.BLACK);
		geridon.setForeground(Color.WHITE);
		geridon.setBounds(200,440,120,30);
        geridon.addActionListener(this); 
		add(geridon);
		
		setBounds(500,100,900,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == kaydet) {
            String kimlik = (String) comboid.getSelectedItem();
            String numara = tfnumber.getText();
            String isim = tfname.getText();
            String soyisim = tfsurname.getText();
            
            String cinsiyet = null;
            if (rmale.isSelected()) cinsiyet = "Erkek";
            else if (rfemale.isSelected()) cinsiyet = "Kadın";
            else if (rnon.isSelected()) cinsiyet = "Belirtilmedi";
            
            String ulke = tfulke.getText();
            String oda = croom.getSelectedItem();
            String zaman = checkintime.getText();
            String depozito = tfdeposit.getText();

            if (oda == null) {
                JOptionPane.showMessageDialog(null, "Lütfen bir oda seçiniz!");
                return;
            }// kontrol
         
            if (isim.isEmpty() || numara.isEmpty() || cinsiyet == null) {
                JOptionPane.showMessageDialog(null, "Lütfen gerekli alanları doldurun!");
                return; // Hatadan sonra kodun devam etmemesi için durdurur
            }

           
            if (!numara.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Lütfen TC No kısmına sadece rakam girin!");
                return;
            }

          
            if (numara.length() != 11) {
                JOptionPane.showMessageDialog(null, "Eksik veya fazla rakam girdiniz! TC No 11 haneli olmalıdır.");
                return;
            }


            try {
                baglanti b = new baglanti();
                
                // SQL SORGUSU: 9 Sütunlu customer tablosuna birebir uygun
                String q1 = "insert into customer values('" + kimlik + "', '" + numara + "', '" + isim + "', '" + soyisim + "', '" + cinsiyet + "', '" + ulke + "', '" + oda + "', '" + zaman + "', '" + depozito + "')";
                
                // Seçilen odayı veritabanında "Dolu" yapar
                String q2 = "update room set availability = 'Dolu' where roomnumber = '" + oda + "'";

                b.s.executeUpdate(q1);
                b.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Müşteri Başarıyla Eklendi");
                setVisible(false);
                new Resepsiyon().setVisible(true);

            } catch (Exception e) {
                System.out.println("Hata Oluştu: " + e.getMessage());
                e.printStackTrace();
            }

        } else if (ae.getSource() == geridon) {
            setVisible(false);
            new Resepsiyon().setVisible(true);
        }
    }
		
	public static void main(String[]args) {
		new YeniMusteriFormu(); 
	}
}