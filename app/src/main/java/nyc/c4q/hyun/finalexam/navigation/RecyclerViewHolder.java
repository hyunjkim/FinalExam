package nyc.c4q.hyun.finalexam.navigation;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.hyun.finalexam.R;
import nyc.c4q.hyun.finalexam.settings.SettingsActivity;

import static nyc.c4q.hyun.finalexam.R.drawable.hearticon;
import static nyc.c4q.hyun.finalexam.R.drawable.logouticon;
import static nyc.c4q.hyun.finalexam.R.drawable.messageicon;
import static nyc.c4q.hyun.finalexam.R.drawable.settingsicon;

/**
 * Created by Hyun on 2/12/17.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private View mRoot;
    public ImageButton imageBtn;
    private TextView tv;
    private AdapterView.OnItemClickListener listener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mRoot = itemView;
        imageBtn = (ImageButton) mRoot.findViewById(R.id.recycler_imageBtn);
        tv = (TextView) mRoot.findViewById(R.id.recycler_TV);
    }

    public void setView(String input) {
        if (input.equals("Heart")) {
            setImageButton("heart");
            tv.setText(input);
            mRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toaster("heart");
                }
            });
        } else if (input.equals("Message")) {
            setImageButton("message");
            tv.setText(input);
            mRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toaster("message");
                }
            });
        } else if (input.equals("Settings")) {
            setImageButton("settings");
            tv.setText(input);
            mRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toaster("settings");
                    Intent settings = new Intent(mRoot.getContext(), SettingsActivity.class);
                    mRoot.getContext().startActivity(settings);
                }
            });
        } else if (input.equals("Logout")) {
            setImageButton("logout");
            tv.setText(input);
            mRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toaster("logout");
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            });
        }
    }


    private void setImageButton(String input) {
        if(input.equals("heart")){
            Picasso.with(mRoot.getContext()).load(hearticon).fit().into(imageBtn);
        } else if (input.equals("message")) {
            Picasso.with(mRoot.getContext()).load(messageicon).fit().into(imageBtn);
        } else if (input.equals("settings")) {
            Picasso.with(mRoot.getContext()).load(settingsicon).fit().into(imageBtn);
        } else if (input.equals("logout")) {
            Picasso.with(mRoot.getContext()).load(logouticon).fit().into(imageBtn);
        }
    }

    private void toaster(String input) {
        if (input.equals("heart")) {
            Toast.makeText(mRoot.getContext(), "Selected Heart Activity", Toast.LENGTH_SHORT).show();
        } else if (input.equals("message")) {
            Toast.makeText(mRoot.getContext(), "Selected Message Activity", Toast.LENGTH_SHORT).show();
        } else if (input.equals("settings")) {
            Toast.makeText(mRoot.getContext(), "Selected Settings Activity", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mRoot.getContext(), "Selected Logout Activity", Toast.LENGTH_SHORT).show();
        }
    }

}

