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
import android.widget.Toast;


public class FPreview extends Fragment {
	
	private String StrEDPName1="";  
	private String StrEDPName2=""; 
	private String StrEDPName3="";
	private int[] C_Up_Down=new int[3];
	private int[] C_Left_Right=new int[3];
	private int[] Text_Size=new int[3];
	

	public FPreview() {
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_text_preview, container, false);
		//初始化 控件
		// 主要显示部分
		final TextView EDPName1=(TextView)rootView.findViewById(R.id.F3_text_EDPName1);
		final TextView EDPName2=(TextView)rootView.findViewById(R.id.F3_text_EDPName2);
		final TextView EDPName3=(TextView)rootView.findViewById(R.id.F3_text_EDPName3);
        
		MainActivity MA0=(MainActivity) getActivity();
		String[] GetText=new String[3];
		GetText=MA0.getEDPTextinformation();
		this.StrEDPName1=GetText[0];
		this.StrEDPName2=GetText[1];
		this.StrEDPName3=GetText[2];
		int[][] GetInput=MA0.getEDPTextPinformation();
		C_Up_Down=GetInput[0];
		C_Left_Right=GetInput[1];
		Text_Size=GetInput[2];
		//设置文字信息
		EDPName1.setText(StrEDPName1);
		EDPName1.setTextSize(Text_Size[0]);
		EDPName1.setPadding(C_Left_Right[0], C_Up_Down[0], 0, 0);
		EDPName2.setText(StrEDPName2);
		EDPName2.setTextSize(Text_Size[1]);
		EDPName2.setPadding(C_Left_Right[1], C_Up_Down[1], 0, 0);
		EDPName3.setText(StrEDPName3);
		EDPName3.setTextSize(Text_Size[2]);
		EDPName3.setPadding(C_Left_Right[2], C_Up_Down[2], 0, 0);
		/**
		 * 页面控制部分
		 * 功能：后退，前进，重置
		 */
		//页面控制
		Button FSet4_back=(Button)rootView.findViewById(R.id.FSet4_back);
		FSet4_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FSetPText()).commit();
				}
			});
		Button FSet4_next=(Button)rootView.findViewById(R.id.FSet4_next);
		FSet4_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().replace(R.id.container, new MainWindow()).commit();
				}
			});
		//预览显示
		Button FSet4_view=(Button)rootView.findViewById(R.id.FSet4_preview);
		FSet4_view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				Toast.makeText(getActivity(), "传输完成",Toast.LENGTH_SHORT).show();
				}
			});
        
	    return rootView;    
	} 
}
