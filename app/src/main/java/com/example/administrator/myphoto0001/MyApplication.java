package com.example.administrator.myphoto0001;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;

/**
 * Created by Administrator on 2018/3/22.
 */

public class MyApplication extends Application {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onCreate() {
        super.onCreate();
        //严苛模式   严苛模式的开启就 是让一些潜在问题暴漏在开发阶段的利器
        //链式写法，Builder模式：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());//
        builder.detectFileUriExposure();
    }
}
/*
https://www.jianshu.com/p/652404b3f775
https://www.jianshu.com/p/3f9e3fc38eae
* detectFileUriExposure用来检测应用是否通过file:的方式将文件共享给其他应用，
* google认为用file:///的方式来共享文件是不规范的，
* 因为可能因为文件的访问权限导致共享失败
* StrictMode可以检测出这个潜在的风险点，并给予我们“惩罚”*/