package de.androidcrypto.blecheckbluetooth5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    SwitchMaterial bluetoothEnabled, supportLe2MPhy, supportLeCodedPhy, supportLeExtendedAdvertising, supportLePeriodicAdvertising;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothEnabled = findViewById(R.id.swMainBleEnabled);
        supportLe2MPhy = findViewById(R.id.swMainBleSupportLe2MPhy);
        supportLeCodedPhy = findViewById(R.id.swMainBleSupportLeCodedPhy);
        supportLeExtendedAdvertising = findViewById(R.id.swMainBleSupportLeExtendedAdvertising);
        supportLePeriodicAdvertising = findViewById(R.id.swMainBleSupportLePeriodicAdvertising);

        if (isBluetoothEnabled()) {
            bluetoothEnabled.setChecked(true);

            if (bluetoothAdapter.isLe2MPhySupported()) supportLe2MPhy.setChecked(true);
            if (bluetoothAdapter.isLeCodedPhySupported()) supportLeCodedPhy.setChecked(true);
            if (bluetoothAdapter.isLeExtendedAdvertisingSupported())
                supportLeExtendedAdvertising.setChecked(true);
            if (bluetoothAdapter.isLePeriodicAdvertisingSupported())
                supportLePeriodicAdvertising.setChecked(true);
        }
    }

    private boolean isBluetoothEnabled() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) return false;
        return bluetoothAdapter.isEnabled();
    }
}