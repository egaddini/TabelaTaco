package br.edu.ifsc.tabelataco;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsc.tabelataco.models.Taco;

public class ExibirDadosAlimento extends AppCompatActivity {

    SQLiteHelper db;
    private TextView ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11, ed12, ed13, ed14, ed15,
            ed16, ed17, ed18, ed19, ed20, ed21, ed22, ed23, ed24, ed25, ed26, ed27, ed28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dados_alimentos);
        Bundle bundle  = getIntent().getExtras();
        Integer id = bundle.getInt("id");
        db = new SQLiteHelper(this);
        Taco taco = db.buscarRegistroPorId(id);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        ed7 = findViewById(R.id.ed7);
        ed8 = findViewById(R.id.ed8);
        ed9 = findViewById(R.id.ed9);
        ed10 = findViewById(R.id.ed20);
        ed11 = findViewById(R.id.ed11);
        ed12 = findViewById(R.id.ed12);
        ed13 = findViewById(R.id.ed13);
        ed14 = findViewById(R.id.ed14);
        ed15 = findViewById(R.id.ed15);
        ed16 = findViewById(R.id.ed16);
        ed17 = findViewById(R.id.ed17);
        ed18 = findViewById(R.id.ed18);
        ed19 = findViewById(R.id.ed19);
        ed20 = findViewById(R.id.ed20);
        ed21 = findViewById(R.id.ed21);
        ed22 = findViewById(R.id.ed22);
        ed23 = findViewById(R.id.ed23);
        ed24 = findViewById(R.id.ed24);
        ed25 = findViewById(R.id.ed25);
        ed26 = findViewById(R.id.ed26);
        ed27 = findViewById(R.id.ed27);
        ed28 = findViewById(R.id.ed28);

        ed1.setText(taco.getAlimento());
        ed2.setText(taco.getCaterogia());
        ed3.setText(taco.getUmidade());
        ed4.setText(taco.getEnergiakcal());
        ed5.setText(taco.getkJ());
        ed6.setText(taco.getProteonag());
        ed7.setText(taco.getLipodeosg());
        ed8.setText(taco.getColesterolmg());
        ed9.setText(taco.getCarboidratosg());
        ed10.setText(taco.getFibraAlimentarg());
        ed11.setText(taco.getCinzasg());
        ed12.setText(taco.getCalciomg());
        ed13.setText(taco.getMagnesiomg());
        ed14.setText(taco.getManganesmg());
        ed15.setText(taco.getFosforomg());
        ed16.setText(taco.getFerromg());
        ed17.setText(taco.getSodiomg());
        ed18.setText(taco.getPotassiomg());
        ed19.setText(taco.getCobremg());
        ed20.setText(taco.getZincomg());
        ed21.setText(taco.getRetinolmcg());
        ed22.setText(taco.getrEmcg());
        ed23.setText(taco.getrAEmcg());
        ed24.setText(taco.getTiaminamg());
        ed25.setText(taco.getRiboflavinamg());
        ed26.setText(taco.getPiridoxinamg());
        ed27.setText(taco.getNiacinamg());
        ed28.setText(taco.getVitaminaCmg());
    }


}
