package com.anshare.edpsystem;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FSetText extends Fragment {
	
	private String StrEDPName1="";  
	private String StrEDPName2=""; 
	private String StrEDPName3=""; 

	public FSetText() {
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_textinput, container, false);
		//初始化 控件
		final TextView EDPName1=(TextView)rootView.findViewById(R.id.text_EDPName1);
		final TextView EDPName2=(TextView)rootView.findViewById(R.id.text_EDPName2);
		final TextView EDPName3=(TextView)rootView.findViewById(R.id.text_EDPName3);
		Button FSet2_back=(Button)rootView.findViewById(R.id.FSet2_back);
		FSet2_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FModelchoose()).commit();
				}
			});
		Button FSet2_next=(Button)rootView.findViewById(R.id.FSet2_next);
		FSet2_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FSetPText()).commit();
				}
			});
		Button FSet2_reset=(Button)rootView.findViewById(R.id.FSet2_reset);
		FSet2_reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				EDPName1.setText("文本内容1");
				EDPName2.setText("文本内容2");
				EDPName3.setText("文本内容3");
				}
			});
		
		
        //初始化控件
        final EditText Input_EDPName1 =(EditText) rootView.findViewById(R.id.edittext_EDPName1);  
        final EditText Input_EDPName2 =(EditText) rootView.findViewById(R.id.edittext_EDPName2);  
        final EditText Input_EDPName3 =(EditText) rootView.findViewById(R.id.edittext_EDPName3);  
        
        MainActivity MA0=(MainActivity) getActivity();
		String[] GetText=new String[3];
		GetText=MA0.getEDPTextinformation();
		this.StrEDPName1=GetText[0];
		this.StrEDPName2=GetText[1];
		this.StrEDPName3=GetText[2];
        
        Button FSet2_TextSet=(Button)rootView.findViewById(R.id.button_textset);
        FSet2_TextSet.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				//获取文本信息
				StrEDPName1=Input_EDPName1.getText().toString();
		        StrEDPName2=Input_EDPName2.getText().toString();
		        StrEDPName3=Input_EDPName3.getText().toString();
		        //将文本赋值  
		        if(StrEDPName1.equals("")){
		        	EDPName1.setText("文本内容1");
		        }
		        else
		        {
		        	EDPName1.setText(StrEDPName1.toCharArray(), 0, StrEDPName1.length());
		        	EDPName1.setTextColor(Color.RED);
		        }
		        if(StrEDPName2.equals("")){
		        	EDPName2.setText("文本内容2");
		        	EDPName2.setTextSize(45);
		        }
		        else
		        {
		        	EDPName2.setText(StrEDPName2.toCharArray(), 0, StrEDPName2.length());
		        	EDPName2.setTextSize(45);
		        	EDPName2.setTextColor(Color.GREEN);
		        }
		        if(StrEDPName3.equals("")){
		        	EDPName3.setText("文本内容3");
		        	EDPName3.setTextSize(25);
		        }
		        else
		        {
		        	EDPName3.setText(StrEDPName3.toCharArray(), 0, StrEDPName3.length());
		        	EDPName3.setTextSize(25);
		        	EDPName3.setTextColor(Color.BLUE);
		        }
		        MainActivity MA=(MainActivity) getActivity();
		        MA.setEDPTextinformation(StrEDPName1, StrEDPName2, StrEDPName3);//传递参数
				}
			});
        
        //将文本赋值  
        if(StrEDPName1.equals("")){
        	EDPName1.setText("文本内容1");
        }
        else
        {
        	EDPName1.setText(StrEDPName1.toCharArray(), 0, StrEDPName1.length());
        	EDPName1.setTextColor(Color.RED);
        }
        if(StrEDPName2.equals("")){
        	EDPName2.setText("文本内容2");
        	EDPName2.setTextSize(45);
        }
        else
        {
        	EDPName2.setText(StrEDPName2.toCharArray(), 0, StrEDPName2.length());
        	EDPName2.setTextSize(45);
        	EDPName2.setTextColor(Color.GREEN);
        }
        if(StrEDPName3.equals("")){
        	EDPName3.setText("文本内容3");
        	EDPName3.setTextSize(25);
        }
        else
        {
        	EDPName3.setText(StrEDPName3.toCharArray(), 0, StrEDPName3.length());
        	EDPName3.setTextSize(25);
        	EDPName3.setTextColor(Color.BLUE);
        }
	    return rootView;    
	} 
}
