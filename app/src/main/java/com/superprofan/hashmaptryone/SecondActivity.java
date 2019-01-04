package com.superprofan.hashmaptryone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private TextSwitcher mSwitcher;
    private int mCounter = 0;
    ArrayList <String> cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       // Intent i = getIntent();
         cards = (ArrayList <String>)getIntent().getSerializableExtra("card-list");

        mSwitcher = findViewById(R.id.switcher);
        mSwitcher.setFactory(mFactory);
        mSwitcher.setText(String.valueOf(cards.get(mCounter)));


        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);

        Button nextButton = findViewById(R.id.buttonnext);
        Button previousButton = findViewById(R.id.buttonprevious);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCounter < cards.size()-1){
                    mCounter++;
                }else{
                    mCounter = 0;
                }
                mSwitcher.setText(String.valueOf(cards.get(mCounter)));
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCounter>0)
                    mCounter--;
                else
                    mCounter = cards.size()-1;
            mSwitcher.setText(String.valueOf(cards.get(mCounter)));
            }
        });

    }
    // BEGIN_INCLUDE(factory)
    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory(){
        @Override
        public View makeView() {
            // Create a new TextView
            TextView t = new TextView(SecondActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(SecondActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
    // END_INCLUDE(factory)
}
