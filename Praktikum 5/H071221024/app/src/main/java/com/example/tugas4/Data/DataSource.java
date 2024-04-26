package com.example.tugas4.Data;

import com.example.tugas4.Model.Post;
import com.example.tugas4.Model.Profile;
import com.example.tugas4.R;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Post> posts = generateDummyPosts();
    public static ArrayList<Profile> profiles = generateDummyProfiles();

//    public static ArrayList<Profile> searchProfiles = generateDummyProfiles();

    private static ArrayList<Post> generateDummyPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.antony_post, "What an unforgettable day! Until the last minute...\n\nThat’s what it means to be a United!! Proud to help and I will never stop fighting and working hard! Let’s go, family!⚽", 1));
        posts.add(new Post(R.drawable.bruno_post, "What a special afternoon for all of us ✨", 2));
        posts.add(new Post(R.drawable.dalot_post, "Special moments at Old Trafford ❤", 3));
        posts.add(new Post(R.drawable.garnacho_post, "I love this football club.", 4));
        posts.add(new Post(R.drawable.hojlund_post, "Proud to win this special Award. I would like to say thanks, to all the people who voted for me, see you all very soon again!✊", 5));
        posts.add(new Post(R.drawable.maguire_post, "Proud to make 200 appearances for this amazing club. Huge honour every time I put on the shirt and wear the badge ❤ \n \nHappy Easter everyone. Have a great day!", 6));
        return posts;
    }
    public static ArrayList<Profile> generateDummyProfiles() {
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(1, R.drawable.antony_profile, "Antony Matheus dos Santos", "antony00"));
        profiles.add(new Profile(2, R.drawable.bruno_profile, "Bruno Fernandes", "brunofernandes08"));
        profiles.add(new Profile(3, R.drawable.dalot_profile, "Diogo Dalot", "diogodalot"));
        profiles.add(new Profile(4, R.drawable.garnacho_profile, "Alejandro Garnacho", "garnacho7"));
        profiles.add(new Profile(5, R.drawable.hojlund_profile, "Rasmus Hojlund", "rasmus.hojlund"));
        profiles.add(new Profile(6, R.drawable.maguire_profile, "Harry Maguire", "harrymaguire93"));
        profiles.add(new Profile(7, R.drawable.jiro, "Rasyad Bimasatya", "Rasyy15"));
        return profiles;
    }
}
