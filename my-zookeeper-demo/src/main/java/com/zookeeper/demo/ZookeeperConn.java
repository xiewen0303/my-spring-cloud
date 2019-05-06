package com.zookeeper.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ZookeeperConn {

    public static CuratorFramework client = null;
    private static final String PATH = "/path1";


    public static CuratorFramework getClient(){
        if(client == null){
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
            client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
                    .sessionTimeoutMs(5000)
                    .connectionTimeoutMs(5000)
                    .retryPolicy(retryPolicy)
                    .namespace("base")
                    .build();
            client.start();
        }
        return client;
    }


    public static void createDataNode() {
        try {
            CuratorFramework client = getClient();
            if(client != null){
                Object data = client.checkExists().forPath(PATH);
                if(data == null){
                    client.create().forPath(PATH,"init".getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        createDataNode();
        for (int i = 1; i <= 3 ; i++) {
            new MyRun(client,i).start();
        }
    }


}

@Slf4j
class MyRun extends  Thread {
    private CuratorFramework client = null;
    private String PATH = "/path1";
    private int flag;

    public MyRun(CuratorFramework client,int flag){
        this.client = client;
        this.flag = flag;
    }
    @Override
    public void run() {
            InterProcessMutex lock = null;
            try {
                lock = new InterProcessMutex(client,PATH);
                if (!lock.acquire(5L, TimeUnit.SECONDS)) {
                    log.error("doExecute get lock error.");
                    return;
                }

                log.error("{} start doExecute .",flag);

                Thread.sleep(5000);

                log.error("{} end doExecute .",flag);
            }catch (Exception e){
                log.debug("doExecute error",e);
                e.printStackTrace();
            }finally {
                if(lock != null && lock.isAcquiredInThisProcess()){
                    try {
                        lock.release();
                    } catch (Exception e) {
                        log.error("lock release error",e);
                    }
                }
            }
    }
}