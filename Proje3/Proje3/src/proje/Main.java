package proje;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();		
        BagliListe linkedList = new BagliListe();
        Graph graph = new Graph();
        İlgiAlanıKullanıcı alan = new İlgiAlanıKullanıcı();
        alan.hazırİlgiAlanları();
        alan.hazırİlgiAlaniTespit();
        
        
        try {
        	
            List<Kullanıcı> kullanıcıList = mapper.readValue(new File("C:\\Code Java workspace\\Proje3\\twitter_data.json"), new TypeReference<List<Kullanıcı>>() {});
            
            for(Kullanıcı kullanıcı : kullanıcıList)
            {
                linkedList.add(kullanıcı);
            }
            
            for(Kullanıcı kullanıcı : kullanıcıList)
            {
                graph.addUser(kullanıcı);
            }
            
            for(Kullanıcı kullanıcı : kullanıcıList)
            {
                GraphNode followerNode = graph.getUserNode(kullanıcı.getUsername());
                for(String followingName : kullanıcı.getFollowing())
                {
                    GraphNode followingNode = graph.getUserNode(followingName);
                    if(followingNode != null)
                    {
                        followerNode.addFollowing(followingNode);
                        followingNode.addFollower(followerNode);
                    }
                }   
            }

            alan.kullanıcıİlgiAlanıTespit(linkedList);            
            
            EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Twitter frame = new Twitter(linkedList,alan,graph);
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
                                  
            
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
	}

}
