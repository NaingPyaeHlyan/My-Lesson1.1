package mm.com.fairway.mylesson11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton myToggle = (ToggleButton)findViewById(R.id.termsToggle);
        myToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            //    TextView myText = (TextView)findViewById(R.id.displayCheckBox);
                if (isChecked){
                    Toast toast = Toast.makeText(getApplicationContext(),"I agree with the Terms and Conditions", Toast.LENGTH_LONG);
                    toast.show();
                //    myText.setText("I agree with the Terms and Conditions");
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(),"I do not agree with the Terms and Coditions",Toast.LENGTH_LONG);
                    toast.show();
                //    myText.setText("I do not agree with the Terms and Conditions");
                }
            }
        });
    }

    public void displaySecondActivity(View view){

    }
    //------------------------------------------------------------------------------------------------------
    // For Radio Group
//------------------------------------------------------------------------------------------------------
    public void getSelectedRadioButton(View view){
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.paymentMethod);
        int radioID= radioGroup.getCheckedRadioButtonId();
        RadioButton singleButton = (RadioButton)findViewById(radioID);

        TextView myDisplay = (TextView)findViewById(R.id.displayRadioButton);
        myDisplay.setText(singleButton.getText());
    }

    public void getSelectedCheckBoxes(View view){
        CheckBox checkJava = (CheckBox)findViewById(R.id.checkBoxJava);
        CheckBox checkAndroid = (CheckBox)findViewById(R.id.checkBoxAndroid);
        CheckBox checkCSharp = (CheckBox)findViewById(R.id.checkBoxCSharp);

        String displayMessage="";
        String totalMessage="Total Sales=";
        int totalSales=0;

        if (checkJava.isChecked()){
            displayMessage = displayMessage + checkJava.getText() + "\n";
            totalSales = totalSales + 30;
        }
        if (checkAndroid.isChecked()){
            displayMessage = displayMessage + checkAndroid.getText() + "\n";
            totalSales = totalSales + 20;
        }
        if (checkCSharp.isChecked()){
            displayMessage = displayMessage + checkCSharp.getText() + "\n";
            totalSales = totalSales + 30;
        }

        TextView myDisplay = (TextView) findViewById(R.id.displayCheckBox);
        myDisplay.setText(String.format(Locale.ENGLISH,"%s %s %d", displayMessage, totalMessage, totalSales));
    }
}

