package com.ruangpendingin;
import java.util.ArrayList;
import java.util.List;


// Class Daging Menerapkan Design Pattern Iterator
// Class ini adalah class utuk menerapkan konsep rak pada ruangan pendingin
// Class yang hanya bisa menyimpan makanan bertipe Sayur
// Rakbuah memiliki List Spaces, setiap rak memiliki bebrapa space untuk menyimpan makanan
public class RakSayur implements RakIterator {

    private String id;
    private String name;
    
    //Rak buah menggunakan ArrayList untuk menyimpan  list space
    private List<Space> spaceList = new ArrayList<Space>();
    private int spaceCapacity;
    public RakSayur(String id, String name, int spaceCount, int spaceCapacity){
        this.id = id;
        this.name = name;
        this.spaceCapacity = spaceCapacity;

        for(int i=1; i <= spaceCount; i++){
            Space space = new Space(String.valueOf(i) );
            spaceList.add(space);
        }
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int spacesCount(){
        return spaceList.size();
    }

    public int availableSpace(){
        int count =0;
        for (Space space : spaceList ){
            if(space.getBenda() == null){
                count++;
            }
        }

        return count;
    }

    public int getSpaceCapacity() {
        return this.spaceCapacity;
    }

    public boolean store(Benda benda){
        for (Space space : spaceList ){
            if(space.getBenda() == null){
                space.setBenda(benda);
                return true;
            }
        }
        return false;
    }

    public boolean out(String spaceId){
        for (Space space : spaceList ){
            if(space.getId().equals(spaceId)){
                space.setBenda(null);
                return true;
            }
        }
        return false;
    }




    @Override
    public Iterator getSpaces() {
        return new SpacesIterator();
    }

    private class SpacesIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < spaceList.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return spaceList.get(index++);
            }
            return null;
        }
    }
}
