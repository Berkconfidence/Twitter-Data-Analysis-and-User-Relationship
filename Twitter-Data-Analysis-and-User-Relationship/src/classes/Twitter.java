package proje;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.TextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;

public class Twitter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public Twitter(BagliListe linkedList, İlgiAlanıKullanıcı alan,Graph graph) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 202, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(202, 0, 594, 563);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JLabel labelTwitter = new JLabel("Twitter");
		labelTwitter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		labelTwitter.setBounds(55, 10, 132, 57);
		panel.add(labelTwitter);
		
		JLabel labelİslemPaneli = new JLabel("İşlem Paneli");
		labelİslemPaneli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		labelİslemPaneli.setBounds(20, 45, 170, 57);
		panel.add(labelİslemPaneli);
		
		JPanel panelİlgiAlanıKullanıcı = new JPanel();
		panelİlgiAlanıKullanıcı.setBounds(0, 0, 594, 563);
		layeredPane.add(panelİlgiAlanıKullanıcı);
		panelİlgiAlanıKullanıcı.setLayout(null);
		
		JLabel labelBaşlık = new JLabel("İlgi Alanına Göre Kullanıcı Bulma");
		labelBaşlık.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		labelBaşlık.setBounds(25, 10, 438, 57);
		panelİlgiAlanıKullanıcı.add(labelBaşlık);
		
		JLabel labelKullanıcı1 = new JLabel("Eşleştirmek İstediğiniz Kullanıcı");
		labelKullanıcı1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKullanıcı1.setBounds(25, 80, 218, 28);
		panelİlgiAlanıKullanıcı.add(labelKullanıcı1);
		
		JComboBox<String> comboBoxKullanıcı1 = new JComboBox<String>();
		comboBoxKullanıcı1.setBounds(25, 115, 135, 20);
		panelİlgiAlanıKullanıcı.add(comboBoxKullanıcı1);
		
		JLabel labelİlgiAlanı = new JLabel("İlgi Alanı Seçimi");
		labelİlgiAlanı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelİlgiAlanı.setBounds(25, 150, 218, 28);
		panelİlgiAlanıKullanıcı.add(labelİlgiAlanı);
		
		JComboBox<String> comboBoxİlgiAlanı = new JComboBox<String>();
		comboBoxİlgiAlanı.setBounds(25, 185, 135, 20);
		panelİlgiAlanıKullanıcı.add(comboBoxİlgiAlanı);
		
		JButton buttonGöster = new JButton("Göster");
		buttonGöster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxİlgiAlanı.removeAllItems();
				if(comboBoxKullanıcı1.getSelectedItem()!=null)
				{
					String kullanıcıİsim = comboBoxKullanıcı1.getSelectedItem().toString();
					Node current = linkedList.head; 
				    while (current != null)
				    {
				    	Kullanıcı kullanıcı = current.data;
				     	if(kullanıcı.getName().equals(kullanıcıİsim))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
				     		for(String alan : ilgiAlanları)
				     		{
				     			comboBoxİlgiAlanı.addItem(alan);
				     		}
				     		break;
				     	}
				        current = current.next;
				     }
				}						
			}
		});
		buttonGöster.setBounds(25, 215, 80, 21);
		panelİlgiAlanıKullanıcı.add(buttonGöster);
		
		JLabel labelKullanıcı2 = new JLabel("Eşleşen Kullanıcı");
		labelKullanıcı2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKullanıcı2.setBounds(25, 250, 218, 28);
		panelİlgiAlanıKullanıcı.add(labelKullanıcı2);
		
		JComboBox<String> comboBoxKullanıcı2 = new JComboBox<String>();
		comboBoxKullanıcı2.setBounds(25, 285, 135, 20);
		panelİlgiAlanıKullanıcı.add(comboBoxKullanıcı2);
		
		JButton buttonAra = new JButton("Ara");
		buttonAra.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				comboBoxKullanıcı2.removeAllItems();
				if(comboBoxKullanıcı1.getSelectedItem()!=null && comboBoxİlgiAlanı.getSelectedItem()!=null)
				{
					String kullanıcıİsim = comboBoxKullanıcı1.getSelectedItem().toString();
					String kullanıcıAlan = comboBoxİlgiAlanı.getSelectedItem().toString();
					
					Liste<Kullanıcı> kullanıcılar = alan.ilgiAlanıKullanıcıGetir(kullanıcıAlan);
					for(Kullanıcı kullanıcı : kullanıcılar)
					{
						if(!kullanıcı.getName().equals(kullanıcıİsim))
							comboBoxKullanıcı2.addItem(kullanıcı.getName());
					}
				}				
				
			}
		});
		buttonAra.setBounds(25, 315, 80, 21);
		panelİlgiAlanıKullanıcı.add(buttonAra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 380, 535, 60);
		panelİlgiAlanıKullanıcı.add(scrollPane);
		
		JTextArea tweetAreaUser1 = new JTextArea();
		scrollPane.setViewportView(tweetAreaUser1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(25, 475, 535, 60);
		panelİlgiAlanıKullanıcı.add(scrollPane2);
		
		JTextArea tweetAreaUser2 = new JTextArea();
		scrollPane2.setViewportView(tweetAreaUser2);
		
		JButton buttonEşleştir = new JButton("Eşleştir");
		buttonEşleştir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tweetAreaUser1.setText("");
				tweetAreaUser2.setText("");
				if(comboBoxKullanıcı1.getSelectedItem()!=null && comboBoxİlgiAlanı.getSelectedItem()!=null && comboBoxKullanıcı2.getSelectedItem()!=null)
				{
					String kullanıcıİsim = comboBoxKullanıcı1.getSelectedItem().toString();
					String kullanıcıAlan = comboBoxİlgiAlanı.getSelectedItem().toString();
					String kullanıcıİsim2 = comboBoxKullanıcı2.getSelectedItem().toString();
					
					Node current = linkedList.head; 
				    while (current != null)
				    {
				    	Kullanıcı kullanıcı = current.data;
				     	if(kullanıcı.getName().equals(kullanıcıİsim))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(kullanıcıAlan.equals(ilgiAlani))
			                    	{
			                    		Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
				                        for(String tweet : tweetlistesi)
				                        {
				                        	tweetAreaUser1.append("  - " + tweet + "\n");
				                        }		                        
			                    	}	                        
			                    }
			                }
				     	}
				     	if(kullanıcı.getName().equals(kullanıcıİsim2))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(kullanıcıAlan.equals(ilgiAlani))
			                    	{
			                    		Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
				                        for(String tweet : tweetlistesi)
				                        {
				                        	tweetAreaUser2.append("  - " + tweet + "\n");
				                        }		                        
			                    	}	                        
			                    }
			                }
				     	}
				        current = current.next;
				    }
				}
							    
			}
		});
		buttonEşleştir.setBounds(115, 315, 80, 21);
		panelİlgiAlanıKullanıcı.add(buttonEşleştir);
		
		JLabel labelTweetKullanıcı1 = new JLabel("Birinci Kullanıcının Tweetleri");
		labelTweetKullanıcı1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTweetKullanıcı1.setBounds(25, 350, 218, 28);
		panelİlgiAlanıKullanıcı.add(labelTweetKullanıcı1);
			
		JLabel labelTweetKullanıcı2 = new JLabel("İkinci Kullanıcının Tweetleri");
		labelTweetKullanıcı2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTweetKullanıcı2.setBounds(25, 445, 218, 28);
		panelİlgiAlanıKullanıcı.add(labelTweetKullanıcı2);
						
		
		JButton buttonKullanıcıİlgiAlanı = new JButton("İlgi Alanı Kullanıcı");
		buttonKullanıcıİlgiAlanı.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(panelİlgiAlanıKullanıcı);
				layeredPane.repaint();
				layeredPane.revalidate();
				comboBoxKullanıcı1.removeAllItems();
				
				 Node current = linkedList.head; 
			     while (current != null)
			     {
			         Kullanıcı kullanıcı = current.data;
			     	 comboBoxKullanıcı1.addItem(kullanıcı.getName());           		                
			         current = current.next;
			     }
			     
				
			}
		});
		buttonKullanıcıİlgiAlanı.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		buttonKullanıcıİlgiAlanı.setBounds(15, 160, 168, 27);
		panel.add(buttonKullanıcıİlgiAlanı);
		
		JPanel panelOrtakİlgiAlanı = new JPanel();
		panelOrtakİlgiAlanı.setBounds(0, 0, 594, 563);
		layeredPane.add(panelOrtakİlgiAlanı);
		panelOrtakİlgiAlanı.setLayout(null);
		
		JLabel labelBaşlık2 = new JLabel("Ortak İlgi Alanı Bulma");
		labelBaşlık2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		labelBaşlık2.setBounds(25, 10, 303, 57);
		panelOrtakİlgiAlanı.add(labelBaşlık2);
		
		JLabel labelBirinciKullanıcı = new JLabel("Birinci Kullanıcıyı Seçiniz");
		labelBirinciKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelBirinciKullanıcı.setBounds(25, 80, 178, 28);
		panelOrtakİlgiAlanı.add(labelBirinciKullanıcı);
		
		JComboBox<String> comboBoxOrtakKullanıcı1 = new JComboBox<String>();
		comboBoxOrtakKullanıcı1.setBounds(25, 115, 135, 20);
		panelOrtakİlgiAlanı.add(comboBoxOrtakKullanıcı1);
		
		JLabel labelİkinciKullanıcı = new JLabel("İkinci Kullanıcıyı Seçiniz");
		labelİkinciKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelİkinciKullanıcı.setBounds(25, 150, 178, 28);
		panelOrtakİlgiAlanı.add(labelİkinciKullanıcı);
		
		JComboBox<String> comboBoxOrtakKullanıcı2 = new JComboBox<String>();
		comboBoxOrtakKullanıcı2.setBounds(25, 185, 135, 20);
		panelOrtakİlgiAlanı.add(comboBoxOrtakKullanıcı2);
		
		JLabel labelOrtakİlgiAlanı = new JLabel("Ortak İlgi Alanı");
		labelOrtakİlgiAlanı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelOrtakİlgiAlanı.setBounds(25, 220, 178, 28);
		panelOrtakİlgiAlanı.add(labelOrtakİlgiAlanı);
		
		JComboBox<String> comboBoxOrtakİlgiAlanı = new JComboBox<String>();
		comboBoxOrtakİlgiAlanı.setBounds(25, 255, 135, 20);
		panelOrtakİlgiAlanı.add(comboBoxOrtakİlgiAlanı);
		
		JButton buttonOrtakAra = new JButton("Ara");
		buttonOrtakAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxOrtakİlgiAlanı.removeAllItems();
			    String kullanıcıİsim1 = comboBoxOrtakKullanıcı1.getSelectedItem().toString();
			    String kullanıcıİsim2 = comboBoxOrtakKullanıcı2.getSelectedItem().toString();

			    Node current = linkedList.head;
			    Liste<String> ilgiAlanları1 = null;
			    Liste<String> ilgiAlanları2 = null;

			    while(current != null)
			    {
			        Kullanıcı kullanıcı = current.data;
			        if (kullanıcı.getName().equals(kullanıcıİsim1))
			        {
			            ilgiAlanları1 = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			        }
			        else if(kullanıcı.getName().equals(kullanıcıİsim2))
			        {
			            ilgiAlanları2 = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			        }

			        if(ilgiAlanları1 != null && ilgiAlanları2 != null)
			        {
				        for (String ortakAlan1 : ilgiAlanları1)
				        {
				        	for (String ortakAlan2 : ilgiAlanları2)
					        {
					            if(ortakAlan1.equals(ortakAlan2))
					            {
					            	comboBoxOrtakİlgiAlanı.addItem(ortakAlan1);
					            }
					        }
				        }
			            break;
			        }
			        current = current.next;
			    }

			    
			    
			}
		});
		buttonOrtakAra.setBounds(25, 285, 80, 21);
		panelOrtakİlgiAlanı.add(buttonOrtakAra);
			
		
		JLabel labelOrtakTweetKullanıcı1 = new JLabel("Birinci Kullanıcının Tweetleri");
		labelOrtakTweetKullanıcı1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelOrtakTweetKullanıcı1.setBounds(25, 335, 218, 28);
		panelOrtakİlgiAlanı.add(labelOrtakTweetKullanıcı1);
		
		JScrollPane scrollOrtakPane = new JScrollPane();
		scrollOrtakPane.setBounds(25, 370, 535, 60);
		panelOrtakİlgiAlanı.add(scrollOrtakPane);
		
		JTextArea tweetOrtakAreaUser1 = new JTextArea();
		scrollOrtakPane.setViewportView(tweetOrtakAreaUser1);
		
		JLabel labelOrtakTweetKullanıcı2 = new JLabel("İkinci Kullanıcının Tweetleri");
		labelOrtakTweetKullanıcı2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelOrtakTweetKullanıcı2.setBounds(25, 445, 218, 28);
		panelOrtakİlgiAlanı.add(labelOrtakTweetKullanıcı2);
		
		JScrollPane scrollOrtakPane_1 = new JScrollPane();
		scrollOrtakPane_1.setBounds(25, 480, 535, 60);
		panelOrtakİlgiAlanı.add(scrollOrtakPane_1);
		
		JTextArea tweetOrtakAreaUser2 = new JTextArea();
		scrollOrtakPane_1.setViewportView(tweetOrtakAreaUser2);
		
		JButton buttonOrtakEşleştir = new JButton("Eşleştir");
		buttonOrtakEşleştir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tweetOrtakAreaUser1.setText("");
				tweetOrtakAreaUser2.setText("");
				if(comboBoxOrtakKullanıcı1.getSelectedItem()!=null && comboBoxOrtakİlgiAlanı.getSelectedItem()!=null && comboBoxOrtakKullanıcı2.getSelectedItem()!=null)
				{
					String kullanıcıİsim = comboBoxOrtakKullanıcı1.getSelectedItem().toString();
					String kullanıcıAlan = comboBoxOrtakİlgiAlanı.getSelectedItem().toString();
					String kullanıcıİsim2 = comboBoxOrtakKullanıcı2.getSelectedItem().toString();
					
					Node current = linkedList.head; 
				    while (current != null)
				    {
				    	Kullanıcı kullanıcı = current.data;
				     	if(kullanıcı.getName().equals(kullanıcıİsim))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(kullanıcıAlan.equals(ilgiAlani))
			                    	{
			                    		Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
				                        for(String tweet : tweetlistesi)
				                        {
				                        	tweetOrtakAreaUser1.append("  - " + tweet + "\n");
				                        }		                        
			                    	}	                        
			                    }
			                }
				     	}
				     	if(kullanıcı.getName().equals(kullanıcıİsim2))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(kullanıcıAlan.equals(ilgiAlani))
			                    	{
			                    		Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
				                        for(String tweet : tweetlistesi)
				                        {
				                        	tweetOrtakAreaUser2.append("  - " + tweet + "\n");
				                        }		                        
			                    	}	                        
			                    }
			                }
				     	}
				        current = current.next;
				    }
				}
			}
		});
		buttonOrtakEşleştir.setBounds(115, 285, 80, 21);
		panelOrtakİlgiAlanı.add(buttonOrtakEşleştir);
		
		JButton buttonOrtakİlgiAlanı = new JButton("Ortak İlgi Alanı Bulma");
		buttonOrtakİlgiAlanı.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(panelOrtakİlgiAlanı);
				layeredPane.repaint();
				layeredPane.revalidate();		
				comboBoxOrtakKullanıcı1.removeAllItems();
				comboBoxOrtakKullanıcı2.removeAllItems();
				
				 Node current = linkedList.head; 
			     while (current != null)
			     {
			         Kullanıcı kullanıcı = current.data;
			         comboBoxOrtakKullanıcı1.addItem(kullanıcı.getName());
			         comboBoxOrtakKullanıcı2.addItem(kullanıcı.getName());  
			         current = current.next;
			     }
			}
		});
		buttonOrtakİlgiAlanı.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		buttonOrtakİlgiAlanı.setBounds(15, 225, 168, 27);
		panel.add(buttonOrtakİlgiAlanı);
		
		JPanel panelTakipçiEşleştirme = new JPanel();
		panelTakipçiEşleştirme.setBounds(0, 0, 594, 563);
		layeredPane.add(panelTakipçiEşleştirme);
		panelTakipçiEşleştirme.setLayout(null);
		
		JLabel labelBaşlık3 = new JLabel("Takipçileri Eşleştirme");
		labelBaşlık3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		labelBaşlık3.setBounds(25, 10, 303, 57);
		panelTakipçiEşleştirme.add(labelBaşlık3);
		
		JLabel labelBirinciKullanıcıTakipçi = new JLabel("Birinci Kullanıcıyı Seçiniz");
		labelBirinciKullanıcıTakipçi.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelBirinciKullanıcıTakipçi.setBounds(25, 80, 178, 28);
		panelTakipçiEşleştirme.add(labelBirinciKullanıcıTakipçi);
		
		JComboBox<String> comboBoxTakipçiKullanıcı1 = new JComboBox<String>();
		comboBoxTakipçiKullanıcı1.setBounds(25, 115, 135, 20);
		panelTakipçiEşleştirme.add(comboBoxTakipçiKullanıcı1);
		
		JLabel labelİkinciKullanıcıTakipçi = new JLabel("İkinci Kullanıcıyı Seçiniz");
		labelİkinciKullanıcıTakipçi.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelİkinciKullanıcıTakipçi.setBounds(25, 150, 178, 28);
		panelTakipçiEşleştirme.add(labelİkinciKullanıcıTakipçi);
		
		JComboBox<String> comboBoxTakipçiKullanıcı2 = new JComboBox<String>();
		comboBoxTakipçiKullanıcı2.setBounds(25, 185, 135, 20);
		panelTakipçiEşleştirme.add(comboBoxTakipçiKullanıcı2);
		
		JLabel labelTakipçiİlgiAlanı = new JLabel("Ortak İlgi Alanı");
		labelTakipçiİlgiAlanı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipçiİlgiAlanı.setBounds(25, 220, 135, 28);
		panelTakipçiEşleştirme.add(labelTakipçiİlgiAlanı);
		
		JComboBox<String> comboBoxTakipçiİlgiAlanı = new JComboBox<String>();
		comboBoxTakipçiİlgiAlanı.setModel(new DefaultComboBoxModel<String>(new String[] {"Spor", "Technology", "Müzik", "Bilim", "Sanat", "Moda", "Film ve TV", "Gezi", "Yemek", "Kitap", "Oyun", "Sağlık ve Fitnes", "Eğlence", "Doğa", "Tarih", "Tekstil", "Finans"}));
		comboBoxTakipçiİlgiAlanı.setBounds(25, 255, 135, 20);
		panelTakipçiEşleştirme.add(comboBoxTakipçiİlgiAlanı);
		
		JLabel labelBirinciKullanıcıTakipçi1_1 = new JLabel("Birinci Kullanıcının Takipçileri");
		labelBirinciKullanıcıTakipçi1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelBirinciKullanıcıTakipçi1_1.setBounds(250, 77, 191, 28);
		panelTakipçiEşleştirme.add(labelBirinciKullanıcıTakipçi1_1);
		
		JComboBox<String> comboBoxTakipçilerKullanıcı1 = new JComboBox<String>();
		comboBoxTakipçilerKullanıcı1.setBounds(250, 115, 135, 20);
		panelTakipçiEşleştirme.add(comboBoxTakipçilerKullanıcı1);
		
		JLabel labelİkinciKullanıcıTakipçi2_1 = new JLabel("İkinci Kullanıcının Takipçileri");
		labelİkinciKullanıcıTakipçi2_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelİkinciKullanıcıTakipçi2_1.setBounds(250, 150, 191, 28);
		panelTakipçiEşleştirme.add(labelİkinciKullanıcıTakipçi2_1);
		
		JComboBox<String> comboBoxTakipçilerKullanıcı2 = new JComboBox<String>();
		comboBoxTakipçilerKullanıcı2.setBounds(250, 185, 135, 20);
		panelTakipçiEşleştirme.add(comboBoxTakipçilerKullanıcı2);
		
		JButton buttonTakipçiAra = new JButton("Ara");
		buttonTakipçiAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxTakipçilerKullanıcı1.removeAllItems();
				comboBoxTakipçilerKullanıcı2.removeAllItems();
				String geciciİsim1 = comboBoxTakipçiKullanıcı1.getSelectedItem().toString();
				String geciciİsim2 = comboBoxTakipçiKullanıcı2.getSelectedItem().toString();
				String ilgiAlanıTakipçi = comboBoxTakipçiİlgiAlanı.getSelectedItem().toString();
				String kullanıcıİsim1=null;
				String kullanıcıİsim2=null;
				
				Node current = linkedList.head; 
			    while (current != null)
			    {
			    	Kullanıcı kullanıcı = current.data;
			     	if(kullanıcı.getName().equals(geciciİsim1))
			     	{
			     		kullanıcıİsim1 = kullanıcı.getUsername();
			     	}
			     	if(kullanıcı.getName().equals(geciciİsim2))
			     	{
			     		kullanıcıİsim2 = kullanıcı.getUsername();
			     	}
			     	current = current.next;
			    }
							
			    Liste<String> eklenenKullanıcılar = new Liste<>();
				Liste<GraphNode> takipçiKullanıcı1 = graph.getFollowers(kullanıcıİsim1);			
				for(GraphNode kullanıcı : takipçiKullanıcı1)
				{
					Node liste = linkedList.head; 
				    while (liste != null)
				    {
				    	Kullanıcı takipçi = liste.data;
				    	if(takipçi.getName().equals(kullanıcı.getUser().getName()) && !eklenenKullanıcılar.contains(takipçi.getName()))
				    	{
				    		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(takipçi);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(ilgiAlanıTakipçi.equals(ilgiAlani))
			                    	{
			                    		comboBoxTakipçilerKullanıcı1.addItem(kullanıcı.getUser().getName());
			                    		eklenenKullanıcılar.add(takipçi.getName());
			                    	}	                        
			                    }
			                }
				    	}
				     	liste = liste.next;
				    }					
				}
				Liste<String> eklenenKullanıcılar2 = new Liste<>();
				Liste<GraphNode> takipçiKullanıcı2 = graph.getFollowers(kullanıcıİsim2);			
				for(GraphNode kullanıcı : takipçiKullanıcı2)
				{
					Node liste = linkedList.head; 
				    while (liste != null)
				    {
				    	Kullanıcı takipçi = liste.data;
				    	if(takipçi.getName().equals(kullanıcı.getUser().getName()) && !eklenenKullanıcılar2.contains(takipçi.getName()))
				    	{
				    		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(takipçi);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(ilgiAlanıTakipçi.equals(ilgiAlani))
			                    	{
			                    		comboBoxTakipçilerKullanıcı2.addItem(kullanıcı.getUser().getName());
			                    		eklenenKullanıcılar2.add(takipçi.getName());
			                    	}	                        
			                    }
			                }
				    	}
				     	liste = liste.next;
				    }					
				}
				
				
			}
		});
		buttonTakipçiAra.setBounds(25, 285, 80, 21);
		panelTakipçiEşleştirme.add(buttonTakipçiAra);
		
		JLabel labelTakipçiTweetKullanıcı1 = new JLabel("Birinci Kullanıcının Tweetleri");
		labelTakipçiTweetKullanıcı1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipçiTweetKullanıcı1.setBounds(25, 325, 218, 28);
		panelTakipçiEşleştirme.add(labelTakipçiTweetKullanıcı1);
		
		JScrollPane scrollTakipçiPane = new JScrollPane();
		scrollTakipçiPane.setBounds(25, 360, 535, 65);
		panelTakipçiEşleştirme.add(scrollTakipçiPane);
		
		JTextArea tweetTakipçiAreaUser1 = new JTextArea();
		scrollTakipçiPane.setViewportView(tweetTakipçiAreaUser1);
		
		JLabel labelTakipçiTweetKullanıcı2 = new JLabel("İkinci Kullanıcının Tweetleri");
		labelTakipçiTweetKullanıcı2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipçiTweetKullanıcı2.setBounds(25, 435, 218, 28);
		panelTakipçiEşleştirme.add(labelTakipçiTweetKullanıcı2);
		
		JScrollPane scrollTakipçiPane2 = new JScrollPane();
		scrollTakipçiPane2.setBounds(25, 470, 535, 65);
		panelTakipçiEşleştirme.add(scrollTakipçiPane2);
		
		JTextArea tweetTakipçiAreaUser2 = new JTextArea();
		scrollTakipçiPane2.setViewportView(tweetTakipçiAreaUser2);
		
		JButton buttonTakipçiEşleştir = new JButton("Eşleştir");
		buttonTakipçiEşleştir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tweetTakipçiAreaUser1.setText("");
				tweetTakipçiAreaUser2.setText("");
				if(comboBoxTakipçilerKullanıcı1.getSelectedItem()!=null && comboBoxTakipçilerKullanıcı2.getSelectedItem()!=null)
				{
					String kullanıcıİsim = comboBoxTakipçilerKullanıcı1.getSelectedItem().toString();
					String kullanıcıAlan = comboBoxTakipçiİlgiAlanı.getSelectedItem().toString();
					String kullanıcıİsim2 = comboBoxTakipçilerKullanıcı2.getSelectedItem().toString();
					
					Node current = linkedList.head; 
				    while (current != null)
				    {
				    	Kullanıcı kullanıcı = current.data;
				     	if(kullanıcı.getName().equals(kullanıcıİsim))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(kullanıcıAlan.equals(ilgiAlani))
			                    	{
			                    		Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
				                        for(String tweet : tweetlistesi)
				                        {
				                        	tweetTakipçiAreaUser1.append("  - " + tweet + "\n");
				                        }		                        
			                    	}	                        
			                    }
			                }
				     	}
				     	if(kullanıcı.getName().equals(kullanıcıİsim2))
				     	{
				     		Liste<String> ilgiAlanları = alan.kullanıcıİlgiAlanlarıGetir(kullanıcı);
			                if (ilgiAlanları != null)
			                {
			                    for (String ilgiAlani : ilgiAlanları)
			                    {	
			                    	if(kullanıcıAlan.equals(ilgiAlani))
			                    	{
			                    		Liste<String> tweetlistesi = alan.kullanıcıİlgiAlanıTweet(kullanıcı,ilgiAlani);
				                        for(String tweet : tweetlistesi)
				                        {
				                        	tweetTakipçiAreaUser2.append("  - " + tweet + "\n");
				                        }		                        
			                    	}	                        
			                    }
			                }
				     	}
				        current = current.next;
				    }
				}
			}
		});
		buttonTakipçiEşleştir.setBounds(250, 215, 80, 21);
		panelTakipçiEşleştirme.add(buttonTakipçiEşleştir);
		
		JPanel panelKarşılaştırma = new JPanel();
		layeredPane.add(panelKarşılaştırma, "name_36588000962100");
		panelKarşılaştırma.setLayout(null);
		
		JLabel labelBaşlık4 = new JLabel("Kullanıcı Karşılaştırma");
		labelBaşlık4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		labelBaşlık4.setBounds(25, 10, 303, 57);
		panelKarşılaştırma.add(labelBaşlık4);
		
		JLabel labelKarşılaştırmaKullanıcı1 = new JLabel("Kullanıcı Seçiniz");
		labelKarşılaştırmaKullanıcı1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKarşılaştırmaKullanıcı1.setBounds(25, 80, 178, 28);
		panelKarşılaştırma.add(labelKarşılaştırmaKullanıcı1);
		
		JComboBox<String> comboBoxTakipçiSayısıKullanıcı1 = new JComboBox<String>();
		comboBoxTakipçiSayısıKullanıcı1.setBounds(25, 110, 135, 20);
		panelKarşılaştırma.add(comboBoxTakipçiSayısıKullanıcı1);
		
		JLabel labelTakipçiSayısıAynıKullanıcı = new JLabel("Takipçi Sayısı Eşit Olanlar");
		labelTakipçiSayısıAynıKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipçiSayısıAynıKullanıcı.setBounds(25, 140, 178, 28);
		panelKarşılaştırma.add(labelTakipçiSayısıAynıKullanıcı);
		
		JComboBox<String> comboBoxTakipçiSayısıKullanıcı2 = new JComboBox<String>();
		comboBoxTakipçiSayısıKullanıcı2.setBounds(25, 170, 135, 20);
		panelKarşılaştırma.add(comboBoxTakipçiSayısıKullanıcı2);
		
		JLabel labelTakipçiSayısı = new JLabel("Takipçi Sayısı");
		labelTakipçiSayısı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipçiSayısı.setBounds(25, 200, 116, 28);
		panelKarşılaştırma.add(labelTakipçiSayısı);
		
		JComboBox<String> comboBoxTakipçiSayısı = new JComboBox<String>();
		comboBoxTakipçiSayısı.setBounds(25, 230, 135, 20);
		panelKarşılaştırma.add(comboBoxTakipçiSayısı);
		
		JButton buttonTakipçiSayısıAra = new JButton("Ara");
		buttonTakipçiSayısıAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxTakipçiSayısıKullanıcı2.removeAllItems();
				comboBoxTakipçiSayısı.removeAllItems();
				
				String geciciİsim = comboBoxTakipçiSayısıKullanıcı1.getSelectedItem().toString();
				String kullanıcıİsim = null;
				String kullanıcılar = null;
				int takipçiSayısı=0;
				
				Node current = linkedList.head; 
			    while (current != null)
			    {
			    	Kullanıcı kullanıcı = current.data;
			     	if(kullanıcı.getName().equals(geciciİsim))
			     	{
			     		kullanıcıİsim = kullanıcı.getUsername();
			     	}			     	
			     	current = current.next;
			    }			    
			    				
			    takipçiSayısı=graph.getFollowersSize(kullanıcıİsim);
			    String takipçiSayı = Integer.toString(takipçiSayısı);
			    comboBoxTakipçiSayısı.addItem(takipçiSayı);
			    
			    Node follower = linkedList.head; 
			    while (follower != null)
			    {
			    	Kullanıcı kullanıcı = follower.data;
			    	kullanıcılar = kullanıcı.getUsername();
			     	if(takipçiSayısı==graph.getFollowersSize(kullanıcılar) && !kullanıcılar.equals(kullanıcıİsim))
			     	{
			     		comboBoxTakipçiSayısıKullanıcı2.addItem(kullanıcı.getName());
			     	}
			     	follower = follower.next;
			    }				
			}
		});
		buttonTakipçiSayısıAra.setBounds(25, 260, 80, 21);
		panelKarşılaştırma.add(buttonTakipçiSayısıAra);
		
		JLabel labelKarşılaştırmaKullanıcı2 = new JLabel("Kullanıcı Seçiniz");
		labelKarşılaştırmaKullanıcı2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKarşılaştırmaKullanıcı2.setBounds(213, 80, 145, 28);
		panelKarşılaştırma.add(labelKarşılaştırmaKullanıcı2);
		
		JComboBox<String> comboBoxTakipSayısıKullanıcı1 = new JComboBox<String>();
		comboBoxTakipSayısıKullanıcı1.setBounds(213, 110, 135, 20);
		panelKarşılaştırma.add(comboBoxTakipSayısıKullanıcı1);
		
		JLabel labelTakipSayısıAynıKullanıcı = new JLabel("Takip Sayısı Eşit Olanlar");
		labelTakipSayısıAynıKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipSayısıAynıKullanıcı.setBounds(213, 140, 168, 28);
		panelKarşılaştırma.add(labelTakipSayısıAynıKullanıcı);
		
		JComboBox<String> comboBoxTakipSayısıKullanıcı2 = new JComboBox<String>();
		comboBoxTakipSayısıKullanıcı2.setBounds(213, 170, 135, 20);
		panelKarşılaştırma.add(comboBoxTakipSayısıKullanıcı2);
		
		JLabel labelTakipSayısı = new JLabel("Takip Edilen Sayısı");
		labelTakipSayısı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTakipSayısı.setBounds(213, 200, 135, 28);
		panelKarşılaştırma.add(labelTakipSayısı);
		
		JComboBox<String> comboBoxTakipSayısı = new JComboBox<String>();
		comboBoxTakipSayısı.setBounds(213, 230, 135, 20);
		panelKarşılaştırma.add(comboBoxTakipSayısı);
		
		JButton buttonTakipSayısıAra = new JButton("Ara");
		buttonTakipSayısıAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxTakipSayısıKullanıcı2.removeAllItems();
				comboBoxTakipSayısı.removeAllItems();
				
				String geciciİsim = comboBoxTakipSayısıKullanıcı1.getSelectedItem().toString();
				String kullanıcıİsim = null;
				String kullanıcılar = null;
				int takipSayısı=0;
				
				Node current = linkedList.head; 
			    while (current != null)
			    {
			    	Kullanıcı kullanıcı = current.data;
			     	if(kullanıcı.getName().equals(geciciİsim))
			     	{
			     		kullanıcıİsim = kullanıcı.getUsername();
			     	}			     	
			     	current = current.next;
			    }			    
			    				
			    takipSayısı=graph.getFollowingSize(kullanıcıİsim);
			    String takipçiSayı = Integer.toString(takipSayısı);
			    comboBoxTakipSayısı.addItem(takipçiSayı);
			    
			    Node follower = linkedList.head; 
			    while (follower != null)
			    {
			    	Kullanıcı kullanıcı = follower.data;
			    	kullanıcılar = kullanıcı.getUsername();
			     	if(takipSayısı==graph.getFollowingSize(kullanıcılar) && !kullanıcılar.equals(kullanıcıİsim))
			     	{
			     		comboBoxTakipSayısıKullanıcı2.addItem(kullanıcı.getName());
			     	}
			     	follower = follower.next;
			    }
			}
		});
		buttonTakipSayısıAra.setBounds(213, 260, 80, 21);
		panelKarşılaştırma.add(buttonTakipSayısıAra);
		
		JLabel labelKarşılaştırmaKullanıcı3 = new JLabel("Kullanıcı Seçiniz");
		labelKarşılaştırmaKullanıcı3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKarşılaştırmaKullanıcı3.setBounds(406, 80, 145, 28);
		panelKarşılaştırma.add(labelKarşılaştırmaKullanıcı3);
		
		JComboBox<String> comboBoxDilKullanıcı1 = new JComboBox<String>();
		comboBoxDilKullanıcı1.setBounds(406, 110, 135, 20);
		panelKarşılaştırma.add(comboBoxDilKullanıcı1);
		
		JLabel labelAynıDilKullanıcı = new JLabel("Aynı Dile Sahip Kullanıcılar");
		labelAynıDilKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelAynıDilKullanıcı.setBounds(406, 140, 178, 28);
		panelKarşılaştırma.add(labelAynıDilKullanıcı);
		
		JComboBox<String> comboBoxDilKullanıcı2 = new JComboBox<String>();
		comboBoxDilKullanıcı2.setBounds(406, 170, 135, 20);
		panelKarşılaştırma.add(comboBoxDilKullanıcı2);
		
		JLabel lblKullanlanDil = new JLabel("Kullanılan Dil");
		lblKullanlanDil.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblKullanlanDil.setBounds(406, 200, 116, 28);
		panelKarşılaştırma.add(lblKullanlanDil);
		
		JComboBox<String> comboBoxKullanılanDil = new JComboBox<String>();
		comboBoxKullanılanDil.setBounds(406, 230, 135, 20);
		panelKarşılaştırma.add(comboBoxKullanılanDil);
		
		JButton buttonDilAra = new JButton("Ara");
		buttonDilAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxDilKullanıcı2.removeAllItems();
				comboBoxKullanılanDil.removeAllItems();
				
				String kullanıcıİsim = comboBoxDilKullanıcı1.getSelectedItem().toString();
				String dil = null;
				
				Node current = linkedList.head; 
			    while (current != null)
			    {
			    	Kullanıcı kullanıcı = current.data;
			     	if(kullanıcı.getName().equals(kullanıcıİsim))
			     	{
			     		dil=kullanıcı.getLanguage();
			     		comboBoxKullanılanDil.addItem(dil);
			     		break;
			     	}			     	
			     	current = current.next;
			    }
			    
			    Node iter = linkedList.head; 
			    while (iter != null)
			    {
			    	Kullanıcı kullanıcı = iter.data;
			     	if(kullanıcı.getLanguage().equals(dil) && !kullanıcı.getName().equals(kullanıcıİsim))
			     	{
			     		comboBoxDilKullanıcı2.addItem(kullanıcı.getName());
			     	}			     	
			     	iter = iter.next;
			    }
			    
			}
		});
		buttonDilAra.setBounds(406, 260, 80, 21);
		panelKarşılaştırma.add(buttonDilAra);
		
		JLabel labelKarşılaştırmaKullanıcı4 = new JLabel("Kullanıcı Seçiniz");
		labelKarşılaştırmaKullanıcı4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKarşılaştırmaKullanıcı4.setBounds(99, 303, 145, 28);
		panelKarşılaştırma.add(labelKarşılaştırmaKullanıcı4);
		
		JComboBox<String> comboBoxBölgeKullanıcı1 = new JComboBox<String>();
		comboBoxBölgeKullanıcı1.setBounds(99, 333, 135, 20);
		panelKarşılaştırma.add(comboBoxBölgeKullanıcı1);
		
		JLabel labelBölgeAynıKullanıcı = new JLabel("Aynı Bölgeden Kullanıcılar");
		labelBölgeAynıKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelBölgeAynıKullanıcı.setBounds(99, 363, 178, 28);
		panelKarşılaştırma.add(labelBölgeAynıKullanıcı);
		
		JComboBox<String> comboBoxBölgeKullanıcı2 = new JComboBox<String>();
		comboBoxBölgeKullanıcı2.setBounds(99, 393, 135, 20);
		panelKarşılaştırma.add(comboBoxBölgeKullanıcı2);
		
		JLabel lblBlge = new JLabel("Bölge");
		lblBlge.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblBlge.setBounds(99, 423, 66, 28);
		panelKarşılaştırma.add(lblBlge);
		
		JComboBox<String> comboBoxBölge = new JComboBox<String>();
		comboBoxBölge.setBounds(99, 453, 135, 20);
		panelKarşılaştırma.add(comboBoxBölge);
		
		JButton buttonBölgeAra = new JButton("Ara");
		buttonBölgeAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxBölgeKullanıcı2.removeAllItems();
				comboBoxBölge.removeAllItems();
				
				String kullanıcıİsim = comboBoxBölgeKullanıcı1.getSelectedItem().toString();
				String bölge = null;
				
				Node current = linkedList.head; 
			    while (current != null)
			    {
			    	Kullanıcı kullanıcı = current.data;
			     	if(kullanıcı.getName().equals(kullanıcıİsim))
			     	{
			     		bölge=kullanıcı.getRegion();
			     		comboBoxBölge.addItem(bölge);
			     		break;
			     	}			     	
			     	current = current.next;
			    }
			    
			    Node iter = linkedList.head; 
			    while (iter != null)
			    {
			    	Kullanıcı kullanıcı = iter.data;
			     	if(kullanıcı.getRegion().equals(bölge) && !kullanıcı.getName().equals(kullanıcıİsim))
			     	{
			     		comboBoxBölgeKullanıcı2.addItem(kullanıcı.getName());
			     	}			     	
			     	iter = iter.next;
			    }
			}
		});
		buttonBölgeAra.setBounds(99, 483, 80, 21);
		panelKarşılaştırma.add(buttonBölgeAra);
		
		JLabel labelKarşılaştırmaKullanıcı5 = new JLabel("Kullanıcı Seçiniz");
		labelKarşılaştırmaKullanıcı5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelKarşılaştırmaKullanıcı5.setBounds(308, 303, 145, 28);
		panelKarşılaştırma.add(labelKarşılaştırmaKullanıcı5);
		
		JComboBox<String> comboBoxTweetSayısıKullanıcı1 = new JComboBox<String>();
		comboBoxTweetSayısıKullanıcı1.setBounds(308, 333, 135, 20);
		panelKarşılaştırma.add(comboBoxTweetSayısıKullanıcı1);
		
		JLabel labelTweetSayısıKullanıcı = new JLabel("Tweet Sayısı Eşit Kullanıcılar");
		labelTweetSayısıKullanıcı.setFont(new Font("Tahoma", Font.ITALIC, 15));
		labelTweetSayısıKullanıcı.setBounds(308, 363, 190, 28);
		panelKarşılaştırma.add(labelTweetSayısıKullanıcı);
		
		JComboBox<String> comboBoxTweetSayısıKullanıcı2 = new JComboBox<String>();
		comboBoxTweetSayısıKullanıcı2.setBounds(308, 393, 135, 20);
		panelKarşılaştırma.add(comboBoxTweetSayısıKullanıcı2);
		
		JLabel lblTweetSays = new JLabel("Tweet Sayısı");
		lblTweetSays.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTweetSays.setBounds(308, 423, 100, 28);
		panelKarşılaştırma.add(lblTweetSays);
		
		JComboBox<String> comboBoxTweetSayısı = new JComboBox<String>();
		comboBoxTweetSayısı.setBounds(308, 453, 135, 20);
		panelKarşılaştırma.add(comboBoxTweetSayısı);
		
		JButton buttonBölgeAra_1 = new JButton("Ara");
		buttonBölgeAra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				comboBoxTweetSayısıKullanıcı2.removeAllItems();
				comboBoxTweetSayısı.removeAllItems();
				
				String kullanıcıİsim = comboBoxTweetSayısıKullanıcı1.getSelectedItem().toString();
				int tweetSayısı = 0;
				
				Node current = linkedList.head; 
			    while (current != null)
			    {
			    	Kullanıcı kullanıcı = current.data;
			     	if(kullanıcı.getName().equals(kullanıcıİsim))
			     	{
			     		tweetSayısı=kullanıcı.getTweetsSize();
			     		String tweetSayısıString = Integer.toString(tweetSayısı);
			     		comboBoxTweetSayısı.addItem(tweetSayısıString);
			     		break;
			     	}			     	
			     	current = current.next;
			    }
			    
			    Node iter = linkedList.head; 
			    while (iter != null)
			    {
			    	Kullanıcı kullanıcı = iter.data;
			     	if(kullanıcı.getTweetsSize()==tweetSayısı && !kullanıcı.getName().equals(kullanıcıİsim))
			     	{
			     		comboBoxTweetSayısıKullanıcı2.addItem(kullanıcı.getName());
			     	}			     	
			     	iter = iter.next;
			    }
			}
		});
		buttonBölgeAra_1.setBounds(308, 483, 80, 21);
		panelKarşılaştırma.add(buttonBölgeAra_1);
		
		
		
		JButton buttonTakipçileriEşleştirme = new JButton("Takipçileri Eşleştirme");
		buttonTakipçileriEşleştirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(panelTakipçiEşleştirme);
				layeredPane.repaint();
				layeredPane.revalidate();			
				comboBoxTakipçiKullanıcı1.removeAllItems();
				comboBoxTakipçiKullanıcı2.removeAllItems();
				
				 Node current = linkedList.head; 
			     while (current != null)
			     {
			         Kullanıcı kullanıcı = current.data;
			         comboBoxTakipçiKullanıcı1.addItem(kullanıcı.getName());
			         comboBoxTakipçiKullanıcı2.addItem(kullanıcı.getName()); 
			         current = current.next;
			     }
			}
		});
		buttonTakipçileriEşleştirme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		buttonTakipçileriEşleştirme.setBounds(15, 290, 168, 27);
		panel.add(buttonTakipçileriEşleştirme);
		
		JButton buttonKarşılaştırma = new JButton("Karşılaştırma");
		buttonKarşılaştırma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				layeredPane.removeAll();
				layeredPane.add(panelKarşılaştırma);
				layeredPane.repaint();
				layeredPane.revalidate();
				comboBoxTakipçiSayısıKullanıcı1.removeAllItems();
				comboBoxTakipSayısıKullanıcı1.removeAllItems();
				comboBoxDilKullanıcı1.removeAllItems();
				comboBoxBölgeKullanıcı1.removeAllItems();
				comboBoxTweetSayısıKullanıcı1.removeAllItems();
				
				Node current = linkedList.head; 
			     while (current != null)
			     {
			         Kullanıcı kullanıcı = current.data;
			         comboBoxTakipçiSayısıKullanıcı1.addItem(kullanıcı.getName());
			         comboBoxTakipSayısıKullanıcı1.addItem(kullanıcı.getName());
			         comboBoxDilKullanıcı1.addItem(kullanıcı.getName()); 
			         comboBoxBölgeKullanıcı1.addItem(kullanıcı.getName()); 			         			      
			         comboBoxTweetSayısıKullanıcı1.addItem(kullanıcı.getName());
			         current = current.next;
			     }
			}
		});
		buttonKarşılaştırma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		buttonKarşılaştırma.setBounds(15, 355, 168, 27);
		panel.add(buttonKarşılaştırma);		
		
		JButton buttonAnalizRaporu = new JButton("Analiz Raporu");
		buttonAnalizRaporu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				alan.rapor(linkedList,alan);
				JOptionPane.showMessageDialog(null, "Rapor Oluşturuldu!");
			}
		});
		buttonAnalizRaporu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		buttonAnalizRaporu.setBounds(15, 420, 168, 27);
		panel.add(buttonAnalizRaporu);
		
		
		
		
	}
}
