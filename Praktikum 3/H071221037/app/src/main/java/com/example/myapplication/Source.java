package com.example.myapplication;

import java.util.ArrayList;

public class Source {
    public static ArrayList<Data> datas = generateDummydatas();

    private static ArrayList<Data> generateDummydatas(){
        ArrayList<Data> datas = new ArrayList<>();
        datas.add(new Data("Nasi Katok", "Nasi Katok adalah makanan khas dari Brunei Darussalam1. Makanan ini terdiri dari nasi putih, sambal (bahan yang dibuat dari cabai yang dihaluskan dan bumbu lainnya), dan sepotong ayam goreng", 50, 20, R.drawable.brunei1, R.drawable.brunei2, R.drawable.brunei3));
        datas.add(new Data("Rendang", "Rendang adalah hidangan yang sangat populer dan dihargai di Indonesia, khususnya di Sumatera Barat, tempat asal makanan ini.", 210, 150, R.drawable.indonesia1, R.drawable.indonesia2, R.drawable.indonesia3));
        datas.add(new Data("Lok Lak", "Lok Lak adalah hidangan tumis khas Kamboja yang sangat populer dan lezat. Lok Lak terbuat dari daging sapi, ayam, atau udang sebagai bahan utama, meskipun daging sapi biasanya menjadi pilihan yang paling populer", 100, 30, R.drawable.kamboja1, R.drawable.kamboja2, R.drawable.kamboja3));
        datas.add(new Data("Larb", "Makanan ini menggunakan daging cincang sebagai bahan utamanya, yang kemudian diberi tambahan jeruk nipis, bumbu kaldu ikan yang difermentasi, beras tumbuh dan ragam rempah-rempah yang kemudian ditumis", 300, 200, R.drawable.laos1, R.drawable.laos2, R.drawable.laos3));
        datas.add(new Data("Nasi Lemak", "Makanan ini merupakan hidangan yang dimasak dengan santan yang dicampur bumbu pedas. Nasi lemak biasanya disuguhkan dengan beberapa jenis lauk seperti ayam goreng, sambel goreng teri atau sotong, telur rebus, tumis kangkung, dan lainnya", 120, 150, R.drawable.malaysia1, R.drawable.malaysia2, R.drawable.malaysia3));
        datas.add(new Data("Nga Htamin", "Makanan ini seperti nasi kuning di Indonesia baik dari tampilan maupun rasanya. Nasi dari Nga Htamin berwarna kuning karena dimasak menggunakan kunyit dan ditambahkan dengan rempah-rempah lainnya yang menghasilkan rasa yang khas. Biasanya Nga Htamin akan disajikan dengan ikan rebus, kentang rebus, pasta tomat, dan juga irisan bawang goreng", 20, 10, R.drawable.myanmar1, R.drawable.myanmar2, R.drawable.myanmar3));
        datas.add(new Data("Chicken Adobo", "Makanan ini adalah makanan khas Filipina yang paling populer. “Adobo” sendiri berasal dari bahasa Spanyol yang memiliki arti dimarinasi. Berbahan dasar ayam, kuliner tradisional Filipina ini diolah dengan dimarinasi campuran bumbu, saus kecap, dan bahan-bahan tradisional lainnya", 10, 5, R.drawable.filipina1, R.drawable.filipina2, R.drawable.filipina3));
        datas.add(new Data("Char Kway Teow", "salah satu hidangan mie yang paling populer dari jalanan Malaysia. Hidangan ini memiliki rasa yang kuat, tekstur yang kontras, dan aroma khas yang diasap, terdiri dari mie tebal yang digoreng dengan berbagai bahan seperti udang, tauge, kerang, dan sosis.", 200, 150, R.drawable.singapura1, R.drawable.singapura2, R.drawable.singapura3));
        datas.add(new Data("Tod Man Pla", "makanan khas Thailand yang biasanya terdiri dari daging ikan yang dihancurkan, pasta kari merah, daun jeruk kaffir, telur, buncis yang diiris tipis, dan tambahan lainnya seperti galangal atau serai. Secara tradisional, hidangan ini dibuat dengan ikan segar jenis clown featherback (pla grai)", 50, 40, R.drawable.thailand1, R.drawable.thailand2, R.drawable.thailand3));
        datas.add(new Data("Goi Cuon", "Makanan ini memiliki bentuk mirip seperti lumpia namun tidak perlu digoreng untuk proses memasaknya. Goi Cuon memiliki beraneka ragam isian, yakni irisan daging atau udang yang ditambah sayur-sayuran dan kemudian dibungkus atau dilapisi dengan kulit lumpia khas negara tersebut", 20, 10, R.drawable.vietnam1, R.drawable.vietnam2, R.drawable.vietnam3));
        return datas;
    }
}
