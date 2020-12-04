package com.linhmd.utility;

import java.util.Objects;
import java.util.Vector;

public interface VectorAble<T> {
	Vector<Object> toVector();
	T toObject(Vector<Object> data);
}
