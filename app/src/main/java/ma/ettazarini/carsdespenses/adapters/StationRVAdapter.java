package ma.ettazarini.carsdespenses.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ma.ettazarini.carsdespenses.data.entities.Station;
import ma.ettazarini.carsdespenses.databinding.StationItemBinding;

public class StationRVAdapter extends RecyclerView.Adapter<StationRVAdapter.ViewHolder> {
    private List<Station> stations = new ArrayList<>();
    private final OnStationClickListener stationClickListener;

    public StationRVAdapter(OnStationClickListener stationClickListener) {
        this.stationClickListener = stationClickListener;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        StationItemBinding itemBinding = StationItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position!=RecyclerView.NO_POSITION){
            Station station = stations.get(position);
            holder.bind(station);
            holder.itemView.setOnClickListener(v->{
                if (stationClickListener != null) {

                    stationClickListener.onStationClick(station);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public interface OnStationClickListener{
        void onStationClick(Station station);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        StationItemBinding itemBinding;
        public ViewHolder(@NonNull StationItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;

        }

        public void bind(Station station) {
            itemBinding.setStation(station);
            itemBinding.executePendingBindings();
        }
    }
}
