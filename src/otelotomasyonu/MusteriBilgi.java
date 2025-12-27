package otelotomasyonu;


public class MusteriBilgi {

	    private int id;             // Veritabanı ID'si
	    private String ad;
	    private String soyad;
	    private int tc;
	    private int telefon;
	    private String eposta;
	    private int odaNo;       
	    private String adres;   

	    // 1. Boş Yapıcı Metot (Veritabanı işlemleri için gerekli)
	    public MusteriBilgi() {
	    }

	    public MusteriBilgi(int id, String ad, String soyad, int tc, int telefon, String eposta, int odaNo, String adres) {
	        this.id = id;
	        this.ad = ad;
	        this.soyad = soyad;
	        this.tc = tc;
	        this.telefon = telefon;
	        this.eposta = eposta;
	        this.odaNo = odaNo;
	        this.adres = adres;
	    }

	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getAd() { return ad; }
	    public void setAd(String ad) { this.ad = ad; }

	    public String getSoyad() { return soyad; }
	    public void setSoyad(String soyad) { this.soyad = soyad; }

	    public int getTc() { return tc; }
	    public void setTcNo(int tc) { this.tc = tc; }

	    public int getTelefon() { return telefon; }
	    public void setTelefon(int telefon) { this.telefon = telefon; }

	    public String getEposta() { return eposta; }
	    public void setEposta(String eposta) { this.eposta = eposta; }

	    public int getOdaNo() { return odaNo; }
	    public void setOdaNo(int odaNo) { this.odaNo = odaNo; }

	    public String getAdres() { return adres; }
	    public void setAdres(String adres) { this.adres = adres; }
	}
