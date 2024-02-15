package ma.ettazarini.carsdespenses.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ma.ettazarini.carsdespenses.data.entities.Station;

@Dao
public interface StationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Station station);
    @Update
    void edit(Station station);
    @Query("DELETE FROM stations WHERE id=:id")
    void delete(int id);
    @Query("SELECT * FROM stations")
    List<Station> getAll();
}
