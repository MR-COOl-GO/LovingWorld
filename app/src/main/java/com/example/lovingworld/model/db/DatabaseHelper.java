package com.example.lovingworld.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lovingworld.model.pojos.Friend;
import com.example.lovingworld.model.pojos.Message;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by 甄大昌 on 2017/1/10.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
    private static final String DATABASE_NAME = "click.db";
    private static final int DATABASE_VERSION = 6;

    private Dao<Message,Integer> messageDao;
    private Dao<Friend,String> friendDao;

    private static DatabaseHelper helperInstance;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (helperInstance == null) {
            synchronized (DatabaseHelper.class) {
                if (helperInstance == null)
                    helperInstance = new DatabaseHelper(context);
            }
        }
        return helperInstance;
    }
    @Override
    public void onCreate(SQLiteDatabase database,
                         ConnectionSource connectionSource)
    {
        try {
            TableUtils.createTable(connectionSource, Message.class);
            TableUtils.createTable(connectionSource, Friend.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to create datbases", e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            TableUtils.dropTable(connectionSource, Message.class, true);
            TableUtils.dropTable(connectionSource, Friend.class, true);
            onCreate(sqliteDatabase, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
                    + newVer, e);
        }
    }

    public Dao<Message,Integer> getMessageDao() throws SQLException
    {
        if(messageDao == null)
        {
            messageDao = getDao(Message.class);
        }

        return messageDao;
    }

    public Dao<Friend,String> getFriendDao() throws SQLException
    {
        if(friendDao == null)
        {
            friendDao = getDao(Friend.class);
        }

        return friendDao;
    }

    @Override
    public void close() {
        super.close();
        messageDao = null;
        friendDao = null;
    }

}



