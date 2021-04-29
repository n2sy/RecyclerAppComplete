package nidhal.tp5.recyclerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    //Préparer la structure qui contiendra les éléments de notre liste
    private final LinkedList<String> mWordList;
    //private final LayoutInflater mInflater;


    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public final TextView wordItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();

            String element = mWordList.get(mPosition);
            String newElement = "Clicked! "+ element;
            mWordList.set(mPosition, newElement);
            mAdapter.notifyDataSetChanged();
        }
    }

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        this.mWordList = wordList;
        //mInflater  = LayoutInflater.from(context);

    }

    //Appelée au moment de la création du ViewHolder qui affichera
    //les éléments chargés à partir de l'Adapter
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // Inflater un view avec le layout déjà créé
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    //Elle est appelé à chaque fois qu'une vue doit être chargé.
    //On récupére alors la position du nouvel élément à afficher
    //et on le charge dans le TextView
    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder,
                                 int position) {
        // Récupérer l'élément qui doit etre affiché et chargé dans le ViewHolder
        String mCurrent = mWordList.get(position);
        // Ajouter l'élément au ViewHolder
        holder.wordItemView.setText(mCurrent);
    }

    //Retourne le nombre d'éléments de notre liste
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}