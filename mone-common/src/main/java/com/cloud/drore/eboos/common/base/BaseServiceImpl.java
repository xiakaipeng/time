package com.cloud.drore.eboos.common.base;

import com.cloud.drore.eboos.common.util.ReflectUtil;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * User: wcy
 * Date: 2017/9/7
 * Time: 15:41
 */
@Service
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

	public abstract MyMapper<T> getMapper();

	private final Log logger = LogFactory.getLog(getClass());

	private static String ERROR_SAVE_MESSAGE = "信息保存失败";

	@Override
	public T insert(T entity) {
		try {
			logger.debug("excute insert:");
			getMapper().insertUseGeneratedKeys(entity);
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		}
		return entity;
	}

	public ResultMessage insertUseGeneratedKeys(T entity) {
		int result = 0;
		try {
			logger.debug("excute insert:");
			getMapper().insertUseGeneratedKeys(entity);
			ResultMessage resultMessage = new ResultMessage();
			Long id = (Long) ReflectUtil.forceGet(entity, "id");
			return ResultMessage.Builder.builder().withId(id+"").build();
		} catch (Exception e) {
			logger.error(e.toString());
			return ResultMessage.Builder.builder().withCode(8500L).withMessage(ERROR_SAVE_MESSAGE).build();
		}

	}

	@Override
	public int deleteByPrimaryKey(ID key) {
		int result = 0;
		try {
			logger.debug("excute delete:");
			result = getMapper().deleteByPrimaryKey(key);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	@Override
	public T selectByPrimaryKey(ID key) {
		try {
			logger.debug("excute get:");
			return getMapper().selectByPrimaryKey(key);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return null;
	}

	@Override
	public int updateByPrimaryKey(T entity) {
		int result = 0;
		try {
			logger.debug("excute update:");
			result = getMapper().updateByPrimaryKey(entity);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return result;
	}

	@Override
	public List<T> getAll() {
		try {
			logger.debug("excute selectAll:");
			return getMapper().selectAll();
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return null;
	}

	@Override
	public int totalCount(Example conditions) {
		try {
			logger.debug("excute totalCount:");
			return getMapper().selectCountByExample(conditions);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return 0;
	}

	/**
	 * 条件查询
	 * 
	 * @param conditions：一个map对象，主要包含键值有fields，where，group，order
	 *            fields指返回字段，example：id,name,address;字段间用逗号隔开
	 *            where指查询条件，example：name='张三' or id=200 group指分组条件，example：name
	 *            order指排序条件,example:name
	 * @return
	 */
	@Override
	public List<T> selectByExample(Example conditions) {
		try {
			logger.debug("excute query:");
			return getMapper().selectByExample(conditions);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return null;
	}
}
