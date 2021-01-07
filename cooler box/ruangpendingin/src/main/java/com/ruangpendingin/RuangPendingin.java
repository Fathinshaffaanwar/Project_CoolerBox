package com.ruangpendingin;
import java.sql.Timestamp;
import java.util.Scanner;


/* Class RuangPendingin akan merepresentasikan sebuah ruangan pendingin 
    Yang lengkap dengan rak-rak penyimpanan yang ada didalamnya

    Class ini memiliki beberapa method yanng berurusan tentang pengecekan status rak dan space
    didalam program. Kemudian menampilkan/print keterangan di console. metod printMakananExpired()
    dan printMakanan() bertugas untuk hal itu

    Class ini juga memiliki method storeMakanan untuk memasukan makanan kedalam
    ruang pendingin dimana rak yg dipilih sesuai dengan jenis makanan

    Ada juga method takeMakanan untuk mengambil makanan dari rak

    

    

*/
public class RuangPendingin {

    RakSayur rakSayur = new RakSayur("rs01", "Rak Sayur", 15, 5);
    RakBuah rakBuah = new RakBuah("rb01", "Rak Buah", 20, 5);
    RakDaging rakDaging = new RakDaging("rd01", "Rak Daging");


    public void printMakananExpired(){

        boolean makananExpiredRakSayur = false;

        for(Iterator i = rakSayur.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
                long difference = space.getBenda().getExpired() - nowTimeStamp;
                if(difference <= 0){
                    makananExpiredRakSayur = true;
                }
            }

        }


        if(makananExpiredRakSayur) {

            System.out.println("Rak Sayuran " + rakSayur.getId());
            CommandLineTable st = new CommandLineTable();
            st.setShowVerticalLines(true);

            st.setHeaders("id Space", "Status", "makanan", "expired");

            for (Iterator i = rakSayur.getSpaces(); i.hasNext(); ) {
                Space space = (Space) i.next();
                String spaceId = space.getId();

                if (space.getBenda() != null) {
                    String makanan = space.getBenda().getNama();
                    String expired = space.getBenda().printGetExpired();
                    st.addRow(spaceId, "terisi", makanan, expired);
                }

            }
            st.print();

            System.out.println("\n");
        }

        boolean makananExpiredRakBuah = false;

        for(Iterator i = rakBuah.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
                long difference = space.getBenda().getExpired() - nowTimeStamp;
                if(difference <= 0){
                    makananExpiredRakBuah = true;
                }
            }

        }

        if(makananExpiredRakBuah){
            System.out.println("Rak Buah " + rakBuah.getId());
            CommandLineTable stb = new CommandLineTable();
            stb.setShowVerticalLines(true);

            stb.setHeaders("id Space", "Status", "makanan", "expired");

            for (Iterator i = rakBuah.getSpaces(); i.hasNext(); ) {
                Space space = (Space) i.next();
                String spaceId = space.getId();

                if (space.getBenda() != null) {
                    String makanan = space.getBenda().getNama();
                    String expired = space.getBenda().printGetExpired();
                    stb.addRow(spaceId, "terisi", makanan, expired);
                }

            }
            stb.print();

            System.out.println("\n");
        }

        boolean makananExpiredRakDaging = false;

        for(Iterator i = rakDaging.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                long nowTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
                long difference = space.getBenda().getExpired() - nowTimeStamp;
                if(difference <= 0){
                    makananExpiredRakDaging = true;
                }
            }

        }

        if(makananExpiredRakDaging){

        System.out.println("Rak Daging "+rakDaging.getId());
        CommandLineTable std = new CommandLineTable();
        std.setShowVerticalLines(true);

        std.setHeaders("id Space","Status",  "makanan", "expired");

        for(Iterator i = rakDaging.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                String makanan = space.getBenda().getNama();
                String expired = space.getBenda().printGetExpired();
                std.addRow(spaceId, "terisi", makanan, expired);
            }

        }
        std.print();
        }

        if(!makananExpiredRakSayur && !makananExpiredRakBuah && !makananExpiredRakDaging){
            System.out.println("Tidak Ada Notifikasi");
        }


    }


    public void printSemuaRak(){
        System.out.println("Rak Sayuran "+rakSayur.getId());
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);

        st.setHeaders("id Space","Status",  "makanan", "expired");

        for(Iterator i = rakSayur.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                String makanan = space.getBenda().getNama();
                String expired = space.getBenda().printGetExpired();
                st.addRow(spaceId, "terisi", makanan, expired);
            }else{
                st.addRow(spaceId, "kosong", "", "");
            }

        }
        st.print();

        System.out.println("\n");

        System.out.println("Rak Buah "+rakBuah.getId());
        CommandLineTable stb = new CommandLineTable();
        stb.setShowVerticalLines(true);

        stb.setHeaders("id Space","Status",  "makanan", "expired");

        for(Iterator i = rakBuah.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                String makanan = space.getBenda().getNama();
                String expired = space.getBenda().printGetExpired();
                stb.addRow(spaceId, "terisi", makanan, expired);
            }else{
                stb.addRow(spaceId, "kosong", "", "");
            }

        }
        stb.print();

        System.out.println("\n");

        System.out.println("Rak Daging "+rakDaging.getId());
        CommandLineTable std = new CommandLineTable();
        std.setShowVerticalLines(true);

        std.setHeaders("id Space","Status",  "makanan", "expired");

        for(Iterator i = rakDaging.getSpaces(); i.hasNext();){
            Space space = (Space) i.next();
            String spaceId = space.getId();

            if(space.getBenda() != null){
                String makanan = space.getBenda().getNama();
                String expired = space.getBenda().printGetExpired();
                std.addRow(spaceId, "terisi", makanan, expired);
            }else{
                std.addRow(spaceId, "kosong", "", "");
            }

        }
        std.print();
    }

    public void storeMakanan(Benda benda){

        if(benda.getJenis().equals("sayur")){
            if(rakSayur.availableSpace() < 1){
                System.out.println("Space Pada Rak Sayur Full, Tidak bisa menyimpan Lagi");

            }else{
                for (Iterator i = rakSayur.getSpaces(); i.hasNext(); ){
                    Space space = (Space) i.next();

                    if(space.getBenda() == null){
                        space.setBenda(benda);
                        System.out.println("Sayur dengan id " + benda.getId()+" berhasil disimpan di rak sayur pada Space id "+space.getId());
                        break;
                    }
                }
            }
        }
        else if(benda.getJenis().equals("buah")){
            if(rakBuah.availableSpace() < 1){
                System.out.println("Space Pada Rak Buah Full, Tidak bisa menyimpan Lagi");

            }else{
                for (Iterator i = rakBuah.getSpaces(); i.hasNext(); ){
                    Space space = (Space) i.next();

                    if(space.getBenda() == null){
                        space.setBenda(benda);
                        System.out.println("Buah dengan id " + benda.getId()+" berhasil disimpan di rak buah pada Space id "+space.getId());
                        break;
                    }
                }
            }
        }
        else if(benda.getJenis().equals("daging")){
            if(rakDaging.availableSpace() < 1){
                System.out.println("Space Pada Rak Daging Full, Tidak bisa menyimpan Lagi");

            }else{
                for (Iterator i = rakDaging.getSpaces(); i.hasNext(); ){
                    Space space = (Space) i.next();

                    if(space.getBenda() == null){
                        space.setBenda(benda);
                        System.out.println("Daging dengan id " + benda.getId()+" berhasil disimpan di rak daging pada Space id "+space.getId());
                        break;
                    }
                }
            }
        }
    }

    public Benda takeMakanan(String rak, String spaceId){
        Benda dariRuangPendining = null;

        if(rak.equals("sayur")){

            for (Iterator i= rakSayur.getSpaces(); i.hasNext();){
                Space space = (Space) i.next();

                if(spaceId.equals(space.getId())){
                    dariRuangPendining = space.getBenda() != null ? space.getBenda(): null;
                    if(space.getBenda() != null) space.setBenda(null);
                    break;
                }
            }

        }else if(rak.equals("buah")){
            for (Iterator i= rakBuah.getSpaces(); i.hasNext();){
                Space space = (Space) i.next();

                if(spaceId.equals(space.getId())){
                    dariRuangPendining = space.getBenda() != null ?  space.getBenda(): null;
                    if(space.getBenda() != null) space.setBenda(null);
                    break;
                }
            }

        }else if(rak.equals("daging")){
            for (Iterator i= rakDaging.getSpaces(); i.hasNext();){
                Space space = (Space) i.next();

                if(spaceId.equals(space.getId())){
                    dariRuangPendining = space.getBenda() != null ? space.getBenda(): null;
                    if(space.getBenda() != null) space.setBenda(null);
                    break;
                }
            }
        }


        return dariRuangPendining;
    }


}
