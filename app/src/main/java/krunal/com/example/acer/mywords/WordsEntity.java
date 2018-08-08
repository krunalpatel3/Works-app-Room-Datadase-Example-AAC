package krunal.com.example.acer.mywords;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


/**
 * Created by acer on 04-02-2018.
 */
@Entity(tableName = "tb")
public class WordsEntity  {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="w_id")
    private int id;

    @ColumnInfo(name = "w_name")
    private String word;

    @Ignore
    public WordsEntity(){

    }

    public WordsEntity(@NonNull String str){
        this.word =str;
    }

    public WordsEntity(int id, String word){
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
