package com.happy.jinbailiang.drawingbroad_jin;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.happy.jinbailiang.drawingbroad_jin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        com.suyati.telvin.drawingboard.DrawingBoard
        initView();
    }

    private void initView() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timg);
        binding.drawingBoard.setImageBitmap(bitmap);
        binding.green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawingBoard.setPenColor1(Color.GREEN);
            }
        });
        binding.yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawingBoard.setPenColor1(Color.YELLOW);
            }
        });
        binding.blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawingBoard.setPenColor1(Color.BLUE);
            }
        });
        binding.white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawingBoard.saveAsImageFile("abc", true);
            }
        });

        binding.move.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                binding.drawingBoard.setInterapt(!binding.drawingBoard.isInterapt());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (binding.drawingBoard.isInterapt()) {
                        binding.move.setBackground(getDrawable(R.mipmap.ic_launcher));
                    } else {
                        binding.move.setBackground(getDrawable(R.mipmap.move));
                    }
                }
            }
        });
    }
}
/**
 * Customize your DrawingBoard
 * <p>
 * To change the board color
 * <p>
 * drawingBoard.setCanvasColor(android.R.color.white);
 * To change the pen color
 * <p>
 * drawingBoard.setPenColor(R.color.colorPrimary);
 * To change the pen width
 * <p>
 * drawingBoard.setPenWidth(6f);
 * ##DrawingBoard Actions
 * <p>
 * To clear the drawing on the board
 * <p>
 * drawingBoard.clearBoard();
 * To save as image file
 * <p>
 * String baseFilePath = "ProjectName/Images"; // The folder name in which your file has to be saved.
 * String fileName = "darwboard1.png"; // Your filename
 * Boolean isShownInGallery = true; // Whether to be shown in Android default gallery.
 * <p>
 * drawingBoard.setBaseFilePath(baseFilePath);
 * drawingBoard.saveAsImageFile(fileName,isShownInGallery);
 * Note: Add WRITE_EXTERNAL_STORAGE permission in manifest file.
 * <p>
 * To get Bitmap of current drawing on the board
 * <p>
 * drawingBoard.getBitMapSignature();
 * #Authors and Contributors
 * <p>
 * DrawingBoard-Android is developed by Suyati Technologies. It is written and maintained by their Android Development team.
 * <p>
 * Author:
 * <p>
 * Telvin Philips Mathew (@telvinphilipsmathew)
 * #Support or Contact
 * <p>
 * Have Suggestions? Want to give us something to do? Contact us at : support@suyati.com
 */


