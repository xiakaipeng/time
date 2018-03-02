package com.cloud.drore.eboos.common.base;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * User: wcy
 * Date: 2017/9/5
 * Time: 15:22
 */
public interface BaseService<T, ID> {

	T insert(T entity);

	int deleteByPrimaryKey(ID key);

	T selectByPrimaryKey(ID key);

	int updateByPrimaryKey(T entity);

	List<T> getAll();

	int totalCount(Example conditions);

	List<T> selectByExample(Example conditions);

}
