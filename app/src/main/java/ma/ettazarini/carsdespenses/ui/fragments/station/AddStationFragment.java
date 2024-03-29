package ma.ettazarini.carsdespenses.ui.fragments.station;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import ma.ettazarini.carsdespenses.data.entities.Station;
import ma.ettazarini.carsdespenses.databinding.FragmentAddStationBinding;
import ma.ettazarini.carsdespenses.viewmodels.StationViewModel;

public class AddStationFragment extends DialogFragment{
    FragmentAddStationBinding binding;
    public static String TAG = "AddStationFragment";
    StationViewModel viewModel;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Station station = AddStationFragmentArgs.fromBundle(getArguments()).getMyStation();
        viewModel = new ViewModelProvider(requireActivity()).get(StationViewModel.class);
        viewModel.setStation(station);
        binding = FragmentAddStationBinding
                .inflate(getLayoutInflater());
        binding.setLifecycleOwner(requireActivity());
        binding.setStationViewModel(viewModel);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setPositiveButton("Valider", (dialog, n)-> {
            if(station.getId()!=0)
                viewModel.updateStation();
            else
                viewModel.addStation();
        });
        builder.setView(binding.getRoot());
        builder.setTitle("Ajouter une station");
        return builder.create();
    }

}