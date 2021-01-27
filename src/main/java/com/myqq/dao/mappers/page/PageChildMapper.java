package com.myqq.dao.mappers.page;

import com.myqq.entity.page.PageChild;
import com.myqq.entity.page.PageChildExample;
import java.util.List;

public interface PageChildMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    long countByExample(PageChildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    int deleteByPrimaryKey(Integer pageChildId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    int insert(PageChild record);
    int insertMany(List<PageChild> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    int insertSelective(PageChild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    List<PageChild> selectByExample(PageChildExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    PageChild selectByPrimaryKey(Integer pageChildId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    int updateByPrimaryKeySelective(PageChild record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table page_child
     *
    
     */
    int updateByPrimaryKey(PageChild record);
}