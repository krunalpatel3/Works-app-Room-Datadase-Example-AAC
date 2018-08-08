package krunal.com.example.acer.mywords;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnitemClickListener{

    public static final String EXTRA_ID = "id";
    private FloatingActionButton fab;
    private ArrayList<WordsEntity> mwordentity;
    private MainActivityViewModel mainActivityViewModel;
    private RecycleViewAdapter mrecycleviewadapter;
    private RecyclerView mrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerview = findViewById(R.id.recyclerView2);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mrecycleviewadapter = new RecycleViewAdapter(this);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerview.setAdapter(mrecycleviewadapter);
        mrecycleviewadapter.setOnitemClickListener(this);

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mainActivityViewModel.delete(mrecycleviewadapter.get(viewHolder.getAdapterPosition()));
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mrecyclerview);

        mainActivityViewModel.getAlllist().observe(this, wordsEntities ->
                mrecycleviewadapter.addword(wordsEntities));

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(v ->{
            Intent intent = new Intent(this,AddActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void OnitemClick(WordsEntity wordsEntity) {
        int getid = wordsEntity.getId();

        Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
        intent.putExtra(MainActivity.EXTRA_ID,getid);
        startActivity(intent);

    }


}
