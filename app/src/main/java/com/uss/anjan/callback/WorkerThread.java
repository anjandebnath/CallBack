package com.uss.anjan.callback;

/**
 * Created by Anjan on 4/11/2017.
 */

public class WorkerThread {

    private UiCallback mUiCallback;

    private  static WorkerThread instance;


    private WorkerThread(){

    }

    public  static  WorkerThread getInstance(){
        if (instance == null)
              instance = new WorkerThread();

        return instance;
    }

    public void setUiCallback(UiCallback uiCallback){
        mUiCallback= uiCallback;
    }

    public void workDone(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mUiCallback.onUpdateUi("Work Done");
            }
        });
        thread.start();

    }
}
