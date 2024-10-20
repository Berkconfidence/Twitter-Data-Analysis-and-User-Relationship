package proje;

import java.util.Arrays;
import java.util.Iterator;

public class Liste<T> implements Iterable<T>{
	
    public Object[] array;
    public int size = 0;

    public Liste()
    {
        array = new Object[10];
    }

    public void add(T element)
    {
        if(size==array.length)
        {
        	kapasiteArttır();
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    public int size()
    {
        return size;
    }

    public void kapasiteArttır()
    {
        int yeniKapasite = array.length * 2;
        array = Arrays.copyOf(array, yeniKapasite);
    }
    
    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            public int currentIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currentIndex < size;
            }

            @SuppressWarnings("unchecked")
			@Override
            public T next()
            {
                return (T) array[currentIndex++];
            }
        };
    }
    
    public boolean contains(T item)
    {
        for(int i = 0; i < size; i++)
        {
            if(array[i].equals(item))
            {
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder("[");
        for(int i=0; i<size; i++)
        {
            result.append(array[i]);
            if(i<size-1)
            {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

}
