package com.Bitmap;

public class BitDemo {
	
	public static void main(String[] args) {
		
		int a = -10;
		int b = -9;
		
		System.out.println(a%2);
		System.out.println(b%2);
	
		System.out.println(a & 1);
		System.out.println(b & 1);
		
		System.out.println(a+","+b);
		
		System.out.println("---------");
		
		int n = 256;
		int m = 3;
		
		System.out.println(n >> 3);
		System.out.println(m << 3);
		
		System.out.println(1 << 2);
		//System.out.println(((n-1)&n));
		//System.out.println((n&(n-1)));
	}

}
