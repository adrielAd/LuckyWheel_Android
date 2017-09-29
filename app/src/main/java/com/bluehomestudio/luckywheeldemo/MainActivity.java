package com.bluehomestudio.luckywheeldemo;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<WheelItem> wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.LTGRAY, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.BLUE, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.BLACK, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.GRAY, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.RED, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.GREEN, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.WHITE, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.DKGRAY, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));
        wheelItems.add(new WheelItem(Color.CYAN, BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_action_name)));


        final LuckyWheel lw = (LuckyWheel) findViewById(R.id.lwv);
        lw.addWheelItems(wheelItems);

        lw.rotateWheelTo(number);

        final Button start = (Button) findViewById(R.id.start);

        lw.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                Toast.makeText(MainActivity.this, "Target Reached : " + number, Toast.LENGTH_LONG).show();
                start.setVisibility(View.VISIBLE);
            }
        });

        start.setVisibility(View.GONE);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                number = random.nextInt(9 - 1 + 1) + 1;
                lw.rotateWheelTo(number);
                start.setVisibility(View.GONE);
            }
        });

    }

}
