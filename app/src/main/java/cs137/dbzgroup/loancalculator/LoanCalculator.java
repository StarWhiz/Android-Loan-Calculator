package cs137.dbzgroup.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        //Linking widgets to View...
        homeValue = (EditText) findViewById(R.id.homeValue);
        downPayment = (EditText) findViewById(R.id.downPayment);
        apr = (EditText) findViewById(R.id.apr);
        taxRate = (EditText) findViewById(R.id.taxRate);
        terms = (EditText) findViewById(R.id.terms);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);
    }
}
