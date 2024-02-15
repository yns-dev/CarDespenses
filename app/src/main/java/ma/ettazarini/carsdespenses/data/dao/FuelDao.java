package ma.ettazarini.carsdespenses.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import ma.ettazarini.carsdespenses.data.entities.Fuel;
import ma.ettazarini.carsdespenses.data.entities.FuelWithStation;

@Dao
public interface FuelDao {
    @Insert
    void add (Fuel fuel);
    @Update
    void edit(Fuel fuel);
    @Query("DELETE FROM fuels WHERE id=:id")
    void remove(int id);
    @Transaction
    @Query("SELECT * FROM fuels")
    List<FuelWithStation> getAll();
    @Query("SELECT * FROM fuels WHERE id=:id")
    Fuel getById(int id);

}
