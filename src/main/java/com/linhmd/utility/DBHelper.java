package com.linhmd.utility;

import java.util.Vector;

public interface DBHelper {
	boolean executeNonQuery(String sqlStatement, Vector<Object> values) throws Exception;
	Vector<Vector<String>> executeQuery(String sqlStatement, Vector<Object> values) throws Exception ;
}
