package nyc.c4q.hyun.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.hyun.finalexam.navigation.RecyclerAdapter;
import nyc.c4q.hyun.finalexam.settings.SettingsActivity;

import static nyc.c4q.hyun.finalexam.R.drawable.hearticon;
import static nyc.c4q.hyun.finalexam.R.drawable.logouticon;
import static nyc.c4q.hyun.finalexam.R.drawable.messageicon;
import static nyc.c4q.hyun.finalexam.R.drawable.settingsicon;
import static nyc.c4q.hyun.finalexam.R.id.heartBtn;
import static nyc.c4q.hyun.finalexam.R.id.logoutBtn;
import static nyc.c4q.hyun.finalexam.R.id.messageBtn;
import static nyc.c4q.hyun.finalexam.R.id.settingBtn;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecycler;
    private ImageButton mHeartBtn, mMessageBtn, mSettingBtn, mlogoutBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        initViews();
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mHeartBtn = (ImageButton) findViewById(heartBtn);
        mMessageBtn = (ImageButton) findViewById(messageBtn);
        mSettingBtn = (ImageButton) findViewById(settingBtn);
        mlogoutBtn = (ImageButton) findViewById(logoutBtn);

        mHeartBtn.setOnClickListener(this);
        mMessageBtn.setOnClickListener(this);
        mSettingBtn.setOnClickListener(this);
        mlogoutBtn.setOnClickListener(this);

        setImageButton(mHeartBtn);
        setImageButton(mMessageBtn);
        setImageButton(mSettingBtn);
        setImageButton(mlogoutBtn);

        mRecycler = (RecyclerView) findViewById(R.id.rview);
        mRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecycler.setAdapter(new RecyclerAdapter());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.heartBtn:
                toaster("heart");
                break;
            case R.id.messageBtn:
                toaster("message");
                break;
            case settingBtn:
                toaster("settings");
                Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settings);
                break;
            case logoutBtn:
                toaster("logout");
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }

    private void setImageButton(ImageButton button) {
        if(button==mHeartBtn){
            Picasso.with(getApplicationContext()).load(hearticon).fit().into(mHeartBtn);
        } else if (button == mMessageBtn) {
            Picasso.with(getApplicationContext()).load(messageicon).fit().into(mMessageBtn);
        } else if (button == mSettingBtn) {
            Picasso.with(getApplicationContext()).load(settingsicon).fit().into(mSettingBtn);
        } else if (button == mlogoutBtn) {
            Picasso.with(getApplicationContext()).load(logouticon).fit().into(mlogoutBtn);
        }
    }

    private void toaster(String input) {
        if (input.equals("heart")) {
            Toast.makeText(getApplicationContext(), "Selected Heart Activity", Toast.LENGTH_SHORT).show();
        } else if (input.equals("message")) {
            Toast.makeText(getApplicationContext(), "Selected Message Activity", Toast.LENGTH_SHORT).show();
        } else if (input.equals("settings")) {
            Toast.makeText(getApplicationContext(), "Selected Settings Activity", Toast.LENGTH_SHORT).show();
        } else if (input.equals("logout")) {
            Toast.makeText(getApplicationContext(), "Selected Logout Activity", Toast.LENGTH_SHORT).show();
        }
    }


}



