package com.myqq.dao.mappers.fangcha;

import com.myqq.entity.fangcha.E2eAndKpiMeasures;
import com.myqq.entity.fangcha.E2eAndKpiMeasuresExample;

import java.util.Collection;
import java.util.List;

public interface E2eAndKpiMeasuresMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e2e_and_kpi_measures
     *
    
     */
    long countByExample(E2eAndKpiMeasuresExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e2e_and_kpi_measures
     *
    
     */
    int insert(E2eAndKpiMeasures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e2e_and_kpi_measures
     *
    
     */
    int insertSelective(E2eAndKpiMeasures record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e2e_and_kpi_measures
     *
    
     */
    List<E2eAndKpiMeasures> selectByExample(E2eAndKpiMeasuresExample example);

	void insertMany(List<E2eAndKpiMeasures> list);
	void deleteAll();
}