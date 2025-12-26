package otelotomasyonu;

public class YoneticiBilgi {
	
	    private int id;
	    private String ad;
	    private String soyad;
	    private int tc;
	    private int telefon;
	    private String kullaniciAdi; // Giriş için gerekli
	    private int sifre;        // Giriş şifresi

	    public YoneticiBilgi() {
	    }

	    public YoneticiBilgi(int id, String ad, String soyad, int tc, int telefon, String kullaniciAdi, int sifre) {
	        this.id = id;
	        this.ad = ad;
	        this.soyad = soyad;
	        this.tc = tc;
	        this.telefon = telefon;
	        this.kullaniciAdi = kullaniciAdi;
	        this.sifre = sifre;
	    }

	  
	    public int getId() { return id; }
	    public void setId(int id) 
	    { this.id = id; }

	    public String getAd() { return ad; }
	    public void setAd(String ad) 
	    { this.ad = ad; }

	    public String getSoyad() { return soyad; }
	    public void setSoyad(String soyad) 
	    { this.soyad = soyad; }

	    public int getTc() { return tc; }
	    public void setTc(int tc) 
	    { this.tc = tc; }

	    public int getTelefon() { return telefon; }
	    public void setTelefon(int telefon) 
	    { this.telefon = telefon; }

	    public String getKullaniciAdi() { return kullaniciAdi; }
	    public void setKullaniciAdi(String kullaniciAdi) 
	    { this.kullaniciAdi = kullaniciAdi; }

	    public int getSifre() { return sifre; }
	    public void setSifre(int sifre) 
	    { this.sifre = sifre; }
	    

	   
	    
	    
	    
	    
	    
	}
