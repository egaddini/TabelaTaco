package br.edu.ifsc.tabelataco;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

import br.edu.ifsc.tabelataco.models.Taco;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {
    private List<Taco> appList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView appNameTextView, ide;

        public ViewHolder(View itemView) {
            super(itemView);
            appNameTextView = itemView.findViewById(R.id.appNameTextView);
            ide = itemView.findViewById(R.id.id);
        }
    }

    public AppListAdapter(List<Taco> appList, Context context) {
        this.appList = appList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Taco appInfo = appList.get(position);
        holder.appNameTextView.setText(appInfo.getAlimento());
        holder.ide.setText(appInfo.getId().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExibirDadosAlimento.class);
                intent.putExtra("id", appInfo.getId());
                context.startActivity(intent);
                Toast.makeText(context, "Unable to launch the app", Toast.LENGTH_SHORT).show();
                //launchApp(appInfo.getPackageName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    private void launchApp(String packageName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Unable to launch the app", Toast.LENGTH_SHORT).show();
        }
    }
}