package ipleiria.taes.fastugadriver.fragments;

import static android.os.Build.VERSION_CODES.M;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.bonuspack.routing.RoadNode;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapListener;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.events.ZoomEvent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

import ipleiria.taes.fastugadriver.BuildConfig;
import ipleiria.taes.fastugadriver.R;

public class MapFragment extends Fragment implements LocationListener  {

    View view;
    MapView map;

    private LocationManager locationManager;

    private static final int PERMISSAO_REQUERIDA = 1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_map, container, false);
        view.setVisibility(View.VISIBLE);
        map = view.findViewById(R.id.mapView);

        // Values received from AvailableOrdersFragment
        Bundle bundle = getArguments();
        assert bundle != null;

//        Set Coordinates
        double restaurantLatitude = bundle.getDouble("restaurantLatitude");
        double restaurantLongitude = bundle.getDouble("restaurantLongitude");
        double clientLatitude = bundle.getDouble("clientLatitude");
        double clientLongitude = bundle.getDouble("clientLongitude");

        assert getContext()!=null;

        if (Build.VERSION.SDK_INT >= M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                String[] permissoes = {Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(permissoes, PERMISSAO_REQUERIDA);
            }
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Configuration.getInstance().setUserAgentValue("MyOwnUserAgent/1.0");

        map.setMultiTouchControls(true);

        locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);

        RoadManager roadManager = new OSRMRoadManager(getContext(), Configuration.getInstance().getUserAgentValue());

        ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();

//        Set startPoint and startMarker
        GeoPoint startPoint = new GeoPoint(restaurantLatitude, restaurantLongitude);

        IMapController mapController = map.getController();
        mapController.setZoom(15);
        mapController.setCenter(startPoint);

        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("Start point");

        map.getOverlays().add(startMarker);

        waypoints.add(startPoint);

//        Set endPoint and endMarker
        GeoPoint endPoint = new GeoPoint(clientLatitude, clientLongitude);

        Marker endMarker = new Marker(map);
        endMarker.setPosition(endPoint);
        endMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        endMarker.setTitle("End point");

        map.getOverlays().add(endMarker);

        waypoints.add(endPoint);

//        Road Overlay
        Road road = roadManager.getRoad(waypoints);
        Polyline roadOverlay = RoadManager.buildRoadOverlay(road);

        map.getOverlays().add(roadOverlay);

//        Path
        Drawable nodeIcon = getResources().getDrawable(R.drawable.ic_baseline_fmd_bad_24);
        for (int i=0; i<road.mNodes.size(); i++){
            RoadNode node = road.mNodes.get(i);

            Marker nodeMarker = new Marker(map);
            nodeMarker.setPosition(node.mLocation);
            nodeMarker.setTitle("Step "+i);
            nodeMarker.setSnippet(node.mInstructions);
            nodeMarker.setIcon(nodeIcon);
            nodeMarker.setSubDescription(Road.getLengthDurationText(getContext(), node.mLength, node.mDuration));

            Drawable icon = getResources().getDrawable(R.drawable.ic_baseline_arrow_upward_24);
            nodeMarker.setImage(icon);
            //TODO: icons mManeuverType
            System.out.println("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGG: " + node.mManeuverType);
            map.getOverlays().add(nodeMarker);
        }

        map.invalidate();

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSAO_REQUERIDA) {
            // Se a solicitação de permissão foi cancelada o array vem vazio.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão cedida, recria a activity para carregar o mapa, só será executado uma vez
                requireActivity().recreate();
            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
        view.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        MapFragment mapFragment = FragmentManager.findFragment(view);
        if (mapFragment.isVisible()) {
            Drawable person = getResources().getDrawable(R.drawable.ic_baseline_person_pin_24);
            GeoPoint center = new GeoPoint(location.getLatitude(), location.getLongitude());

            assert map != null;
            assert view != null;
            Marker personMarker = new Marker(map);

            personMarker.setPosition(center);
            personMarker.setIcon(person);

            map.getOverlays().add(personMarker);
            map.invalidate();
        }
    }
}