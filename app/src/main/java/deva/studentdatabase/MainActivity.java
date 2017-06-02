package deva.studentdatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button exit = (Button) findViewById(R.id.button);
        Button insert_activity = (Button) findViewById(R.id.btn_Insert_Activity);
        Button delete_activity = (Button) findViewById(R.id.btn_Delete_Activity);
        Button update_activity = (Button) findViewById(R.id.btn_Update_Activity);

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

        insert_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("deva.studentdatabase.Insert_Activity");
                startActivity(i);
            }
        });

        delete_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("deva.studentdatabase.Delete_Activity");
                startActivity(i);
            }
        });

        update_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("deva.studentdatabase.Update_Activity");
                startActivity(i);
            }
        });
    }
}
