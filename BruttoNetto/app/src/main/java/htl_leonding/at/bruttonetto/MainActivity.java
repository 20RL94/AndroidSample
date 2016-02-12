package htl_leonding.at.bruttonetto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nettoValue;
    private EditText bruttoValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initApp();
    }

    private void initApp() {

        Button button = (Button) findViewById(R.id.calcButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nettoValue = (EditText) findViewById(R.id.nettoValue);
                if (nettoValue.getText() != null) {
                    calculateBrutto(nettoValue);
                }

            }
        });
    }

    private void calculateBrutto(EditText nettoValue) {
        double netto = Double.parseDouble(nettoValue.getText().toString());
        double brutto = netto * 1.151;
        bruttoValue = (EditText) findViewById(R.id.bruttoValue);
        bruttoValue.setText(String.format("%s", String.valueOf(brutto)));

    }


}
