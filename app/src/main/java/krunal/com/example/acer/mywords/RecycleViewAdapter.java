package krunal.com.example.acer.mywords;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 04-02-2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecyclerViewHolder> {

    private LayoutInflater mInflater;
    private List<WordsEntity> mlist = new ArrayList<WordsEntity>();
    private OnitemClickListener onitemClickListener;

    Context context;

    RecycleViewAdapter(Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    @Override
    public RecycleViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = mInflater.inflate(R.layout.list, parent, false);
        return new RecyclerViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.RecyclerViewHolder holder, int position) {
        WordsEntity wordsEntity = mlist.get(position);
        holder.mwordtext.setText(wordsEntity.getWord());
        holder.Bind(mlist.get(position),onitemClickListener);
    }

    WordsEntity get(int position) {
        return mlist.get(position);
    }

    @Override
    public int getItemCount() {
        if (mlist.size() != 0) {
            return mlist.size();
        } else {
            return 0;
        }
    }


    void addword(List<WordsEntity> wordsEntity) {
        this.mlist = wordsEntity;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView mwordtext;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            mwordtext = itemView.findViewById(R.id.itemTextView);
        }

        void Bind(WordsEntity wordsEntity, OnitemClickListener listener){
            itemView.setOnClickListener(v -> {
                listener.OnitemClick(wordsEntity);
            });
        }

    }

}