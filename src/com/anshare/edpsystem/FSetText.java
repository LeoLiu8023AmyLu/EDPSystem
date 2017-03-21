package com.anshare.edpsystem;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.res.AssetManager; 


public class FSetText extends Fragment {
	
	private String[] StrEDPName=new String[3];
	private String[] StrEDPNameFont=new String[3];
	private Typeface[] EDPTF=new Typeface[3];
	
	public FSetText() {
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_textinput, container, false);
		//初始化 显示控件
		final TextView EDPName1=(TextView)rootView.findViewById(R.id.text_EDPName1);
		final TextView EDPName2=(TextView)rootView.findViewById(R.id.text_EDPName2);
		final TextView EDPName3=(TextView)rootView.findViewById(R.id.text_EDPName3);
		/*
		 * 设置按钮
		 * 返回、下一步、重置
		 */
		Button FSet2_back=(Button)rootView.findViewById(R.id.FSet2_back);
		FSet2_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().add(R.id.container, new FModelchoose()).commit();
				}
			});
		Button FSet2_next=(Button)rootView.findViewById(R.id.FSet2_next);
		FSet2_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().add(R.id.container, new FSetPText()).commit();
				}
			});
		Button FSet2_reset=(Button)rootView.findViewById(R.id.FSet2_reset);
		FSet2_reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EDPName1.setText("文本内容1");
				EDPName2.setText("文本内容2");
				EDPName3.setText("文本内容3");
				}
			});
        /*
         * 设置输入框 控件
         */
        final EditText Input_EDPName1 =(EditText) rootView.findViewById(R.id.edittext_EDPName1);  
        final EditText Input_EDPName2 =(EditText) rootView.findViewById(R.id.edittext_EDPName2);  
        final EditText Input_EDPName3 =(EditText) rootView.findViewById(R.id.edittext_EDPName3);  
        
        MainActivity MA0=(MainActivity) getActivity();
		String[] GetText=new String[3];
		GetText=MA0.getEDPTextinformation();
		this.StrEDPName=GetText;
		Typeface[] GetTextFont=new Typeface[3];
		GetTextFont=MA0.getEDPTextFontinformation();
		this.EDPTF=GetTextFont;
		/*
         * 重要的应用按钮
         * 设置文本信息 保存信息
         */
        Button FSet2_TextSet=(Button)rootView.findViewById(R.id.button_textset);
        FSet2_TextSet.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				//获取文本信息
				StrEDPName[0]=Input_EDPName1.getText().toString();
		        StrEDPName[1]=Input_EDPName2.getText().toString();
		        StrEDPName[2]=Input_EDPName3.getText().toString();
		        //将文本赋值  
		        if(StrEDPName[0].equals("")){
		        	EDPName1.setText("文本内容1");
		        }
		        else
		        {
		        	EDPName1.setText(StrEDPName[0].toCharArray(), 0, StrEDPName[0].length());
		        	EDPName1.setTextColor(Color.RED);
		        }
		        if(StrEDPName[1].equals("")){
		        	EDPName2.setText("文本内容2");
		        	EDPName2.setTextSize(45);
		        }
		        else
		        {
		        	EDPName2.setText(StrEDPName[1].toCharArray(), 0, StrEDPName[1].length());
		        	EDPName2.setTextSize(45);
		        	EDPName2.setTextColor(Color.GREEN);
		        }
		        if(StrEDPName[2].equals("")){
		        	EDPName3.setText("文本内容3");
		        	EDPName3.setTextSize(25);
		        }
		        else
		        {
		        	EDPName3.setText(StrEDPName[2].toCharArray(), 0, StrEDPName[2].length());
		        	EDPName3.setTextSize(25);
		        	EDPName3.setTextColor(Color.BLUE);
		        }
		        MainActivity MA=(MainActivity) getActivity();
		        MA.setEDPTextinformation(StrEDPName,StrEDPNameFont);//传递参数
		        Toast.makeText(getActivity(), "保存完成",Toast.LENGTH_SHORT).show();
				}
			});
        /*
         * 设置字体
         */
        EDPName1.setTypeface(EDPTF[0]);
        EDPName2.setTypeface(EDPTF[1]);
        EDPName3.setTypeface(EDPTF[2]);
        /*
         * 设置文本
         */
        if(StrEDPName[0].equals("")){
        	EDPName1.setText("文本内容1");
        }
        else
        {
        	EDPName1.setText(StrEDPName[0].toCharArray(), 0, StrEDPName[0].length());
        	EDPName1.setTextColor(Color.RED);        	
        }
        if(StrEDPName[1].equals("")){
        	EDPName2.setText("文本内容2");
        	EDPName2.setTextSize(45);
        }
        else
        {
        	EDPName2.setText(StrEDPName[1].toCharArray(), 0, StrEDPName[1].length());
        	EDPName2.setTextSize(45);
        	EDPName2.setTextColor(Color.GREEN);
        }
        if(StrEDPName[2].equals("")){
        	EDPName3.setText("文本内容3");
        	EDPName3.setTextSize(25);
        }
        else
        {
        	EDPName3.setText(StrEDPName[2].toCharArray(), 0, StrEDPName[2].length());
        	EDPName3.setTextSize(25);
        	EDPName3.setTextColor(Color.BLUE);
        }
	    return rootView;    
	} 
}
