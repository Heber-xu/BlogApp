package org.zzrblog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.zzrblog.blogapp.R;
import org.zzrblog.blogapp.cube.CubeActivity;
import org.zzrblog.blogapp.hockey.HockeyActivity;
import org.zzrblog.blogapp.panorama.PanoramaActivity;
import org.zzrblog.camera.ContinuousRecordActivity;
import org.zzrblog.camera2.Camera2BasicActivity;
import org.zzrblog.ffmp.FFmpDecoderActivity;
import org.zzrblog.ffmp.NativeAVEncodeActivity;
import org.zzrblog.fmod.EffectActivity;
import org.zzrblog.fmod.FmodActivity;

import java.util.UUID;

public class MainActivity extends Activity {

    static {
        try {
            System.loadLibrary("native-lib");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public native void nativeThreadEnvTest();

    public static String getUuid() {
        // 提供给nativeThreadEnvTest使用
        return UUID.randomUUID().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PermissionUtils.requestMultiPermissions(this, mPermissionGrant);
    }

    public void clickOnPThreadEnvTest(@SuppressLint("USELESS") View view) {
        nativeThreadEnvTest();
    }

    public void clickOnHockey(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, HockeyActivity.class));
    }

    public void clickOnCube(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, CubeActivity.class));
    }

    public void clickOnPanorama(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, PanoramaActivity.class));
    }

    public void clickOnWatermarkRecord(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, ContinuousRecordActivity.class));
    }

    public void clickOnFmod(View view) {
        startActivity(new Intent(MainActivity.this, FmodActivity.class));
    }

    public void clickOnFmodEffect(View view) {
        startActivity(new Intent(MainActivity.this, EffectActivity.class));
    }

    public void clickOnFFmpDecoderTest(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, FFmpDecoderActivity.class));
    }

    public void clickOnFFmpEncoderTest(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, NativeAVEncodeActivity.class));
    }

    public void clickOnCamera2Basic(@SuppressLint("USELESS") View view) {
        startActivity(new Intent(MainActivity.this, Camera2BasicActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private PermissionUtils.PermissionGrant mPermissionGrant = new PermissionUtils.PermissionGrant() {

        @Override
        public void onPermissionGranted(int requestCode) {
            switch (requestCode) {
                case PermissionUtils.CODE_RECORD_AUDIO:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_RECORD_AUDIO", Toast
                            .LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_GET_ACCOUNTS:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_GET_ACCOUNTS", Toast
                            .LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_READ_PHONE_STATE:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_READ_PHONE_STATE", Toast
                            .LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_CALL_PHONE:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_CALL_PHONE", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case PermissionUtils.CODE_CAMERA:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_CAMERA", Toast.LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_ACCESS_FINE_LOCATION:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_ACCESS_FINE_LOCATION", Toast
                            .LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_ACCESS_COARSE_LOCATION:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_ACCESS_COARSE_LOCATION", Toast
                            .LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_READ_EXTERNAL_STORAGE:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_READ_EXTERNAL_STORAGE", Toast
                            .LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_WRITE_EXTERNAL_STORAGE:
                    Toast.makeText(MainActivity.this, "Result Permission Grant CODE_WRITE_EXTERNAL_STORAGE", Toast
                            .LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
}
