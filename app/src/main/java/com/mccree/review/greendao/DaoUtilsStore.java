package com.mccree.review.greendao;

/**
 * Created by: lixingzhou
 * Created Date: 2021/10/9 16:42
 * Description:
 */

import com.mccree.review.greendao.gen.UserInfoDao;
import com.mccree.review.module.database.UserInfo;

/**
 * 初始化、存放及获取DaoUtils
 */
public class DaoUtilsStore {
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<UserInfo> mUserDaoUtils;

    public static DaoUtilsStore getInstance() {
        return instance;
    }

    private DaoUtilsStore() {
        DaoManager mManager = DaoManager.getInstance();
        UserInfoDao _UserDao = mManager.getDaoSession().getUserInfoDao();
        mUserDaoUtils = new CommonDaoUtils<>(UserInfo.class, _UserDao);
    }

    public CommonDaoUtils<UserInfo> getUserDaoUtils() {
        return mUserDaoUtils;
    }

}
