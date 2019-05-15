package br.com.unipac.infra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import br.com.unipac.model.Aluno;

public class DbHelper extends SQLiteOpenHelper {

    public static final String CHAMADA_DB = "chamada.db";
    public static final int VERSION_DB = 1;

    public DbHelper(@Nullable Context context) {
        super(context, CHAMADA_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Aluno.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Aluno.TABLE_NAME);
        onCreate(db);
    }
}
