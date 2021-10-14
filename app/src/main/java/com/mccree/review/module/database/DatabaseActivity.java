package com.mccree.review.module.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mccree.review.R;
import com.mccree.review.greendao.DaoUtilsStore;
import com.mccree.review.utils.LLog;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {


    private List<UserInfo> mUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        initView();


    }

    private void initView() {
        findViewById(R.id.tv_database_1).setOnClickListener(this);
        findViewById(R.id.tv_database_2).setOnClickListener(this);
        findViewById(R.id.tv_database_3).setOnClickListener(this);
        findViewById(R.id.tv_database_4).setOnClickListener(this);
        findViewById(R.id.tv_database_5).setOnClickListener(this);
        findViewById(R.id.tv_database_6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_database_1:
                initUserInfo();
                break;
            case R.id.tv_database_2:
                queryUserInfo();
                break;
            case R.id.tv_database_3:
                insertNewUserInfo();
                break;
            case R.id.tv_database_4:
                updateUserInfo();
                break;
            case R.id.tv_database_5:
                deleteUserInfo();
                break;
            case R.id.tv_database_6:
                break;
        }
    }

    /**
     * 批量插入数据
     */
    private void initUserInfo() {

        DaoUtilsStore.getInstance().getUserDaoUtils().deleteAll();
        mUserList = new ArrayList<>();
        UserInfo info;
        for (int i = 0; i < 5; i++) {
            info = new UserInfo();
            info.setUserId(1000 + i);
            info.setUserData("No:100_" + i);
            info.setUserName("Name:No00" + i);
            mUserList.add(info);
        }

        DaoUtilsStore.getInstance().getUserDaoUtils().insertMultiple(mUserList);
    }

    /**
     * 查询所有数据
     */
    private void queryUserInfo() {
        mUserList = DaoUtilsStore.getInstance().getUserDaoUtils().queryAll();
        LLog.i("UserInfo：" + mUserList.toString());
    }

    /**
     * 插入新数据
     */
    private void insertNewUserInfo() {
        UserInfo info = new UserInfo(100L, 8888, "插入新数据", "插入新数据");
        DaoUtilsStore.getInstance().getUserDaoUtils().insert(info);
    }

    /**
     * 更新数据
     */
    private void updateUserInfo() {
        UserInfo user = mUserList.get(mUserList.size() - 1);
        user.setUserName("我必须要更新你的名字");

        DaoUtilsStore.getInstance().getUserDaoUtils().update(user);
    }

    /**
     * 删除数据
     */
    private void deleteUserInfo() {
        UserInfo user = mUserList.get(mUserList.size() - 1);
        //删除最末用户
        DaoUtilsStore.getInstance().getUserDaoUtils().delete(user);
    }


}