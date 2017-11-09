package cs137.dbzgroup.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoanCalculator extends AppCompatActivity {

    //input
    String dataHomeValue, dataDownPayment, dataApr , dataTerms, dataTaxRate;
    //output
    double datatotalTax, datatotalInterest, datamonthlyPayment;
    String dataDate;

    //EditTextViews
    EditText homeValue, downPayment, apr, terms, taxRate;
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

        totalTax = (TextView) findViewById(R.id.totalTaxNumbers);
        totalInterest = (TextView) findViewById(R.id.totalInterestNumbers);
        monthlyPayment = (TextView) findViewById(R.id.monthlyPaymentNumbers);
        date = (TextView) findViewById(R.id.payOffDateNumbers);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        //OnClickListener for Calculate
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                dataHomeValue = homeValue.getText().toString();
                dataDownPayment = downPayment.getText().toString();
                dataApr = apr.getText().toString();
                dataTerms =
                dataTaxRate = taxRate.getText().toString();

                if (dataHomeValue.matches("") || dataDownPayment.matches("") ||
                        dataApr .matches("") || dataTerms.matches("") || dataTaxRate.matches("")){

                    Toast.makeText(getApplicationContext(), "Please complete all fields above 'Payment'", Toast.LENGTH_SHORT).show();
                }
                else {
                    System.out.println("not empty");
                }

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
                totalTax.setText("");
                totalInterest.setText("");
                monthlyPayment.setText("");
                date.setText("");

                Toast.makeText(getApplicationContext(), "All fields cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
