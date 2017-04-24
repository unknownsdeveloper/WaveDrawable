package ankit.developer.unknowns.wavedrawable;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import me.alexrs.wavedrawable.WaveDrawable;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String[] interpolatorsList = {

            "LinearInterpolator", "AccelerateDecelerateInterpolator",

            "AccelerateInterpolator", "AnticipateInterpolator",

            "AnticipateOvershootInterpolator", "BounceInterpolator",

            "CycleInterpolator", "DecelerateInterpolator", "OvershootInterpolator"


    };


    WaveDrawable waveDrawable;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Spinner spinner = (Spinner) findViewById(R.id.spiner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, interpolatorsList);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


        waveDrawable = new WaveDrawable(Color.parseColor("#8e44ad"), 500);

        imageView.setBackgroundDrawable(waveDrawable);


    }


    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Interpolator interpolator;

        switch (position) {

            case 0:

                interpolator = new LinearInterpolator();

                break;

            case 1:

                interpolator = new AccelerateDecelerateInterpolator();

                break;

            case 2:

                interpolator = new AccelerateInterpolator();

                break;

            case 3:

                interpolator = new AnticipateInterpolator();

                break;

            case 4:

                interpolator = new AnticipateOvershootInterpolator();

                break;

            case 5:

                interpolator = new BounceInterpolator();

                break;

            case 6:

                interpolator = new CycleInterpolator(3);

                break;

            case 7:

                interpolator = new DecelerateInterpolator();

                break;

            case 8:

                interpolator = new OvershootInterpolator();

                break;

            default:

                interpolator = new LinearInterpolator();

                break;

        }

        waveDrawable.setWaveInterpolator(interpolator);

        waveDrawable.startAnimation();

    }


    @Override

    public void onNothingSelected(AdapterView<?> parent) {


    }
}