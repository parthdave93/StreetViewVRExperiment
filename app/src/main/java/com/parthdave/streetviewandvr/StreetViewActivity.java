package com.parthdave.streetviewandvr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.StreetViewPanoramaView;
import com.google.android.gms.maps.model.LatLng;

public class StreetViewActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {
    
    StreetViewPanoramaFragment streetViewPanoramaFragment;
    StreetViewPanoramaView mStreetViewPanoramaView;
            
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        
        streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
        
    }
    
    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        LatLng SAN_FRAN = new LatLng(-33.87365, 151.20689);
        streetViewPanorama.setPosition(SAN_FRAN);
        mStreetViewPanoramaView = new StreetViewPanoramaView(this, new StreetViewPanoramaOptions().position(SAN_FRAN));
        
    }
}
