package com.nexstacks.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeListHolder> {

    private Context context;
    private ArrayList<Employee> employeeList;

    public EmployeeListAdapter(Context context, ArrayList<Employee> employees){
        this.context = context;
        this.employeeList = employees;
    }

    @NonNull
    @Override
    public EmployeeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeListHolder holder = new EmployeeListHolder(LayoutInflater.from(context).inflate(R.layout.cell_employee_info, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeListHolder holder, int position) {
        Employee currentEmployee = employeeList.get(position);

        holder.mTvEmpID.setText(currentEmployee.getEmployeeID());
        holder.mTvEmpName.setText(currentEmployee.getEmployeeName());
        holder.mTvEmpDesgn.setText(currentEmployee.getEmployeeDesignation());
        holder.mTvEmpMob.setText(String.valueOf(currentEmployee.getEmployeePhoneNumber()));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeListHolder extends RecyclerView.ViewHolder{

        private TextView mTvEmpID;
        private TextView mTvEmpName;
        private TextView mTvEmpMob;
        private TextView mTvEmpDesgn;

        public EmployeeListHolder(@NonNull View itemView) {
            super(itemView);

            mTvEmpID = itemView.findViewById(R.id.tv_emp_id);
            mTvEmpName = itemView.findViewById(R.id.tv_emp_name);
            mTvEmpMob = itemView.findViewById(R.id.tv_emp_phone);
            mTvEmpDesgn = itemView.findViewById(R.id.tv_emp_desgn);
        }
    }
}
