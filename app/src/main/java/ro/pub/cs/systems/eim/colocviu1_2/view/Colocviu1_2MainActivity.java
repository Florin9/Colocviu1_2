package ro.pub.cs.systems.eim.colocviu1_2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ro.pub.cs.systems.eim.colocviu1_2.R;
import ro.pub.cs.systems.eim.colocviu1_2.general.Constants;

public class Colocviu1_2MainActivity extends AppCompatActivity {
    private EditText nextTermEditText;
    private EditText allTermsEditText;
    private Button addButton, computeButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String inputString = nextTermEditText.getText().toString();
            nextTermEditText.setText("");
            int inputNumber = Integer.valueOf(inputString);
            String allTerms = allTermsEditText.getText().toString();

            switch(view.getId()) {
                case R.id.add_button:
                    if (allTerms.equals("")){
                        String newString = String.valueOf(inputNumber);
                        allTermsEditText.setText(newString);
                        break;
                    } else {
                        String newString = allTerms + " + " + inputNumber;
                        allTermsEditText.setText(newString);
                        break;
                    }

                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);
                    String computeString = allTermsEditText.getText().toString();
                    intent.putExtra(Constants.COMPUTE_STRING, computeString);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        nextTermEditText = (EditText)findViewById(R.id.next_term_edit_text);
        allTermsEditText = (EditText)findViewById(R.id.all_terms_edit_text);
        addButton = (Button)findViewById(R.id.add_button);
        addButton.setOnClickListener(buttonClickListener);
        computeButton = (Button)findViewById(R.id.compute_button);
        computeButton.setOnClickListener(buttonClickListener);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The computed value is: " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
