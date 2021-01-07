package com.ruangpendingin;
import java.sql.Timestamp;



// Class Makanan adalah class yang menyimpan data Makanan apa saja yang dimasukan ke lemari pendingin
// Class makanan bisa didecor tanpa merubah code class, dengan menerapka konsep Decorator Design Pattern
public class Makanan implements Benda{


    private String id;
    private String nama;
    private String jenis;
    // terhitung menyimpan lama expired, dalam detik
    private long expired;


    public Makanan(String id, String nama, String jenis){
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;

        // Pemanggilan Library Timestamp untuk menentukan waktu kapan makanan dimasukan ke lemari pendingin
        // dan menghitung masa expirednya
        long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();

        if(jenis.equals("sayur")) expired = nowTimeStamp + (180*1000);
        else if(jenis.equals("buah")) expired = nowTimeStamp + (240*1000);
        else if(jenis.equals("daging")) expired = nowTimeStamp + (150*1000);
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }


    public String getJenis() {
        return jenis;
    }

    @Override
    public long getExpired() {
        return this.expired;
    }

    public String printGetExpired(){
        long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        long difference = expired - nowTimeStamp;
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
