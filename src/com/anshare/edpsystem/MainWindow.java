package com.anshare.edpsystem;

import java.util.Calendar;
import android.app.Fragment;  
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainWindow extends Fragment {

	public MainWindow() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		Button MainEnterBT=(Button)rootView.findViewById(R.id.button_MainEnter);
		MainEnterBT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				getFragmentManager().beginTransaction().add(R.id.container, new FModelchoose()).commit();
			}
			});
		Button MainAutoSetBT=(Button)rootView.findViewById(R.id.button_MainAutoset);
		MainAutoSetBT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//do something
				Toast.makeText(getActivity(), "�ݲ�֧�֣���ȴ��������",Toast.LENGTH_SHORT).show();
				}
			});
		//��ʼ�� �ؼ�
		TextView MainTime=(TextView)rootView.findViewById(R.id.MainTime);
		TextView MainDate=(TextView)rootView.findViewById(R.id.MainDate);
		Calendar c = Calendar.getInstance();  
		//��ȡʱ�䣬�ֱ�����ʱ��������
		long sysTime = System.currentTimeMillis();
		CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);
        CharSequence sysDateStr = DateFormat.format("yyyy-MM-dd", sysTime);
		//��������
        int week =c.get(Calendar.DAY_OF_WEEK);
		String[] weekname={"����","��һ","�ܶ�","����","����","����","����"};
		//������õ���ʱ����Ϣ���͸�UI
		MainTime.setText(sysTimeStr);
		MainDate.setText(sysDateStr+"  "+weekname[week-1]);
		return rootView;   
	} 
}
