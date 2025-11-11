package ro.pub.cs.systems.eim.test5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ro.pub.cs.systems.eim.test5.R;

public class test5SecondaryActivity extends AppCompatActivity {
    private EditText text11;
    private EditText text22;
    private Button sum;
    private Button prod;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.button)
                setResult(RESULT_OK, null);
            else if (view.getId() == R.id.button11)
                setResult(RESULT_CANCELED, null);
            finish();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5secondaryactivity);
        Intent intent = getIntent();
        text11 = findViewById(R.id.buton44);
        text22 = findViewById(R.id.buton33);

        sum = findViewById(R.id.button);
        prod = findViewById(R.id.button11);

        if (intent != null && intent.getExtras() != null) {
            String direction = getIntent().getStringExtra("DIRECTION");
            text11.setText(direction);
            String direction1 = getIntent().getStringExtra("DIRECTION1");
            text22.setText(direction1);
        }

        sum = (Button) findViewById(R.id.button);
        sum.setOnClickListener(buttonClickListener);
        prod = (Button) findViewById(R.id.button11);
        prod.setOnClickListener(buttonClickListener);
        sum.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            int resultsum = Integer.parseInt(text11.getText().toString()) + Integer.parseInt(text22.getText().toString());
            resultIntent.putExtra("pressedButton", resultsum);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        prod.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            int resultprod = Integer.parseInt(text11.getText().toString()) * Integer.parseInt(text22.getText().toString());
            resultIntent.putExtra("pressedButton", resultprod);
            setResult(RESULT_CANCELED, resultIntent);
            finish();
        });

    }
}