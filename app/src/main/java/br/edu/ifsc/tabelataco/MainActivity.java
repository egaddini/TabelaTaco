package br.edu.ifsc.tabelataco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLInput;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsc.tabelataco.models.Taco;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private RecyclerView recyclerView;
    private AppListAdapter adapter;
    private SQLiteHelper db;
    private EditText ed;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new SQLiteHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Taco> appList = db.getAlimentos();
        adapter = new AppListAdapter(appList, this);
        recyclerView.setAdapter(adapter);

        ed = findViewById(R.id.etItem);
        button = findViewById(R.id.busca);
    }

    public void buscaItem(View view) {
        List<Taco> appList = new ArrayList<>();
        int id = Integer.parseInt(ed.getText().toString());
        Taco taco = db.buscarRegistroPorId(id);
        if (taco != null) {
            appList.add(taco);
        }
        adapter = new AppListAdapter(appList, this);
        recyclerView.setAdapter(adapter);
    }




}