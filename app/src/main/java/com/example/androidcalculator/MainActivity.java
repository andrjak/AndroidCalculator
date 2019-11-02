package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TAG_SCIENTIFIC = "FRAGMENT_SCIENTIFIC";
    static final String TAG_BASIC = "FRAGMENT_BASIC";
    ScientificFunction scientificFunction;
    BasicFunctionsFragment basicFunctionsFragment;
    MainActivity activity;
    private FragmentManager fragmentManager;
    private TextView textFragment;
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        activity = this;
        textFragment = findViewById(R.id.textView);
        int orientation = activity.getResources().getConfiguration().orientation;
        if (savedInstanceState == null) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                // добавляем фрагмент
                basicFunctionsFragment = new BasicFunctionsFragment();
                fragmentTransaction.add(R.id.container, basicFunctionsFragment, TAG_BASIC);
                fragmentTransaction.commit();
            }
        }
        else {
            text = savedInstanceState.getString("TextResult");
            textFragment.setText(text);
        }
    }

    public TextView getText()
    {
        return textFragment;
    }

        // getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE; получить орентацию экрана
        // getWindowManager().getDefaultDisplay().getRotation() получить градус поворота
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Установить програмно орентацию экрана

    @Override
    public void onSaveInstanceState(Bundle saveInstance)
    {
        text = textFragment.getText().toString();
        saveInstance.putString("TextResult", text);
        super.onSaveInstanceState(saveInstance);
    }

    public void ChangeMode(View view)
    {
        ScientificFunction fragment = (ScientificFunction) fragmentManager.findFragmentByTag(TAG_SCIENTIFIC);

        if (fragment == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            scientificFunction = new ScientificFunction();
            fragmentTransaction.replace(R.id.container, scientificFunction, TAG_SCIENTIFIC);
            fragmentTransaction.commit();

        }
        else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            basicFunctionsFragment = new BasicFunctionsFragment();
            fragmentTransaction.replace(R.id.container, basicFunctionsFragment, TAG_BASIC);
            fragmentTransaction.commit();
        }
    }
}
