package ma.ettazarini.carsdespenses.ui.fragments.fuel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import ma.ettazarini.carsdespenses.R;
import ma.ettazarini.carsdespenses.databinding.FragmentFuelListBinding;
import ma.ettazarini.carsdespenses.databinding.FragmentStationsListBinding;
import ma.ettazarini.carsdespenses.ui.fragments.station.AddStationFragment;


public class FuelFragment extends Fragment implements View.OnClickListener {

    FragmentFuelListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFuelListBinding.inflate(getLayoutInflater());
        binding.fabAddFuel.setOnClickListener(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Navigation.findNavController(v).navigate(R.id.action_listFragment_to_addFragment);
    }
}