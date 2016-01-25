package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Администратор on 14.01.2016.
 */

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>
{
    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    public AmigoSet()
    {
        map = new HashMap<>();
    }

    @Override
    public Object clone()
    {
        AmigoSet<E> amigoSet = new AmigoSet<>();

        try
        {
            amigoSet.addAll(this);
            amigoSet.map.putAll(this.map);
        }
        catch (Exception e)
        {
            throw new InternalError();
        }

        return amigoSet;
    }

    @Override
    public boolean add(E e)
    {
        return null == map.put(e, PRESENT);
    }

    @Override
    public boolean remove(Object o)
    {
        return map.keySet().remove(o);
    }

    @Override
    public void clear()
    {
        map.keySet().clear();
    }

    public AmigoSet(Collection<? extends E> collection)
    {
        map = new HashMap<>((int) Math.max(16, collection.size() / .75f));
        this.addAll(collection);
    }

    @Override
    public Iterator<E> iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size()
    {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty()
    {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.keySet().contains(o);
    }


    private void writeObject(ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();

        s.writeObject(map.size());
        for (E e : map.keySet())
        {
            s.writeObject(e);
        }
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
    {
        int size = (int) s.readObject();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++)
        {
            set.add((E) s.readObject());
        }
        int copacity = (int) s.readObject();
        float loadFactory = (float) s.readObject();
        map = new HashMap<>(copacity, loadFactory);
        for (E e : set)
        {
            map.put(e, PRESENT);
        }
        s.defaultReadObject();
    }
}
