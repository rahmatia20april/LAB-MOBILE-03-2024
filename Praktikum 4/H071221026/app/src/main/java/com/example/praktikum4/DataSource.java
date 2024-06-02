package com.example.praktikum4;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Postingan> postingans = generateDummyPostingans();

    private static  ArrayList<Postingan> generateDummyPostingans(){
        ArrayList<Postingan> postingans1 = new ArrayList<>();
        postingans1.add(new Postingan("Naruto Shipudden", "Uzumaki Naruto",
                "Party after winning battle against pain",
                R.drawable.naruto_profile, R.drawable.naruto_post));
        postingans1.add(new Postingan("Bleach", "Ichigo Kurosaki",
                "Preperation for biggest battle in this century",
                R.drawable.ichigo_profile, R.drawable.ichigo_post));
        postingans1.add(new Postingan("Black Clover", "Asta",
                "With my best friends and also my best rival",
                R.drawable.asta_profile, R.drawable.asta_post));
        postingans1.add(new Postingan("Fairy Tail", "Natsu Dragnell",
                "Playing in the forest with my father",
                R.drawable.natsu_profile, R.drawable.natsu_post));
        postingans1.add(new Postingan("Dragon Ball", "Son Go Ku",
                "it's time to end the battle with you FRIEZZAAAA!!!!!!",
                R.drawable.goku_profile, R.drawable.goku_post));
        postingans1.add(new Postingan("Boku no Hero Academia", "Midoriya Izuku",
                "a little bit nervous bcs this is my first final exam in high school",
                R.drawable.deku_profile, R.drawable.deku_post));
        postingans1.add(new Postingan("One Piece", "Monkey D. Luffy",
                "I WANNAAA EATT YOUUUU KATAKURIIIII, I'M HUNGRYYY",
                R.drawable.luffy_profile, R.drawable.luffy_post));

        return postingans1;
    }
}
