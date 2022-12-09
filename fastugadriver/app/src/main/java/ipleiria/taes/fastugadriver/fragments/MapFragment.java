package ipleiria.taes.fastugadriver.fragments;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.os.Build.VERSION_CODES.M;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import java.util.Hashtable;
import java.util.Objects;

import ipleiria.taes.fastugadriver.BuildConfig;
import ipleiria.taes.fastugadriver.R;

public class MapFragment extends Fragment implements LocationListener {

    View view;
    MapView map;
    Road road;
    Marker personMarker;
    TextView textPopUp;
    double meters = 0;
    double duration = 0;

    GeoPoint center;
    private LocationManager locationManager;

    private static final int PERMISSAO_REQUERIDA = 1;

    double restaurantLatitude;
    double restaurantLongitude;
    double clientLatitude;
    double clientLongitude;

    private Hashtable<Integer, Double> hashtablePoints;

    private Object[][] objects;

    private ArrayList<RoadNode> geoPoints;

    private boolean first = true;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        hashtablePoints = new Hashtable<>();
        geoPoints = new ArrayList<>();
        objects = new Object[20][1];
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_map, container, false);
        view.setVisibility(View.VISIBLE);
        map = view.findViewById(R.id.mapView);

        // Values received from AvailableOrdersFragment
        Bundle bundle = getArguments();
        assert bundle != null;

//        Set Coordinates
        restaurantLatitude = bundle.getDouble("restaurantLatitude");
        restaurantLongitude = bundle.getDouble("restaurantLongitude");
        clientLatitude = bundle.getDouble("clientLatitude");
        clientLongitude = bundle.getDouble("clientLongitude");

        assert getContext() != null;

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

        mapFeatures();

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

        GeoPoint newCenter = new GeoPoint(location.getLatitude(), location.getLongitude());
        if (mapFragment.isVisible()) {
            if (center == null) {
                myLocation(location);
            } else {
                if (!center.equals(newCenter)) {
                    myLocation(location);
                }
            }
        }
    }

    public void myLocation(Location location) {
        Drawable person = getResources().getDrawable(R.drawable.ic_baseline_person_pin_circle_24);

        if (personMarker != null) {
            personMarker.remove(map);
        }
        center = new GeoPoint(location.getLatitude(), location.getLongitude());

        if (geoPoints.size() > 0) {
            RoadManager roadManager = new OSRMRoadManager(getContext(), Configuration.getInstance().getUserAgentValue());
            ArrayList<GeoPoint> distanceUserToEnd = new ArrayList<GeoPoint>();
            ArrayList<GeoPoint> distancePointToEnd = new ArrayList<GeoPoint>();
            Road roadUserToEnd;
            Road roadPointToEnd;
            distanceUserToEnd.add(center);

            Drawable nodeIcon = getResources().getDrawable(R.drawable.ic_baseline_fmd_bad_24);

            Marker nodeMarker = new Marker(map);
            nodeMarker.setPosition(geoPoints.get(0).mLocation);
            nodeMarker.setTitle("Next Step");
            nodeMarker.setSnippet(geoPoints.get(0).mInstructions);
            nodeMarker.setSubDescription(Road.getLengthDurationText(getContext(), meters, geoPoints.get(0).mDuration));
            nodeMarker.setIcon(nodeIcon);

            Drawable icon = getManeuverIcon(geoPoints.get(0).mManeuverType);
            nodeMarker.setImage(icon);
            map.getOverlays().add(nodeMarker);
            nodeMarker.showInfoWindow();

            System.out.println("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG - " + geoPoints.get(0).mInstructions + " - " + geoPoints.get(0).mLength);

            distancePointToEnd.add(geoPoints.get(0).mLocation);
            distancePointToEnd.add(geoPoints.get(geoPoints.size() - 1).mLocation);

            distanceUserToEnd.add(geoPoints.get(geoPoints.size() - 1).mLocation);
            roadUserToEnd = roadManager.getRoad(distanceUserToEnd);
            roadPointToEnd = roadManager.getRoad(distancePointToEnd);

            if (roadUserToEnd.mLength < roadPointToEnd.mLength) {
                meters = geoPoints.get(0).mLength;
                duration = geoPoints.get(0).mDuration;
                geoPoints.remove(0);
                nodeMarker.remove(map);
            }
        }

        assert map != null;
        assert view != null;
        personMarker = new Marker(map);

        personMarker.setPosition(center);
        personMarker.setIcon(person);
        personMarker.setTitle("Driver");

        map.getOverlays().add(personMarker);
        map.invalidate();
    }

    private void mapFeatures() {
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
        road = roadManager.getRoad(waypoints);
        Polyline roadOverlay = RoadManager.buildRoadOverlay(road);

        map.getOverlays().add(roadOverlay);
//        Path
        Drawable nodeIcon = getResources().getDrawable(R.drawable.ic_baseline_fmd_bad_24);
        for (int i = 0; i < road.mNodes.size(); i++) {
            RoadNode node = road.mNodes.get(i);
            if (node.mInstructions == null) {
                node.mInstructions = "Keep Going";
            }

            geoPoints.add(i, node);

            Marker nodeMarker = new Marker(map);
            nodeMarker.setPosition(node.mLocation);
            nodeMarker.setTitle("Step " + i);
            nodeMarker.setSnippet(node.mInstructions);
            nodeMarker.setIcon(nodeIcon);
            nodeMarker.setSubDescription(Road.getLengthDurationText(getContext(), node.mLength, node.mDuration));

            System.out.println("DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG ------------------------- " + i + " ----------------- " + node.mManeuverType);

            Drawable icon = getManeuverIcon(node.mManeuverType);
            nodeMarker.setImage(icon);
            map.getOverlays().add(nodeMarker);
        }
        map.invalidate();
    }

    private Drawable getManeuverIcon(int number) {
        switch (number) {
            case 0:
            case 1:
            case 17:
            case 22:
                return getResources().getDrawable(R.drawable.ic_baseline_arrow_upward_24);
            case 2:
            case 5:
            case 6:
            case 9:
            case 7:
            case 10:
            case 11:
            case 12:
            case 18:
            case 20:
            case 23:
            case 37:
                return getResources().getDrawable(R.drawable.ic_baseline_turn_right_24);
            case 3:
            case 13:
            case 14:
            case 15:
            case 16:
            case 19:
            case 21:
            case 38:
                return getResources().getDrawable(R.drawable.ic_baseline_turn_left_24);
            case 26:
            case 27:
            case 29:
            case 8:
            case 28:
                return getResources().getDrawable(R.drawable.ic_baseline_change_circle_24);
            default:
                return getResources().getDrawable(R.drawable.ic_baseline_start_24);
        }
    }
}