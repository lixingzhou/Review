package com.mccree.review.module.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by: lixingzhou
 * Created Date: 2021/10/9 16:30
 * Description:
 */
@Entity
public class UserInfo {

    @Id(autoincrement = true)
    private Long id;

    @Unique
    private int userId;
    @Property
    private String userName;
    @Property
    private String userData;
    @Generated(hash = 149340866)
    public UserInfo(Long id, int userId, String userName, String userData) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userData = userData;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserData() {
        return this.userData;
    }
    public void setUserData(String userData) {
        this.userData = userData;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userData='" + userData + '\'' +
                '}';
    }
}
