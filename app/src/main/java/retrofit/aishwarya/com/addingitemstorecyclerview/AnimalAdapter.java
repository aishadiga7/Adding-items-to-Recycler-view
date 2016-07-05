package retrofit.aishwarya.com.addingitemstorecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aishwarya on 30/6/16.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private ArrayList<String> mAnimals;
    private Context mContext;

    public AnimalAdapter(ArrayList<String> animal, Context context) {
        this.mAnimals = animal;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mAnimals.get(position);
        holder.mAnimName.setText(animal);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mAnimName;

        public ViewHolder(View itemView) {
            super(itemView);
            mAnimName = (TextView) itemView.findViewById(R.id.anim_name);
        }
    }

    public void add(String newAnimal) {
        if (newAnimal != null && (!newAnimal.isEmpty())) {
            mAnimals.add(newAnimal);
            notifyDataSetChanged();
        }
    }

    public void remove() {
        if (mAnimals.size() > 0) {
            mAnimals.remove(mAnimals.size()-1);
            notifyDataSetChanged();
        }
    }
}
