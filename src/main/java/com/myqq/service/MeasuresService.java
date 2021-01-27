package com.myqq.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myqq.dao.mappers.fangcha.E2eAndKpiMeasuresMapper;
import com.myqq.entity.fangcha.E2eAndKpiMeasures;
import com.myqq.entity.fangcha.E2eAndKpiMeasuresExample;
import com.myqq.util.MeasuresUtil;
@Service
public class MeasuresService {
	@Autowired
	private E2eAndKpiMeasuresMapper ekmm;
	/**
	  * 前32位是e2eId;
	 * 33-52:是kpiId 20 bit
	 * 53-56:是0-12个月; 4bit
	 * 57-59:是0-7个周;3 bit
	 * 60-64:是0-24个小时;5bit
	 */
	private static final Map<Long,E2eAndKpiMeasures> map = new ConcurrentHashMap<>();
	public static Map<Long,E2eAndKpiMeasures> getMap() {
		return map;
	}
	/**
	 * 初始加载,重新加载
	 * init,reset都行
	 */
	public void resetData() {
		E2eAndKpiMeasuresExample  example = new  E2eAndKpiMeasuresExample();
		example.createCriteria();
		List<E2eAndKpiMeasures> list = ekmm.selectByExample(example);
		map.clear();
		for (E2eAndKpiMeasures e2eAndKpiMeasures : list) {
			Integer e2eId = e2eAndKpiMeasures.getE2eId();
			Integer kpiId = e2eAndKpiMeasures.getKpiId();
			Integer week = e2eAndKpiMeasures.getTimeWeek();
			Integer month = e2eAndKpiMeasures.getTimeMonth();
			Integer hour = e2eAndKpiMeasures.getTimeHour();
			long key = MeasuresUtil.getKey(month, week, hour, e2eId, kpiId);
			map.put(key,e2eAndKpiMeasures);
		}
	}
	/**
	 * 写数据
	 */
	public void writeData() {
		long l1 = System.currentTimeMillis();
		ekmm.deleteAll();
		 Collection<E2eAndKpiMeasures> values = map.values();
		 if(values.size() == 0)return;
		List<E2eAndKpiMeasures> list = new ArrayList<>();
		list.addAll(values);
		int a = list.size()/3000;
		int b = list.size()%3000;
		for (int i = 0; i < a; i++) {
			List<E2eAndKpiMeasures> subList = list.subList(i*3000, (i+1)*3000);
			ekmm.insertMany(subList);
		}
		if(b > 0) {
			List<E2eAndKpiMeasures> subList = list.subList(a*3000, list.size());
			ekmm.insertMany(subList);
		}
		long l2 = System.currentTimeMillis();
		System.out.println("本次更新数据:"+list.size()+"条,费时: "+(l2-l1)+" ms.");
	}
}
