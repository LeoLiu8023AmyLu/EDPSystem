package com.anshare.edpsystem;

import android.app.Fragment;  
import android.os.Bundle;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FModelchoose extends Fragment {

	public FModelchoose() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.f_modelchoose, container, false);
		// 初始化控件
		TextView FSet1_0Dital1=(TextView)rootView.findViewById(R.id.FSet1_0Dital1);
		TextView FSet1_0Dital2=(TextView)rootView.findViewById(R.id.FSet1_0Dital2);
		TextView FSet1_0Dital3=(TextView)rootView.findViewById(R.id.FSet1_0Dital3);
		Button FSet1_back=(Button)rootView.findViewById(R.id.FSet1_back);
		FSet1_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().replace(R.id.container, new MainWindow()).commit();
				getFragmentManager().beginTransaction().remove(new FModelchoose()).commit();
				}
			});
		Button FSet1_next=(Button)rootView.findViewById(R.id.FSet1_next);
		FSet1_next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FSetText()).commit();
				getFragmentManager().beginTransaction().remove(new FModelchoose()).commit();
				}
			});
		Button FSet1_input=(Button)rootView.findViewById(R.id.FSet1_input);
		FSet1_input.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				Toast.makeText(getActivity(), "暂不支持此项功能，请等待开发完成",Toast.LENGTH_SHORT).show();
				}
			});
		FSet1_0Dital1.setText("模板名称");
		FSet1_0Dital2.setText("导入时间");
		FSet1_0Dital3.setText("详情：");
	    return rootView;    
	} 
}
