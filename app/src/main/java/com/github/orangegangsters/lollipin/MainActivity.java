package com.github.orangegangsters.lollipin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.orangegangsters.lollipin.lib.PinActivity;
import com.github.orangegangsters.lollipin.lib.managers.AppLock;

import lollipin.orangegangsters.github.com.lollipin.R;


public class MainActivity extends PinActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_ENABLE = 11;
    private static final int REQUEST_CODE_DISABLE = 12;
    private static final int REQUEST_CODE_UNLOCK_PIN_CANCELLABLE = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.button_enable_pin).setOnClickListener(this);
        this.findViewById(R.id.button_change_pin).setOnClickListener(this);
        this.findViewById(R.id.button_unlock_pin).setOnClickListener(this);
        this.findViewById(R.id.button_unlock_pin_cancellable).setOnClickListener(this);
        this.findViewById(R.id.button_disable_pin).setOnClickListener(this);
        this.findViewById(R.id.button_not_locked).setOnClickListener(this);
        this.findViewById(R.id.button_locked).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CustomPinActivity.class);
        switch (v.getId()) {
            case R.id.button_enable_pin:
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
                startActivityForResult(intent, REQUEST_CODE_ENABLE);
                break;
            case R.id.button_change_pin:
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.CHANGE_PIN);
                startActivity(intent);
                break;
            case R.id.button_unlock_pin:
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.UNLOCK_PIN);
                startActivity(intent);
                break;
            case R.id.button_unlock_pin_cancellable:
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.UNLOCK_PIN_CANCELLABLE);
                startActivityForResult(intent, REQUEST_CODE_UNLOCK_PIN_CANCELLABLE);
                break;
            case R.id.button_disable_pin:
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.DISABLE_PINLOCK);
                startActivityForResult(intent, REQUEST_CODE_DISABLE);
                break;
            case R.id.button_not_locked:
                Intent intent2 = new Intent(MainActivity.this, NotLockedActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_locked:
                Intent intent3 = new Intent(MainActivity.this, LockedActivity.class);
                startActivity(intent3);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_ENABLE:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "PinCode enabled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PinCode enable action cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_DISABLE:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "PinCode disabled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PinCode disable action cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_UNLOCK_PIN_CANCELLABLE:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "PinCode cancellable unlocked action is success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PinCode cancellable unlocked action cancelled", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
