package ma.ettazarini.carsdespenses.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                            AppDatabase.class, DB_NAME)
                                    //.allowMainThreadQueries()
                                    .addCallback(insertStation)
                                    .fallbackToDestructiveMigration()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }


    private static final RoomDatabase.Callback insertStation = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            StationDAO dao = INSTANCE.getStationDAO();
            AsyncTask.execute(() -> {
                dao.insert(new Station("Station Service Afriquia", "Marjane Bouregreg, Rabat 10000", "0566775544"));
                dao.insert(new Station("Station Winxo", "Av. Hassan II, Rabat", "0661342567"));
                dao.insert(new Station("Station Shell", "Av. Hassan II, Rabat 10000", "0537669087"));
            });
        }

    };
    /*// below line is to create a callback for our room database.
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // this method is called when database is created
            // and below line is to populate our data.
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    // we are creating an async task class to perform task in background.
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        StationDAO dao;
        PopulateDbAsyncTask(AppDatabase instance) {
            dao = instance.getStationDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.insert(new Station("Station Service Afriquia", "Marjane Bouregreg, Rabat 10000","0566775544"));
            dao.insert(new Station("Station Winxo","Av. Hassan II, Rabat","0661342567"));
            dao.insert(new Station("Station Shell","Av. Hassan II, Rabat 10000","0537669087"));
            return null;
        }
    }
    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            StationDAO dao = INSTANCE.getStationDAO();
            AsyncTask.execute(()->{
                dao.insert(new Station("AFRIQUA"));
                dao.insert(new Station("WINXO"));
                dao.insert(new Station("SHELL"));
            });
        }
    };*/

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
