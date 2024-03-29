package ma.ettazarini.carsdespenses.repositories;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import ma.ettazarini.carsdespenses.data.dao.StationDAO;
import ma.ettazarini.carsdespenses.data.database.AppDatabase;
import ma.ettazarini.carsdespenses.data.entities.Station;

public class StationRepositoryImpl implements StationRepository {
    private final StationDAO stationDAO;

    public StationRepositoryImpl(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        this.stationDAO = db.getStationDAO();
    }

    @Override
    public LiveData<List<Station>> getAll() {
        return stationDAO.getAll();
    }

    @Override
    public void insert(Station station) {
        AsyncTask.execute(()-> stationDAO.insert(station));
    }

    @Override
    public void update(Station station) {
        AsyncTask.execute(()-> stationDAO.edit(station));
    }

    @Override
    public void delete(int id) {
        AsyncTask.execute(()-> stationDAO.delete(id));
    }
}
