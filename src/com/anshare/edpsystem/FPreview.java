package com.anshare.edpsystem;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
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


public class FPreview extends Fragment {
	
	private String[] StrEDPName=new String[3];
	private Typeface[] EDPTF=new Typeface[3];
	private int[] C_Up_Down=new int[3];
	private int[] C_Left_Right=new int[3];
	private int[] Text_Size=new int[3];
	private int right, bottom;
	private int[] left=new int[3], top=new int[3];

	public FPreview() {
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_text_preview, container, false);
		//初始化 控件
		final RelativeLayout Rlayout=(RelativeLayout) rootView.findViewById(R.id.F3_RelativeLayout);
		right = bottom = 0;
		final LinearLayout.LayoutParams params0 = new LinearLayout.LayoutParams(
			    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		final LinearLayout.LayoutParams paramsA = new LinearLayout.LayoutParams(
		    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		final LinearLayout.LayoutParams paramsB = new LinearLayout.LayoutParams(
			    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		final LinearLayout.LayoutParams paramsC = new LinearLayout.LayoutParams(
			    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		// 主要显示部分
		final TextView EDPName1=new TextView(this.getActivity());
		final TextView EDPName2=new TextView(this.getActivity());
		final TextView EDPName3=new TextView(this.getActivity());
		
		MainActivity MA0=(MainActivity) getActivity();
		String[] GetText=new String[3];
		GetText=MA0.getEDPTextinformation();
		this.StrEDPName[0]=GetText[0];
		this.StrEDPName[1]=GetText[1];
		this.StrEDPName[2]=GetText[2];
		int[][] GetInput=MA0.getEDPTextPinformation();
		C_Up_Down=GetInput[0];
		C_Left_Right=GetInput[1];
		Text_Size=GetInput[2];
		Text_Size[0]=Text_Size[0]*6/5;
		Text_Size[1]=Text_Size[1]*6/5;
		Text_Size[2]=Text_Size[2]*6/5;
		Typeface[] GetTextFont=new Typeface[3];
		GetTextFont=MA0.getEDPTextFontinformation();
		this.EDPTF=GetTextFont;
		//设置文字信息
		EDPName1.setText(StrEDPName[0]);
		EDPName1.setTextSize(Text_Size[0]);
		EDPName1.setTextColor(Color.BLACK);
		EDPName1.setTypeface(EDPTF[0]);
		EDPName2.setText(StrEDPName[1]);
		EDPName2.setTextSize(Text_Size[1]);
		EDPName2.setTextColor(Color.BLACK);
		EDPName2.setTypeface(EDPTF[1]);
		EDPName3.setText(StrEDPName[2]);
		EDPName3.setTextSize(Text_Size[2]);
		EDPName3.setTextColor(Color.BLACK);
		EDPName3.setTypeface(EDPTF[2]);
		int RLW=Rlayout.getLayoutParams().width;
		int RLH=Rlayout.getLayoutParams().height;
		top[0]=(RLH/3-80); // 10
		top[1]=(RLH*2/3-70); // 120
		top[2]=(RLH-120); //200
		//第一个文字位置
		paramsA.setMargins(left[0]+C_Left_Right[0], top[0]+C_Up_Down[0], right, bottom);
		EDPName1.setLayoutParams(paramsA);
		//第二个文字位置
		paramsB.setMargins(left[1]+C_Left_Right[1], top[1]+C_Up_Down[1], right, bottom);
		EDPName2.setLayoutParams(paramsB);
		//第三个文字位置
		paramsC.setMargins(left[2]+C_Left_Right[2], top[2]+C_Up_Down[2], right, bottom);
		EDPName3.setLayoutParams(paramsC);
		final LinearLayout EDPLL1 = new LinearLayout(this.getActivity());
		EDPLL1.setOrientation(LinearLayout.VERTICAL);
		
		final LinearLayout EDPLL2 = new LinearLayout(this.getActivity());
		EDPLL2.setOrientation(LinearLayout.VERTICAL);
		
		final LinearLayout EDPLL3 = new LinearLayout(this.getActivity());
		EDPLL3.setOrientation(LinearLayout.VERTICAL);
		params0.setMargins(0,0,0,0);
		EDPLL1.addView(EDPName1);
		EDPName1.setGravity(Gravity.CENTER);
		EDPLL1.setLayoutParams(params0);
		EDPLL2.addView(EDPName2);
		EDPName2.setGravity(Gravity.CENTER);
		EDPLL2.setLayoutParams(params0);
		EDPLL3.addView(EDPName3);
		EDPName3.setGravity(Gravity.CENTER);
		EDPLL3.setLayoutParams(params0);
		
		Rlayout.addView(EDPLL1);
		Rlayout.addView(EDPLL2);
		Rlayout.addView(EDPLL3);
		//
		Toast.makeText(getActivity(), "RLW "+RLW+"  RLH "+RLH+"\n"
				+"EDPName1 Left "+left[0]+" L&R "+C_Left_Right[0]+" Top "+top[0]+" U&D "+C_Up_Down[0]+"\n"
				+"EDPName2 Left "+left[1]+" L&R "+C_Left_Right[1]+" Top "+top[1]+" U&D "+C_Up_Down[1]+"\n"
				+"EDPName3 Left "+left[2]+" L&R "+C_Left_Right[2]+" Top "+top[2]+" U&D "+C_Up_Down[2]+"",Toast.LENGTH_LONG).show();
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
				Toast.makeText(getActivity(), 
						"EDPName1 Left "+left[0]+"\t L&R "+C_Left_Right[0]+"\t Top "+top[0]+"\t U&D "+C_Up_Down[0]+"\n"
						+"EDPName2 Left "+left[1]+"\t L&R "+C_Left_Right[1]+"\t Top "+top[1]+"\t U&D "+C_Up_Down[1]+"\n"
						+"EDPName3 Left "+left[2]+"\t L&R "+C_Left_Right[2]+"\t Top "+top[2]+"\t U&D "+C_Up_Down[2]+"",
						Toast.LENGTH_LONG).show();
				}
			});
        
	    return rootView;    
	} 
}
