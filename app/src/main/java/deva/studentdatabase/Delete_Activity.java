package deva.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Activity extends AppCompatActivity {

    EditText editNameDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btnDelete = (Button) findViewById(R.id.btn_delete);
        editNameDelete = (EditText) findViewById(R.id.editNameDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rowsDeleted = MainActivity.databaseHelper.delete(editNameDelete.getText().toString());
                Toast.makeText(Delete_Activity.this, rowsDeleted+" rows deleted.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
