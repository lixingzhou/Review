package com.mccree.review.module.mpaas.event;

/**
 * Created by: lixingzhou
 * Created Date: 2021/9/13 11:26
 * Description:移动分析管理
 */
public class EventManager {
    private static EventManager manager;

    public static EventManager getInstance() {
        if (manager == null) {
            synchronized (EventManager.class) {
                if (manager == null) {
                    manager = new EventManager();
                }
            }
        }
        return manager;
    }

    private EventManager() {
    }
}
