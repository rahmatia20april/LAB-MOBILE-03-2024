package com.example.praktikum5;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams =generateDummyInstagram();

    private static ArrayList<Instagram> generateDummyInstagram() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("UIjull", "Zoel Ramadhan", "Jangan Lupa Ketawa"
                ,R.drawable.profile_zul, R.drawable.post_fail));

        instagrams1.add(new Instagram("Dekuuu", "Midoriya Izuku", "Hari pertama sekolah"
                ,R.drawable.deku_profile, R.drawable.deku_post));

        instagrams1.add(new Instagram("Natsu123", "Natsu Dragon Igneel", "Latihan sama bapackk"
                ,R.drawable.natsu_profile, R.drawable.natsu_post));

        instagrams1.add(new Instagram("Rapinhass", "Rafael Rapinha", "Hattrick ga nih???"
                ,R.drawable.barcelona_profile, R.drawable.barcelona_post));

        return instagrams1;

    }

}