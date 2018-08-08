package krunal.com.example.acer.mywords;


import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private EditText meditext;
    private AddActivityViewModel mviewmodel;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mviewmodel = ViewModelProviders.of(this).get(AddActivityViewModel.class);
        fab= findViewById(R.id.floatingActionButton2);

        meditext = findViewById(R.id.editText);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(meditext.getText().toString())){
                    Toast.makeText(getBaseContext(),"Value not inserted",Toast.LENGTH_SHORT).show();
                }else {
                    mviewmodel.insert(new WordsEntity(meditext.getText().toString()));
                    Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

    }
}
