package deva.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert_Activity extends AppCompatActivity {

    private EditText editName,editRoll,editMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editMarks = (EditText) findViewById(R.id.editText_marks);
        editName = (EditText) findViewById(R.id.editText_name);
        editRoll = (EditText) findViewById(R.id.editText_roll);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button add = (Button) findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = MainActivity.databaseHelper.insert(Integer.parseInt(editRoll.getText().toString()),
                        editName.getText().toString(),
                        Integer.parseInt(editMarks.getText().toString()));
                if(result==true)
                    Toast.makeText(Insert_Activity.this, "Entry Successfully added!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Insert_Activity.this, "Oops! Entry was not added.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
