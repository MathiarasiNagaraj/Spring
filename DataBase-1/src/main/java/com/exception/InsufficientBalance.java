package com.exception;

public class InsufficientBalance extends Exception {
String msg;

/**
 * @param msg
 */
public InsufficientBalance(String msg) {
	this.msg = msg;
}

@Override
public String toString() {
	return "InsufficientBalance [msg=" + msg + "]";
}

}
