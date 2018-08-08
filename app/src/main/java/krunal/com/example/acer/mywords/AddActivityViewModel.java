package krunal.com.example.acer.mywords;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;

/**
 * Created by acer on 04-02-2018.
 */

public class AddActivityViewModel extends AndroidViewModel {

    private Repository mrepository;

    public AddActivityViewModel(Application application){
        super(application);
        this.mrepository = new Repository(application);
    }

    public void insert(WordsEntity wordsEntity){
        mrepository.insert(wordsEntity);
    }

}
