package ro.pub.cs.systems.eim.test5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class test5MainActivity extends AppCompatActivity {

    private EditText textleft;
    private EditText textright;
    private CheckBox checkBoxleft;
    private CheckBox checkBoxright;
    private Button leftbutton;
    private Button rightbutton;
     private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private Button NavigateToSecondaryActivity;
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.left_button) {
                if (checkBoxleft.isChecked()) {
                    textleft.append(String.valueOf("north"));
                    textleft.append(String.valueOf(" "));
                }
            } else if (view.getId() == R.id.right_button) {
                if (checkBoxright.isChecked()) {
                    textright.append((String.valueOf("south")));
                    textright.append(String.valueOf(" "));
                }
            }
                if (view.getId() == R.id.button3) {
                    Intent intent = new Intent(getApplicationContext(), test5SecondaryActivity.class);

                    // aici text este un TextView sau EditText
                    String direction1 = textleft.getText().toString();
                    String direction2 = textright.getText().toString();


                    intent.putExtra("DIRECTION", direction1);
                    intent.putExtra("DIRECTION1", direction2);



                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test5_activity_main);
        checkBoxleft = findViewById(R.id.checkBox2);
        checkBoxright = findViewById(R.id.checkBox3);
        NavigateToSecondaryActivity = findViewById(R.id.button3);
        textleft = findViewById(R.id.left_edit);
        textright = findViewById(R.id.right_edit);
        leftbutton = findViewById(R.id.left_button);
        rightbutton = findViewById(R.id.right_button);
        textleft.setText(String.valueOf("left"));
        textright.setText(String.valueOf("right"));

        leftbutton.setOnClickListener(new ButtonClickListener());
        rightbutton.setOnClickListener(new ButtonClickListener());
        NavigateToSecondaryActivity.setOnClickListener(new ButtonClickListener());
    }
}