package id.co.imastudio.androidsqlite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by nandoseptianhusni on 4/10/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Makanan> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textName,textPrice,textRestoran;

        public ViewHolder(View v) {
            super(v);

            textName = v.findViewById(R.id.textName);
            textPrice = v.findViewById(R.id.textPrice);
            textRestoran = v.findViewById(R.id.textRestoran);

        }

        public void bind(final Makanan datanyaItem) {
            textName.setText(datanyaItem.getName());
            textPrice.setText(datanyaItem.getHarga());
            textRestoran.setText(datanyaItem.getRestoran());



        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Makanan> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recylerview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}