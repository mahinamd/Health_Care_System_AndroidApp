package android.mahinahmed.health_care_system;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FindMedicineActivity extends AppCompatActivity {
    private EditText searchMedicineEditText;
    private Button searchButton;
    private ListView medicineListView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_medicine);

        searchMedicineEditText = findViewById(R.id.searchMedicineEditText);
        searchButton = findViewById(R.id.searchButton);
        medicineListView = findViewById(R.id.medicineListView);

        // Initialize adapter for medicine list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        medicineListView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = searchMedicineEditText.getText().toString().trim();
                searchMedicine(searchText);
            }
        });
    }

    private void searchMedicine(String searchText) {
        // Clear previous search results
        adapter.clear();

        // TODO: Implement search logic here, e.g. by querying a database or API
        // In this example, we will just add some dummy search results to the adapter
        if (searchText.equals("pain")) {
            adapter.add("Ibuprofen");
            adapter.add("Acetaminophen");
            adapter.add("Aspirin");
        } else if (searchText.equals("allergy")) {
            adapter.add("Benadryl");
            adapter.add("Claritin");
            adapter.add("Zyrtec");
        } else if (searchText.equals("cold")) {
            adapter.add("Nyquil");
            adapter.add("Dayquil");
            adapter.add("Robitussin");
        } else {
            adapter.add("No results found.");
        }

        // Notify adapter that data has changed
        adapter.notifyDataSetChanged();
    }

}
