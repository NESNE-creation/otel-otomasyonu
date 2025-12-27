package otelotomasyonu;

public class CalisanBilgi {
	
	
	    private int id;
	    private String ad;
	    private String soyad;
	    private int tc;
	    private int telefon;
	    private String departman;
	    private double maas;      
	    private String vardiya;  
	    private String iseGirisTarihi;

	    
	    public CalisanBilgi() {
	    }

	    public CalisanBilgi(int id, String ad, String soyad, int tc, int telefon, String departman, double maas, String vardiya, String iseGirisTarihi) {
	        this.id = id;
	        this.ad = ad;
	        this.soyad = soyad;
	        this.tc = tc;
	        this.telefon = telefon;
	        this.departman = departman;
	        this.maas = maas;
	        this.vardiya = vardiya;
	        this.iseGirisTarihi = iseGirisTarihi;
	    }


	    public int getId() { 
	    	return id; }
	    public void setId(int id) {
	    	this.id = id; }

	    public String getAd() { 
	    	return ad; }
	    public void setAd(String ad) {
	    	this.ad = ad; }

	    public String getSoyad() { return soyad; }
	    public void setSoyad(String soyad) { this.soyad = soyad; }

	    public int getTc() { return tc; }
	    public void setTcNo(int tc) { this.tc = tc; }

	    public int getTelefon() { return telefon; }
	    public void setTelefon(int telefon) { this.telefon = telefon; }

	    public String getDepartman() { return departman; }
	    public void setDepartman(String departman) { this.departman = departman; }

	    public double getMaas() { return maas; }
	    public void setMaas(double maas) { this.maas = maas; }

	    public String getVardiya() { return vardiya; }
	    public void setVardiya(String vardiya) { this.vardiya = vardiya; }

	    public String getIseGirisTarihi() { return iseGirisTarihi; }
	    public void setIseGirisTarihi(String iseGirisTarihi) { this.iseGirisTarihi = iseGirisTarihi; }


}
