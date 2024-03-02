package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;
import java.util.List;

public class PersonalDashboardActivity extends AppCompatActivity {

    private EditText searchBar;
    private LinearLayout parentLayout;
    private List<Employee> defaultEmployees;
    private ImageButton homeButton;
    private ImageButton personalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_dashboard);
        homeButton = findViewById(R.id.imageButton);
        personalButton = findViewById(R.id.imageButton2);
        // Initialize views
        searchBar = findViewById(R.id.search_bar);
        parentLayout = findViewById(R.id.parent_layout); // Or any other appropriate layout that you want to add the card views to.


        // Initialize default employee list
        defaultEmployees = getDefaultEmployees();

        // Populate card views for default employees
        populateCardViews(defaultEmployees);

        // Set text change listener for search bar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                // Filter employees based on search query
                String query = s.toString().toLowerCase().trim();
                List<Employee> filteredEmployees = new ArrayList<>();
                for (Employee employee : defaultEmployees) {
                    if (employee.getName().toLowerCase().contains(query)) {
                        filteredEmployees.add(employee);
                    }
                }
                // Clear previous card views
                parentLayout.removeAllViews();
                // Populate card views for filtered employees or show "No records found" if no match
                if(filteredEmployees.isEmpty()) {
                    // Show "No records found" message
                    showNoRecordsFound();
                } else {
                    // Populate card views for filtered employees
                    populateCardViews(filteredEmployees);
                }
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalDashboardActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        personalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalDashboardActivity.this, PersonalDashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to initialize default employee list
    private List<Employee> getDefaultEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,101, "John Doe", "25/05/1980", "Manager"));
        employees.add(new Employee(2,102, "Jane Smith", "15/08/1985", "Developer"));
        employees.add(new Employee(3,103, "Alice Johnson", "10/12/1978", "Designer"));
        employees.add(new Employee(4,104, "Bob Brown", "03/04/1990", "Engineer"));
        employees.add(new Employee(5,105, "Eva Lee", "20/11/1982", "Analyst"));
        return employees;
    }

    // Method to populate card views with employee details
    private void populateCardViews(List<Employee> employees) {
        for (Employee employee : employees) {
            // Inflate card view layout
            CardView cardView = (CardView) getLayoutInflater().inflate(R.layout.employee_card, null);

            // Find views within card view
            TextView snoTextView=cardView.findViewById(R.id.sno);
            TextView empIdTextView = cardView.findViewById(R.id.empid);
            TextView nameTextView = cardView.findViewById(R.id.name);
            TextView dobTextView = cardView.findViewById(R.id.dob);
            TextView roleTextView = cardView.findViewById(R.id.role);
            // Set employee details
            snoTextView.setText(String.valueOf(employee.getsno()));
            empIdTextView.setText("Emp ID: " + employee.getEmpId());
            nameTextView.setText("Name: " + employee.getName());
            dobTextView.setText("DOB: " + employee.getDob());
            roleTextView.setText("Role: " + employee.getRole());
            // Add card view to parent layout
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(0, 0, 0, 16); // Adjust the margin as needed
            cardView.setLayoutParams(layoutParams);
            parentLayout.addView(cardView);
        }
    }

    // Method to show "No records found" message
    private void showNoRecordsFound() {
        TextView noRecordsTextView = new TextView(this);
        noRecordsTextView.setText("No records found");
        parentLayout.addView(noRecordsTextView);
    }

}


