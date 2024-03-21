package com.example.tugas1; // Mendefinisikan package untuk kelas MainActivity dalam proyek ini.

import android.os.Bundle; // Mengimpor kelas Bundle dari paket android untuk pengelolaan data instance state.
import android.view.View; // Mengimpor kelas View dari paket android untuk tampilan UI.
import android.widget.EditText; // Mengimpor kelas EditText dari paket android untuk input teks.
import android.widget.TextView; // Mengimpor kelas TextView dari paket android untuk menampilkan teks.
import androidx.appcompat.app.AppCompatActivity; // Mengimpor kelas AppCompatActivity dari paket androidx.appcompat untuk aktivitas aplikasi.

import com.example.tugas1.R;

public class MainActivity extends AppCompatActivity { // Mendefinisikan kelas MainActivity yang merupakan turunan dari AppCompatActivity.

    EditText editTextName; // Mendeklarasikan variabel editTextName untuk EditText.
    TextView textViewDisplay; // Mendeklarasikan variabel textViewDisplay untuk TextView.

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Mendefinisikan metode onCreate() yang dipanggil saat aktivitas dibuat.
        super.onCreate(savedInstanceState); // Memanggil metode onCreate() dari kelas induk.
        setContentView(R.layout.activity_main); // Mengatur tata letak aktivitas dengan layout activity_main.
        editTextName = findViewById(R.id.editTextName); // Menginisialisasi editTextName dengan EditText dari layout.
        textViewDisplay = findViewById(R.id.textViewDisplay); // Menginisialisasi textViewDisplay dengan TextView dari layout.
    }

    public void onOkButtonClick(View view) { // Mendefinisikan metode onOkButtonClick() yang dipanggil saat tombol Ok diklik.
        String inputText = editTextName.getText().toString(); // Mengambil teks dari EditText dan menyimpannya dalam variabel inputText.
        textViewDisplay.append(inputText + "\n"); // Menambahkan teks inputText ke TextView textViewDisplay dengan newline (\n).
        editTextName.setText(""); // Mengosongkan EditText setelah teks ditambahkan ke TextView.
    }
}