package com.myqq.entity.page;

import java.util.ArrayList;
import java.util.List;

public class PageMain {
    private Integer pageId;
    private Long pageIp;
    private Integer pagePort;

    /**
     * page浏览器里的url
     *
    
     */
    private String pageUrl;

    /**
     * 该页面属于哪个应用
     *
    
     */
    private String pageBelong;
    
    private List<PageChild> child = new ArrayList<>();
    /**
     *
     *
    
     */
    public Integer getPageId() {
    	return pageId;
    }
    
    public List<PageChild> getChild() {
		return child;
	}

	public void setChild(List<PageChild> child) {
		this.child = child;
	}


    public Long getPageIp() {
		return pageIp;
	}

	public void setPageIp(Long pageIp) {
		this.pageIp = pageIp;
	}

	public Integer getPagePort() {
		return pagePort;
	}

	public void setPagePort(Integer pagePort) {
		this.pagePort = pagePort;
	}

	/**
     *
     *
    
     */
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    /**
     *
     * page浏览器里的url
     * @return  
     *
    
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     *
     * page浏览器里的url
     * @param 
     *
    
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     *
     * 该页面属于哪个应用
     * @return  
     *
    
     */
    public String getPageBelong() {
        return pageBelong;
    }

    /**
     *
     * 该页面属于哪个应用
     * @param 
     *
    
     */
    public void setPageBelong(String pageBelong) {
        this.pageBelong = pageBelong;
    }
}