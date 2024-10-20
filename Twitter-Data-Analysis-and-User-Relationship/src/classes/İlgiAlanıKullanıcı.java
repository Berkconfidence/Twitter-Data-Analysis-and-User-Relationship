package proje;

public class İlgiAlanıKullanıcı {


	public HashTablosu<String, Liste<Kullanıcı>> ilgiAlanlarıKullanıcı = new HashTablosu<>();
    public HashTablosu<String, Liste<String>> ilgiAlanlarıTespit = new HashTablosu<>();
    public HashTablosu<Kullanıcı, Liste<String>> kullanıcıİlgiAlanları = new HashTablosu<>();
    public Liste<String> ilgiAlanları = new Liste<String>();


    public void ilgiAlanınaEkle(String ilgiAlanı, Kullanıcı kullanıcı)
    {    	
        int ekle=1;
        if(ilgiAlanlarıKullanıcı.get(ilgiAlanı)!=null)
    	{
    		Liste<Kullanıcı> kullaniciListesi = ilgiAlanlarıKullanıcı.get(ilgiAlanı);
            
            for(Kullanıcı kullanıcıkontrol : kullaniciListesi)
            {
                if(kullanıcıkontrol.equals(kullanıcı))
                {
                	ekle=0;
                }            	
            }          
            if(ekle==1)
            {
            	kullaniciListesi.add(kullanıcı);
            	if(kullanıcıİlgiAlanları.get(kullanıcı)!=null)
            	{
            		Liste<String> kullanıcıAlanEkle = kullanıcıİlgiAlanları.get(kullanıcı);
                	kullanıcıAlanEkle.add(ilgiAlanı);
            	}
            	else
            	{
            		Liste<String> kullanıcıAlanEkle = new Liste<String>();
            		kullanıcıİlgiAlanları.put(kullanıcı, kullanıcıAlanEkle);
            	}
            } 
    	}
    	else
    	{
    		Liste<Kullanıcı> kullaniciListesi = new Liste<>();
    		kullaniciListesi.add(kullanıcı);
        	if(kullanıcıİlgiAlanları.get(kullanıcı)!=null)
        	{
        		Liste<String> kullanıcıAlanEkle = kullanıcıİlgiAlanları.get(kullanıcı);
            	kullanıcıAlanEkle.add(ilgiAlanı);
        	}
        	else
        	{
        		Liste<String> kullanıcıAlanEkle = new Liste<String>();
        		kullanıcıİlgiAlanları.put(kullanıcı, kullanıcıAlanEkle);
        	}
    	}
    }
    

    public void ilgiAlanıEkle(String ilgiAlani)
    {           
    	Liste<Kullanıcı> kullaniciListesi = new Liste<>();
        ilgiAlanlarıKullanıcı.put(ilgiAlani, kullaniciListesi);
        ilgiAlanları.add(ilgiAlani);
    }

    
    public void hazırİlgiAlanları()
    {           
    	ilgiAlanıEkle("Spor");					
    	ilgiAlanıEkle("Technology");				
    	ilgiAlanıEkle("Müzik");					
    	ilgiAlanıEkle("Bilim");					
    	ilgiAlanıEkle("Sanat");					
    	ilgiAlanıEkle("Moda");					
    	ilgiAlanıEkle("Film ve TV");
    	ilgiAlanıEkle("Gezi");
    	ilgiAlanıEkle("Yemek");
    	ilgiAlanıEkle("Kitap");
    	ilgiAlanıEkle("Oyun");
    	ilgiAlanıEkle("Sağlık ve Fitnes");
    	ilgiAlanıEkle("Eğlence");
    	ilgiAlanıEkle("Doğa");
    	ilgiAlanıEkle("Tarih");
    	ilgiAlanıEkle("Tekstil");
    	ilgiAlanıEkle("Finans");

    }
    
    
    public void hazırİlgiAlaniTespit()
    {
    	Liste<String> spor = new Liste<String>();
    	spor.add("futbol");spor.add("basketbol");spor.add("voleybol");spor.add("premier");spor.add("süper lig");spor.add("messi");
    	ilgiAlanlarıTespit.put("Spor",spor);
    	
    	Liste<String> teknoloji = new Liste<String>();
    	teknoloji.add("programlama");teknoloji.add("yazılım");teknoloji.add("teknoloji");
    	ilgiAlanlarıTespit.put("Technology", teknoloji);
    	
    	Liste<String> müzik = new Liste<String>();
    	müzik.add("müzisyen");müzik.add("albüm");müzik.add("müzik");
    	ilgiAlanlarıTespit.put("Müzik", müzik);
    	
    	Liste<String> bilim = new Liste<String>();
    	bilim.add("fizik"); bilim.add("biyoloji"); bilim.add("kimya"); bilim.add("matematik");
    	ilgiAlanlarıTespit.put("Bilim", bilim);
    	
    	Liste<String> sanat = new Liste<String>();
    	sanat.add("resim"); sanat.add("müze"); sanat.add("heykel");
    	ilgiAlanlarıTespit.put("Sanat", sanat);
    	
    	Liste<String> moda = new Liste<String>();
    	moda.add("giyim"); moda.add("aksesuar"); moda.add("moda"); moda.add("adidas");
    	ilgiAlanlarıTespit.put("Moda", moda);

    	Liste<String> filmVeTV = new Liste<String>();
    	filmVeTV.add("film"); filmVeTV.add("dizi"); filmVeTV.add("bleach"); filmVeTV.add("prison break"); filmVeTV.add("breaking bad");
    	ilgiAlanlarıTespit.put("Film ve TV", moda);
    	
    	Liste<String> gezi = new Liste<String>();
    	gezi.add("seyahat"); gezi.add("tatil"); gezi.add("keşif"); gezi.add("gezi");
    	ilgiAlanlarıTespit.put("Gezi", gezi);

    	Liste<String> yemek = new Liste<String>();
    	yemek.add("mutfak"); yemek.add("tarif"); yemek.add("gurme"); yemek.add("yemek");
    	ilgiAlanlarıTespit.put("Yemek", yemek);
    	
    	Liste<String> kitap = new Liste<String>();
    	kitap.add("yazar"); kitap.add("kitap");
    	ilgiAlanlarıTespit.put("Kitap", kitap);

    	Liste<String> oyun = new Liste<String>();
    	oyun.add("steam"); oyun.add("ubisoft"); oyun.add("league of legends"); oyun.add("minecraft"); oyun.add("grand theft");
    	ilgiAlanlarıTespit.put("Oyun", oyun);

    	Liste<String> saglikVeFitness = new Liste<String>();
    	saglikVeFitness.add("egzersiz"); saglikVeFitness.add("fitness"); saglikVeFitness.add("sağlık"); saglikVeFitness.add("fitness");
    	ilgiAlanlarıTespit.put("Sağlık ve Fitnes", saglikVeFitness);

    	Liste<String> eglence = new Liste<String>();
    	eglence.add("magazin"); eglence.add("komedi"); eglence.add("lunapark"); eglence.add("eğlence");
    	ilgiAlanlarıTespit.put("Eğlence", eglence);

    	Liste<String> doga = new Liste<String>();
    	doga.add("dağ"); doga.add("göl"); doga.add("vahşi");
    	ilgiAlanlarıTespit.put("Doğa", doga);

    	Liste<String> tarih = new Liste<String>();
    	tarih.add("antik çağ"); tarih.add("yeniçeri"); tarih.add("Atatürk");
    	ilgiAlanlarıTespit.put("Tarih", tarih);

    	Liste<String> tekstil = new Liste<String>();
    	tekstil.add("tekstil"); tekstil.add("kumaş"); tekstil.add("tasarım");
    	ilgiAlanlarıTespit.put("Tekstil", tekstil);

    	Liste<String> finans = new Liste<String>();
    	finans.add("ekonomi"); finans.add("finans"); finans.add("yatırım"); finans.add("borsa"); finans.add("kripto"); finans.add("bitcoin"); finans.add("ethereum");
    	ilgiAlanlarıTespit.put("Finans", finans);
    }
    
    public void kullanıcıİlgiAlanıTespit(BagliListe linkedListe)
    {   	
    	Node iter = linkedListe.head;
		while(iter != null)
		{
		    Kullanıcı kullanıcı = iter.data;
		    for(String tweet : kullanıcı.getTweets())
		    {
		    	for(String ilgiAlani : ilgiAlanları)
                {
                    Liste<String> anahtarKelimeler = ilgiAlanıAnahtarKelimeleriGetir(ilgiAlani);
                    for(String anahtarKelime : anahtarKelimeler)
                    {
                        if(tweet.toLowerCase().contains(anahtarKelime.toLowerCase()))
                        {   
                        	ilgiAlanınaEkle(ilgiAlani, kullanıcı);
                        }
                    }
                }		      
		    }
		    iter = iter.next;
		}
    }
    
    
    public Liste<String> kullanıcıİlgiAlanıTweet(Kullanıcı kullanıcı, String ilgiAlanı)
    {
        Liste<String> ilgiAlanınaAitTweetler = new Liste<>();
        Liste<String> kullanıcıİlgiAlanları = kullanıcıİlgiAlanlarıGetir(kullanıcı);

        if(kullanıcıİlgiAlanları != null && kullanıcıİlgiAlanları.contains(ilgiAlanı))
        {
            for(String tweet : kullanıcı.getTweets())
            {            
                Liste<String> anahtarKelimeler = ilgiAlanlarıTespit.get(ilgiAlanı);
                for(String anahtarKelime : anahtarKelimeler)
                {
                    if(tweet.toLowerCase().contains(anahtarKelime.toLowerCase()))
                    {   
                    	ilgiAlanınaAitTweetler.add(tweet);
                    }
                }               
            }
        }
        return ilgiAlanınaAitTweetler;
    }

    
    public Liste<Kullanıcı> ilgiAlanıKullanıcıGetir(String ilgiAlanı)
    {    	
        return ilgiAlanlarıKullanıcı.get(ilgiAlanı);
    }
    public Liste<String> kullanıcıİlgiAlanlarıGetir(Kullanıcı kullanıcı)
    {   
        return kullanıcıİlgiAlanları.get(kullanıcı);
    }
    public Liste<String> ilgiAlanıAnahtarKelimeleriGetir(String ilgiAlanı)
    {   
        return ilgiAlanlarıTespit.get(ilgiAlanı);
    }
    public void rapor(BagliListe linkedListe,İlgiAlanıKullanıcı alan)
    {
    	AnalizRaporu rapor = new AnalizRaporu();
    	rapor.raporuKaydet(linkedListe,alan);    	    	
    }

}
