package com.anshare.edpsystem;

import android.text.format.DateFormat;
import android.util.TimeFormatException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.appcompat.R.color;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends Activity {

	private static final int msgKey1 = 1;
    public static Boolean TimeFlag=true;
    private String StrEDPName1="";  
    private String StrEDPName2=""; 
    private String StrEDPName3="";
    private String StrEDPNameFont1="";  
    private String StrEDPNameFont2=""; 
    private String StrEDPNameFont3="";
    private int C_Up_Down1=0;
	private int C_Up_Down2=0;
	private int C_Up_Down3=0;
	private int C_Left_Right1=0;
	private int C_Left_Right2=0;
	private int C_Left_Right3=0;
	private int Text_Size1=90;
	private int Text_Size2=45;
	private int Text_Size3=25;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new MainWindow()).commit();
		}
		// 更新时间 (最后退出的时候要回收资源)
		new TimeThread().start();
	}
	
	public void setEDPTextinformation(String A,String B,String C)
	{
		//传递值
		this.StrEDPName1=A;
		this.StrEDPName2=B;
		this.StrEDPName3=C;	
	} 
	
	public String[] getEDPTextinformation()
	{
		//传递值
		String GetBack[]=new String[3];
		GetBack[0]=this.StrEDPName1;
		GetBack[1]=this.StrEDPName2;
		GetBack[2]=this.StrEDPName3;
		return GetBack;
	}
	
	//第二层软件设置
	public void setEDPTextPinformation(String A,String B,String C)
	{
		//传递值
		this.StrEDPName1=A;
		this.StrEDPName2=B;
		this.StrEDPName3=C;	
	} 
	
	public String[] getEDPTextPinformation()
	{
		//传递值
		String GetBack[]=new String[3];
		GetBack[0]=this.StrEDPName1;
		GetBack[1]=this.StrEDPName2;
		GetBack[2]=this.StrEDPName3;
		return GetBack;
	}
	
	public class TimeThread extends Thread {
        @Override
       public void run () {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);
               }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(TimeFlag);
        }
    }
	private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                	//时间更新
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);
                    CharSequence sysDateStr = DateFormat.format("yyyy-MM-dd", sysTime);
        			//初始化控件
                    TextView MainTime=(TextView)findViewById(R.id.MainTime);
        			TextView MainDate=(TextView)findViewById(R.id.MainDate);
        			//初始化 日历
        			Calendar c = Calendar.getInstance();
        			int week =c.get(Calendar.DAY_OF_WEEK);
        			String[] weekname={"周日","周一","周二","周三","周四","周五","周六"};
        			//设置UI
        			MainTime.setText(sysTimeStr);
        			MainDate.setText(sysDateStr+"  "+weekname[week-1]);
                    break;             
           default:
                    break;
            }
        }
    };
    
	
}
