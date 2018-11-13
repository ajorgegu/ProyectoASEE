package DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import Objects.Comida;
import ObjectsDAO.ComidaDAO;

@Database(entities = {Comida.class}, version =1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ComidaDAO comidaDAO();
}
