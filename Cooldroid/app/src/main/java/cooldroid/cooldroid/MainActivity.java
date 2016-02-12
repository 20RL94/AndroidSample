package cooldroid.cooldroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textViewmessage;
    private ImageView imageViewdroid;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeApp();
    }


    private void initializeApp() {
        textViewmessage = (TextView) findViewById(R.id.textview_droid_output_text);
        imageViewdroid = (ImageView) findViewById(R.id.imageView);
        imageViewdroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touchDroid();
            }
        });

    }

    private void touchDroid() {
        counter++;
        String temp = getStringForDisplay(counter);
        textViewmessage.setText(String.format("You touched the droid %s", temp));
        if (counter == 10) {
            TextView tV = (TextView) findViewById(R.id.textView_welcome_text);
            tV.setText("I'm so MAD!");
            imageViewdroid.setImageResource(R.drawable.maddroid);
        }
        if (counter == 20) {
            TextView tV = (TextView) findViewById(R.id.textView_welcome_text);
            tV.setText("GET REKT APPLE!");
            imageViewdroid.setImageResource(R.drawable.androidpiss);
        }
    }

    private String getStringForDisplay(int counter) {

        String temp;
        switch (counter) {
            case 1:
                temp = "once";
                break;
            case 2:
                temp = "twice";
                break;
            default:
                temp = String.format("%d times", counter);

        }
        return temp;
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
}
