package nyc.c4q.hyun.finalexam.settings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.hyun.finalexam.R;

/**
 * Created by Hyun on 2/12/17.
 */
public class SettingsAdapter extends RecyclerView.Adapter<SettingsViewHolder> {

    private View view;
    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.settings_viewholder, parent, false);
        return new SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, int position) {
        holder.tv.setText("Setting - " + String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
