package sg.edu.rp.c346.id22021136.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    EditText name;
    EditText mobileNo;
    EditText numPax;
    RadioGroup rgTableArea;
    Button btnConfirm;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        name = findViewById(R.id.editName);
        mobileNo = findViewById(R.id.editMobileNo);
        numPax = findViewById(R.id.editNumPax);
        rgTableArea = findViewById(R.id.tableSelect);
        btnConfirm = findViewById(R.id.Confirm);
        btnReset = findViewById(R.id.Reset);

        
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numofpax = Integer.parseInt(numPax.getText().toString());
                int checkedRadioId = rgTableArea.getCheckedRadioButtonId();
                int year = dp.getYear();
                int month = dp.getMonth();
                int day = dp.getDayOfMonth();
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                if (numofpax > 0) {
                    Toast.makeText(getApplicationContext(), "Booked table for:" + numofpax, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Reservation date: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Reservation time: " + hour + " : " + min, Toast.LENGTH_SHORT).show();

                if (checkedRadioId == R.id.tableSelect) {
                    Toast.makeText(getApplicationContext(), "Reserved for smoking table", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Reserved for Non-smoking table", Toast.LENGTH_SHORT).show();
                }

            }
        });








        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                mobileNo.setText("");
                numPax.setText("");
                rgTableArea.clearCheck();
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,6 - 1,1);
            }
        });




    }
}