package com.bulpet.loto;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class GetLoto extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_loto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_get_loto, menu);
        return true;
    }
    
    @SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public void RandomMe(View v)
    {
    	Random r = new Random();
    	
    	ArrayList<Integer> arr = new ArrayList<Integer>(5);
    	
    	LackyNumbers ln = new LackyNumbers();
    	ArrayList<Integer> lackyArr = ln.getLackyNumbers();
    	int indx = 6 - lackyArr.size();
    	
    	for(;arr.size()<indx;)
    	{
    		int tmp = r.nextInt(37)+1;
    		if(!arr.contains(tmp) && !lackyArr.contains(tmp))
    			arr.add(tmp);
    	}
    	arr.addAll(lackyArr);
    	
    	bubbleSort(arr);
    	try
    	{
	    	LinearLayout L = (LinearLayout)this.findViewById(R.id.linear);
	    	L.removeAllViews();
	    	L.setPadding(5, 0, 5, 0);
	    	
	    	for(int i=0;i<arr.size();i++)
	    	{
		   	    L.addView(CreateView(arr.get(i),lackyArr.contains(arr.get(i))));
	    	}
    	
    	}
    	catch(Exception e)
    	{
    		TextView tv = new TextView(this);
    		tv.append(e.toString());
    		setContentView(tv);
    	}
    	
    	
    	
   	    //setContentView(tv);
    }
    
    @TargetApi(16)
	private TextView CreateView(Integer numb,Boolean isLackyNumber)
    {
    	TextView tv = new TextView(this);
   	    //tv.append("Random Number : " + arr.get(i) + "\r\n");
		tv.append(numb.toString());
		tv.setWidth(40);
		
		if(isLackyNumber)
			tv.setTextColor(-65536);
		
		tv.setBackground(getResources().getDrawable(R.drawable.kadur1));
		tv.setWidth(30);
		tv.setHeight(30);
		tv.setGravity(Gravity.CENTER);
		
		LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50);
        layoutParams.setMargins(6, 2, 6, 2);
        
		tv.setLayoutParams(layoutParams);
		
		return tv;

    }
    
    /**
     * This method performs the bubble sort
     * @param numbersToSort 
     */
    private static void bubbleSort(ArrayList<Integer> numbersToSort) {

        int temp = 0;
        for (int i = 0; i < numbersToSort.size() - 1; i++) {
            for (int j = 1; j < (numbersToSort.size() - i); j++) {
                if (numbersToSort.get(j - 1) > numbersToSort.get(j)) {
                    //swap the elements!
                    temp = numbersToSort.get(j - 1);
                    numbersToSort.set(j - 1, numbersToSort.get(j));
                    numbersToSort.set(j, temp);
                }

            }
        }
    }
}
