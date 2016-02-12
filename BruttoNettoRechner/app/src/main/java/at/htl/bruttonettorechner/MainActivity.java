package at.htl.bruttonettorechner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinner_steuer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tax_arrays,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.button_Result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup_Selection);
                int checked = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(checked);
                int selectedVal = getResources().getIntArray(R.array.taxvalue_array)[spinner.getSelectedItemPosition()];
                TextView textView = (TextView) findViewById(R.id.textView_Result);
                EditText editText = (EditText) findViewById(R.id.editText_Betrag);

                if (editText.getText() != null) {
                    int value = Integer.parseInt(editText.getText().toString());
                    if (radioButton.getText().equals("Netto")) {
                        textView.setText("Brutto: "+ value +"\n"
                                +"Netto: "+calculateNetto(value,selectedVal)+"\n"+"Umsatzsteuer: "+ selectedVal);
                    } else {
                        textView.setText("Netto: "+ value +"\n"
                                +"Brutto: "+calculateBrutto(value,selectedVal)+"\n"+"Umsatzsteuer: "+ selectedVal);
                    }
                }

            }
        });

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private double calculateNetto(int value, int selectedVal) {
        double brutto = value;
        double netto = brutto * (100 - selectedVal);
        return netto/100;
    }

    private double calculateBrutto(int value,int selVal) {
        double netto = value;
        double brutto = netto * (100 + selVal);
        return brutto/100;
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
