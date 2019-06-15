package com.example.databindingsample.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.databindingsample.R;
import com.example.databindingsample.databinding.ItemLayoutBinding;

import java.util.List;

public class FlightsRecyclerViewAdapter extends
        RecyclerView.Adapter<FlightsRecyclerViewAdapter.ViewHolder>
        implements FlightsEventListener {

    private List<Flight> flightsList;
    private Context context;

    public FlightsRecyclerViewAdapter(List<Flight> flsLst, Context ctx) {
        flightsList = flsLst;
        context = ctx;
    }

    @Override
    public FlightsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        ItemLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flight flight = flightsList.get(position);
        holder.flightItemBinding.setFlight(flight);
        holder.flightItemBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return flightsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemLayoutBinding flightItemBinding;

        public ViewHolder(ItemLayoutBinding flightItemLayoutBinding) {
            super(flightItemLayoutBinding.getRoot());
            flightItemBinding = flightItemLayoutBinding;
        }
    }

    public void bookFlight(Flight f) {
        Toast.makeText(context, "You booked " + f.getAirLines(),
                Toast.LENGTH_LONG).show();
    }
}