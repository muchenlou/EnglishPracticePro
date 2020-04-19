package cn.muchenlou.practicepro.common;

import java.util.List;

/**
 * 分页结果
 */
public class PageResult<T> {

    private Long total;//总记录数

    private List<T> rows;//每页数据

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }
}
