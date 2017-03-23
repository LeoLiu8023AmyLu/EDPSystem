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
		// ��ʼ������
		Set_Text_Size[0]=100;
		Set_Text_Size[1]=40;
		Set_Text_Size[2]=35;
		
		Set_Up_Down[0]=0;
		Set_Up_Down[1]=0;
		Set_Up_Down[2]=0;
		
		Set_Left_Right[0]=0;
		Set_Left_Right[1]=0;
		Set_Left_Right[2]=0;
		
		StrEDPName[0]="���ĿƼ�";
		StrEDPName[1]="Anshare";
		StrEDPName[2]="�Ͼ����ĵ��ӿƼ����޹�˾";
		
		StrEDPNameFont[0]="fonts/HWXW.ttf";
		StrEDPNameFont[1]="fonts/FZXBSJW.TTF";
		StrEDPNameFont[2]="fonts/FZKTJW.TTF";
		
		EDPTF[0] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[0]);
		EDPTF[1] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[1]);
		EDPTF[2] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[2]);
		
		// ����ʱ�� (����˳���ʱ��Ҫ������Դ)
		new TimeThread().start();
	}
	
	/*
	 * ���� ������Ϣ��������Ϣ
	 * ���� �ı���Ϣ  ������Ϣ
	 */
	public void setEDPTextinformation(String[] Name,String[] Name_Font)
	{
		// ������ֵ�� MainActivity
		this.StrEDPName=Name;
		this.StrEDPNameFont=Name_Font;	
	} 
	
	public String[] getEDPTextinformation()
	{
		//����ֵ ���ص�����
		String GetBack[]=new String[3];
		GetBack=StrEDPName;
		return GetBack;
	}
	
	public Typeface[] getEDPTextFontinformation()
	{
		//����ֵ ���ص�����
		Typeface GetBack[]=new Typeface[3];
		EDPTF[0] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[0]);
		EDPTF[1] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[1]);
		EDPTF[2] = Typeface.createFromAsset(getAssets(), StrEDPNameFont[2]);
		GetBack=EDPTF;
		return GetBack;
	}
	
	/*
	 * ���ݺ����ӿ�
	 * ���������λ����Ϣ ��С��Ϣ 
	 */
	public void setEDPTextPinformation(int[] Up_Down,int[] Left_Right,int[] Text_Size)
	{
		//����ֵ ���� ����λ�� �����С
		this.Set_Up_Down=Up_Down;
		this.Set_Left_Right=Left_Right;
		this.Set_Text_Size=Text_Size;	
	} 
	
	public int[][] getEDPTextPinformation()
	{
		//����ֵ ����λ�� �����С
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
