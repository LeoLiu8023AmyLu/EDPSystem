package com.anshare.edpsystem;

import android.text.format.DateFormat;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
    private int[] Set_Up_Down=new int[3];
	private int[] Set_Left_Right=new int[3];
	private int[] Set_Text_Size=new int[3];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new MainWindow()).commit();
		}
		Set_Text_Size[0]=90;
		Set_Text_Size[1]=45;
		Set_Text_Size[2]=25;
		Set_Up_Down[0]=0;
		Set_Up_Down[1]=0;
		Set_Up_Down[2]=0;
		Set_Left_Right[0]=0;
		Set_Left_Right[1]=0;
		Set_Left_Right[2]=0;
		
		
		// ����ʱ�� (����˳���ʱ��Ҫ������Դ)
		new TimeThread().start();
	}
	
	public void setEDPTextinformation(String Name_A,String Name_B,String Name_C)
	{
		//����ֵ
		this.StrEDPName1=Name_A;
		this.StrEDPName2=Name_B;
		this.StrEDPName3=Name_C;	
	} 
	
	public String[] getEDPTextinformation()
	{
		//����ֵ
		String GetBack[]=new String[3];
		GetBack[0]=this.StrEDPName1;
		GetBack[1]=this.StrEDPName2;
		GetBack[2]=this.StrEDPName3;
		return GetBack;
	}
	
	//�ڶ����������
	public void setEDPTextPinformation(int[] Up_Down,int[] Left_Right,int[] Text_Size)
	{
		//����ֵ
		this.Set_Up_Down=Up_Down;
		this.Set_Left_Right=Left_Right;
		this.Set_Text_Size=Text_Size;	
	} 
	
	public int[][] getEDPTextPinformation()
	{
		//����ֵ
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
                	//ʱ�����
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);
                    CharSequence sysDateStr = DateFormat.format("yyyy-MM-dd", sysTime);
        			//��ʼ���ؼ�
                    TextView MainTime=(TextView)findViewById(R.id.MainTime);
        			TextView MainDate=(TextView)findViewById(R.id.MainDate);
        			//��ʼ�� ����
        			Calendar c = Calendar.getInstance();
        			int week =c.get(Calendar.DAY_OF_WEEK);
        			String[] weekname={"����","��һ","�ܶ�","����","����","����","����"};
        			//����UI
        			MainTime.setText(sysTimeStr);
        			MainDate.setText(sysDateStr+"  "+weekname[week-1]);
                    break;             
           default:
                    break;
            }
        }
    };
    
	
}
