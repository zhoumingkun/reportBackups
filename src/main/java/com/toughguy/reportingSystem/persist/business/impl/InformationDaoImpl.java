package com.toughguy.reportingSystem.persist.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.reportingSystem.dto.InformationDTO;
import com.toughguy.reportingSystem.model.authority.User;
import com.toughguy.reportingSystem.model.business.Information;
import com.toughguy.reportingSystem.model.business.Informer;
import com.toughguy.reportingSystem.pagination.PagerModel;
import com.toughguy.reportingSystem.persist.business.prototype.IInformationDao;
import com.toughguy.reportingSystem.persist.impl.GenericDaoImpl;
import com.toughguy.reportingSystem.system.SystemContext;

/**
 * 举报信息Dao实现类
 * @author BOBO
 *
 */
@Repository
public class InformationDaoImpl extends GenericDaoImpl<Information, Integer> implements IInformationDao{

	@Override
	public int findNum(int state) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findNum", state);
	}

	@Override
	public List<Integer> findValidNumber() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findValidNumber");
	}
	@Override
	public List<InformationDTO> findSum() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findSum");
	}

	// -- 获取总的条目数 (分页查询中使用)
	private int findValidTotal() {
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".findValidTotal");
		return count;
	}
	// -- 举报记录小程序查询
	@Override
	public List<Information> getInformation(int informerId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".getInformation", informerId);
		
	}
	// -- 查询各行业领域类型数量
	@Override
	public Information findAllInformerType() {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.selectOne(typeNameSpace + ".findAllInformerType");
	}

	@Override
	public List<Information> findByOpenId(String openId) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.selectList(typeNameSpace + ".findByOpenId",openId);
	}
}
