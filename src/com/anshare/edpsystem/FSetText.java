package com.anshare.edpsystem;

import java.util.HashMap;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class FSetText extends Fragment {
	
	private String[] StrEDPName=new String[3];
	private String[] StrEDPNameFont=new String[3];
	private Typeface[] EDPTF=new Typeface[3];
	private HashMap<String, String> EDPFont_Map = new HashMap<String, String>();
	private HashMap<String, String> EDPFont_Map_Spinner = new HashMap<String, String>();
	
	public FSetText() { }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_textinput, container, false);
		/*
		 * 初始化 字体字典
		 * @ 字体-->字体路径
		 */
		EDPFont_Map.put("华文新魏", "fonts/HWXW.ttf");
		EDPFont_Map.put("方正楷体", "fonts/FZKTJW.TTF");
		EDPFont_Map.put("方正黑体", "fonts/FZHTJW.TTF");
		EDPFont_Map.put("方正小标宋", "fonts/FZXBSJW.TTF");
		EDPFont_Map.put("方正仿宋", "fonts/FZFSJW.TTF");
		EDPFont_Map.put("仿宋_GB2312", "fonts/simfang.ttf");
		EDPFont_Map.put("楷体_GB2312", "fonts/simkai.ttf");
		EDPFont_Map.put("微软雅黑", "fonts/MSYH.TTF");
		// 为 Spinner 选择用的遍历 Map
		EDPFont_Map_Spinner.put("fonts/HWXW.ttf","华文新魏");
		EDPFont_Map_Spinner.put("fonts/FZKTJW.TTF","方正楷体");
		EDPFont_Map_Spinner.put("fonts/FZHTJW.TTF","方正黑体");
		EDPFont_Map_Spinner.put("fonts/FZXBSJW.TTF","方正小标宋");
		EDPFont_Map_Spinner.put("fonts/FZFSJW.TTF","方正仿宋");
		EDPFont_Map_Spinner.put("fonts/simfang.ttf","仿宋_GB2312");
		EDPFont_Map_Spinner.put("fonts/simkai.ttf","楷体_GB2312");
		EDPFont_Map_Spinner.put("fonts/MSYH.TTF","微软雅黑");
		//初始化 显示控件
		final TextView EDPName1=(TextView)rootView.findViewById(R.id.text_EDPName1);
		final TextView EDPName2=(TextView)rootView.findViewById(R.id.text_EDPName2);
		final TextView EDPName3=(TextView)rootView.findViewById(R.id.text_EDPName3);
		// 初始化下拉菜单 
		final Spinner EDPName_Font_1=(Spinner) rootView.findViewById(R.id.spinner_EDPName1);
		final Spinner EDPName_Font_2=(Spinner) rootView.findViewById(R.id.spinner_EDPName2);
		final Spinner EDPName_Font_3=(Spinner) rootView.findViewById(R.id.spinner_EDPName3);
		// 初始化 输入文本框
        final EditText Input_EDPName1 =(EditText) rootView.findViewById(R.id.edittext_EDPName1);  
        final EditText Input_EDPName2 =(EditText) rootView.findViewById(R.id.edittext_EDPName2);  
        final EditText Input_EDPName3 =(EditText) rootView.findViewById(R.id.edittext_EDPName3);  
        // 初始化数值 文本信息、字体信息
        MainActivity MA0=(MainActivity) getActivity();
		String[] GetText=new String[3];
		GetText=MA0.getEDPTextinformation();
		this.StrEDPName=GetText;
		String[] GetFont=new String[3];
		GetFont=MA0.getEDPTextFontinformation();
		this.StrEDPNameFont=GetFont;
		Typeface[] GetTextFont=new Typeface[3];
		GetTextFont=MA0.getEDPTextFontSetting();
		this.EDPTF=GetTextFont;
		Input_EDPName1.setText(StrEDPName[0]);
		Input_EDPName2.setText(StrEDPName[1]);
		Input_EDPName3.setText(StrEDPName[2]);
		// 设置 下拉列表 默认选择值
		setSpinnerItemSelectedByValue(EDPName_Font_1,EDPFont_Map_Spinner.get(StrEDPNameFont[0]));
		setSpinnerItemSelectedByValue(EDPName_Font_2,EDPFont_Map_Spinner.get(StrEDPNameFont[1]));
		setSpinnerItemSelectedByValue(EDPName_Font_3,EDPFont_Map_Spinner.get(StrEDPNameFont[2]));
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
				for(int i=0;i<3;i++)
		        {
					StrEDPName[i]="文本内容"+Integer.toString(i+1)+"";
		        	StrEDPNameFont[i]="fonts/HWXW.ttf";
		        }
				EDPName1.setText(StrEDPName[0]);
				EDPName2.setText(StrEDPName[1]);
				EDPName3.setText(StrEDPName[2]);
		        MainActivity MA=(MainActivity) getActivity();
		        MA.setEDPTextinformation(StrEDPName,StrEDPNameFont);//传递参数
		        // 字体部分处理
		        Typeface[] GetTextFont=new Typeface[3];
				GetTextFont=MA.getEDPTextFontSetting();
				EDPTF=GetTextFont;
				EDPName1.setTypeface(EDPTF[0]);
		        EDPName2.setTypeface(EDPTF[1]);
		        EDPName3.setTypeface(EDPTF[2]);
		        setSpinnerItemSelectedByValue(EDPName_Font_1,EDPFont_Map_Spinner.get(StrEDPNameFont[0]));
				setSpinnerItemSelectedByValue(EDPName_Font_2,EDPFont_Map_Spinner.get(StrEDPNameFont[1]));
				setSpinnerItemSelectedByValue(EDPName_Font_3,EDPFont_Map_Spinner.get(StrEDPNameFont[2]));
				}
			});
		
       
		/*
         * 重要的应用按钮
         * 设置文本信息 保存信息
         */
        Button FSet2_TextSet=(Button)rootView.findViewById(R.id.button_textset);
        FSet2_TextSet.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获取文本信息
				StrEDPName[0]=Input_EDPName1.getText().toString();
		        StrEDPName[1]=Input_EDPName2.getText().toString();
		        StrEDPName[2]=Input_EDPName3.getText().toString();
		        // 将文本赋值  
		        if(StrEDPName[0].equals("")){ EDPName1.setText("文本内容1");}
		        else{EDPName1.setText(StrEDPName[0]);}
		        if(StrEDPName[1].equals("")){ EDPName2.setText("文本内容2");}
		        else{EDPName2.setText(StrEDPName[1]);}
		        if(StrEDPName[2].equals("")){ EDPName3.setText("文本内容3");}
		        else{EDPName3.setText(StrEDPName[2]);}
		        // 获取字体设置信息
		        String[] SPEDP_Font=new String[3];
		        SPEDP_Font[0] = EDPName_Font_1.getSelectedItem().toString();
		        SPEDP_Font[1] = EDPName_Font_2.getSelectedItem().toString();
		        SPEDP_Font[2] = EDPName_Font_3.getSelectedItem().toString();
		        // 这边需要进行字体对照匹配映射 华文新魏-->HWXW.tff
		        for(int i=0;i<3;i++)
		        {
		        	StrEDPNameFont[i]=EDPFont_Map.get(SPEDP_Font[i]);
		        }
		        // 加载字体
		        MainActivity MA=(MainActivity) getActivity();
		        MA.setEDPTextinformation(StrEDPName,StrEDPNameFont);//传递参数
		        // 字体部分处理
		        Typeface[] GetTextFont=new Typeface[3];
				GetTextFont=MA.getEDPTextFontSetting();
				EDPTF=GetTextFont;
				EDPName1.setTypeface(EDPTF[0]);
		        EDPName2.setTypeface(EDPTF[1]);
		        EDPName3.setTypeface(EDPTF[2]);
		        setSpinnerItemSelectedByValue(EDPName_Font_1,EDPFont_Map_Spinner.get(StrEDPNameFont[0]));
				setSpinnerItemSelectedByValue(EDPName_Font_2,EDPFont_Map_Spinner.get(StrEDPNameFont[1]));
				setSpinnerItemSelectedByValue(EDPName_Font_3,EDPFont_Map_Spinner.get(StrEDPNameFont[2]));
		        // 提示
		        Toast.makeText(getActivity(), "保存完成",Toast.LENGTH_SHORT).show();
		        Toast.makeText(getActivity(), "字体文件：\n"
		        		+"字体1："+SPEDP_Font[0]+" 转换："+StrEDPNameFont[0]+" \n"
		        		+"字体2："+SPEDP_Font[1]+" 转换："+StrEDPNameFont[1]+" \n"
		        		+"字体3："+SPEDP_Font[2]+" 转换："+StrEDPNameFont[2]+"",Toast.LENGTH_SHORT).show();
				}
			});
        /*
         * 设置字体 字体大小
         */
        EDPName1.setTypeface(EDPTF[0]);
        EDPName2.setTypeface(EDPTF[1]);
        EDPName3.setTypeface(EDPTF[2]);
        // 字体大小
        EDPName2.setTextSize(45);
        EDPName3.setTextSize(25);
        /*
         * 设置文本
         */
        if(StrEDPName[0].equals("")){ EDPName1.setText("文本内容1");}
        else{EDPName1.setText(StrEDPName[0]);}
        if(StrEDPName[1].equals("")){ EDPName2.setText("文本内容2");}
        else{EDPName2.setText(StrEDPName[1]);}
        if(StrEDPName[2].equals("")){ EDPName3.setText("文本内容3");}
        else{EDPName3.setText(StrEDPName[2]);}
	    return rootView;    
	}
	
	/**  
	 * 根据值, 设置spinner默认选中:  
	 * @param spinner  
	 * @param value  
	 */  
	public static void setSpinnerItemSelectedByValue(Spinner spinner,String value){  
	      
	    SpinnerAdapter apsAdapter= spinner.getAdapter(); //得到SpinnerAdapter对象  
	    int k= apsAdapter.getCount();  
	    for(int i=0;i<k;i++){  
	        if(value.equals(apsAdapter.getItem(i).toString())){  
	            spinner.setSelection(i,true);// 默认选中项  
	            break;  
	        }  
	    }  
	}
}