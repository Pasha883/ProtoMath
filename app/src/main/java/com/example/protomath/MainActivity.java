package com.example.protomath;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editA, editB, editC;
    Button solve;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = findViewById(R.id.coefA);
        editB = findViewById(R.id.coefB);
        editC = findViewById(R.id.coefC);

        solve = findViewById(R.id.button);

        ans = findViewById(R.id.Ans);

        solve.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double a = 0, b = 0, c = 0;
                try {
                    a = Double.parseDouble(editA.getText().toString());
                    b = Double.parseDouble(editB.getText().toString());
                    c = Double.parseDouble(editC.getText().toString());
                }
                catch (Exception e){

                }

                if (a == 0){
                    Toast toast = Toast.makeText(v.getContext(), "A non-quadratic equation",Toast.LENGTH_SHORT);
                    toast.show();
                }

                double disk = (b * b) - (4 * a * c);
                if(disk < 0){
                    ans.setText("No answers!");
                }
                else if(disk == 0){
                    ans.setText(String.format(Locale.US,"%.2f",(-1 * b) / 2 * a));
                }
                else{
                    ans.setText(String.format(Locale.US,"%.2f",(-1 * b) + Math.sqrt(disk) / 2 * a) + " " +
                                String.format(Locale.US,"%.2f",(-1 * b) - Math.sqrt(disk) / 2 * a));
                }
            }
        });


    }
}