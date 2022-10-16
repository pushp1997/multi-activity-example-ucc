package ml.pushp.multiactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    // Declare widget objects
    private TextView nameTV;


    // Data
    private Person data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Wire widget objects
        nameTV = findViewById(R.id.textView2);

        // Get the data
        Intent intent = getIntent();
        data = (Person)intent.getExtras().getSerializable("data");

        // Populate widgets with data
        nameTV.setText(data.getName());

    }
}