package com.ruangpendingin;

//Interface Iterator yang akan diimplementasikan oleh innner class di Class RakBah, RakSayur dan RakDaging
// Iterator juga di implementasikan oleh class RakIterator
// Keberadaan Interface Iterator ini sangat berperan penting pada penerapan Design Iterator Pattern 
public interface Iterator {

    public boolean hasNext();
    public Object next();
}
