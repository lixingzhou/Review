package com.mccree.review.module.mpaas;

import android.app.Activity;

import com.alipay.mobile.framework.LauncherApplicationAgent;
import com.mccree.review.utils.LLog;
import com.mpaas.cdp.ActionExecutor;
import com.mpaas.cdp.CdpAdvertisementService;
import com.mpaas.cdp.structure.SpaceInfo;
import com.mpaas.cdp.structure.SpaceObjectInfo;

import java.util.HashMap;

/**
 * Created by: lixingzhou
 * Created Date: 2021/9/10 14:43
 * Description:MPaaS智能投放管理
 */
public class CdpManager {

    private static final String TAG = "CdpManager";

    private static CdpManager manager;

    private CdpAdvertisementService mService;

    private CdpManager() {
    }

    public static CdpManager getInstance() {
        if (manager == null) {
            synchronized (CdpManager.class) {
                if (manager == null) {
                    manager = new CdpManager();
                }
            }
        }
        return manager;
    }

    /**
     * 获取Serview
     *
     * @return
     */
    public CdpAdvertisementService getService() {
        return LauncherApplicationAgent.getInstance().getMicroApplicationContext().findServiceByInterface(CdpAdvertisementService.class.getName());
    }

    /**
     * 检查是否有广告配置(开屏广告)
     *
     * @return
     */
    public boolean checkIfSplashPrepared() {

        if (mService == null) {
            mService = getService();
        }
        if (mService != null) {
            return mService.checkIfSplashPrepared();
        }
        LLog.e(TAG, "return false");
        return false;
    }

    /**
     * 展示开屏广告
     *
     * @param activity
     */
    public void showCdpSplash(Activity activity) {
        if (mService == null) {
            mService = getService();
        }
        mService.doSplash(activity, new HashMap<String, String>(), new CdpAdvertisementService.IAdEventHandler() {
            @Override
            public void onClosed(SpaceInfo spaceInfo) {
                LLog.i(TAG, "Splash onClosed()");
            }

            @Override
            public void onJump(SpaceInfo spaceInfo) {
                // 跳转到活动目标页面
                LLog.d(TAG, "Splash onJump() " + spaceInfo.toString());
//                String url = spaceInfo.spaceObjectList.get(0).actionUrl;
            }
        });

    }

    /**
     * 刷新所有广告
     */
    public void refreshAllCdp() {
        if (null == mService) {
            getService();
        }
        if (null != mService) {
            mService.refresh(new CdpAdvertisementService.IRefreshZoneCallBack() {
                @Override
                public void onStart() {
                    LLog.d(TAG, "refreshAllCdp()  --  onStart()");
                }

                @Override
                public void onEnd() {
                    LLog.d(TAG, "refreshAllCdp()  --  onEnd()");
                }
            });
        }
    }

    /**
     * 通过广告ID  获取对应广告相关数据
     *
     * @param codeId   广告ID
     * @param callback
     */
    public void getSpaceInfoByCode(String codeId, CdpAdvertisementService.IAdGetSingleSpaceInfoCallBack callback) {
        if (mService == null) {
            mService = getService();
        }
        if (mService != null) {
            mService.getSpaceInfoByCode(codeId, callback);
        }
    }

    /**
     * 设置广告Action处理器
     */
    public void setActionExecutor() {
        if (mService == null) {
            mService = getService();
        }
        if (mService != null) {
            mService.setActionExecutor(new ActionExecutor() {
                /**
                 * 是否拦截 Action
                 * @param spaceInfo 展位信息
                 * @param spaceObjectInfo 广告信息
                 * @param url action url
                 * @return true表示拦截该 action，false 表示不拦截
                 */
                @Override
                public boolean interceptAction(SpaceInfo spaceInfo, SpaceObjectInfo spaceObjectInfo, String url) {
                    //上报移动分析埋点事件

                    LLog.w(TAG, "interceptAction()  === spaceInfo = " + spaceInfo + "   ,   spaceObjectInfo = " + spaceObjectInfo + "   ,   url = " + url);
                    /*interceptAction()  === spaceInfo = SpaceInfo{spaceCode='Banner_list_01', iOSViewId='null', androidViewId='', h5ViewId='', appId='', spaceObjectList=[SpaceObjectInfo{objectId='16831', contentType='PIC', contentHeight=210, crontabList=null, behaviors=[SpaceObjectBehavior [behavior=ALWAYS, showTimes=1, closedByUser=false, jumpedByUser=false, behaviorUpdateTime=0, hadShowedTimes=0]], widgetId='', content='null', hrefUrl='https://prod-mcdp.oss-cn-hangzhou.aliyuncs.com/mcdp/ONEX57DD551231508-default/1631260939207/b5e4d564a90adce8db62948838b7374a.jpg', shortImgUrl='null', actionUrl='https://www.json.cn/', gmtStart=1631677092000, gmtEnd=1631849892000, fgColor='null', bgColor='null', textColor='null', widgetColor='null', priority=2, mrpRuleId='', bizExtInfo={picWidth=1080, gmtModified=1631677313000, picHeight=420, LAYER_TYPE=normal}, timeSensitive=false, clientMinVersion='null', clientMaxVersion='null', logExtInfo={picWidth=1080, gmtModified=1631677313000, picHeight=420, groupId=14695, LAYER_TYPE=normal}, selfAdapt=false}, SpaceObjectInfo{objectId='16830', contentType='PIC', contentHeight=210, crontabList=null, behaviors=[SpaceObjectBehavior [behavior=ALWAYS, showTimes=1, closedByUser=false, jumpedByUser=false, behaviorUpdateTime=0, hadShowedTimes=0]], widgetId='', content='null', hrefUrl='https://prod-mcdp.oss-cn-hangzhou.aliyuncs.com/mcdp/ONEX57DD551231508-default/1631260939207/b5e4d564a90adce8db62948838b7374a.jpg', shortImgUrl='null', actionUrl='https://www.baidu.com/', gmtStart=1631677092000, gmtEnd=1631849892000, fgColor='null', bgColor='null', textColor='null', widgetColor='null', priority=1, mrpRuleId='', bizExtInfo={picWidth=1080, gmtModified=1631677313000, picHeight=420, LAYER_TYPE=normal}, timeSensitive=false, clientMinVersion='null', clientMaxVersion='null', logExtInfo={picWidth=1080, gmtModified=1631677313000, picHeight=420, groupId=14695, LAYER_TYPE=normal}, selfAdapt=false}], location='NULL', height=210, hasPlaceholder=false, useCacheFirst=false, width=0, reqRpcTime=1631690570525, multiStyle='ROTATION', rotationTime=2, close=false, displayMaxCount=2, modifyTime=0, localRuleList=[], extInfo={}}   ,   spaceObjectInfo = SpaceObjectInfo{objectId='16831', contentType='PIC', contentHeight=210, crontabList=null, behaviors=[SpaceObjectBehavior [behavior=ALWAYS, showTimes=1, closedByUser=false, jumpedByUser=false, behaviorUpdateTime=0, hadShowedTimes=0]], widgetId='', content='null', hrefUrl='https://prod-mcdp.oss-cn-hangzhou.aliyuncs.com/mcdp/ONEX57DD551231508-default/1631260939207/b5e4d564a90adce8db62948838b7374a.jpg', shortImgUrl='null', actionUrl='https://www.json.cn/', gmtStart=1631677092000, gmtEnd=1631849892000, fgColor='null', bgColor='null', textColor='null', widgetColor='null', priority=2, mrpRuleId='', bizExtInfo={picWidth=1080, gmtModified=1631677313000, picHeight=420, LAYER_TYPE=normal}, timeSensitive=false, clientMinVersion='null', clientMaxVersion='null', logExtInfo={picWidth=1080, gmtModified=1631677313000, picHeight=420, groupId=14695, LAYER_TYPE=normal}, selfAdapt=false}   ,   url = https://www.json.cn/*/
                    //此处可以根据对饮的广告codeId进行拦截，或者根据跳转url进行拦截
                    String cdpCode = spaceInfo.spaceCode;
                    String jumpUrl = url;
                    if ("xxxxxx".equals(cdpCode) || "https://www.baidu.com/".equals(url)) {
                        //Action 执行自定义动作
                        return true;
                    }

                    return false;
                }

                /**
                 * 执行Action
                 *
                 * @param spaceInfo 展位信息
                 * @param spaceObjectInfo 展位信息
                 * @param url action url
                 * @return 1表示执行成功，其他值表示异常
                 */
                @Override
                public int executeAction(SpaceInfo spaceInfo, SpaceObjectInfo spaceObjectInfo, String url) {
                    LLog.w(TAG, "executeAction()  === spaceInfo = " + spaceInfo + "   ,   spaceObjectInfo = " + spaceObjectInfo + "   ,   url = " + url);
                    return 0;
                }
            });
        }
    }

}


