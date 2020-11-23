package com.nexstacks.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeListHolder> {

    private Context context;
    private ArrayList<Employee> employeeList;

    private EmployeeClickListener listener;

    public EmployeeListAdapter(Context context, ArrayList<Employee> employees){
        this.context = context;
        this.employeeList = employees;
    }

    public void setListener(EmployeeClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmployeeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeListHolder holder = new EmployeeListHolder(LayoutInflater.from(context).inflate(R.layout.cell_employee_info, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeListHolder holder, int position) {
        final Employee currentEmployee = employeeList.get(position);

        holder.mTvEmpID.setText(currentEmployee.getEmployeeID());
        holder.mTvEmpName.setText(currentEmployee.getEmployeeName());
        holder.mTvEmpDesgn.setText(currentEmployee.getEmployeeDesignation());
        holder.mTvEmpMob.setText(String.valueOf(currentEmployee.getEmployeePhoneNumber()));

        holder.mLlEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onEditEmployeeClicked(currentEmployee);
                }
            }
        });

        holder.mLlDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onDeleteEmployeeClicked(currentEmployee);
                }
            }
        });
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

        private LinearLayout mLlEdit;
        private LinearLayout mLlDelete;

        public EmployeeListHolder(@NonNull View itemView) {
            super(itemView);

            mTvEmpID = itemView.findViewById(R.id.tv_emp_id);
            mTvEmpName = itemView.findViewById(R.id.tv_emp_name);
            mTvEmpMob = itemView.findViewById(R.id.tv_emp_phone);
            mTvEmpDesgn = itemView.findViewById(R.id.tv_emp_desgn);

            mLlEdit = itemView.findViewById(R.id.ll_emp_edit);
            mLlDelete = itemView.findViewById(R.id.ll_emp_delete);
        }
    }

    public interface EmployeeClickListener{
        void onEditEmployeeClicked(Employee employee);
        void onDeleteEmployeeClicked(Employee employee);
    }
}
