package com.example.pertemuan5;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams =generateDummyInstagram();

    private static ArrayList<Instagram> generateDummyInstagram() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Tia", "Rahmatia", "Woman"
                ,R.drawable.satu, R.drawable.satu));

        instagrams1.add(new Instagram("TiaM", "Tia Ihza Mahendra", "Profesor"
                ,R.drawable.dua, R.drawable.dua));

        instagrams1.add(new Instagram("TiaG", "Tia Gerung", "Pengamat Politik"
                ,R.drawable.tiga, R.drawable.tiga));

        instagrams1.add(new Instagram("TiaS", "Tia Subianto", "Army"
                ,R.drawable.empat, R.drawable.empat));

        return instagrams1;

    }

}
