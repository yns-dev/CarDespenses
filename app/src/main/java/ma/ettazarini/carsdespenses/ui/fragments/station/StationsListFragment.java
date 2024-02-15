package ma.ettazarini.carsdespenses.ui.fragments.station;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ma.ettazarini.carsdespenses.R;
import ma.ettazarini.carsdespenses.databinding.FragmentStationsListBinding;

public class StationsListFragment extends Fragment {
    FragmentStationsListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentStationsListBinding.inflate(getLayoutInflater());
        binding.fabAddStation.setOnClickListener(v -> new AddStationFragment().show(getChildFragmentManager(), AddStationFragment.TAG));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return binding.getRoot();
    }
}