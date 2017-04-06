package com.anshare.edpsystem;

import android.text.format.DateFormat;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends Activity {

	private static final int msgKey1 = 1;
    public static Boolean TimeFlag=true;
    private String[] StrEDPName=new String[3];
    private String[] StrEDPNameFont=new String[3];
    private int[] Set_Up_Down=new int[3];
	private int[] Set_Left_Right=new int[3];
	private int[] Set_Text_Size=new int[3];
	private Typeface[] EDPTF=new Typeface[3];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new MainWindow()).commit();
		}
		/*
		 * 初始化 电子席卡的数值
		 * @ 字体大小、字体上下位置、字体左右位置、显示文字、字体
		 */
		// 文字大小
		Set_Text_Size[0]=100;
		Set_Text_Size[1]=40;
		Set_Text_Size[2]=35;
		// 文字位置
		Set_Up_Down[0]=0;
		Set_Up_Down[1]=0;
		Set_Up_Down[2]=0;
		Set_Left_Right[0]=0;
		Set_Left_Right[1]=0;
		Set_Left_Right[2]=0;
		// 文字字体
		for(int i=0;i<3;i++)
        {
        	StrEDPName[i]="文本内容"+Integer.toString(i+1)+"";	// 初始化 文本信息
        	StrEDPNameFont[i]="fonts/HWXW.ttf";				// 初始化 文本字体
        }
		// 字体对象
		EDPTF[0] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[0]);
		EDPTF[1] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[1]);
		EDPTF[2] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[2]);
		// 用一个线程不断更新时间
		new TimeThread().start();
	}
	
	/*
	 * 重点接口程序
	 * @ 文字信息、字体信息的传入接口，传出函数
	 */
	public void setEDPTextinformation(String[] Name,String[] Name_Font)
	{
		//传入文本信息数组[]、字体信息数组[]
		this.StrEDPName=Name;
		this.StrEDPNameFont=Name_Font;	
	} 
	
	public String[] getEDPTextinformation()
	{
		//返回文本信息数组
		String GetBack[]=new String[3];
		GetBack=StrEDPName;
		return GetBack;
	}
	public String[] getEDPTextFontinformation()
	{
		//返回文本信息数组
		String GetBack[]=new String[3];
		GetBack=StrEDPNameFont;
		return GetBack;
	}
	public Typeface[] getEDPTextFontSetting()
	{
		//返回字体对象类型数组[]
		Typeface GetBack[]=new Typeface[3]; // 新建字体对象类型
		EDPTF[0] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[0]); //加载字体
		EDPTF[1] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[1]); //加载字体
		EDPTF[2] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[2]); //加载字体
		GetBack=EDPTF;
		return GetBack;
	}
	/*
	 * 重点接口程序
	 * @ 文字位置、大小的传入接口，传出函数
	 */
	public void setEDPTextPinformation(int[] Up_Down,int[] Left_Right,int[] Text_Size)
	{
		//传入字体上下位置数组[]，字体左右位置数组[]，字体大小数组[]
		this.Set_Up_Down=Up_Down;
		this.Set_Left_Right=Left_Right;
		this.Set_Text_Size=Text_Size;	
	} 
	
	public int[][] getEDPTextPinformation()
	{
		//返回 由 字体上下位置数组[]，字体左右位置数组[]，字体大小数组[] 组成的二维数组
		int[][] GetBack=new int[3][3];
		GetBack[0]=this.Set_Up_Down;
		GetBack[1]=this.Set_Left_Right;
		GetBack[2]=this.Set_Text_Size;
		return GetBack;
	}
	
	public class TimeThread extends Thread {
        @Override
       public void run () {
            do {
                try {
                    Thread.sleep(1000);//一秒的时间间隔
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
                	//获取时间
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);	// 获取时间
                    CharSequence sysDateStr = DateFormat.format("yyyy-MM-dd", sysTime);	// 获取日期
        			//获取控件
                    TextView MainTime=(TextView)findViewById(R.id.MainTime);
        			TextView MainDate=(TextView)findViewById(R.id.MainDate);
        			//解算时间
        			Calendar c = Calendar.getInstance();
        			int week =c.get(Calendar.DAY_OF_WEEK);
        			String[] weekname={"周日","周一","周二","周三","周四","周五","周六"};
        			//更新 UI
        			MainTime.setText(sysTimeStr);
        			MainDate.setText(sysDateStr+"  "+weekname[week-1]);
                    break;             
           default:
                    break;
            }
        }
    };
    
	
}
