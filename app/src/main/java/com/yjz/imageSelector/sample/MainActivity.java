package com.yjz.imageSelector.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yjz.imageSelector.ImageSelector;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ImageSelector.builder()
                        .setCrop(true)
                        .setSingleMode(true)
                        .start(MainActivity.this, 1);


            }
        });

        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageSelector.builder()
                        .setMaxCount(9)
                        .setSingleMode(false)
                        .setSelected(selected)
                        .start(MainActivity.this, 1);


            }
        });


    }

    private ArrayList<String> selected=new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null && requestCode == 1) {
                selected = data.getStringArrayListExtra(ImageSelector.EXTRA_RESULT);
                final String path = selected.get(0);
                Log.d("##########--->", "-----------------" + path);
                Toast.makeText(this, "path:" + selected.size(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


