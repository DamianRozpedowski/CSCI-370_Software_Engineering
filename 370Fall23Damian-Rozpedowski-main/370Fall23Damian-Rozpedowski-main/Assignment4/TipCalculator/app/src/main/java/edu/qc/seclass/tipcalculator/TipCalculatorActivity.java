package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TipCalculatorActivity extends AppCompatActivity {
    private EditText checkAmountText;
    private EditText partySizeText;
    private Button buttonCompute;
    private TextView fifteenPercentTipText;
    private TextView twentyPercentTipText;
    private TextView twentyfivePercentTipText;
    private TextView fifteenPercentTotalText;
    private TextView twentyPercentTotalText;
    private TextView twentyfivePercentTotalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountText = findViewById(R.id.checkAmountValue);
        partySizeText = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);
        fifteenPercentTipText = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipText = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipText = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalText = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalText = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalText = findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkAmountString = checkAmountText.getText().toString();
                String partySizeString = partySizeText.getText().toString();
                // When either inputs are empty
                if (checkAmountString.isEmpty() || partySizeString.isEmpty()) {
                    showToast("Empty input.");
                    return;
                }

                double checkAmount = Double.parseDouble(checkAmountString);
                int partySize = Integer.parseInt(partySizeString);
                // Check amount will likely never go below 0 since it doesn't take negatives
                if (checkAmount < 0 || partySize < 1) {
                    showToast("Invalid input.");
                    return;
                }

                int fifteenPercentTip = computeTip(checkAmount, 0.15, partySize);
                int twentyPercentTip = computeTip(checkAmount, 0.20, partySize);
                int twentyfivePercentTip = computeTip(checkAmount, 0.25, partySize);
                int fifteenPercentTotal = computeTotal(checkAmount, 0.15, partySize);
                int twentyPercentTotal = computeTotal(checkAmount, 0.20, partySize);
                int twentyfivePercentTotal = computeTotal(checkAmount, 0.25, partySize);

                fifteenPercentTipText.setText(String.valueOf(fifteenPercentTip));
                twentyPercentTipText.setText(String.valueOf(twentyPercentTip));
                twentyfivePercentTipText.setText(String.valueOf(twentyfivePercentTip));
                fifteenPercentTotalText.setText(String.valueOf(fifteenPercentTotal));
                twentyPercentTotalText.setText(String.valueOf(twentyPercentTotal));
                twentyfivePercentTotalText.setText(String.valueOf(twentyfivePercentTotal));
            }
        });
    }

    private void showToast(String msg) {
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
    private int computeTip(double amount, double tipPercent, int partySize) {
        double tipAmount = (amount * tipPercent) / partySize;
        return (int) Math.ceil(tipAmount);
    }
    private int computeTotal(double amount, double tipPercent, int partySize) {
        double totalAmount = (amount + (amount*tipPercent)) / partySize;
        return (int) Math.ceil(totalAmount);
    }
}