package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button btnTop;
    Button btnBottom;
    TextView textBox;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        textBox = (TextView) findViewById(R.id.storyTextView);
        btnTop = (Button) findViewById(R.id.buttonTop);
        btnBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("btnTopPressed", "Top button pressed!");
//                textBox.setText(R.string.T3_Story);
//                btnTop.setText(R.string.T3_Ans1);
//                btnBottom.setText(R.string.T3_Ans2);
//                Log.d("id", "The ID is " + R.string.T3_Ans1);
                updateStory(1);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("btnBottomPressed", "Bottom button pressed!");
//                textBox.setText(R.string.T2_Story);
//                btnTop.setText(R.string.T2_Ans1);
//                btnBottom.setText(R.string.T2_Ans2);
                updateStory(2);
            }
        });

    }

    public void updateStory(int theBtnPressed) {
        if(mStoryIndex == 1) {
            if(theBtnPressed == 1 || theBtnPressed == 0) {
                textBox.setText(R.string.T3_Story);
                btnTop.setText(R.string.T3_Ans1);
                btnBottom.setText(R.string.T3_Ans2);
                mStoryIndex = 3;
            }
            else {
                textBox.setText(R.string.T2_Story);
                btnTop.setText(R.string.T2_Ans1);
                btnBottom.setText(R.string.T2_Ans2);
                mStoryIndex = 2;
            }
        }
        else if(mStoryIndex == 2) {
            if(theBtnPressed == 1) {
                mStoryIndex = 1;
                updateStory(0);
            }
            else {
                textBox.setText(R.string.T4_End);
                btnTop.setVisibility(View.GONE);
                btnBottom.setVisibility(View.GONE);
            }
        }
        else {
            if(theBtnPressed == 1) {
                textBox.setText(R.string.T6_End);
                btnTop.setVisibility(View.GONE);
                btnBottom.setVisibility(View.GONE);
            }
            else {
                textBox.setText(R.string.T5_End);
                btnTop.setVisibility(View.GONE);
                btnBottom.setVisibility(View.GONE);
            }
        }
    }
}
