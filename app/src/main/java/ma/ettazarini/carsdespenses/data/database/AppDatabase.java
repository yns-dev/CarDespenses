package ma.ettazarini.carsdespenses.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ma.ettazarini.carsdespenses.data.dao.FuelDao;
import ma.ettazarini.carsdespenses.data.dao.StationDAO;
import ma.ettazarini.carsdespenses.data.entities.Fuel;
import ma.ettazarini.carsdespenses.data.entities.Station;

@Database(entities = {Fuel.class, Station.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "car_expenses_db";
    private static volatile AppDatabase INSTANCE;
    public abstract FuelDao getFuelDao();
    public abstract StationDAO getStationDAO();


    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                            AppDatabase.class, DB_NAME)
                                    .allowMainThreadQueries()
                                    .fallbackToDestructiveMigration()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
