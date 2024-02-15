package ma.ettazarini.carsdespenses.data.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class FuelWithStation {
    @Embedded
    public Station station;
    @Relation(
            parentColumn = "id",
            entityColumn = "stationId"
    )
    public List<Fuel> fuelList;

}
