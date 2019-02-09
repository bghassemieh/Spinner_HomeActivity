package cejv669.concordia.com.spinner_homeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ed_price = findViewById(R.id.edtxt_price);
        final Spinner sp_tip = findViewById(R.id.spinner_TIP);
        final TextView tv_result = findViewById(R.id.txt_result);
        Button b = findViewById(R.id.btn_calc);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double price = Double.parseDouble(ed_price.getText().toString());
                String spinner_value = sp_tip.getSelectedItem().toString();
                double tipAmount = 0.0;

                switch (spinner_value) {
                    case "Great service - 25%":
                        tipAmount = 0.25;
                        break;
                    case "Normal Service - 20%":
                        tipAmount = 0.2;
                        break;
                    case "Not that great - 15%":
                        tipAmount = 0.15;
                        break;
                    case "Not good - 10%":
                        tipAmount = 0.1;
                        break;
                }

                NumberFormat currency = NumberFormat.getCurrencyInstance();
                tv_result.setText(currency.format(tipAmount * price));
            }
        });

    }
}