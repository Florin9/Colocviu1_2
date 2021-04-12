package ro.pub.cs.systems.eim.colocviu1_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ro.pub.cs.systems.eim.colocviu1_2.general.Constants;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.COMPUTE_STRING)) {
            String computeString = intent.getStringExtra(Constants.COMPUTE_STRING);
            String[] arrOfStr = computeString.split("\\+");
            int result = 0;
            for (String s:arrOfStr) {
                System.out.println(s);
                if(!s.equals("")) {
                    result += Integer.valueOf(s.trim());
                }
            }
            setResult(result, null);
            finish();
        }

    }
}
