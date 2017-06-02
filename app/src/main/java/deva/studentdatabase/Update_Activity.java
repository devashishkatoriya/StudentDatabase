package deva.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Activity extends AppCompatActivity {

    private EditText oldRoll,newName,newMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        oldRoll = (EditText) findViewById(R.id.editRollUpdate);
        newName = (EditText) findViewById(R.id.editNameUpdate);
        newMarks = (EditText) findViewById(R.id.editMarksUpdate);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btnUpdate = (Button) findViewById(R.id.update_btn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rowsUpdated = MainActivity.databaseHelper.update(Integer.parseInt(oldRoll.getText().toString()),
                        newName.getText().toString(),
                        Integer.parseInt(newMarks.getText().toString()));
                Toast.makeText(Update_Activity.this, rowsUpdated+" rows updated.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
