package edu.hevttc.commons;

import java.util.List;

public class PageBean<T> {
    /**
     * 分页时必须要拥有的5个数字
     * 总记录数 totalNum 数据库统计
     * 每页显示条数 pageSize
     * 当前页码  pageNum
     * 共多少页 pageCount = 总记录数/每页显示条数  如果总记录/每页显示条数 有余数则总页数+1
     * 跳过的记录数量 skipNum= (当前页-1) * 每页显示的数量
     */
    private Integer pageNum;
    private Integer totalPage;
    private Integer totalNum;
    private Integer pageSize;
    private Integer skipNum;
    private List<T> pageData;

    public PageBean(Integer pageNum, Integer totalNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.totalNum = totalNum;
        this.pageSize = pageSize;
        //计算总页数
        int totalPage = totalNum / pageSize;
        if ((totalNum % pageSize) > 0) {
            totalPage++;
        }
        this.totalPage=totalPage;
        this.skipNum =(pageNum-1) *pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSkipNum() {
        return skipNum;
    }

    public void setSkipNum(Integer skipNum) {
        this.skipNum = skipNum;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }



}
