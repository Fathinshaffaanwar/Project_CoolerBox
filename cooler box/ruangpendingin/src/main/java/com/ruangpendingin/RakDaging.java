package com.ruangpendingin;
import java.util.List;



// Class Daging Menerapkan Design Pattern Iterator
// Class ini adalah class utuk menerapkan konsep rak pada ruangan pendingin
// Class yang hanya bisa menyimpan makanan bertipe Daging
// Rakbuah memiliki List Spaces, setiap rak memiliki bebrapa space untuk menyimpan makanan
public class RakDaging implements RakIterator {

    private String id;
    private String name;

    // berbeda dengan list spaces rak buah dan rak sayur, listspaces di rakdaging menggunakan array bukan class List
    // karena banyak spaces yg bisa ditampung oleh rakdaging tidak bisa diubah secara dinamis
    // jumlah spaces di rak daging selalu 10, dengan kapasitas masing-masing 5kg
    // list space pada rakDaging menggunakan Array, berbeda dengan rakbuah dan raksayur yg menggunakan Arraylist
    private Space spacesList[] = new Space[10];
    private int spaceCapacity;

    public RakDaging(String id, String name){
        this.id = id;
        this.name = name;
        this.spaceCapacity = spaceCapacity;
        for(int i=0; i < 10; i++){
            Space space = new Space(String.valueOf((i+1)) );
            spacesList[i] = space;
        }
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int spacesCount(){
        return spacesList.length;
    }



    public int availableSpace(){
        int count =0;
        for (int i=0; i < spacesList.length; i++ ){
            if(spacesList[0].getBenda() == null){

                count++;
            }
        }

        return count;
    }

    public int getSpaceCapacity() {
        return this.spaceCapacity;
    }

    public boolean store(Benda benda){
        for (int i=0; i < spacesList.length; i++ ){
            if(spacesList[0].getBenda() == null){
                spacesList[0].setBenda(benda);
                return true;
            }
        }
        return false;
    }

    public boolean out(String spaceId){
        for (int i=0; i < spacesList.length; i++ ){
            if(spacesList[0].getId().equals(spaceId)){
                spacesList[0].setBenda(null);
                return true;
            }
        }
        return false;
    }






    @Override
    public Iterator getSpaces() {
        return new SpacesIterator();
    }

    // inner class to implement iterator desing  pattern
    private class SpacesIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < spacesList.length ){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return spacesList[index++];
            }
            return null;
        }
    }
}
