package retrofit.aishwarya.com.addingitemstorecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText mAddItem;
    private Button mAdd;
    private Button mRemove;
    private RecyclerView mRecyclerView;
    private AnimalAdapter mAnimalAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        mAddItem = (EditText) findViewById(R.id.new_item);
        mAdd = (Button) findViewById(R.id.add);
        mRemove = (Button) findViewById(R.id.remove);
        mRecyclerView = (RecyclerView) findViewById(R.id.items);
         String[] animals = getResources().getStringArray(R.array.animals);
        ArrayList<String> animal = new ArrayList<>(Arrays.asList(animals));
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mAnimalAdapter = new AnimalAdapter(animal, this);
            mRecyclerView.setAdapter(mAnimalAdapter);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimalAdapter.add(mAddItem.getText().toString());
            }
        });
        mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimalAdapter.remove();
            }
        });
    }
}
