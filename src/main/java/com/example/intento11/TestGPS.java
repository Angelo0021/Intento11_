package com.example.intento11;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class TestGPS extends AppCompatActivity {
    TextView tvLatitud;
    TextView tvLongitud;
    TextView tvDireccion;

    public TestGPS() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2131427356);
        this.tvLatitud = (TextView)this.findViewById(2131231167);
        this.tvLongitud = (TextView)this.findViewById(2131231168);
        this.tvDireccion = (TextView)this.findViewById(2131231166);
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1000);
        } else {
            this.locationStart();
        }

    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager)this.getSystemService("location");
        TestGPS.Localizacion Local = new MainActivity.Localizacion();
        Local.setTesGPS(this);
        boolean gpsEnabled = mlocManager.isProviderEnabled("gps");
        if (!gpsEnabled) {
            Intent intentgps = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            this.startActivity(intentgps);
        }

        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1000);
        } else {
            mlocManager.requestLocationUpdates("network", 0L, 0.0F, Local);
            mlocManager.requestLocationUpdates("gps", 0L, 0.0F, Local);
            this.tvLatitud.setText("Localización GPS");
            this.tvDireccion.setText("");
        }
    }

    public void setLocation(Location loc) {
        if (loc.getLatitude() != 0.0D && loc.getLongitude() != 0.0D) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = (Address)list.get(0);
                    this.tvDireccion.setText(DirCalle.getAddressLine(0));
                }
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

    }

    public class Localizacion implements LocationListener {
        TestGPS mainActivity;

        public Localizacion() {
        }

        public TestGPS getMainActivity() {
            return this.mainActivity;
        }

        public void setMainActivity(TestGPS mainActivity) {
            this.mainActivity = mainActivity;
        }

        public void onLocationChanged(Location loc) {
            loc.getLatitude();
            loc.getLongitude();
            TestGPS.this.tvLatitud.setText(String.valueOf(loc.getLatitude()));
            TestGPS.this.tvLongitud.setText(String.valueOf(loc.getLongitude()));
            this.mainActivity.setLocation(loc);
        }

        public void onProviderDisabled(String provider) {
            TestGPS.this.tvLatitud.setText("GPS Desactivado");
        }

        public void onProviderEnabled(String provider) {
            TestGPS.this.tvLatitud.setText("GPS Activado");
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch(status) {
                case 0:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case 1:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
                case 2:
                    Log.d("debug", "LocationProvider.AVAILABLE");
            }

        }
    }
}
