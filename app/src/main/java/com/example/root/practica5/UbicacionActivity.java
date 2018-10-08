package com.example.root.practica5;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UbicacionActivity extends Activity implements OnMapReadyCallback{
    MapView mapView;
    GoogleMap mMap;
    private int lug;
    private TextView tdetalles;
    private Button bvolver;
    private String [] ubicaciones={"CC Premium Plaza","CC San Diego","CC Santa Fe","CC Bosque Plaza","CC Los molinos"};
    private String [] direcciones={"Cra. 43A #30-25","Cl. 34 #43-66","Av. El Poblado #7","Cra. 52a #6586","Calle 30A ##82a-26"};
    private String [] horarios={"11:30-22:00","11:00-22:00","10:00-23:00","9:30–21:00","10:00-21:00"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        mapView=findViewById(R.id.mapu);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        bvolver=findViewById(R.id.bvolver);
        tdetalles=findViewById(R.id.tdetalles);

        Bundle args;
        args = getIntent().getExtras();
        if (args != null) {
            lug = args.getInt("lugar");
            tdetalles.setText("Mis Carnes Parrilla "+ubicaciones[lug]+"\n"+"Dirección: "+direcciones[lug]+"\n"+
            "Horario: "+horarios[lug]);

        }
        bvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        double locations[][] = {
                {6.2293845, -75.5726474},
                {6.221992,-75.5726052},
                {6.1958631,-75.57383},
                {6.2679431,-75.566913},
                {6.2339551,-75.601443}
        };
        LatLng misca = new LatLng(locations[lug][0], locations[lug][1]);
        mMap.addMarker(new MarkerOptions()
                .position(misca)
                .title(ubicaciones[lug])
                .snippet(direcciones[lug]+", Horario: "+horarios[lug])
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(misca, 15));

    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
