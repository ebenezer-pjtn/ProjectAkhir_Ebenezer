package com.example.projectakhir_ebenezer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.example.projectakhir_ebenezer.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    // Deklarasi variabel
    DbHelper dbHelper;
    private EditText inNama, inNIK;
    private Button btnSimpan, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout utama

        // Inisialisasi database helper
        dbHelper = new DbHelper(this);

        // Hubungkan variabel dengan komponen di layout XML
        inNIK = findViewById(R.id.inp_nik);
        inNama = findViewById(R.id.inp_nama);
        btnSimpan = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);

        // Tombol SIMPAN ditekan
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = inNIK.getText().toString().trim();
                String nama = inNama.getText().toString().trim();

                if (nik.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Error: NIK harus diisi!", Toast.LENGTH_SHORT).show();
                } else if (nama.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Error: Nama Lengkap harus diisi!", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper.addUserDetail(nik, nama);
                    inNIK.setText("");
                    inNama.setText("");
                    Toast.makeText(MainActivity.this, "Simpan berhasil!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Tombol DAFTAR MASYARAKAT ditekan
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.projectakhir_ebenezer.ListMasyarakatActivity.class);
                startActivity(intent);
            }
        });
    }
}
