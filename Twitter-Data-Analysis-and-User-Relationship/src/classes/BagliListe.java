package proje;

class Node {
	
    public Kullanıcı data;
    public Node next;

    public Node(Kullanıcı data)
    {   	
        this.data = data;
        this.next = null;
    }
}

public class BagliListe {
	
    public Node head;
    public int size;

    public BagliListe()
    {
        this.head = null;
        this.size = 0;
    }
    
    public void add(Kullanıcı data)
    {  	
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
        } 
        else 
        {
            Node iter = head;
            while(iter.next!=null)
            {
            	iter=iter.next;
            }
            iter.next=newNode;
        }
        size++;
    }
    
    public Kullanıcı kullanıcıGetir(String username)
    {       
    	Node iter=head;
    	
        while(iter!=null)
        {
            if (iter.data.getUsername().equals(username))
            {
                return iter.data;
            }
            iter=iter.next;
        }
        return null;
    }
    
}