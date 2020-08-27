package com.gentek.lib_pullalive.app;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * 一个轻量的后台job service,利用空闲时间执行一些小事情，提高进程不被回收的概率
 */
@TargetApi(value = Build.VERSION_CODES.LOLLIPOP)
public class AliveJobService extends JobService {
    private static final String TAG = AliveJobService.class.getName();

    private JobScheduler mJobScheduler;// 调度类

    private Handler mJobHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            Log.d(TAG, "pull alive.");
            jobFinished((JobParameters) msg.obj, true);
            return true;
        }
    });

    public static void start(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(context, AliveJobService.class);
            context.startService(intent);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        JobInfo job = initJobInfo(startId);
        // 提交自己的job到system process中
        if (mJobScheduler.schedule(job) <= 0) {
            Log.d(TAG, "AliveJobService failed");// 启动失败
        } else {
            Log.d(TAG, "AliveJobService success");
        }
        return START_STICKY;
    }

    //开始任务
    @Override
    public boolean onStartJob(JobParameters params) {
        mJobHandler.sendMessage(Message.obtain(mJobHandler, 1, params));
        return true;
    }

    //结束任务
    @Override
    public boolean onStopJob(JobParameters params) {
        mJobHandler.sendEmptyMessage(1);
        return false;
    }

    //执行条件
    private JobInfo initJobInfo(int startId) {
        JobInfo.Builder builder = new JobInfo.Builder(startId,
                new ComponentName(getPackageName(), AliveJobService.class.getName()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//版本大于24
            builder.setMinimumLatency(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS); //执行的最小延迟时间
            builder.setOverrideDeadline(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);  //执行的最长延时时间
            builder.setBackoffCriteria(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS,
                    JobInfo.BACKOFF_POLICY_LINEAR);//线性重试方案
        } else {// 24以下
            builder.setPeriodic(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);
        }
        // 至少要提交一个条件，不然系统不知道什么情况要调用，所以会调度失败
        builder.setPersisted(false);// 持久，音乐关闭就关闭
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE);// 网络条件  任何一个网络
        builder.setRequiresCharging(true);// 充电的时候是否执行
        return builder.build();
    }
}
