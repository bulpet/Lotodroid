package com.bulpet.loto;

import java.util.ArrayList;
import java.util.Random;


public class LackyNumbers {

	private ArrayList<Integer> lackynums = new ArrayList<Integer>();
	
	LackyNumbers()
	{
		lackynums.add(13);
		lackynums.add(7);
		lackynums.add(16);
		lackynums.add(2);
		lackynums.add(4);
		lackynums.add(8);
	}
	public ArrayList<Integer> getLackyNumbers()
	{
		Random r = new Random();
		int i =r.nextInt(7);
		
		ArrayList<Integer> arr= new ArrayList<Integer>(i);
		
		for(int k=0;k<i;k++)
		{
			int indx = r.nextInt(lackynums.size());
			int tmp = lackynums.get(indx);
			arr.add(tmp);
			lackynums.remove(indx);
		}
		
		return arr;
	}
}
