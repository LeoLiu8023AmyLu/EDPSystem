package com.anshare.edpsystem;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FSetPText extends Fragment {
	
	private String[] StrEDPName=new String[3];
	private Typeface[] EDPTF=new Typeface[3];
	private int[] C_Up_Down=new int[3];
	private int[] C_Left_Right=new int[3];
	private String Text_Size_Temp="";
	private int[] Text_Size=new int[3];
	private int EDP_Name_Flag=0, right, bottom;
	private int[] left=new int[3], top=new int[3];

	public FSetPText() { }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_textpset, container, false);
		// 初始化 控件
		// 主要显示部分
		final RelativeLayout Rlayout=(RelativeLayout) rootView.findViewById(R.id.F2_RelativeLayout);
		right = bottom = 0;
		final LinearLayout.LayoutParams params0 = new LinearLayout.LayoutParams(
			    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		final LinearLayout.LayoutParams paramsA = new LinearLayout.LayoutParams(
		    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		final LinearLayout.LayoutParams paramsB = new LinearLayout.LayoutParams(
			    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		final LinearLayout.LayoutParams paramsC = new LinearLayout.LayoutParams(
			    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

		final TextView EDPName1=new TextView(this.getActivity());
		final TextView EDPName2=new TextView(this.getActivity());
		final TextView EDPName3=new TextView(this.getActivity());
		// 字体位置
		final TextView Text_UP_Down_Num=(TextView)rootView.findViewById(R.id.textUp_Down_Number);
		final TextView Text_Left_Right_Num=(TextView)rootView.findViewById(R.id.textLeft_Right_Number);
		// 字体大小
		final EditText Input_Text_Size =(EditText) rootView.findViewById(R.id.text_size_input);  
        Button FSet3_TextPSet_Size=(Button) rootView.findViewById(R.id.button_textsize_set);
        // 方向
        Button FSet3_TextPSet_Up=(Button)rootView.findViewById(R.id.button_up);
        Button FSet3_TextPSet_Down=(Button)rootView.findViewById(R.id.button_down);
        Button FSet3_TextPSet_Left=(Button)rootView.findViewById(R.id.button_left);
        Button FSet3_TextPSet_Right=(Button)rootView.findViewById(R.id.button_right);
        // 快速居中
        Button FSet3_TextPSet_UpDown_Center=(Button) rootView.findViewById(R.id.button_up_down_center);
        Button FSet3_TextPSet_Left_Right_Center=(Button) rootView.findViewById(R.id.button_left_right_center);
		// 字体 调整
        Button FSet3_TextPSet_Size_Up=(Button) rootView.findViewById(R.id.button_textsize_up);
        Button FSet3_TextPSet_Size_Down=(Button) rootView.findViewById(R.id.button_textsize_down);
        // 全盘保存
        Button FSet3_TextPSet=(Button)rootView.findViewById(R.id.button_textpset);
		// 获取文字信息
		MainActivity MA0=(MainActivity) getActivity();
		String[] GetText=new String[3];
		GetText=MA0.getEDPTextinformation();
		this.StrEDPName=GetText;
		int[][] GetInput=MA0.getEDPTextPinformation();
		C_Up_Down=GetInput[0];
		C_Left_Right=GetInput[1];
		Text_Size=GetInput[2];
		Typeface[] GetTextFont=new Typeface[3];
		GetTextFont=MA0.getEDPTextFontSetting();
		this.EDPTF=GetTextFont;
		//设置文字信息
		EDPName1.setText(StrEDPName[0]);
		EDPName1.setTextSize(Text_Size[0]);
		EDPName1.setTextColor(Color.LTGRAY);
		EDPName1.setTypeface(EDPTF[0]);
		EDPName2.setText(StrEDPName[1]);
		EDPName2.setTextSize(Text_Size[1]);
		EDPName2.setTextColor(Color.BLACK);
		EDPName2.setTypeface(EDPTF[1]);
		EDPName3.setText(StrEDPName[2]);
		EDPName3.setTextSize(Text_Size[2]);
		EDPName3.setTextColor(Color.BLACK);
        EDPName3.setTypeface(EDPTF[2]);
		// 设置偏移部分
		// 布局的长宽
		int RLW=Rlayout.getLayoutParams().width;
		int RLH=Rlayout.getLayoutParams().height;
		top[0]=RLH/3-80; // 10
		top[1]=RLH*2/3-70; // 120
		top[2]=RLH-120; //200
		//第一个文字位置
		paramsA.setMargins(left[0]+C_Left_Right[0], top[0]+C_Up_Down[0], right, bottom);
		EDPName1.setLayoutParams(paramsA);
		//第二个文字位置
		paramsB.setMargins(left[1]+C_Left_Right[1], top[1]+C_Up_Down[1], right, bottom);
		EDPName2.setLayoutParams(paramsB);
		//第三个文字位置
		paramsC.setMargins(left[2]+C_Left_Right[2], top[2]+C_Up_Down[2], right, bottom);
		EDPName3.setLayoutParams(paramsC);
		// 初始化层
		final LinearLayout EDPLL1 = new LinearLayout(this.getActivity());
		EDPLL1.setOrientation(LinearLayout.VERTICAL);
		
		final LinearLayout EDPLL2 = new LinearLayout(this.getActivity());
		EDPLL2.setOrientation(LinearLayout.VERTICAL);
		
		final LinearLayout EDPLL3 = new LinearLayout(this.getActivity());
		EDPLL3.setOrientation(LinearLayout.VERTICAL);
		// 设置层控件属性
		params0.setMargins(0,0,0,0);
		EDPLL1.addView(EDPName1);
		EDPName1.setGravity(Gravity.CENTER);
		EDPLL1.setLayoutParams(params0);	// 设置层的偏移属性
		EDPLL2.addView(EDPName2);
		EDPName2.setGravity(Gravity.CENTER);
		EDPLL2.setLayoutParams(params0);	// 设置层的偏移属性
		EDPLL3.addView(EDPName3);
		EDPName3.setGravity(Gravity.CENTER);
		EDPLL3.setLayoutParams(params0);	// 设置层的偏移属性
		
		Rlayout.addView(EDPLL1);
		Rlayout.addView(EDPLL2);
		Rlayout.addView(EDPLL3);
		// 显示调试的内容
		Toast.makeText(getActivity(), "调试信息：\n画布大小 RLW "+RLW+"  RLH "+RLH+"\n"
				+"EDPName1 Left "+left[0]+" L&R "+C_Left_Right[0]+" Top "+top[0]+" U&D "+C_Up_Down[0]+"\n"
				+"EDPName2 Left "+left[1]+" L&R "+C_Left_Right[1]+" Top "+top[1]+" U&D "+C_Up_Down[1]+"\n"
				+"EDPName3 Left "+left[2]+" L&R "+C_Left_Right[2]+" Top "+top[2]+" U&D "+C_Up_Down[2]+"",Toast.LENGTH_LONG).show();
		// 更新页面的设置信息
		Text_UP_Down_Num.setText(-C_Up_Down[0]+"");
		Text_Left_Right_Num.setText(C_Left_Right[0]+"");
		Input_Text_Size.setText(Text_Size[0]+"");
		/**
		 * 设置显示的对象的监听
		 * 这个后期需要优化(非必须3个项目)
		 */
		//设置监听器
		EDPName1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				EDP_Name_Flag=0;
				EDPName1.setTextColor(Color.LTGRAY);
				EDPName2.setTextColor(Color.BLACK);
				EDPName3.setTextColor(Color.BLACK);
				Text_UP_Down_Num.setText(-C_Up_Down[EDP_Name_Flag]+"");
				Text_Left_Right_Num.setText(C_Left_Right[EDP_Name_Flag]+"");
				Input_Text_Size.setText(Text_Size[EDP_Name_Flag]+"");
			}
		});
		EDPName2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				EDP_Name_Flag=1;
				EDPName1.setTextColor(Color.BLACK);
				EDPName2.setTextColor(Color.LTGRAY);
				EDPName3.setTextColor(Color.BLACK);
				Text_UP_Down_Num.setText(-C_Up_Down[EDP_Name_Flag]+"");
				Text_Left_Right_Num.setText(C_Left_Right[EDP_Name_Flag]+"");
				Input_Text_Size.setText(Text_Size[EDP_Name_Flag]+"");
			}
		});
		EDPName3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				EDP_Name_Flag=2;
				EDPName1.setTextColor(Color.BLACK);
				EDPName2.setTextColor(Color.BLACK);
				EDPName3.setTextColor(Color.LTGRAY);
				Text_UP_Down_Num.setText(-C_Up_Down[EDP_Name_Flag]+"");
				Text_Left_Right_Num.setText(C_Left_Right[EDP_Name_Flag]+"");
				Input_Text_Size.setText(Text_Size[EDP_Name_Flag]+"");
			}
		});
		/**
		 * 页面控制部分
		 * 功能：后退，前进，重置
		 */
		//页面控制
		Button FSet3_back=(Button)rootView.findViewById(R.id.FSet3_back);
		FSet3_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FSetText()).commit();
				}
			});
		Button FSet3_next=(Button)rootView.findViewById(R.id.FSet3_next);
		FSet3_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FPreview()).commit();
				}
			});
		//重置
		Button FSet3_reset=(Button)rootView.findViewById(R.id.FSet3_reset);
		FSet3_reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				C_Up_Down[0]=0;
				C_Up_Down[1]=0;
				C_Up_Down[2]=0;
				C_Left_Right[0]=0;
				C_Left_Right[1]=0;
				C_Left_Right[2]=0;
				Text_Size[0]=100;
				Text_Size[1]=40;
				Text_Size[2]=35;
				EDPName1.setText(StrEDPName[0]);
				EDPName1.setTextSize(Text_Size[0]);
				EDPName1.setTextColor(Color.LTGRAY);
				EDPName2.setText(StrEDPName[1]);
				EDPName2.setTextSize(Text_Size[1]);
				EDPName2.setTextColor(Color.BLACK);
				EDPName3.setText(StrEDPName[2]);
				EDPName3.setTextSize(Text_Size[2]);
				EDPName3.setTextColor(Color.BLACK);
				paramsA.setMargins(left[0]+C_Left_Right[0], top[0]+C_Up_Down[0], right, bottom);
				paramsB.setMargins(left[1]+C_Left_Right[1], top[1]+C_Up_Down[1], right, bottom);
				paramsC.setMargins(left[2]+C_Left_Right[2], top[2]+C_Up_Down[2], right, bottom);
				Text_UP_Down_Num.setText(-C_Up_Down[0]+"");
				Text_Left_Right_Num.setText(C_Left_Right[0]+"");
				Input_Text_Size.setText(Text_Size[0]+"");
				//保存 本页面设置信息
				MainActivity MA=(MainActivity) getActivity();
				MA.setEDPTextPinformation(C_Up_Down, C_Left_Right, Text_Size);
				Toast.makeText(getActivity(), "已重置设置，并保存完成",Toast.LENGTH_SHORT).show();
				}
			});
		/**
		 * 字体位置设置功能部分
		 * 功能：上下左右 调节
		 */
		//字体位置设置部分
		FSet3_TextPSet_Up.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//字体位置 上移
				C_Up_Down[EDP_Name_Flag]=C_Up_Down[EDP_Name_Flag]-1;//转化数据类型
				Text_UP_Down_Num.setText(-C_Up_Down[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){
					paramsA.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName1.setLayoutParams(paramsA);}
				else if(EDP_Name_Flag==1){
					paramsB.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName2.setLayoutParams(paramsB);}
				else if(EDP_Name_Flag==2){
					paramsC.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName3.setLayoutParams(paramsC);}
				}
			});
		FSet3_TextPSet_Down.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//字体位置 下移
				C_Up_Down[EDP_Name_Flag]=C_Up_Down[EDP_Name_Flag]+1;//转化数据类型
				Text_UP_Down_Num.setText(-C_Up_Down[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){
					paramsA.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName1.setLayoutParams(paramsA);}
				else if(EDP_Name_Flag==1){
					paramsB.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName2.setLayoutParams(paramsB);}
				else if(EDP_Name_Flag==2){
					paramsC.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName3.setLayoutParams(paramsC);}
				}
			});
		FSet3_TextPSet_Right.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//字体位置 右移
				C_Left_Right[EDP_Name_Flag]=C_Left_Right[EDP_Name_Flag]+1;//转化数据类型
				Text_Left_Right_Num.setText(C_Left_Right[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){
					paramsA.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName1.setLayoutParams(paramsA);}
				else if(EDP_Name_Flag==1){
					paramsB.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName2.setLayoutParams(paramsB);}
				else if(EDP_Name_Flag==2){
					paramsC.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName3.setLayoutParams(paramsC);}
				}
			});
		FSet3_TextPSet_Left.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//字体位置 左移
				C_Left_Right[EDP_Name_Flag]=C_Left_Right[EDP_Name_Flag]-1;//转化数据类型
				Text_Left_Right_Num.setText(C_Left_Right[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){
					paramsA.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName1.setLayoutParams(paramsA);}
				else if(EDP_Name_Flag==1){
					paramsB.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName2.setLayoutParams(paramsB);}
				else if(EDP_Name_Flag==2){
					paramsC.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName3.setLayoutParams(paramsC);}
				}
			});
		/**
		 * 字体位置 居中 快速设置
		 */
		FSet3_TextPSet_UpDown_Center.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//字体位置 左移
				C_Up_Down[EDP_Name_Flag]=0;//转化数据类型
				Text_UP_Down_Num.setText(-C_Up_Down[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){
					paramsA.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName1.setLayoutParams(paramsA);}
				else if(EDP_Name_Flag==1){
					paramsB.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName2.setLayoutParams(paramsB);}
				else if(EDP_Name_Flag==2){
					paramsC.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName3.setLayoutParams(paramsC);}
				}
			});
		FSet3_TextPSet_Left_Right_Center.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//字体位置 左移
				C_Left_Right[EDP_Name_Flag]=0;//转化数据类型
				Text_Left_Right_Num.setText(C_Left_Right[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){
					paramsA.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName1.setLayoutParams(paramsA);}
				else if(EDP_Name_Flag==1){
					paramsB.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName2.setLayoutParams(paramsB);}
				else if(EDP_Name_Flag==2){
					paramsC.setMargins((left[EDP_Name_Flag]+C_Left_Right[EDP_Name_Flag]), (top[EDP_Name_Flag]+C_Up_Down[EDP_Name_Flag]), right, bottom);
					EDPName3.setLayoutParams(paramsC);}
				}
			});
		/**
		 * 字体设置部分
		 * @ 监听按钮：更改、增大、减小
		 * @ 更改 显示数字，显示字体的大小
		 */
		FSet3_TextPSet_Size.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//输入框设置 字体大小
				Text_Size_Temp=Input_Text_Size.getText().toString();//获取输入框数据
				Text_Size[EDP_Name_Flag]=Integer.parseInt(Text_Size_Temp);//转化数据类型
				Input_Text_Size.setText(Text_Size[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){EDPName1.setTextSize(Text_Size[EDP_Name_Flag]);}
				else if(EDP_Name_Flag==1){EDPName2.setTextSize(Text_Size[EDP_Name_Flag]);}
				else if(EDP_Name_Flag==2){EDPName3.setTextSize(Text_Size[EDP_Name_Flag]);}
				}
			});
		FSet3_TextPSet_Size_Up.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//输入框设置 字体大小
				Text_Size[EDP_Name_Flag]=Text_Size[EDP_Name_Flag]+1;//转化数据类型
				Input_Text_Size.setText(Text_Size[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){EDPName1.setTextSize(Text_Size[EDP_Name_Flag]);}
				else if(EDP_Name_Flag==1){EDPName2.setTextSize(Text_Size[EDP_Name_Flag]);}
				else if(EDP_Name_Flag==2){EDPName3.setTextSize(Text_Size[EDP_Name_Flag]);}
				}
			});
		FSet3_TextPSet_Size_Down.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				//输入框设置 字体大小
				Text_Size[EDP_Name_Flag]=Text_Size[EDP_Name_Flag]-1;//转化数据类型
				Input_Text_Size.setText(Text_Size[EDP_Name_Flag]+"");
				if(EDP_Name_Flag==0){EDPName1.setTextSize(Text_Size[EDP_Name_Flag]);}
				else if(EDP_Name_Flag==1){EDPName2.setTextSize(Text_Size[EDP_Name_Flag]);}
				else if(EDP_Name_Flag==2){EDPName3.setTextSize(Text_Size[EDP_Name_Flag]);}
				}
			});
		/**
		 * 全局保存功能
		 * @ 将此界面的所有参数 以数组的形式传递给 MainActivity
		 * @ 数组为：上下位置，左右位置，字体大小
		 */   
        FSet3_TextPSet.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				//保存 本页面设置信息
				MainActivity MA=(MainActivity) getActivity();
				MA.setEDPTextPinformation(C_Up_Down, C_Left_Right, Text_Size);
				Toast.makeText(getActivity(), "保存完成",Toast.LENGTH_SHORT).show();
				Toast.makeText(getActivity(), 
						"EDPName1 Left "+left[0]+"\t L&R "+C_Left_Right[0]+"\t Top "+top[0]+"\t U&D "+C_Up_Down[0]+"\n"
						+"EDPName2 Left "+left[1]+"\t L&R "+C_Left_Right[1]+"\t Top "+top[1]+"\t U&D "+C_Up_Down[1]+"\n"
						+"EDPName3 Left "+left[2]+"\t L&R "+C_Left_Right[2]+"\t Top "+top[2]+"\t U&D "+C_Up_Down[2]+"",Toast.LENGTH_LONG).show();
				}
			});
        
	    return rootView;    
	} 
}