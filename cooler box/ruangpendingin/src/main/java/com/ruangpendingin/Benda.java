package com.ruangpendingin;

// interface Benda yang akan diimplementasikan oleh class Makanan dan class Decorator, Plastik dan Kaleng
//Interface ini sangat penting dalam pengimplementasian Konsep Design Decorator Pattern 
public interface Benda {
    public String getId();

    public String getNama();

    public String getJenis();

    public long getExpired();
    public String printGetExpired();
}
