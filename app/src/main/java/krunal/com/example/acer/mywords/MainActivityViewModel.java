package krunal.com.example.acer.mywords;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import java.util.List;

/**
 * Created by acer on 04-02-2018.
 */

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<WordsEntity>> mholelist;

    private Repository mrepository;

    public MainActivityViewModel(Application application){
        super(application);
        this.mrepository = new Repository(application);
        this.mholelist = mrepository.getAllword();
    }

    public LiveData<List<WordsEntity>> getAlllist(){
        return mholelist;
    }

    public void delete(WordsEntity wordsEntity){
        mrepository.delete(wordsEntity);
    }
}
