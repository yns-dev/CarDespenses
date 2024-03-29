package ma.ettazarini.carsdespenses.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ma.ettazarini.carsdespenses.data.entities.Station;
import ma.ettazarini.carsdespenses.repositories.StationRepository;
import ma.ettazarini.carsdespenses.repositories.StationRepositoryImpl;

public class StationViewModel extends AndroidViewModel {
    private Station station;
    private final StationRepository stationRepository;
    private final LiveData<List<Station>> stationsList;

    public StationViewModel(@NonNull Application application) {
        super(application);
        station = new Station();
        stationRepository = new StationRepositoryImpl(application);
        stationsList = stationRepository.getAll();
    }

    public void addStation() {
        stationRepository.insert(station);
    }
    public void updateStation() {
        stationRepository.update(station);
    }

    public LiveData<List<Station>> getAllStations() {
        return this.stationsList;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
