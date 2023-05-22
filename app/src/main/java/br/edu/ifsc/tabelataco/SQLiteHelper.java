package br.edu.ifsc.tabelataco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import br.edu.ifsc.tabelataco.models.Taco;

public class SQLiteHelper  extends SQLiteOpenHelper {

    private SQLiteDatabase myDatabase = this.getWritableDatabase();

    Context context;

    private static final String DATABASE_NAME = "aula7.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_TACO = "taco4";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CATEROGIA = "caterogia";
    public static final String COLUMN_ALIMENTO = "alimento";
    public static final String COLUMN_UMIDADE = "umidade";
    public static final String COLUMN_ERNERGIAKCAL = "energiakcal";
    public static final String COLUMN_kJ = "kJ";
    public static final String COLUMN_PROTEONAG = "proteonag";
    public static final String COLUMN_LIPODEOSG = "lipodeosg";
    public static final String COLUMN_COLESTEROLMG = "colesterolmg";
    public static final String COLUMN_CARBOIDRATOSG = "carboidratosg";
    public static final String COLUMN_FIBRAALIMENTARG = "fibraAlimentarg";
    public static final String COLUMN_CINZASG = "cinzasg";
    public static final String COLUMN_CALCIOMG = "calciomg";
    public static final String COLUMN_MAGNESIOMG = "magnesiomg";
    public static final String COLUMN_MANGANESMG = "manganesmg";
    public static final String COLUMN_FOSFOROMG = "fosforomg";
    public static final String COLUMN_FERROMG = "ferromg";
    public static final String COLUMN_SODIOMG = "sodiomg";
    public static final String COLUMN_POTASSIOMG = "potassiomg";
    public static final String COLUMN_COBREMG = "cobremg";
    public static final String COLUMN_ZINCOMG = "zincomg";
    public static final String COLUMN_RETINOLMCG = "retinolmcg";
    public static final String COLUMN_REMCG = "rEmcg";
    public static final String COLUMN_RAEMCG = "rAEmcg";
    public static final String COLUMN_TIAMINAMG = "tiaminamg";
    public static final String COLUMN_RIBOFLAVINAMG = "riboflavinamg";
    public static final String COLUMN_PIRIDOXINAMG = "piridoxinamg";
    public static final String COLUMN_NIACINAMG = "niacinamg";
    public static final String COLUMN_VITAMINACMG = "vitaminaCmg";

    public SQLiteHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        context = c;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable =
            "CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_TACO + "(" +
            SQLiteHelper.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SQLiteHelper.COLUMN_CATEROGIA + " VARCHAR(37) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_ALIMENTO + " VARCHAR(64) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_UMIDADE + " VARCHAR(4) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_ERNERGIAKCAL + " VARCHAR(4) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_kJ + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_PROTEONAG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_LIPODEOSG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_COLESTEROLMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_CARBOIDRATOSG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_FIBRAALIMENTARG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_CINZASG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_CALCIOMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_MAGNESIOMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_MANGANESMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_FOSFOROMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_FERROMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_SODIOMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_POTASSIOMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_COBREMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_ZINCOMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_RETINOLMCG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_REMCG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_RAEMCG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_TIAMINAMG + " VARCHAR(4) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_RIBOFLAVINAMG + " VARCHAR(4) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_PIRIDOXINAMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_NIACINAMG + " VARCHAR(5) DEFAULT NULL, " +
            SQLiteHelper.COLUMN_VITAMINACMG + " VARCHAR(5) DEFAULT NULL );";
        db.execSQL(createTable);
        executeSQLFile();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists " + SQLiteHelper.TABLE_TACO + ";");
    }

    public Boolean excluiNota(Taco t) {
        String[] whereArgs = {String.valueOf(t.getId())};
        myDatabase.delete(SQLiteHelper.TABLE_TACO, "id = ?", whereArgs);
        return true;
    }

    public Taco inserirRegistro(Taco t) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.COLUMN_CATEROGIA, t.getCaterogia());
        contentValues.put(SQLiteHelper.COLUMN_ALIMENTO, t.getAlimento());
        contentValues.put(SQLiteHelper.COLUMN_UMIDADE, t.getUmidade());
        contentValues.put(SQLiteHelper.COLUMN_ERNERGIAKCAL, t.getEnergiakcal());
        contentValues.put(SQLiteHelper.COLUMN_kJ, t.getkJ());
        contentValues.put(SQLiteHelper.COLUMN_PROTEONAG, t.getProteonag());
        contentValues.put(SQLiteHelper.COLUMN_LIPODEOSG, t.getLipodeosg());
        contentValues.put(SQLiteHelper.COLUMN_COLESTEROLMG, t.getColesterolmg());
        contentValues.put(SQLiteHelper.COLUMN_CARBOIDRATOSG, t.getCarboidratosg());
        contentValues.put(SQLiteHelper.COLUMN_FIBRAALIMENTARG, t.getFibraAlimentarg());
        contentValues.put(SQLiteHelper.COLUMN_CINZASG, t.getCinzasg());
        contentValues.put(SQLiteHelper.COLUMN_CALCIOMG, t.getCalciomg());
        contentValues.put(SQLiteHelper.COLUMN_MAGNESIOMG, t.getMagnesiomg());
        contentValues.put(SQLiteHelper.COLUMN_MANGANESMG, t.getManganesmg());
        contentValues.put(SQLiteHelper.COLUMN_FOSFOROMG, t.getFosforomg());
        contentValues.put(SQLiteHelper.COLUMN_FERROMG, t.getFerromg());
        contentValues.put(SQLiteHelper.COLUMN_SODIOMG, t.getSodiomg());
        contentValues.put(SQLiteHelper.COLUMN_POTASSIOMG, t.getPotassiomg());
        contentValues.put(SQLiteHelper.COLUMN_COBREMG, t.getCobremg());
        contentValues.put(SQLiteHelper.COLUMN_ZINCOMG, t.getZincomg());
        contentValues.put(SQLiteHelper.COLUMN_RETINOLMCG, t.getRetinolmcg());
        contentValues.put(SQLiteHelper.COLUMN_REMCG, t.getrEmcg());
        contentValues.put(SQLiteHelper.COLUMN_RAEMCG, t.getrAEmcg());
        contentValues.put(SQLiteHelper.COLUMN_TIAMINAMG, t.getTiaminamg());
        contentValues.put(SQLiteHelper.COLUMN_RIBOFLAVINAMG, t.getRiboflavinamg());
        contentValues.put(SQLiteHelper.COLUMN_PIRIDOXINAMG, t.getPiridoxinamg());
        contentValues.put(SQLiteHelper.COLUMN_NIACINAMG, t.getNiacinamg());
        contentValues.put(SQLiteHelper.COLUMN_VITAMINACMG, t.getVitaminaCmg());
        int i = (int) myDatabase.insert(SQLiteHelper.TABLE_TACO, null, contentValues);
        t.setId(i);
        return t;
    }

    public Taco buscarRegistroPorId(int id) {
        Cursor cursor = myDatabase.rawQuery("SELECT * FROM " + SQLiteHelper.TABLE_TACO + " WHERE id = ?;", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            String caterogia = cursor.getString(1);
            String alimento = cursor.getString(2);
            String umidade = cursor.getString(3);
            String energiakcal = cursor.getString(4);
            String kJ = cursor.getString(5);
            String proteonag = cursor.getString(6);
            String lipodeosg = cursor.getString(7);
            String colesterolmg = cursor.getString(8);
            String carboidratosg = cursor.getString(9);
            String fibraAlimentarg = cursor.getString(10);
            String cinzasg = cursor.getString(11);
            String calciomg = cursor.getString(12);
            String magnesiomg = cursor.getString(13);
            String manganesmg = cursor.getString(14);
            String fosforomg = cursor.getString(15);
            String ferromg = cursor.getString(16);
            String sodiomg = cursor.getString(17);
            String potassiomg = cursor.getString(18);
            String cobremg = cursor.getString(19);
            String zincomg = cursor.getString(20);
            String retinolmcg = cursor.getString(21);
            String rEmcg = cursor.getString(22);
            String rAEmcg = cursor.getString(23);
            String tiaminamg = cursor.getString(24);
            String riboflavinamg = cursor.getString(25);
            String piridoxinamg = cursor.getString(26);
            String niacinamg = cursor.getString(27);
            String vitaminaCmg = cursor.getString(28);
            return new Taco(id, caterogia, alimento, umidade, energiakcal, kJ, proteonag, lipodeosg, colesterolmg, carboidratosg, fibraAlimentarg, cinzasg,
                    calciomg, magnesiomg, manganesmg, fosforomg, ferromg, sodiomg, potassiomg, cobremg, zincomg, retinolmcg, rEmcg, rAEmcg, tiaminamg,
                    riboflavinamg, piridoxinamg, niacinamg, vitaminaCmg);
        }
        return null;
    }

    public Boolean atualizaNota(Taco t) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.COLUMN_CATEROGIA, t.getCaterogia());
        contentValues.put(SQLiteHelper.COLUMN_ALIMENTO, t.getAlimento());
        contentValues.put(SQLiteHelper.COLUMN_UMIDADE, t.getUmidade());
        contentValues.put(SQLiteHelper.COLUMN_ERNERGIAKCAL, t.getEnergiakcal());
        contentValues.put(SQLiteHelper.COLUMN_kJ, t.getkJ());
        contentValues.put(SQLiteHelper.COLUMN_PROTEONAG, t.getProteonag());
        contentValues.put(SQLiteHelper.COLUMN_LIPODEOSG, t.getLipodeosg());
        contentValues.put(SQLiteHelper.COLUMN_COLESTEROLMG, t.getColesterolmg());
        contentValues.put(SQLiteHelper.COLUMN_CARBOIDRATOSG, t.getCarboidratosg());
        contentValues.put(SQLiteHelper.COLUMN_FIBRAALIMENTARG, t.getFibraAlimentarg());
        contentValues.put(SQLiteHelper.COLUMN_CINZASG, t.getCinzasg());
        contentValues.put(SQLiteHelper.COLUMN_CALCIOMG, t.getCalciomg());
        contentValues.put(SQLiteHelper.COLUMN_MAGNESIOMG, t.getMagnesiomg());
        contentValues.put(SQLiteHelper.COLUMN_MANGANESMG, t.getManganesmg());
        contentValues.put(SQLiteHelper.COLUMN_FOSFOROMG, t.getFosforomg());
        contentValues.put(SQLiteHelper.COLUMN_FERROMG, t.getFerromg());
        contentValues.put(SQLiteHelper.COLUMN_SODIOMG, t.getSodiomg());
        contentValues.put(SQLiteHelper.COLUMN_POTASSIOMG, t.getPotassiomg());
        contentValues.put(SQLiteHelper.COLUMN_COBREMG, t.getCobremg());
        contentValues.put(SQLiteHelper.COLUMN_ZINCOMG, t.getZincomg());
        contentValues.put(SQLiteHelper.COLUMN_RETINOLMCG, t.getRetinolmcg());
        contentValues.put(SQLiteHelper.COLUMN_REMCG, t.getrEmcg());
        contentValues.put(SQLiteHelper.COLUMN_RAEMCG, t.getrAEmcg());
        contentValues.put(SQLiteHelper.COLUMN_TIAMINAMG, t.getTiaminamg());
        contentValues.put(SQLiteHelper.COLUMN_RIBOFLAVINAMG, t.getRiboflavinamg());
        contentValues.put(SQLiteHelper.COLUMN_PIRIDOXINAMG, t.getPiridoxinamg());
        contentValues.put(SQLiteHelper.COLUMN_NIACINAMG, t.getNiacinamg());
        contentValues.put(SQLiteHelper.COLUMN_VITAMINACMG, t.getVitaminaCmg());
        String[] whereArgs = {String.valueOf(t.getId())};
        myDatabase.update(SQLiteHelper.TABLE_TACO, contentValues, " id = ?", whereArgs);
        return true;
    }

    public ArrayList<Taco> getAlimentos() {
        Cursor cursor = myDatabase.rawQuery("SELECT * FROM " + SQLiteHelper.TABLE_TACO + ";", null);
        cursor.moveToFirst();
        ArrayList<Taco> arrayList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String caterogia = cursor.getString(1);
            String alimento = cursor.getString(2);
            String umidade = cursor.getString(3);
            String energiakcal = cursor.getString(4);
            String kJ = cursor.getString(5);
            String proteonag = cursor.getString(6);
            String lipodeosg = cursor.getString(7);
            String colesterolmg = cursor.getString(8);
            String carboidratosg = cursor.getString(9);
            String fibraAlimentarg = cursor.getString(10);
            String cinzasg = cursor.getString(11);
            String calciomg = cursor.getString(12);
            String magnesiomg = cursor.getString(13);
            String manganesmg = cursor.getString(14);
            String fosforomg = cursor.getString(15);
            String ferromg = cursor.getString(16);
            String sodiomg = cursor.getString(17);
            String potassiomg = cursor.getString(18);
            String cobremg = cursor.getString(19);
            String zincomg = cursor.getString(20);
            String retinolmcg = cursor.getString(21);
            String rEmcg = cursor.getString(22);
            String rAEmcg = cursor.getString(23);
            String tiaminamg = cursor.getString(24);
            String riboflavinamg = cursor.getString(25);
            String piridoxinamg = cursor.getString(26);
            String niacinamg = cursor.getString(27);
            String vitaminaCmg = cursor.getString(28);
            arrayList.add(new Taco(id, caterogia, alimento, umidade, energiakcal, kJ, proteonag, lipodeosg, colesterolmg, carboidratosg, fibraAlimentarg, cinzasg,
                    calciomg, magnesiomg, manganesmg, fosforomg, ferromg, sodiomg, potassiomg, cobremg, zincomg, retinolmcg, rEmcg, rAEmcg, tiaminamg,
                    riboflavinamg, piridoxinamg, niacinamg, vitaminaCmg));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public void executeSQLFile() {
        try {
            InputStream inputStream = context.getAssets().open("taco4.sql");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            StringBuilder statement = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                statement.append(line);
                if (line.endsWith(";")) {
                    myDatabase.execSQL(statement.toString());
                    statement.setLength(0);
                }
            }

            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
