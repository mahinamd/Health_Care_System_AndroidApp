package android.mahinahmed.health_care_system;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TakeAppointmentActivity extends Activity {

    private EditText doctorNameEditText;
    private TextView appointmentDateTextView;
    private CalendarView calendarView;
    private Button confirmButton;
    private ListView appointmentsListView;

    private ArrayList<String> appointmentsList;
    private ArrayAdapter<String> appointmentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_appointment);

        doctorNameEditText = findViewById(R.id.doctorNameEditText);
        appointmentDateTextView = findViewById(R.id.appointmentDateTextView);
        calendarView = findViewById(R.id.calendarView);
        confirmButton = findViewById(R.id.confirmButton);
        appointmentsListView = findViewById(R.id.appointmentsListView);

        appointmentsList = new ArrayList<>();
        appointmentsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appointmentsList);
        appointmentsListView.setAdapter(appointmentsAdapter);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                appointmentDateTextView.setText(String.format("%d/%d/%d", dayOfMonth, month + 1, year));
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctorName = doctorNameEditText.getText().toString();
                String appointmentDate = appointmentDateTextView.getText().toString();

                if (!doctorName.isEmpty() && !appointmentDate.isEmpty()) {
                    String appointment = String.format("%s - %s", doctorName, appointmentDate);
                    appointmentsList.add(appointment);
                    appointmentsAdapter.notifyDataSetChanged();

                    Toast.makeText(TakeAppointmentActivity.this, "Appointment saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TakeAppointmentActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        appointmentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String appointment = appointmentsList.get(position);
                Toast.makeText(TakeAppointmentActivity.this, appointment, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
