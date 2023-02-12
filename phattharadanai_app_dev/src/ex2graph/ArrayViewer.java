/*
 * Util.java
 *
 * Created on 16 May 2005, 10:38
 */

/**
 *
 * @author  cs50
 */
package ex2graph;

import java.text.DecimalFormat;
public class ArrayViewer {
    static DecimalFormat formatter = new DecimalFormat("#,###.###");
    static String delimiter = ",";
    static String newline = "\n";
    public void setFormat(String f) { formatter = new DecimalFormat(f); }
    public void setDelimiter(String d) { delimiter = d; }
    public static void view2DStringArray(String [][] s) {
    	for(int i=0; i<s.length; i++)
    		view1DStringArray(s[i]);
    }
    public static void view1DStringArray(String [] s) {
    	System.out.println(get1DStringArray(s));
    }
    public static void view2DLongArray(long [][] d) {
        for(int i=0; i<d.length; i++)
            view1DLongArray(d[i]);
    }
    public static void view1DLongArray(long [] d) {
    	System.out.println(get1DLongArray(d));
    }
    public static void view2DIntArray(int [][] d) {
        for(int i=0; i<d.length; i++)
            view1DIntArray(d[i]);
    }
    public static void view1DIntArray(int [] d) {
    	System.out.println(get1DIntArray(d));
    	
    }
    public static void view2DDoubleArray(double [][] a) {
        for(int i=0; i<a.length; i++)
            view1DDoubleArray(a[i]);
    }
    public static void view1DDoubleArray(double [] a) {
    	System.out.println(get1DDoubleArray(a));
    }
    public static void view2DFloatArray(float [][] a) {
        for(int i=0; i<a.length; i++)
            view1DFloatArray(a[i]);
    }
    public static void view1DFloatArray(float [] a) {
    	System.out.println(get1DFloatArray(a));
    }
    public static void view2DShortArray(byte [][] b) {
        for(int i=0; i<b.length; i++)
            view1DByteArray(b[i]);
    }
    public static void view1DByteArray(byte [] b) {
    	System.out.println(get1DByteArray(b));
    }
    public static void view2DShortArray(short [][] s) {
        for(int i=0; i<s.length; i++)
            view1DShortArray(s[i]);
    }
    public static void view1DShortArray(short [] s) {
    	System.out.println(get1DShortArray(s));
    }
    public static String get2DLongArray(long[][] d) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<d.length; i++)
    		buff.append(get1DLongArray(d[i])).append("\n");
    	return buff.toString();
    }
    public static String get1DLongArray(long [] d) {
    	StringBuffer buff = new StringBuffer();
        for(int i=0; i<d.length; i++)
        	buff.append(d[i]+(i<d.length-1?delimiter:""));
        return buff.toString();
    }
    public static String get2DIntArray(int[][] d) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<d.length; i++)
    		buff.append(get1DIntArray(d[i])).append("\n");
    	return buff.toString();
    }
    public static String get1DIntArray(int [] d) {
    	StringBuffer buff = new StringBuffer();
        for(int i=0; i<d.length; i++)
        	buff.append(d[i]+(i<d.length-1?delimiter:""));
        return buff.toString();
    }
    public static String get2DShortArray(short[][] s) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<s.length; i++)
    		buff.append(get1DShortArray(s[i])).append("\n");
    	return buff.toString();
    }
    public static String get1DShortArray(short [] s) {
    	StringBuffer buff = new StringBuffer();
        for(int i=0; i<s.length; i++)
        	buff.append(s[i]+(i<s.length-1?delimiter:""));
        return buff.toString();
    }
    public static String get2DByteArray(byte[][] b) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<b.length; i++)
    		buff.append(get1DByteArray(b[i])).append("\n");
    	return buff.toString();
    }
    public static String get1DByteArray(byte [] b) {
    	StringBuffer buff = new StringBuffer();
        for(int i=0; i<b.length; i++)
        	buff.append(b[i]+(i<b.length-1?delimiter:""));
        return buff.toString();
    }
    public static String get2DFloatArray(float[][] f) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<f.length; i++)
    		buff.append(get1DFloatArray(f[i])).append("\n");
    	return buff.toString();
    }
    public static String get1DFloatArray(float [] f) {
    	StringBuffer buff = new StringBuffer();
        for(int i=0; i<f.length; i++)
        	buff.append(f[i]+(i<f.length-1?delimiter:""));
        return buff.toString();
    }
    public static String get2DDoubleArray(double[][] d) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<d.length; i++)
    		buff.append(get1DDoubleArray(d[i])).append("\n");
    	return buff.toString();
    }
    public static String get1DDoubleArray(double [] d) {
    	StringBuffer buff = new StringBuffer();
        for(int i=0; i<d.length; i++)
        	buff.append(d[i]+(i<d.length-1?delimiter:""));
        return buff.toString();
    }
    public static String get1DStringArray(String [] s) {
    	StringBuffer buff = new StringBuffer();
    	for(int i=0; i<s.length; i++) {
    		buff.append(s[i]+(i<s.length-1?newline:""));
    	}
    	return buff.toString();
    }

	
}