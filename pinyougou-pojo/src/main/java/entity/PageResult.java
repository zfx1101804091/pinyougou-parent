package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @description:分页结果封装对象
 * @author: zheng-fx
 * @time: 2019/8/22 0022 23:25
 */
public class PageResult implements Serializable {
    private long total;//总记录数
    private List rows;//当前页结果	

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
