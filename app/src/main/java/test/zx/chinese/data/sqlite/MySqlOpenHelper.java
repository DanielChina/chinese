package test.zx.chinese.data.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.util.Preconditions;

import test.zx.chinese.Constant.Constant;
import test.zx.chinese.data.User;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by THink on 2018/2/5.
 */

public class MySqlOpenHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase db;
    private MySqlOpenHelper sqlHelper;
    private boolean mIsClosed;
    private static final String DB_NAME= Constant.DATABASE_NAME;
    private static final int DB_VERSION=Constant.DATABASE_VERSION;
  //  private static final Class[] ENTITIES = new Class[]{Chinese.class, User.class};
    private static final Class[] ENTITIES = new Class[]{User.class};

    static {
        // register our models
        for (Class clazz : ENTITIES) {
            cupboard().register(clazz);
        }
    }
    public MySqlOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }

    public User getUserProfile(String username) {
        assetNotClosed();

        try {
            return cupboard().withDatabase(getReadableDatabase())
                    .query(User.class)
                    .withSelection("username = ?", username)
                    .get();
        } catch (Exception e) {
            return null;
        }
    }

    public void put(User profile) {
        assetNotClosed();
        try {
            cupboard().withDatabase(getWritableDatabase()).put(profile);
        } catch (Exception e) {
        }
    }

    public void delete(User profile) {
        assetNotClosed();
        try {
            cupboard().withDatabase(getWritableDatabase()).delete(profile);
        } catch (Exception e) {
        }
    }
    public int deleteAll() {
        assetNotClosed();
        try {
            cupboard().withDatabase(getWritableDatabase()).delete(User.class,null);

        } catch (Exception e) {
        }
        return -1;
    }
      @Override
    public synchronized void close() {
        mIsClosed = true;
        super.close();
    }

    public boolean isClosed() {
        return mIsClosed;
    }

    @SuppressLint("RestrictedApi")
    private void assetNotClosed() {
        Preconditions.checkState(!mIsClosed, "Database is closed");
    }
    public MySqlOpenHelper newInstance(Context context){
        sqlHelper=new MySqlOpenHelper(context);
        return sqlHelper;
    }
}

