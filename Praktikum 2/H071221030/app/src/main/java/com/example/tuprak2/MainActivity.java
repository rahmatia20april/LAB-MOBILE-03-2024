    package com.example.tuprak2;

    import androidx.activity.result.ActivityResult;
    import androidx.activity.result.ActivityResultCallback;
    import androidx.activity.result.ActivityResultLauncher;
    import androidx.activity.result.contract.ActivityResultContract;
    import androidx.activity.result.contract.ActivityResultContracts;
    import androidx.appcompat.app.AppCompatActivity;

    import android.app.Activity;
    import android.content.Intent;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.media.Image;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageView;

    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.InputStream;

    public class MainActivity extends AppCompatActivity {
        private Uri selectedImageUri;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ImageView openGallery = findViewById(R.id.openGallery);

            ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent data = result.getData();
                                if (data != null) {
                                    selectedImageUri = data.getData();
                                    try {
                                        InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                        openGallery.setImageBitmap(bitmap);
                                        inputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
            );

            openGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    launcherIntentGallery.launch(Intent.createChooser(intent, "Choose a picture"));
                }
            });

            EditText inputName = findViewById(R.id.editName);
            EditText inputNickname = findViewById(R.id.editNickname);

            Button buttonNext = findViewById(R.id.nextScene);
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = inputName.getText().toString();
                    String nickname = inputNickname.getText().toString();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("IMAGE_URI", selectedImageUri);
                    intent.putExtra("NAME", name);
                    intent.putExtra("NICKNAME", nickname);

                    startActivity(intent);
                }
            });
        }
    }