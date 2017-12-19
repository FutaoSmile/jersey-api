package entity;

import entity.base.IdEntity;
import entity.base.TimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author futao
 * Created on 2017/12/19 - 13:07.
 */
@Entity
@Table(name = "bishe_user")
@DynamicInsert
@DynamicUpdate
public class User extends IdEntity implements TimeEntity {

    /**
     * nick name 昵称，唯一
     */
    @Column(name = "nick_name", length = _nickName_len_max)
    private String nickName;
    public static final String _nickName = "nickName";
    public static final int _nickName_len_max = 50;

    /**
     * 手机号
     */
    @Column(name = "mobile", length = _mobile_len_max)
    private String mobile;
    public static final String _mobile = "mobile";
    public static final int _mobile_len_max = 20;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;
    public static final String _createTime = "createTime";
    /**
     * 最后修改时间
     */
    @Column(name = "last_modify_time")
    private Timestamp lastModifyTime;
    public static final String _lastModifyTime = "lastModifyTime";

    @Override
    public Timestamp getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    @Override
    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
