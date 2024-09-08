package com.example.flightscorevoardv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightViewHolder> {
    private List<Flight> flights;

    public FlightAdapter(List<Flight> flights) {
        this.flights = flights;
    }

    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_item, parent, false);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        Flight flight = flights.get(position);
        holder.bind(flight);
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    class FlightViewHolder extends RecyclerView.ViewHolder {
        private TextView cityTextView;
        private TextView numberTextView;
        private TextView timeTextView;

        public FlightViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.city_text_view);
            numberTextView = itemView.findViewById(R.id.number_text_view);
            timeTextView = itemView.findViewById(R.id.time_text_view);
        }

        public void bind(Flight flight) {
            cityTextView.setText(flight.getCity());
            numberTextView.setText(flight.getNumber());
            timeTextView.setText(flight.getTime());
        }
    }
}
