package proje;

import java.io.FileWriter;
import java.io.IOException;


public class AnalizRaporu {

    public void raporuKaydet(BagliListe linkedList,İlgiAlanıKullanıcı alan)
    {
        
	    try {
	    	
	        FileWriter writer = new FileWriter("Analiz Raporu.txt");
	
	        writer.write("Analiz Raporu\n");
	        writer.write("-----------------------------------------\n\n");
	
	        writer.write("Analiz Edilen İlgi Alanları:\n");
	        int alanSıra = 1;
	        for(String ilgiAlani : alan.ilgiAlanları)
	        {
	            writer.write(alanSıra + ". " + ilgiAlani + "\n");
	            alanSıra++;
	        }
	        writer.write("\n-----------------------------------------\n\n");
	
	        writer.write("İlgi Alanı Analizi:\n");
	        for(String ilgiAlani : alan.ilgiAlanları)
	        {
	            Liste<Kullanıcı> kullaniciListesi = alan.ilgiAlanıKullanıcıGetir(ilgiAlani);	
	            writer.write("➢ " + ilgiAlani + ":\n");
	            writer.write("   ➢ Toplam Kullanıcı Sayısı: " + kullaniciListesi.size() + "\n");
	            writer.write("   ➢ Öne Çıkan Anahtar Kelimeler:"+ alan.ilgiAlanlarıTespit.get(ilgiAlani)+"\n\n");
	        }
	        writer.write("-----------------------------------------\n\n");
	
	        writer.write("Detaylı Analiz Raporu:\n");
	        int kullaniciSıra = 1;
	        Node current = linkedList.head; 
	        while(current != null)
	        {
	            Kullanıcı kullanıcı = current.data;
	            writer.write(kullaniciSıra + ". Kullanıcı Adı: " + kullanıcı.getUsername() + "\n");
                writer.write("   ➢ İlgi Alanları:\n");
                Liste<String> ilgiAlanlariKullanici = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
                if(ilgiAlanlariKullanici != null)
                {
                    for(String ilgiAlani : ilgiAlanlariKullanici)
                    {
                        writer.write("     ➢ " + ilgiAlani + "\n");
                        writer.write("   	  ➢ " + "Tweetler:" + "\n");
                        Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
                        for(String tweet : tweetlistesi)
                        {
                        	writer.write("   	  ➢ " + tweet + "\n");
                        }
                        
                    }
                }
                
                writer.write("\n");
                kullaniciSıra++;
                
	            current = current.next;
	        }	      

	        writer.close();
	        
	    }
	    catch (IOException e)
	    {
	        System.out.println("Hata! " + e.getMessage());
	    }
    }
    
}
