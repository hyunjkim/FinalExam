package nyc.c4q.hyun.finalexam.settings;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.hyun.finalexam.R;

/**
 * Created by Hyun on 2/12/17.
 */
public class SettingsViewHolder extends RecyclerView.ViewHolder {

    public  TextView tv;
    private View mRoot;

    public SettingsViewHolder(View itemView) {
        super(itemView);
        mRoot = itemView;

        tv = (TextView) mRoot.findViewById(R.id.recyclersettingsTV);
    }
}
