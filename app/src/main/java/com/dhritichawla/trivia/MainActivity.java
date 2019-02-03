package com.dhritichawla.trivia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void animate(View view){
//        ImageView image = (ImageView) findViewById(R.id.iv_card);
//        Animation hyperspaceJump = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
//        image.startAnimation(hyperspaceJump);
//
//    }
}
