package com.example.root.practica5;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends Fragment implements OnMapReadyCallback{

    MapView mapView;
    GoogleMap mMap;
    private String [] ubicacionest={"CC Premium Plaza","CC San Diego","CC Santa Fe",
            "CC Bosque Plaza","CC Los molinos","CC:Florida", "Parque Berrio","CC El Tesoro",
            "CC Mayorca","Exito Laureles"};
    private double locations[][] = {
            {6.2293845, -75.5726474},
            {6.221992,-75.5726052},
            {6.1958631,-75.57383},
            {6.2679431,-75.566913},
            {6.2339551,-75.601443},
            {6.2639378, -75.5771802},
            {6.2533262,-75.5713115},
            {6.1986368,-75.5614075},
            {6.1757878,-75.5881409},
            {6.2455476,-75.6029736}
    };

    public MapaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);

        mapView=view.findViewById(R.id.mapu);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        return view;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

        LatLng misca = new LatLng(locations[0][0], locations[0][1]);
        for (int i=0;i<(ubicacionest).length;i++) {

            LatLng miscaf = new LatLng(locations[i][0], locations[i][1]);
            mMap.addMarker(new MarkerOptions()
                    .position(miscaf)
                    .title(ubicacionest[i])
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.food)));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(misca, 13));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
