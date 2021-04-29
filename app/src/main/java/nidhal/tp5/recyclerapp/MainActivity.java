package nidhal.tp5.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    //on aurait pu utiliser une autre structure de données comme  :
    //private final List<String> wordsList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Ajouter des éléments à notre LinkedList.
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Element " + i);
        }

        // Créer une variable de type reycylerView
        mRecyclerView = this.findViewById(R.id.recyclerview);

        // Créer l'Adapter et lui passer la liste dont il va afficher les éléments
        mAdapter = new WordListAdapter(this, mWordList);

        // Connecter l'Adapter à notre RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        // Passer au RecyclerView le LayoutManager désiré
        LinearLayoutManager l = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(l);

    

    //Ajouter un ActionBar
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    //Ajouter un Actionbutton
    FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int wordListSize = mWordList.size();
            // Ajouter un nouveau mot à notre liste mWordList
            mWordList.addLast("+ New Element " + wordListSize);
            // Notifier l'Adapter que la liste a été modifiée.
            mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
            // Scroller en bas.
            mRecyclerView.smoothScrollToPosition(wordListSize);
        }
    });
}

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        //L'Inflater va ajouter les élements du menu au Menu de l'ActionBar
        getMenuInflater().inflate(R.menu.menu_main, m);

        //Si il y a eu un problème avec l'ajout du menu, ca déclenchera une exception
        //Sinon, on renvoie true
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Récupérer l'Id de l'item selectionné
        int id = item.getItemId();

        // Tester l'id de l'élément selectionné
        if (id == R.id.action_settings1) {
            Toast.makeText(getApplicationContext(), R.string.action_settings1, Toast.LENGTH_LONG).show();
            return true;
        }
        else if(id == R.id.action_settings2) {
            Toast.makeText(getApplicationContext(), R.string.action_settings2, Toast.LENGTH_LONG).show();
            return true;
        }
        else if(id == R.id.action_settings3) {
            Toast.makeText(getApplicationContext(), R.string.action_settings3, Toast.LENGTH_LONG).show();
            return true;
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.action_settings4, Toast.LENGTH_LONG).show();
            return true;
        }

    }
}

