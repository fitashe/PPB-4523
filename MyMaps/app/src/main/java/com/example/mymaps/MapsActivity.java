package com.example.mymaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public static final String nama_pulau[] = {"Pilih Pulau","Sumatera", "Jawa", "Kalimantan", "Sulawesi", "Bali", "NTB", "NTT", "Maluku", "Papua"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        spinner = findViewById(R.id.selected_pulau);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, nama_pulau);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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
        /*
        LatLng sydney = new LatLng(-7.0508786, 109.8125231);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Posisi saya sekarang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
         */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double latitude, longitude;

        switch (position){
            case 0:
                mMap.clear();
                break;
            case 1:
                mMap.clear();
                LatLng aceh = new LatLng(5.595062, 95.3833879);
                mMap.addMarker(new MarkerOptions().position(aceh).title("NANGGROE ACEH DARUSSALAM"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aceh));

                LatLng medan = new LatLng(3.5663163, 98.6920811);
                mMap.addMarker(new MarkerOptions().position(medan).title("MEDAN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(medan));

                LatLng padang = new LatLng(-0.9032129, 100.3318466);
                mMap.addMarker(new MarkerOptions().position(padang).title("PADANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(padang));

                LatLng palembang = new LatLng(-2.9549663, 104.6929238);
                mMap.addMarker(new MarkerOptions().position(palembang).title("PALEMBANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palembang));
                break;
            case 2:
                mMap.clear();
                LatLng banten = new LatLng(-6.124767, 106.1745111);
                mMap.addMarker(new MarkerOptions().position(banten).title("BANTEN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(banten));

                LatLng jakarta = new LatLng(-6.1820324, 106.7988816);
                mMap.addMarker(new MarkerOptions().position(jakarta).title("JAKARTA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));

                LatLng bandung = new LatLng(-6.9192185, 107.6048745);
                mMap.addMarker(new MarkerOptions().position(bandung).title("BANDUNG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bandung));

                LatLng semarang = new LatLng(-6.9905558, 110.390292);
                mMap.addMarker(new MarkerOptions().position(semarang).title("SEMARANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(semarang));

                LatLng jogja = new LatLng(-7.7926358, 110.3571195);
                mMap.addMarker(new MarkerOptions().position(jogja).title("DAERAH ISTIMEWA YOGYAKARTA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(jogja));

                LatLng surabaya = new LatLng(-7.2502809, 112.6143183);
                mMap.addMarker(new MarkerOptions().position(surabaya).title("SURABAYA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(surabaya));

                LatLng madura = new LatLng(-7.0870204, 112.9130735);
                mMap.addMarker(new MarkerOptions().position(madura).title("MADURA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(madura));
                break;
            case 3:
                mMap.clear();
                LatLng pontianak = new LatLng(0.0069438, 109.2803954);
                mMap.addMarker(new MarkerOptions().position(pontianak).title("PONTIANAK"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(pontianak));

                LatLng palangkaraya = new LatLng(-2.202504, 113.8743612);
                mMap.addMarker(new MarkerOptions().position(palangkaraya).title("PALANGKARAYA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palangkaraya));

                LatLng banjarmasin = new LatLng(-3.3059284, 114.5589704);
                mMap.addMarker(new MarkerOptions().position(banjarmasin).title("BANJARMASIN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(banjarmasin));

                LatLng samarinda = new LatLng(-0.4954162, 117.0752156);
                mMap.addMarker(new MarkerOptions().position(samarinda).title("SAMARINDA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(samarinda));

                LatLng tarakan = new LatLng(3.3314507, 117.5230075);
                mMap.addMarker(new MarkerOptions().position(tarakan).title("TARAKAN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(tarakan));

                LatLng balikpapan = new LatLng(-1.2448137, 116.8452529);
                mMap.addMarker(new MarkerOptions().position(balikpapan).title("PALEMBANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(balikpapan));
                break;
            case 4:
                mMap.clear();
                LatLng manado = new LatLng(1.4551593, 124.8063673);
                mMap.addMarker(new MarkerOptions().position(manado).title("MANADO"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(manado));

                LatLng gorontalo = new LatLng(0.5292572, 123.0485078);
                mMap.addMarker(new MarkerOptions().position(gorontalo).title("GORONTALO"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(gorontalo));

                LatLng palu = new LatLng(-0.8722924, 119.8111892);
                mMap.addMarker(new MarkerOptions().position(palu).title("PALU"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palu));

                LatLng makassar = new LatLng(-5.1466448, 119.370394);
                mMap.addMarker(new MarkerOptions().position(makassar).title("MAKASSAR"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(makassar));

                LatLng kendari = new LatLng(-3.9846556, 122.4996526);
                mMap.addMarker(new MarkerOptions().position(kendari).title("KENDARI"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(kendari));

                LatLng mamuju = new LatLng(-2.6803514, 118.8469393);
                mMap.addMarker(new MarkerOptions().position(mamuju).title("MAMUJU"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(mamuju));
                break;
            case 5:
                mMap.clear();
                LatLng bali = new LatLng(-8.6770699, 115.2170517);
                mMap.addMarker(new MarkerOptions().position(bali).title("DENPASAR"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bali));

                LatLng nusa_penida = new LatLng(-8.7548375, 115.4623759);
                mMap.addMarker(new MarkerOptions().position(nusa_penida).title("NUSA PENIDA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nusa_penida));
                break;
            case 6:
                mMap.clear();
                LatLng lombok = new LatLng(-8.7192536, 116.2386757);
                mMap.addMarker(new MarkerOptions().position(lombok).title("LOMBOK"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(lombok));

                LatLng sumbawa = new LatLng(-8.6351252, 116.9951826);
                mMap.addMarker(new MarkerOptions().position(sumbawa).title("SUMBAWA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sumbawa));

                LatLng bima = new LatLng(-8.45694, 118.7140282);
                mMap.addMarker(new MarkerOptions().position(bima).title("BIMA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bima));
                break;
            case 7:
                mMap.clear();
                LatLng manggarai = new LatLng(-8.5654417, 119.4845821);
                mMap.addMarker(new MarkerOptions().position(manggarai).title("PULAU KOMODO"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(manggarai));

                LatLng sumba = new LatLng(-9.5254565, 119.6990885);
                mMap.addMarker(new MarkerOptions().position(sumba).title("SUMBA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sumba));

                LatLng masumeli = new LatLng(-8.7018292, 121.0217806);
                mMap.addMarker(new MarkerOptions().position(masumeli).title("MASUMELI"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(masumeli));
                break;
            /*case 8:
                mMap.clear();
                LatLng ambon = new LatLng(-3.645279, 128.1747038);
                mMap.addMarker(new MarkerOptions().position(ambon).title("AMBON"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ambon));

                LatLng banda_neira = new LatLng(-4.5194412, 129.8996175);
                mMap.addMarker(new MarkerOptions().position(banda_neira).title("BANDA NEIRA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(banda_neira));
                break;
            case 9:
                mMap.clear();
                LatLng papua = new LatLng(-3.6413263, 137.152021);
                mMap.addMarker(new MarkerOptions().position(papua).title("PAPUA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(papua));

                LatLng papua_barat= new LatLng(-0.2378819, 130.4971827);
                mMap.addMarker(new MarkerOptions().position(papua_barat).title("PAPUA BARAT"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(papua_barat));
                break;

             */
            default:
                Toast.makeText(this, "Pilihan tidak ada..!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}