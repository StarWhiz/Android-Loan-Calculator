package cs137.dbzgroup.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class LoanCalculator extends AppCompatActivity {

    //input
    String dataHomeValue, dataDownPayment, dataApr , dataTerms, dataTaxRate;
    Double dblHomeValue, dblDownPayment, dblDataApr, dblDataTerms, dblDataTaxRate;
    //output
    double resultTotalTax, resultTotalInterest, resultMonthlyPayment;
    String stringResultTotalTax, stringResultTotalInterest, stringResultMonthlyPayment;
    String resultDate;

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
                dataTerms = terms.getText().toString();
                dataTaxRate = taxRate.getText().toString();

                if (dataHomeValue.matches("") || dataDownPayment.matches("") ||
                        dataApr .matches("") || dataTerms.matches("") || dataTaxRate.matches("")){
                    Toast.makeText(getApplicationContext(), "Please complete all fields above 'Payment'", Toast.LENGTH_SHORT).show();
                }
                else {
                    System.out.println("not empty");


                    // Calculations here
                    dblHomeValue = Double.parseDouble(dataHomeValue); // P
                    dblDownPayment = Double.parseDouble(dataDownPayment);
                    dblDataApr = Double.parseDouble(dataApr)/100; //so we can input whole number in taht field
                    dblDataTerms = Double.parseDouble(dataTerms);
                    dblDataTaxRate = Double.parseDouble(dataTaxRate);

                    double principal = dblHomeValue - dblDownPayment;


                    double numberOfMonthlyPayments = dblDataTerms*12; // n
                    double monthlyInterestRate = dblDataApr / 12; // r
                    double numerator;
                    double denominator;
                    DecimalFormat df = new DecimalFormat("#.##");

                    numerator = monthlyInterestRate * Math.pow((1+monthlyInterestRate),numberOfMonthlyPayments);
                    denominator = Math.pow((1+monthlyInterestRate),numberOfMonthlyPayments) -1;
                    resultMonthlyPayment = principal * (numerator/denominator);

                    //stringResultMonthlyPayment = Double.toString(resultMonthlyPayment);
                    stringResultMonthlyPayment = df.format(resultMonthlyPayment); //makes it 2 decimal places

                    monthlyPayment.setText(stringResultMonthlyPayment);





                    resultTotalInterest = dblHomeValue*dblDataApr;
                    stringResultTotalInterest = Double.toString(resultTotalInterest);
                    totalInterest.setText(stringResultTotalInterest);
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
