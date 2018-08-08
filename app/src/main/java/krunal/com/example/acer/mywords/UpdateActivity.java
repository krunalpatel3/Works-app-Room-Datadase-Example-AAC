package krunal.com.example.acer.mywords;


import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateActivity extends AppCompatActivity {

    private FloatingActionButton mfab;
    private static final String TAB = UpdateActivity.class.getSimpleName();
    private EditText mUpdateWord;
    private UpdateActivityViewModel mUpdateViewModel;
    private static int Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mUpdateWord = findViewById(R.id.editTextUpdateWord);
        mfab = findViewById(R.id.floatingActionButton3);
        mUpdateViewModel = ViewModelProviders.of(this).get(UpdateActivityViewModel.class);
        Id = getIntent().getIntExtra(MainActivity.EXTRA_ID,-1);
        Log.i(TAB,String.valueOf(Id));
        mUpdateViewModel.Query(Id);
        try {
            Thread.sleep(300);
            mUpdateWord.setText(UpdateActivityViewModel.WordName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        mfab.setOnClickListener(v -> {

            String name = mUpdateWord.getText().toString().trim();
            Log.i(TAB,name);
            Log.i(TAB,String.valueOf(Id));

            if (!TextUtils.isEmpty(name)) {
                WordsEntity wordsEntity = new WordsEntity(Id, name);
                mUpdateViewModel.Update(wordsEntity);
                Toast.makeText(this, "Update Sucessfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Update Error",Toast.LENGTH_SHORT).show();
            }

            finish();
        });

    }
}
