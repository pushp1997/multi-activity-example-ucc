package ml.pushp.multiactivityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends AppCompatActivity {

    // Widget objects
    private TextView nameTV;
    private ImageView personIV;
    private Button moreInfoBT;

    // Data
    private Person data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        // Wire objects with the widgets
        nameTV = findViewById(R.id.textView1);
        personIV = findViewById(R.id.imageView);
        moreInfoBT = findViewById(R.id.button);

        // Import the data
        data = new Person(
                "Pushp Vashisht",
                "WGB, UCC, Cork",
                "+353894890299",
                "pushp.png",
                "https://pushp.ml/"
        );

        // Populate widgets with data
        nameTV.setText(data.getName());
//        personIV.setImageResource(R.drawable.pushp);
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.lastIndexOf("."));
        int imageID = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        personIV.setImageResource(imageID);

        moreInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create and load the intent with data
                Intent intent = new Intent(PersonActivity.this, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}