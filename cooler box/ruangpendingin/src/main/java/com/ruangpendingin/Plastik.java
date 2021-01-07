package com.ruangpendingin;
import java.sql.Timestamp;


// Class Plastik bertindak sebagai Decorator untuk Class Makanan sama seperti class Kaleng
// Memiliki Kesamaan dengan class makanan karena sama-sama mengimplementasikan interface yang sam yaitu Interface Benda
public class Plastik implements Benda{

    Makanan makanan;
    public Plastik(Makanan makanan){
        this.makanan = makanan;
    }

    @Override
    public String getId() {
        return this.makanan.getId();
    }

    @Override
    public String getNama() {
        return this.makanan.getNama();
    }

    @Override
    public String getJenis() {
        return this.makanan.getJenis();
    }

    @Override
    public long getExpired() {
        // Plastik menambah masa expired sebuah barang sebanyak 60 detik atau 1 menit
        return this.makanan.getExpired()+ (60*1000);
    }

    public String printGetExpired(){

        long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        long difference = this.makanan.getExpired() + (60*1000) - nowTimeStamp;
        String printWaktu;
        if(difference < 0 ){
            printWaktu = "expired";
        }else{
            long detik = difference/1000;
            long menit = detik / 60;
            detik = detik % 60;

            printWaktu = menit+" menit, "+detik+" detik lagi";
        }
        return printWaktu;
    }
}