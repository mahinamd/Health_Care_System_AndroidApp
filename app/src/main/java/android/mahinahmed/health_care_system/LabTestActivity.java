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
import java.util.List;

public class LabTestActivity extends AppCompatActivity {

    private EditText searchEditText;
    private ListView labListView;
    private Button searchButton;
    private ArrayAdapter<String> adapter;
    private List<String> labTests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        // Initialize views
        searchEditText = findViewById(R.id.searchLabEditText);
        labListView = findViewById(R.id.labListView);
        searchButton = findViewById(R.id.searchButton);

        // Set up lab test list
        String[] labTestsArray = getResources().getStringArray(R.array.lab_tests);
        labTests = new ArrayList<>(Arrays.asList(labTestsArray));
        labTests.add("Blood glucose test");
        labTests.add("Thyroid function test");
        labTests.add("Complete blood count (CBC)");
        labTests.add("Lipid panel");
        labTests.add("Blood Count Tests");
        labTests.add("Genetic Testing");
        labTests.add("Kidney Tests");
        labTests.add("Laboratory Tests");
        labTests.add("Prenatal Testing");
        labTests.add("Thyroid Tests");
        labTests.add("Urinalysis");
        labTests.add("Pregnancy test");
        labTests.add("Thoracentesis");



        // Set up adapter and list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, labTests);
        labListView.setAdapter(adapter);

        // Set up search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String searchQuery = charSequence.toString().toLowerCase();
                List<String> filteredLabTests = new ArrayList<>();

                for (String labTest : labTests) {
                    if (labTest.toLowerCase().contains(searchQuery)) {
                        filteredLabTests.add(labTest);
                    }
                }

                adapter.clear();
                adapter.addAll(filteredLabTests);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Set up item click listener
        labListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedLabTest = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(LabTestActivity.this, "You clicked " + selectedLabTest, Toast.LENGTH_SHORT).show();
            }
        });

        // Set up search button click listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchQuery = searchEditText.getText().toString().toLowerCase();
                List<String> filteredLabTests = new ArrayList<>();

                for (String labTest : labTests) {
                    if (labTest.toLowerCase().contains(searchQuery)) {
                        filteredLabTests.add(labTest);
                    }
                }

                adapter.clear();
                adapter.addAll(filteredLabTests);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
