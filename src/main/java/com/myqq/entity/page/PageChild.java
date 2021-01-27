package com.myqq.entity.page;

public class PageChild {
    private Integer pageChildId;

    /**
     * 属于哪个page
     *
    
     */
    private Integer pageId;

    /**
     * 子url的路径
     *
    
     */
    private String pageChildUrl;
    /**
     *
     *
    
     */
    public Integer getPageChildId() {
        return pageChildId;
    }

    /**
     *
     *
    
     */
    public void setPageChildId(Integer pageChildId) {
        this.pageChildId = pageChildId;
    }

    /**
     *
     * 属于哪个page
     * @return  
     *
    
     */
    public Integer getPageId() {
        return pageId;
    }

    /**
     *
     * 属于哪个page
     * @param 
     *
    
     */
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    /**
     *
     * 子url的路径
     * @return  
     *
    
     */
    public String getPageChildUrl() {
        return pageChildUrl;
    }

    /**
     *
     * 子url的路径
     * @param 
     *
    
     */
    public void setPageChildUrl(String pageChildUrl) {
        this.pageChildUrl = pageChildUrl;
    }
}