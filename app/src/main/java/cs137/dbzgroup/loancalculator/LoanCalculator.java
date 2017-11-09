package cs137.dbzgroup.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoanCalculator extends AppCompatActivity {

    //input
    double dataHomeValue, dataDownPayment, dataApr , dataTaxRate;
    int dataTerms;
    //output
    double datatotalTax, datatotalInterest, datamonthlyPayment;
    String dataDate;

    //EditTextViews
    EditText homeValue, downPayment, apr, taxRate, terms;
    TextView totalTax, totalInterest, monthlyPayment, date;
    Button calculateButton, resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator); //LOAD THIS LAYOUT

        //Linking widgets to View...
        homeValue = (EditText) findViewById(R.id.homeValue);
        downPayment = (EditText) findViewById(R.id.downPayment);
        apr = (EditText) findViewById(R.id.apr);
        taxRate = (EditText) findViewById(R.id.taxRate);
        terms = (EditText) findViewById(R.id.terms);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        resetButton = (Button) findViewById(R.id.resetButton);


        //OnClickListener for Calculate
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                System.out.println("calc was pressed");

            }
        });


        //OnClickListener for Reset
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                homeValue.getText().clear();
                downPayment.getText().clear();
                apr.getText().clear();
                taxRate.getText().clear();
                terms.getText().clear();

                System.out.println("reset was pressed");
            }
        });
    }
}
