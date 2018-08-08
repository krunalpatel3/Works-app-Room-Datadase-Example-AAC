package krunal.com.example.acer.mywords;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

/**
 * Created by acer on 24-03-2018.
 */

public class UpdateActivityViewModel extends AndroidViewModel {

    private Repository mRepository;

    static String WordName;

    public UpdateActivityViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new Repository(application);
    }

    void Query(int id){
        mRepository.getWordById(id);
    }

    void Update(WordsEntity wordsEntity){
        mRepository.Update(wordsEntity);
    }
}
