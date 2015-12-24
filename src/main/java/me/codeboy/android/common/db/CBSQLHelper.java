package me.codeboy.android.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库操作
 * @author yuedong.lyd
 */
public abstract class CBSQLHelper {
	protected CBSQLiteHelper sqlHelper;
	protected SQLiteDatabase db;
	protected static String dbName = null;

	public CBSQLHelper(Context context) {
		if (dbName == null) // 默认数据库名字
			dbName = "db";

		sqlHelper = new CBSQLiteHelper(context, dbName, null, 1);
		db = sqlHelper.getWritableDatabase();
	}

	public CBSQLHelper(Context context, String dbName) {
		setDbName(dbName);
		sqlHelper = new CBSQLiteHelper(context, dbName, null, 1);
		db = sqlHelper.getWritableDatabase();
	}

	public abstract void createTables();

	/**
	 * 设置数据库名字
	 * 
	 * @param dbName
	 */
	public void setDbName(String dbName) {
		CBSQLHelper.dbName = dbName;
	}

	public void close() {
		db.close();
		sqlHelper.close();
	}
}