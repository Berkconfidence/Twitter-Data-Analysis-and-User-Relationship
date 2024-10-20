package proje;

public class HashTablosu<K, V> {

    public static class Node<K, V>
    {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public Node<K, V>[] table;
    public int size;
    public int kapasite;
    public float loadFactor;

    public HashTablosu()
    {
    	this(16, 0.75f);
    }

    @SuppressWarnings("unchecked")
	public HashTablosu(int kapasite, float loadFactor)
    {  	
    	this.table = new Node[kapasite];
        this.kapasite = kapasite;
        this.loadFactor = loadFactor;
    }

    public void put(K key, V value)
    {
        kapasiteKontrol();

        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if(table[index] == null)
        {
            table[index] = newNode;
            size++;
        }
        else
        {
            Node<K, V> current = table[index];
            while(current.next != null)
            {
                if(current.key.equals(key))
                {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }
    
    private void kapasiteKontrol()
    {
        if((float) size / kapasite >= loadFactor)
        {
            kapasite *= 2;
            @SuppressWarnings("unchecked")
			Node<K, V>[] newtable = new Node[kapasite];

            for(Node<K, V> node : table)
            {
                while(node != null)
                {
                    int index = node.key.hashCode() % kapasite;
                    Node<K, V> next = node.next;
                    node.next = newtable[index];
                    newtable[index] = node;
                    node = next;
                }
            }
            table = newtable;
        }
    }

    
    public V get(K key)
    {
        int index = getIndex(key);
        Node<K, V> iter = table[index];

        while(iter!=null)
        {
            if(iter.key.equals(key))
            {
                return iter.value;
            }
            iter = iter.next;
        }

        return null;
    }

    public int getIndex(K key)
    {
        return key.hashCode() % table.length;
    }
    
}
