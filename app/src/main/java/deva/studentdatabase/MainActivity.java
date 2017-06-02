package deva.studentdatabase;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText editName,editRoll,editMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        editMarks = (EditText) findViewById(R.id.editText_marks);
        editName = (EditText) findViewById(R.id.editText_name);
        editRoll = (EditText) findViewById(R.id.editText_roll);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button exit = (Button) findViewById(R.id.button);
        Button add = (Button) findViewById(R.id.button2);
        Button btnDelete = (Button) findViewById(R.id.button3);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setMessage("Are you sure you want to exit ?")
                        .setCancelable(false)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, R.string.thank_you, Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            }
                        });

                AlertDialog alert = a.create();
                alert.setTitle("Alert!");
                alert.show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = databaseHelper.insert(Integer.parseInt(editRoll.getText().toString()),
                        editName.getText().toString(),
                        Integer.parseInt(editMarks.getText().toString()));
                if(result==true)
                    Toast.makeText(MainActivity.this, "Entry Successfully added!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Oops! Entry was not added.", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rowsDeleted = databaseHelper.delete(editName.getText().toString());
                Toast.makeText(MainActivity.this, rowsDeleted+" rows deleted.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
