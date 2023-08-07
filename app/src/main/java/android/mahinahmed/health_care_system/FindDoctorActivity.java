package android.mahinahmed.health_care_system;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDoctorActivity extends AppCompatActivity {

    private EditText searchDoctorEditText;
    private Button searchButton;
    private ListView doctorListView;
    private ArrayAdapter<String> listViewAdapter;
    private ArrayList<String> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // Get references to the UI components
        searchDoctorEditText = findViewById(R.id.searchDoctorEditText);
        searchButton = findViewById(R.id.searchButton);
        doctorListView = findViewById(R.id.doctorListView);

        // Initialize the doctor list
        doctorList = new ArrayList<>(Arrays.asList("Dr. John Smith (Cardiologist)", "Dr. Sarah Lee (Dermatologist)",
                "Dr. David Chen (Neurologist)", "Dr. Emily Wong (Pediatrician)", "Dr. Michael Davis (Oncologist)",
                "Dr. Lisa Patel (Endocrinologist)", "Dr. Andrew Kim (Psychiatrist)", "Dr. Jessica Lee (Gynecologist)",
                "Dr. Matthew Lee (Family Physician)", "Dr. Michelle Brown (Orthopedist)"));

        // Set up the ListView adapter
        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doctorList);
        doctorListView.setAdapter(listViewAdapter);

        // Set up the search functionality
        searchDoctorEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Filter the doctor list based on the search text
                listViewAdapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Set up the ListView item click listener
        doctorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Display a toast message with the selected doctor's name
                Toast.makeText(getApplicationContext(), "You selected " + doctorList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
