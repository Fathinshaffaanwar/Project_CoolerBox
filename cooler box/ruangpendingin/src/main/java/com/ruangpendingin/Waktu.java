package com.ruangpendingin;
import java.sql.Timestamp;



/* Class waktu menerapkan Design Pattern Singleton
    Dimana artinya saat program berjalan hanya akan ada satu instance dari class Waktu ini.
    Class waktu memiliki private constructor yg artinya hanya bisa dibuatkan object dari dalam class
    Kode dari luar class tidak bisa membuat object Waktu secara langsung, kode luar harus memanggil
    method static milik class waktu yaitu getInstance() untuk mendapatkan instance/object dari class waktu
    yang tentunya sama untuk semua kode yg memanggilnya
*/
public class Waktu {
    private static Waktu waktuInstance;

    // menyimpan waktu timestamp, pertama kali program dijalankan
    private long firstTimeStamp;
    private Waktu(){
        this.firstTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public long howLongProgramRunning(){
        long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        return nowTimeStamp - firstTimeStamp;
    }

    public String printProgramTime(){
        long menit =0;
        long detik = 0;
        long howlong = howLongProgramRunning();
        detik = howlong/1000;

        menit = detik / 60;
        detik = detik % 60;

        String printWaktu = menit+" menit, "+detik+" detik";

        return printWaktu;
    }


    public static Waktu getInstance(){
        if(waktuInstance == null){
            waktuInstance = new Waktu();
        }

        return waktuInstance;
    }
}
