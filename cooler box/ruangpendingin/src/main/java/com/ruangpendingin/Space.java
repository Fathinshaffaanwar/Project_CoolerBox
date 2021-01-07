package com.ruangpendingin;


// Class space digunakan untuk menyimpan Object bertipe yang mengimplementasikan Interface Benda
// Class Space memiliki ID dan benda variable, jika benda sama dengan null berarti space kosong,
// jika benda tidak sama dengan null berarti space terisi sebuah benda
public class Space {
    String id;
    // jika null maka spaces kosong
    Benda benda;

    public Space(String id){
        this.id = id;

    }

    public String getId() {
        return this.id;
    }


    public Benda getBenda() {
        return this.benda;
    }

    public void setBenda(Benda benda) {
        this.benda = benda;
    }
}
