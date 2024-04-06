package com.example.instagramapp;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Account> accounts = generateDummyStudents();

    private static ArrayList<Account> generateDummyStudents() {
        ArrayList<Account> accounts= new ArrayList<>();
        accounts.add(new Account("FC Barcelona",
                R.drawable.barcelona_story,
                R.drawable.barcelona_post,
                "Una sola llengua: Futbol.",
                126, 91, R.drawable.barcelona_profile));
        accounts.add(new Account("Real Madrid",
                R.drawable.madrid_story,
                R.drawable.madrid_post,
                "Spot the wrong team! Acierta el equipo incorrecto!",
                154, 53, R.drawable.madrid_profile));
        accounts.add(new Account("Atletico Madrid",
                R.drawable.atletico_story,
                R.drawable.atletico_post,
                "Reinildo’s smile to charge your energies this Wednesday ",
                168, 61, R.drawable.atletico_profile));
        accounts.add(new Account("Bayern Munchen",
                R.drawable.bayern_story,
                R.drawable.bayern_post,
                "Today’s training session was open to our fans",
                417, 64, R.drawable.bayern_profile));
        accounts.add(new Account("Bayer Leverkusen",
                R.drawable.leverkusen_story,
                R.drawable.leverkusen_post,
                "Today’s training session was open to our fans",
                417, 64, R.drawable.leverkusen_profile));
        accounts.add(new Account("Borussia Dortmund",
                R.drawable.dortmund_story,
                R.drawable.dortmund_post,
                "Some call it iconic, we call it home \n" +
                        "\n" +
                        "Celebrate 50 years of BVB’s home stadium with the BVB Special Edition. Available on 5th April.",
                198, 98, R.drawable.dortmund_profile));
        accounts.add(new Account("Juventus",
                R.drawable.juventus_story,
                R.drawable.juventus_post,
                "Nothing changes until we do. Never again.\n" +
                        "Juventus against racism.",
                604, 74, R.drawable.juventus_profile));
        accounts.add(new Account("Inter Milan",
                R.drawable.inter_story,
                R.drawable.inter_post,
                "Raise your gloves if you kept a clean sheet ",
                114, 118, R.drawable.inter_profile));
        accounts.add(new Account("Manchester United",
                R.drawable.mu_story,
                R.drawable.mu_post,
                "Head to our Story now to register for pre-sale for Rosenberg v United this July",
                635, 146, R.drawable.mu_profile));
        accounts.add(new Account("Manchester United",
                R.drawable.city_story,
                R.drawable.city_post,
                "Midweek action at the Etihad!",
                635, 146, R.drawable.city_profile));
        return accounts;
    }
}
