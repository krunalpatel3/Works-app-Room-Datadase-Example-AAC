package krunal.com.example.acer.mywords;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import java.util.List;

/**
 * Created by acer on 04-02-2018.
 */

public class Repository {

    private AppExecutor mAppExcutor;
    private WordDatabase mworddatabase;

    private LiveData<List<WordsEntity>> mlist;

    public Repository(Application application){
        mAppExcutor = new AppExecutor();
        mworddatabase= WordDatabase.getinstance(application);
        mlist = mworddatabase.getdao().getAllword();
    }

    public LiveData<List<WordsEntity>> getAllword(){
        return mlist;
    }

    public void getWordById(int id){
        new GetWordByIdAsyncTask(mworddatabase).execute(id);
    }

    public void Update(WordsEntity wordsEntity){
        mAppExcutor.diskIO().execute(()->{
            mworddatabase.getdao().Update(wordsEntity);
        });


    }

    public void insert(WordsEntity word){
        new insertasytask(mworddatabase).execute(word);
    }

    public void delete(WordsEntity word){
        new deleteasytask(mworddatabase).execute(word);
    }

    private static class deleteasytask extends AsyncTask<WordsEntity,Void,Void>{

        private WordDatabase db;

        deleteasytask(WordDatabase db){
            this.db= db;
        }
        @Override
        protected Void doInBackground(WordsEntity... wordsEntities) {
            db.getdao().delete(wordsEntities[0]);
            return null;
        }
    }

    private static class insertasytask extends AsyncTask<WordsEntity,Void,Void>{

        private WordDatabase db;

        insertasytask(WordDatabase db){
            this.db = db;
        }
        @Override
        protected Void doInBackground(WordsEntity... wordsEntities) {
            db.getdao().insert(wordsEntities[0]);
            return null;
        }
    }

    private static class GetWordByIdAsyncTask extends AsyncTask<Integer,Void,Void>{

        private WordDatabase db;

        private WordsEntity mWords;

        GetWordByIdAsyncTask(WordDatabase db){
            this.db = db;
        }
        @Override
        protected Void doInBackground(Integer... ints) {
           mWords = db.getdao().getWordById(ints[0]);
           UpdateActivityViewModel.WordName = mWords.getWord();

           return null;
        }

    }

}
