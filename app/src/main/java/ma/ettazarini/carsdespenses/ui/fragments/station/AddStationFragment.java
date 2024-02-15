package ma.ettazarini.carsdespenses.ui.fragments.station;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ma.ettazarini.carsdespenses.R;
import ma.ettazarini.carsdespenses.databinding.FragmentAddStationBinding;

public class AddStationFragment extends DialogFragment {
    FragmentAddStationBinding binding;
    public static String TAG = "AddStationFragment";
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext()).setView(R.layout.fragment_add_station)
                .setTitle("Ajouter une station")
                /*.setPositiveButton("Valider", null )
                .setNegativeButton("Annuler", null)*/
                .create();
    }

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentAddStationBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}