package com.example.myapplication;

import java.util.ArrayList;

public class Source {
    public static ArrayList<Data>datas = generateDummyDatas();
    private static ArrayList<Data> generateDummyDatas() {
        ArrayList<Data> datas = new ArrayList<>();
        datas.add(new Data("Sung Jin Woo", "Jin Woo", "Protagonis utama cerita. Awalnya, ia adalah seorang Hunter kelas rendah yang dianggap lemah oleh orang lain. Namun, setelah kejadian misterius di dalam dungeon, ia mulai memperoleh kekuatan dan keterampilan baru, yang mengubah hidupnya secara drastis.", R.drawable.profile_image, null));
        datas.add(new Data("Chae Hae-In", "Hae In", "Seorang Hunter kelas tinggi yang memimpin tim Sung Jin-Woo dalam beberapa misi. Dia memiliki perasaan terhadap Jin-Woo yang berkembang seiring cerita berlangsung.", R.drawable.cha, null));
        datas.add(new Data("Baek Yoon-Ho", "Baek", "Baek Yoon-Ho adalah ketua Guild Hunter Korea yang kuat dan karismatik, memiliki kemampuan bertarung luar biasa dan kesetiaan yang dalam terhadap rekan-rekannya, termasuk Sung Jin-Woo.", R.drawable.baek, null));
        datas.add(new Data("Choi Jong-In", "Jong In", "Choi adalah salah satu Hunter terbaik Korea yang dikagumi oleh ribuan orang. Menjadi Guild Master of Hunters Guild, dia mendapatkan kepopularitasan untuk dirinya sendiri di berbagai media. Dia adalah orang yang sangat andal dan dapat melindungi anggota timnya pada saat dibutuhkan.", R.drawable.choi, null));
        datas.add(new Data("Go Gun-Hee", "Gun Hee", "Ketua Asosiasi Hunter Korea dan merupakan salah satu tokoh terkemuka dalam dunia Hunter. Dia menyadari potensi Sung Jin-Woo dan memperhatikan perjalanan kekuatannya.", R.drawable.gun, null));
        datas.add(new Data("Thomas Andre", "Thomas", "Thomas Andre dianggap sebagai pembangkit tenaga listrik Amerika dan Hunter Tingkat Nasional paling populer. Di dunia, dia dianggap sebagai Hunter paling kuat dan bahkan pemerintah pun takut jika sampai memprovokasinya. Dia selalu bangga pada apapun yang dilakukannya dan tidak suka berhutang budi pada orang lain.", R.drawable.thomas, null));
        datas.add(new Data("Goto Ryuji", "Ryuji", "Goto adalah Hunter nomor 1 Jepang terbaik dari Draw Sword Guild yang berpotensi menjadi Hunter Tingkat Nasional. Dari luar Dia adalah pria yang tampak lembut dengan rasa ketenangan yang tercermin dari kepribadiannya. Namun kenyataannya, dia selalu merasa lebih unggul dari Hunter lainnya dan tidak pernah peduli pada siapapun.", R.drawable.gutu, null));
        return datas;
    }
}
