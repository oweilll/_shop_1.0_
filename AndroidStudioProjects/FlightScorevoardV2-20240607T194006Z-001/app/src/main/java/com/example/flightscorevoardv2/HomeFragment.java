package com.example.flightscorevoardv2;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private RecyclerView recyclerView;
    private FlightAdapter flightAdapter;
    private List<Flight> flightList = new ArrayList<>();
    private DatabaseReference databaseReference;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "FlightPreferences";
    private static final String AIRPORT_KEY = "selectedAirport";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        flightAdapter = new FlightAdapter(flightList);
        recyclerView.setAdapter(flightAdapter);

        sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, 0);
        String selectedAirport = sharedPreferences.getString(AIRPORT_KEY, "Шереметьево");

        databaseReference = FirebaseDatabase.getInstance().getReference(selectedAirport);
        fetchFlights();
        return view;
    }

    private void fetchFlights() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                flightList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    try {
                        Flight flight = snapshot.getValue(Flight.class);
                        if (flight != null) {
                            flightList.add(flight);
                        } else {
                            Log.e(TAG, "Flight data is null");
                        }
                    } catch (DatabaseException e) {
                        Log.e(TAG, "Error parsing flight data", e);
                    }
                }
                flightAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "Database error: " + databaseError.getMessage());
                Toast.makeText(getContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
