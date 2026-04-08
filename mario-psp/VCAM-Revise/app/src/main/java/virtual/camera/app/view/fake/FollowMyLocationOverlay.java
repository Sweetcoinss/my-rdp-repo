package virtual.camera.app.view.fake;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;
import virtual.camera.app.R;

public class FollowMyLocationOverlay extends AppCompatActivity {
    
    private MapView mapView;
    private MyLocationNewOverlay locationOverlay;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osmdroid);
        
        mapView = findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        
        locationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(this), mapView);
        locationOverlay.enableMyLocation();
        locationOverlay.enableFollowLocation();
        
        mapView.getOverlays().add(locationOverlay);
        
        // التركيز على الموقع الحالي
        Location lastKnownLocation = locationOverlay.getMyLocation();
        if (lastKnownLocation != null) {
            mapView.getController().animateTo(lastKnownLocation);
            mapView.getController().setZoom(15);
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationOverlay != null) {
            locationOverlay.disableMyLocation();
            locationOverlay.disableFollowLocation();
        }
    }
}
