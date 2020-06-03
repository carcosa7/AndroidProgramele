package com.heyletscode.ihavetofly;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.heyletscode.ihavetofly.GameView.screenRatioX;
import static com.heyletscode.ihavetofly.GameView.screenRatioY;

public class Rock {

    public int speed = 20;
    public boolean wasShot = true;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap rock1, rock2, rock3;

    Rock(Resources res) {

        rock1 = BitmapFactory.decodeResource(res, R.drawable.meteor1);
        rock2 = BitmapFactory.decodeResource(res, R.drawable.meteor2);
        rock3 = BitmapFactory.decodeResource(res, R.drawable.meteor3);

        width = rock1.getWidth();
        height = rock1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        rock1 = Bitmap.createScaledBitmap(rock1, width, height, false);
        rock2 = Bitmap.createScaledBitmap(rock2, width, height, false);
        rock3 = Bitmap.createScaledBitmap(rock3, width, height, false);
        //bird4 = Bitmap.createScaledBitmap(bird4, width, height, false);

        y = -height;
    }

    Bitmap getBird () {

        if (birdCounter == 1) {
            birdCounter++;
            return rock1;
        }

        if (birdCounter == 2) {
            birdCounter++;
            return rock2;
        }

        if (birdCounter == 3) {
            birdCounter++;
            return rock3;
        }

        birdCounter = 1;

        return rock3;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}
