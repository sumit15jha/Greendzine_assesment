package com.example.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_dashboard, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.bind(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private TextView empIdTextView;
        private TextView nameTextView;
        private TextView dobTextView;
        private TextView roleTextView;
        private CardView cardView;
        private TextView sno;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            sno=itemView.findViewById(R.id.sno);
            empIdTextView = itemView.findViewById(R.id.empid);
            nameTextView = itemView.findViewById(R.id.name);
            dobTextView = itemView.findViewById(R.id.dob);
            roleTextView = itemView.findViewById(R.id.role);

        }

        public void bind(Employee employee) {
            sno.setText(String.valueOf(sno));
            empIdTextView.setText("Emp ID: " + employee.getEmpId());
            nameTextView.setText("Name: " + employee.getName());
            dobTextView.setText("DOB: " + employee.getDob());
            roleTextView.setText("Role: " + employee.getRole());
        }
    }
}
