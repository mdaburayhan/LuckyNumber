package com.arsoft.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView luckyNumber;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        luckyNumber = findViewById(R.id.luckyNumberTxt);
        shareBtn = findViewById(R.id.shareBtn);

        // Receiving the data from Main Activity
        Intent intent = getIntent();
        String username = intent.getStringExtra("name");


        //Generating Random Numbers
        int randomNumber = generateRandomNumber();
        luckyNumber.setText(""+randomNumber);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username, randomNumber);
            }
        });



    }

    private void shareData(String username, int randomNumber) {
        // Implicit intent
         Intent i = new Intent(Intent.ACTION_SEND);
         i.setType("text/plain");

         // Additional info
         i.putExtra(Intent.EXTRA_SUBJECT,username+ " got lucky toaday.");
         i.putExtra(Intent.EXTRA_TEXT, username+"\'s lucky number is: "+randomNumber);

         startActivity(Intent.createChooser(i,"Choose a platform"));


    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

}