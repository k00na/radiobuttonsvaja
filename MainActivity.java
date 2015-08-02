package coms.example.k00na.radiobuttonsvaja;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements ColorFragment.colorChangedListener {

    LinearLayout ourActivity;
    TextView colorNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ourActivity = (LinearLayout)findViewById(R.id.mainActivityXML);
        colorNameText = (TextView)findViewById(R.id.textDisplay);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ColorFragment colorFragment = new ColorFragment();

        fragmentTransaction.add(R.id.fragment_container, colorFragment);
        fragmentTransaction.commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getThatColor(String colorName) {

        if(colorName.equals("RED")) {
            ourActivity.setBackgroundColor(Color.RED);
            colorNameText.setText("ReD");

        }
        else if (colorName.equals("GREEN"))
            ourActivity.setBackgroundColor(Color.GREEN);
        else if (colorName.equals("BLUE"))
            ourActivity.setBackgroundColor(Color.BLUE);

    }
}
