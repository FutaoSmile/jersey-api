package entity.base;

import java.sql.Timestamp;

/**
 * @author futao
 * Created on 2017/12/19 - 13:09.
 */
public interface TimeEntity {
    Timestamp getCreateTime();

    void setCreateTime(Timestamp createTime);

    Timestamp getLastModifyTime();

    void setLastModifyTime(Timestamp lastModifyTime);


}
