package com.ruangpendingin;

import java.util.ArrayList;
import java.util.Scanner;


// Class App sebagai tempat method Main untuk menjalankan program
public class App {

    // Membuat Object dari class Ruang Pendingin
    static RuangPendingin ruangPendingin = new RuangPendingin();

    // untuk menentukan id makanan yang dimasukan ke ruang pendingin
    // setiap menambah makanan  ke ruuang pendingin maka variable ini akan bertambah
    static int makananIdCount = 0;

    //method static dimana method pertama yang dipanggil oleh java runtime
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String inputMenu;

        while(true){
            printMenu();
            System.out.print("Input Pilihan : ");
            inputMenu = scanner.nextLine();
            switch (inputMenu){
                case "1": menu1();
                          break;
                case "2": menu2();
                          break;
                case "3": menu3();
                    break;
                case "4": menu4();
                    break;
                case "5": menu5();
                    break;
                case "6": menu6();
                    break;
                case "7": System.out.println("Berhasil Keluar Dari Program :)");
                        break;
                default: System.out.println("Input Salah!");
                        scanner.next();
            }

            if (inputMenu.equals("7")) break;
        }


    }

    // mengosongkan Console terminal dari karakter
    static void clearConsole(){
        try {
            Runtime.getRuntime().exec("cls");
        }catch (final Exception e){
            //
        }
    }

    static void printMenu(){
        clearConsole();
        System.out.println("\n\nProgram Pengelolaan Ruang Pendingin");
        System.out.println("Program Sudah Berjalan Selama : "+ Waktu.getInstance().printProgramTime() );

        System.out.println("");
        System.out.println("Menu Pilihan");
        System.out.println("1. Lihat Ruang Pendingin");
        System.out.println("2. Masukan Makanan ke Ruang Pendingin");
        System.out.println("3. Keluarkan Makanan dari Ruang Pendingin");
        System.out.println("4. Notifikasi Pemberitahuan");
        System.out.println("5. Refresh Waktu");
        System.out.println("6. Informasi Tentang Program");
        System.out.println("7. Keluar Dari Program");

    }

    static void menu1(){
        clearConsole();
        System.out.println("Menu Lihat Ruangan Pendingin");
        System.out.println("----------------------------");
        ruangPendingin.printSemuaRak();
        System.out.print("\nPress Enter to back to Menu . . .");
        new Scanner(System.in).nextLine();

    }

    static void menu2(){
        clearConsole();
        System.out.println("Menu Memasukan Barang ke Ruangan Pendingan");
        System.out.println("----------------------------");

        Scanner scanner = new Scanner(System.in);
        Benda makanananDisimpan;
        String nama;
        String jenis;
        String berat;
        String idMakanan;
        System.out.println("Input Data Makanan");
        System.out.print("Input Nama : ");
        nama = scanner.nextLine();

        while (true){
            System.out.print("Input Jenis :");
            jenis = scanner.nextLine();
            jenis = jenis.toLowerCase();

            if(jenis.equals("sayur")){
                break;
            }else if(jenis.equals("buah")){
                break;
            }else if(jenis.equals("daging")){
                break;
            }else{
                System.out.println("Input Salah! Jenis makanan Harus (sayur, buah atau daging)");
            }
        }

        System.out.print("Input Berat : ");
        berat = scanner.nextLine();

        idMakanan = "mk00"+(++makananIdCount);
        Makanan makanan = new Makanan(idMakanan, nama, jenis);

        String inputYN;
        System.out.print("Apakah Anda ingin menambahkan pembungkus ? (y/t) : ");
        inputYN = scanner.nextLine();
        inputYN  = inputYN.toLowerCase();

        if(inputYN.equals("y")){
            CommandLineTable st = new CommandLineTable();
            st.setShowVerticalLines(true);
            st.setHeaders("no","Pembungkus","tambah masa expired");
            st.addRow("1","Plastik", "1 menit");
            st.addRow("2","Kaleng", "3 menit");
            st.print();

            String nomorPembungkus;

            while (true){
                System.out.print("Input No Pembungkus :");
                nomorPembungkus = scanner.nextLine();

                if(nomorPembungkus.equals("1")){
                    makanananDisimpan = new Plastik(makanan);
                    System.out.println(jenis+ " Sudah berhasil di bungkus dengan Plastik");
                    break;
                } else if(nomorPembungkus.equals("2")){
                    makanananDisimpan = new Kaleng(makanan);
                    System.out.println(jenis+ " Sudah berhasil di bungkus dengan Kaleng");
                    break;
                }else{
                    System.out.println("Input Salah!");
                }
            }


        }else {
            makanananDisimpan = makanan;
        }

        ruangPendingin.storeMakanan(makanananDisimpan);
        System.out.print("\nPress Enter to back to Menu . . .");
        scanner.nextLine();
    }

    static void menu3(){
        clearConsole();
        System.out.println("Menu Mengeluarkan Barang dari Ruangan Pendingin");
        System.out.println("-----------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        String inputYN;
        System.out.print("Apakah Anda ingin Melihat Kondisi Ruang Pendingin ? (y/n) : ");
        inputYN = scanner.nextLine();

        if(inputYN.toLowerCase().equals("y")){
            ruangPendingin.printSemuaRak();
        }
        String rak;

        while (true){
            System.out.print("Input Jenis :");
            rak = scanner.nextLine();
            rak = rak.toLowerCase();

            if(rak.equals("sayur")){
                break;
            }else if(rak.equals("buah")){
                break;
            }else if(rak.equals("daging")){
                break;
            }else{
                System.out.println("Input Salah! Rak makanan Harus (sayur, buah atau daging)");
            }
        }

        String spaceId;

        System.out.print("Masukan Id Space penyimpanan : ");
        spaceId = scanner.nextLine();

        Benda makananDingin = ruangPendingin.takeMakanan(rak, spaceId);

        if(makananDingin == null){
            System.out.println("ID Space Penyimpanan Salah atau Space Penyimpanan Kosong");
        }else {
            System.out.print(rak+" dengan id "+makananDingin.getId()+" berhasil dikeluarkan dari ruangan pendingin");
            System.out.println(" rak "+rak+" dengan ID Space penyimpanan : "+spaceId);
        }


        System.out.print("\nPress Enter to back to Menu . . .");
        scanner.nextLine();


    }

    static void menu4(){
        clearConsole();
        System.out.println("Notifikasi Makanan yang sudah Expired/Busuk di Ruangan Pendingin");
        System.out.println("----------------------------");
        ruangPendingin.printMakananExpired();
        System.out.print("\nPress Enter to back to Menu . . .");
        new Scanner(System.in).nextLine();
    }

    static void menu5(){
        clearConsole();
    }

    static void menu6(){
        clearConsole();
        System.out.println("Karena Untuk Mengetes Semua Fungsi Program Tentu Waktu 7 Hari");
        System.out.println("adalah waktu yang lama. Dengan itu program ini mendefinisikan ");
        System.out.println("waktunya sendiri, program menggunakan basis menit untuk menentukan expired dari");
        System.out.println("Dari sebuah makanan.");

        System.out.println("\nMakanan Berjenis sayuran akan expired dalam waktu 3 menit");
        System.out.println("Makanan Berjenis buah akan expired dalam waktu 4 menit");
        System.out.println("Makanan Berjenis daging akan expired dalam waktu 2,5 menit");

        System.out.println("\n Ada juga sistem Pembungkusan yg Menangplikasikan Decorator Design");
        System.out.println("Jika makanan dibungkus dengan plastik maka masa expirednya akan ditambah 1 menit");
        System.out.println("Jika makanan dibungkus dengan kaleng maka masa expirednya akan ditambah 3 menit");
        System.out.print("\nPress Enter to back to Menu . . .");
        new Scanner(System.in).nextLine();
    }

}
