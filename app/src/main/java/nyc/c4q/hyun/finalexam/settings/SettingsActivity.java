package nyc.c4q.hyun.finalexam.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import nyc.c4q.hyun.finalexam.R;

/**
 * Created by Hyun on 2/12/17.
 */

public class SettingsActivity extends AppCompatActivity {

    private RecyclerView mSettingRV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();
    }

    private void initViews() {
        mSettingRV = (RecyclerView) findViewById(R.id.settings_RV);
        mSettingRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSettingRV.setAdapter(new SettingsAdapter());
    }
}
