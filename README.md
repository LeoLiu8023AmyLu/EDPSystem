# EDPSystem</br>
EDPSystem 安夏电子席卡 Android 版本 客户端</br>
## 外观要求：</br>
1.轻便可折叠，便携易存储</br>
2.双显示屏 内侧显示屏为触屏操控 (另外可以有亮度调节功能)</br>	
## 功能要求：</br>
1.完成席卡作用(设置+显示)</br>
2.文件共享</br>
3.网络通信</br>
4.自动化设置</br>
5.开机自动启动预定程序</br>
## 硬性要求：</br>
1.续航能力</br>
2.多场景适应能力</br>
## 工作内容：</br>
1.完成向导型设计UI</br>
* 欢迎界面[OK]-></br>
* 模板选取界面[已经完成UI，功能没有实现]-></br>
* 文字设置界面[基本完成，字体选择功能 OK]-></br>
* 字体位置设置界面[基本完成，TextView 显示不全 OK ]-></br>
* 预览界面[OK]-></br>
* 主功能界面[ 目前暂时不考虑编辑 ]->（之后暂时不考虑，改为插件式编程方式）</br>

2.显示席卡图像</br>
* 考虑屏幕分辨率等差异，保证显示效果 </br>
* 目前暂定使用的屏幕分辨率为 1024*600 微雪7寸C型显示器</br>

3.数据传输</br>
* 传输需要的数据有：[背景颜色,文字[],字体[],大小[],位置X[],位置Y[]]</br>

4.SQLite 数据库设计</br>
* 数据库主要存放模板信息 包括初始[背景颜色,文字[],字体[],大小[],位置X[],位置Y[]]</br>

5.文件共享</br>
* 文件共享利用网络访问固定公共空间的资源</br>
* 计划使用技术：FTP 文件共享</br>

## 目前问题：</br>
1.【已经解决】显示问题 TextView 定位问题 setPadding 以及 setMargin，另外fragment 层穿透，或者替换 </br>
* [解决方法:https://segmentfault.com/q/1010000004032766?_ea=464119](https://segmentfault.com/q/1010000004032766?_ea=464119)</br>
* 采用动态加载LinearLayout的方式，把控件放在Layout层中，然后通过控制层从而达到控制控件位置的效果

2.画布缩放问题 </br>
* 布局使用画布尺寸： (128/75)*5 ---> (128/75)*6 ---> (128/75)*8  效果还在优化  </br>
* 目前发现问题是： 字体大小并不与画面大小变化一致 可能需要函数来等比缩放</br>

3.【已经解决】字体加载问题</br>	
	
	'
		// 加载assets中的字体  这个必须在 MainActivity中
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/1.ttf");
		textView1.setTypeface(typeface);
	'
	
* 方法：</br>
	[Android 编程下字库的使用](http://www.cnblogs.com/sunzn/archive/2013/01/22/2871521.html)</br>
	[Android 字体库的使用](http://blog.csdn.net/zuiwuyuan/article/details/49454411)</br>
* 之后就是下来菜单的功能实现：</br>
	[下拉菜单](https://www.oschina.net/question/54100_33274)</br>

4.通信问题 蓝牙、串口 方式</br> 
* 参考资料：</br>
	1.[关于利用android-serialport-api实现在安卓设备上进行串口通信](http://blog.csdn.net/ckw474404603/article/details/37811499)</br>
	2.[Android系统访问串口设备](http://blog.csdn.net/mr_raptor/article/details/21161389)</br>
	3.[Android 串口编程原理和实现方式(附源码)](http://blog.csdn.net/tangcheng_ok/article/details/7021470)</br>
	4.[android 串口编程](http://blog.csdn.net/imyang2007/article/details/8331800/)</br>
	
5.Fragment 打开后还需要回收 否则会出现图层穿透(最下面图层的控件未显示，但是可以输入或者选择)</br>

6.MarkDown [学习网站：http://www.appinn.com/markdown/](http://www.appinn.com/markdown/)</br>

7.【已经解决】Spinner 设置初始值</br>

8. Android 线程资源回收</br>

9.Android JNI 相关资料</br>
* 参考资料：</br>
	1.[深入理解JNI](http://wiki.jikexueyuan.com/project/deep-android-v1/jni.html)</br>
	2.[Android JNI编程—JNI基础](http://www.jianshu.com/p/aba734d5b5cd)</br>
	3.[JNI Tips](https://developer.android.com/training/articles/perf-jni.html)</br>

## 工作记录：</br>
* 2017.03.21 解决字体样式加载问题</br>
* 2017.03.22 下拉列表控件</br>
* 2017.03.23 利用HashMap将 下拉列表得到的字体名称转化为路径，然后传递给MainActivity 经过资源获取到Typeface类型对象，然后再传递回去，从而改变字体 [大进步] 然后优化程序，将文本、字体类型都转成数组形式，方便接口程序进行对接。</br>
* 2017.03.27 全局软件改编码为 utf-8、优化席卡文本输入页面程序，增加Spinner默认选择参数的程序，以及输入文本框的默认程序。修改小Bug+优化程序</br>
* 2017.03.28 研究通信接口 通信协议</br>
* 2017.03.30 研究串口通信接口 通信协议API，树莓派 RTAndroid 软件测试,录像保留资料并公司备份</br>
* 2017.04.06 优化代码结构，添加注释；研究串口通信接口 通信协议API </br>
* 2017.04.07 优化代码结构，添加注释；研究串口通信接口 通信协议API，难度有些大，在看Demo 涉及到 底层的编程；更新了usb-serial 项目文件 </br>
* 2017.04.11 研究usbserial代码 </br>
* 目前遇到了瓶颈 准备先学习一些其他的知识