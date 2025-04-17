package com.example;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.WatchedEvent;

public class ZooKeeperClient {

    public static void main(String[] args) throws Exception {
        String connectString = "localhost:2181"; // Change if needed
        int sessionTimeout = 2000;

        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("Watcher event: " + event);
            }
        };

        System.out.println("Connecting to ZooKeeper...");
        ZooKeeper zk = new ZooKeeper(connectString, sessionTimeout, watcher);

        String path = "/demo";
        boolean exists = zk.exists(path, false) != null;

        System.out.println("Node " + path + (exists ? " exists." : " does not exist."));

        zk.close();
    }
}
