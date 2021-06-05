package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myapplication.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng a2 = new LatLng(22.903246709587776, 120.27372806503739);
        LatLng a1 = new LatLng(22.96029892980658, 120.26159641472572);
        LatLng a3 = new LatLng(22.935082794863213, 120.2245334517179);
        mMap.addMarker(new MarkerOptions().position(a2).title("長榮大學"));
        mMap.addMarker(new MarkerOptions()
                .position(a1)
                .title("測試")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon1))
                .alpha(0.3f));
        PolygonOptions polygonOptions=new PolygonOptions()
                .add(a1,a2,a3);
        Polygon p1 =mMap.addPolygon(polygonOptions);
        p1.setStrokeColor(Color.RED);
        p1.setFillColor(Color.BLUE);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(a1,13.0f));


    }
}