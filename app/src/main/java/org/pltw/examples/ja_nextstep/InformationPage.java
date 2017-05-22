package org.pltw.examples.ja_nextstep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by acastro on 5/17/2017.
 */

public class InformationPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the view for the activity to be the xml layout screen that has the FrameLayout that will contain the trip fragment
        // (which in turn uses fragment_trip.xml)
        setContentView(R.layout.information_page);
    }
}
