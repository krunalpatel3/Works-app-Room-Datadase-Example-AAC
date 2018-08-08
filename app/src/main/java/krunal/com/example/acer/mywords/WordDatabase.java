package krunal.com.example.acer.mywords;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by acer on 04-02-2018.
 */
@Database(entities = {WordsEntity.class}, version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    private static WordDatabase INSTANCE;

    public abstract Worddao getdao();

    static WordDatabase getinstance(Context context){
        if (INSTANCE == null){
            INSTANCE = buildatabase(context);
        }
        return INSTANCE;
    }

    private static WordDatabase buildatabase(Context context){
         String dbname= "My_db";
        return Room.databaseBuilder(context,WordDatabase.class,dbname).build();
    }
}
