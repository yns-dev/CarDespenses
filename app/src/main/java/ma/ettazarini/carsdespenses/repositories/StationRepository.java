package ma.ettazarini.carsdespenses.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import ma.ettazarini.carsdespenses.data.entities.Station;

public interface StationRepository {
    LiveData<List<Station>> getAll();
    void insert(Station station);
    void update(Station station);
    void delete(int id);
}
