package com.art.merumuseum.modules.VrModule;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.art.merumuseum1.R;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class VrActivity extends AppCompatActivity {

    private VrPanoramaView vr_pan_view;
    private final String TAG = "VrPanoramaView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vr_activity_main);
        String price1 = getIntent().getStringExtra("price");
        String desc1 = getIntent().getStringExtra("desc");
        final String name1 = getIntent().getStringExtra("name");
        String image1 = getIntent().getStringExtra("image");
        Toast.makeText(this, image1, Toast.LENGTH_SHORT).show();





        vr_pan_view = (VrPanoramaView) findViewById(R.id.vr_pan_view);


        new LoadImage().execute(image1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vr_pan_view.pauseRendering();
        vr_pan_view.shutdown();
    }


    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(strings[0]).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            VrPanoramaView.Options options = new VrPanoramaView.Options();
            options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
            vr_pan_view.setEventListener(new VrPanoramaEventListener() {

                @Override
                public void onDisplayModeChanged(int newDisplayMode) {
                    super.onDisplayModeChanged(newDisplayMode);
                    Log.d(TAG, "onDisplayModeChanged()->newDisplayMode=" + newDisplayMode);
                }

                @Override
                public void onLoadError(String errorMessage) {
                    super.onLoadError(errorMessage);
                    Log.d(TAG, "onLoadError()->errorMessage=" + errorMessage);
                }

                @Override
                public void onLoadSuccess() {
                    super.onLoadSuccess();
                    Log.d(TAG, "onLoadSuccess->??????");
                }
                @Override
                public void onClick() {
                    super.onClick();
                    Log.d(TAG, "onClick()");
                }
            });
            vr_pan_view.loadImageFromBitmap(bitmap, options);
        }
    }
}
