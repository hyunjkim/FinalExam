package nyc.c4q.hyun.finalexam.navigation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nyc.c4q.hyun.finalexam.R;

/**
 * Created by Hyun on 2/12/17.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private View view;
    private final int HEART = 0, MESSAGE = 1, SETTINGS = 2, LOGOUT = 3;
    private List<String> navi = new ArrayList<>(Arrays.asList("Heart", "Message", "Settings", "Logout"));

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.recycler_viewholder, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEART:
                holder.setView(navi.get(position));
                break;
            case MESSAGE:
                holder.setView(navi.get(position));
                break;
            case SETTINGS:
                holder.setView(navi.get(position));
                break;
            case LOGOUT:
                holder.setView(navi.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return navi.size();
    }

}
