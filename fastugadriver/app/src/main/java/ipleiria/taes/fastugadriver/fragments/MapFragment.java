package ipleiria.taes.fastugadriver.fragments;

import static android.os.Build.VERSION_CODES.M;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapListener;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.events.ZoomEvent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import ipleiria.taes.fastugadriver.BuildConfig;
import ipleiria.taes.fastugadriver.R;

public class MapFragment extends Fragment implements LocationListener {
    private static MapFragment INSTANCE = null;
    View view;
    MapView osm;

    MapView map = null;
    private MapController mc;
    private LocationManager locationManager;
    private static final int PERMISSAO_REQUERIDA = 1;

    private static final String TAG = "OsmFragment";

    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new MapFragment();
        return INSTANCE;

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_map, container, false);
        //return view;

        if (Build.VERSION.SDK_INT >= M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                String[] permissoes = {Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(permissoes, PERMISSAO_REQUERIDA);
            }
        }
        //onde mostra a imagem do mapa
        Context ctx = getActivity().getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        osm = (MapView) view.findViewById(R.id.mapView);
        osm.setTileSource(TileSourceFactory.MAPNIK);
        osm.setBuiltInZoomControls(true);
        osm.setMultiTouchControls(true);

        mc = (MapController) osm.getController();
        mc.setZoom(15);



        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);


        osm.setMapListener(new MapListener() {
            @Override
            public boolean onScroll(ScrollEvent event) {
                Log.i("Script", "onScroll()");
                return false;
            }

            @Override
            public boolean onZoom(ZoomEvent event) {
                Log.i("Script", "onZoom()");
                return false;
            }
        });



        GeoPoint fastuga = new GeoPoint(39.73308546164388, -8.824988664507234);
        // GeoPoint pontoTeste = new GeoPoint(39.75489162077547, -8.931481197546757);
        mc.animateTo(fastuga);
        addMarker(fastuga, "fastuga");

        /*RoadManager roadManager = new OSRMRoadManager(getContext(), Configuration.getInstance().getUserAgentValue());
        ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
        points.add(pontoTeste);
        points.add(fastuga);

        Road road = roadManager.getRoad(points);

        List<Overlay> mapOverlays = osm.getOverlays();
        Polyline roadOverlay = RoadManager.buildRoadOverlay(road);
       mapOverlays.add(roadOverlay);
        osm.invalidate();*/

        return view;
    }

    public void addMarker(GeoPoint center, String title) {
        Marker startMarker = new Marker(osm);
        startMarker.setPosition(center);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        osm.getOverlays().add(startMarker);
        startMarker.setTitle(title);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSAO_REQUERIDA: {
                // Se a solicitação de permissão foi cancelada o array vem vazio.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permissão cedida, recria a activity para carregar o mapa, só será executado uma vez
                    getActivity().recreate();

                }

            }
        }
    }

    public void onResume() {
        super.onResume();

    }


    public void onPause() {
        super.onPause();
    }

    @Override
    public void onLocationChanged(Location location) {
        GeoPoint center = new GeoPoint(location.getLatitude(), location.getLongitude());


        mc.animateTo(center);
        addMarker(center,"Localização Atual");

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }

    }

    /*class MapOverlay extends Overlay{
        public MapOverlay (Context ctx){
            super(ctx);
        }
        @Override
        public void draw(Canvas arg0, MapView arg1, boolean arg2){}

       // @Override
        public boolean OnSingleTapConfirmed(MotionEvent me, MapView mv){
            Projection p = osm.getProjection();
            GeoPoint gp = (GeoPoint) p.fromPixels((int) me.getX(), (int) me.getY());
            mc.animateTo(gp);

            addMarker(gp,"youtube");
            return (false);
        }
    }*/

    //ROUTE
   /* public void drawRoute(GeoPoint start, GeoPoint end){
        RoadManager roadManager = new OSRMRoadManager();
        ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
        points.add(start);
        points.add(end);
        Road road = roadManager.getRoad(points);
        final Polyline roadOverlay = RoadManager.buildRoadOverlay(road, getActivity().getApplicationContext());
    }*/
}