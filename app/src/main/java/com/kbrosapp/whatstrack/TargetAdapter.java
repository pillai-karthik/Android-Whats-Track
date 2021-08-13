package com.kbrosapp.whatstrack;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TargetAdapter extends RecyclerView.Adapter<TargetAdapter.TargetHolder> {
    private List<Target> targets = new ArrayList<>();
    ViewGroup parentForContext;
    public TargetViewModel targetViewModel;

    @NonNull
    @Override
    public TargetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.target_card, parent, false);
        parentForContext = parent;
        targetViewModel = ViewModelProviders.of((FragmentActivity) parentForContext.getContext()).get(TargetViewModel.class);

        return new TargetHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TargetHolder holder, int position) {
        final Target currentTarget = targets.get(position);
        holder.targetName.setText(currentTarget.getTarget_Name());
        holder.targetPhone.setText(currentTarget.getTarget_Phone());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parentForContext.getContext(), TargetDetailsActivity.class);
                intent.putExtra("NameOfTheClickedTarget", currentTarget.getTarget_Name());
                intent.putExtra("IdOfTheClickedTarget", currentTarget.getTarget_Id());
                parentForContext.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return targets.size();
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
        notifyDataSetChanged();
    }

    class TargetHolder extends RecyclerView.ViewHolder {
        private TextView targetName;
        private TextView targetPhone;

        public TargetHolder(@NonNull View itemView) {
            super(itemView);
            targetName = itemView.findViewById(R.id.targetName);
            targetPhone = itemView.findViewById(R.id.targetPhone);
        }
    }
}
