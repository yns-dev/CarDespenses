package ma.ettazarini.carsdespenses.ui.fragments.station;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ma.ettazarini.carsdespenses.adapters.StationRVAdapter;
import ma.ettazarini.carsdespenses.data.entities.Station;
import ma.ettazarini.carsdespenses.databinding.FragmentStationsListBinding;
import ma.ettazarini.carsdespenses.viewmodels.StationViewModel;

public class StationsListFragment extends Fragment implements StationRVAdapter.OnStationClickListener {
    FragmentStationsListBinding binding;
    StationRVAdapter adapter;
    StationViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentStationsListBinding.inflate(getLayoutInflater());
        //binding.fabAddStation.setOnClickListener(v -> new AddStationFragment().show(getChildFragmentManager(), AddStationFragment.TAG));
        binding.fabAddStation.setOnClickListener(v -> {
                    NavDirections action = StationsListFragmentDirections.actionToAddStationFragment(new Station());
                    NavHostFragment.findNavController(this).navigate(action);
                }
        );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new StationRVAdapter(this);
        binding.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(StationViewModel.class);
        viewModel.getAllStations().observe(getViewLifecycleOwner(), stations -> {
            if (stations != null)
                adapter.setStations(stations);
        });
        return binding.getRoot();
    }

    @Override
    public void onStationClick(Station station) {
        NavDirections action = StationsListFragmentDirections.actionToAddStationFragment(station);
        NavHostFragment.findNavController(this).navigate(action);
    }

}