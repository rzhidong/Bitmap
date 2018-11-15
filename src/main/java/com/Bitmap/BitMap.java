package com.Bitmap;

import java.util.Random;


public class BitMap {
	// 保存数据的
	private byte[] bits;

	// 能够存储多少数据
	private int capacity;

	public BitMap(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		// 1bit能存储8个数据，那么capacity数据需要多少个bit呢，capacity/8+1,右移3位相当于除以8
		bits = new byte[(capacity >> 3) + 1];
	}

	public void add(int num) {
		// num/8得到byte[]的index
		int arrayIndex = num >> 3;

		// num%8得到在byte[index]的位置
		int position = num & 0x07;
		// int position = num % 8;

		//System.out.print(arrayIndex + "\t" + bits[arrayIndex] + "\t");

		// 将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
		bits[arrayIndex] |= 1 << position;

		//System.out.println(bits[arrayIndex]);
	}

	public boolean contain(int num) {
		// num/8得到byte[]的index
		int arrayIndex = num >> 3;

		// num%8得到在byte[index]的位置
		int position = num & 0x07;

		return (bits[arrayIndex] & (1 << position)) != 0;

	}

	public void clear(int num) {
		// num/8得到byte[]的index
		int arrayIndex = num >> 3;

		// num%8得到在byte[index]的位置
		int position = num & 0x07;

		bits[arrayIndex] &= ~(1 << position);
	}

	public static void main(String[] args) {
		/* 运行前内存 */
		long beforeMemory = Runtime.getRuntime().totalMemory();
		System.out.println("beforeMemory: " + beforeMemory);
		long start1 = System.currentTimeMillis();

		int length = 2000000000;

		BitMap bitMap = new BitMap(length);

		for (int i = 0; i < length; i++) {
			/* 假设898989这个数不在20亿个数里面 */
			if (i != 898989) {
				bitMap.add(i);
			}
		}

		/* 创建20亿个数后所占内存 */
		long afterMemory = Runtime.getRuntime().totalMemory();
		System.out.println("afterMemory:" + afterMemory);

		long end1 = System.currentTimeMillis();
		System.out.println("总共内存使用:" + (afterMemory - beforeMemory) / 1024
				/ 1024 + "MB");
		System.out.println("存入内存耗时:" + (end1 - start1)  + "毫秒");
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		long start2 = System.currentTimeMillis();
		System.err.println(start2);

		boolean isExit1 = bitMap.contain(898989);
		
		int number = new Random().nextInt(2000000000);
		
		boolean isExit2 = bitMap.contain(number);

		long end2 = System.currentTimeMillis();
		System.err.println(end2);
		/* 输出在20亿个数中判断898989是否包含在里面 */
		System.out.println(isExit1);
		System.out.println("20个亿中" + (isExit1 ? "包含" : "不包含") + 898989);
		System.out.println("20个亿中" + (isExit2 ? "包含" : "不包含") + number);
		System.out.println("查询用时:" + (end2 - start2) + "毫秒");
		
	}

}
