package ma.ettazarini.carsdespenses.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ma.ettazarini.carsdespenses.R;
import ma.ettazarini.carsdespenses.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpNavigation();
    }

    public void setUpNavigation() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.app_graph);
        BottomNavigationView bottomNav = binding.bottomNavigationView;
        //navController.setGraph(navGraph);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }
}