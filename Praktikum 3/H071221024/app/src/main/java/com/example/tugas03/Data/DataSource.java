package com.example.tugas03.Data;

import java.util.ArrayList;
import com.example.tugas03.Model.Post;
import com.example.tugas03.Model.User;
import com.example.tugas03.Model.Story;
import com.example.tugas03.R;

public class DataSource {
    public static ArrayList<Post> posts = generateDummyPosts();
    public static ArrayList<Story> stories = generateDummyStories();
    public static ArrayList<User> users = generateDummyUser();

    private static ArrayList<Post> generateDummyPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(0, R.drawable.antony_post, "What an unforgettable day! Until the last minute...\n\nThat’s what it means to be a United!! Proud to help and I will never stop fighting and working hard! Let’s go, family!⚽", 0));
        posts.add(new Post(11, R.drawable.antony_post2, "Great win, important goal! ⚽🏴✅", 0));
        posts.add(new Post(12, R.drawable.antony_post3, "Great win ⚽🏴✅", 0));

        posts.add(new Post(1, R.drawable.bruno_post, "What a special afternoon for all of us ✨", 1));

        posts.add(new Post(2, R.drawable.dalot_post, "Special moments at Old Trafford ❤", 2));

        posts.add(new Post(3, R.drawable.garnacho_post, "I love this football club.", 3));

        posts.add(new Post(4, R.drawable.hojlund_post, "Proud to win this special Award. I would like to say thanks, to all the people who voted for me, see you all very soon again!✊", 4));

        posts.add(new Post(5, R.drawable.maguire_post, "Proud to make 200 appearances for this amazing club. Huge honour every time I put on the shirt and wear the badge ❤ \n\n Happy Easter everyone. Have a great day!", 5));

        posts.add(new Post(6, R.drawable.mount_post, "Mixed feelings, but I’m proud to celebrate my first goal for this club! We’ll continue to work on finishing the season on a high.\n\n Thank you for all the support.", 6));

        posts.add(new Post(7, R.drawable.mu_post, "Unrivalled commitment ❤", 7));

        posts.add(new Post(8, R.drawable.onana_post, "We’re Man United and we are never gonna stop.\n\n Next stop, Wembley.", 8));

        posts.add(new Post(9, R.drawable.rashford_post, "What a special moment walking out at Old Trafford with my niece & nephew 😘", 9));

        return posts;
    }

    private static ArrayList<Story> generateDummyStories() {
        ArrayList<Story> stories = new ArrayList<>();

        stories.add(new Story(0, R.drawable.antony_story, 0));

        stories.add(new Story(1, R.drawable.bruno_story, 1));

        stories.add(new Story(2, R.drawable.dalot_story, 2));

        stories.add(new Story(3, R.drawable.garnacho_story, 3));

        stories.add(new Story(4, R.drawable.hojlund_story, 4));

        stories.add(new Story(5, R.drawable.maguire_story, 5));

        stories.add(new Story(6, R.drawable.mount_story, 6));

        stories.add(new Story(7, R.drawable.mu_story, 7));

        stories.add(new Story(8, R.drawable.onana_story, 8));

        stories.add(new Story(9, R.drawable.rashford_story, 9));

        return stories;
    }

    private static ArrayList<User> generateDummyUser() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(0, R.drawable.antony_profile, "antony00", 234, 435));
        users.add(new User(1, R.drawable.bruno_profile, "brunofernandes08", 221, 423));
        users.add(new User(2, R.drawable.dalot_profile, "diogodalot", 211, 412));
        users.add(new User(3, R.drawable.garnacho_profile, "garnacho7", 222, 423));
        users.add(new User(4, R.drawable.hojlund_profile, "rasmus.hojlund", 245, 434));
        users.add(new User(5, R.drawable.maguire_profile, "harrymaguire93", 243, 454));
        users.add(new User(6, R.drawable.mount_profile, "masonmount", 264, 465));
        users.add(new User(7, R.drawable.mu_profile, "manchesterunited", 276, 426));
        users.add(new User(8, R.drawable.onana_profile, "andreonana.24", 255, 475));
        users.add(new User(9, R.drawable.rashford_profile, "marcusrashford", 287, 487));
        return users;
    }
}
