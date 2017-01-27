package br.com.fatecpg.preferencesframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        COnfigFragment cOnfigFragment = new COnfigFragment();

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, cOnfigFragment, "configFragment" )
                .commit();
    }
}
