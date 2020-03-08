package com.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 
 * @ClassName: BaseMapper
 * @Description: 基础增删查改操作
 * @author lyn
 * @date 2020年3月8日
 *
 * @param <E>业务实体对象
 * @param <Q>查询条件对象
 */
public interface BaseMapper<E, Q> {

	int countByExample(Q example);

	int deleteByExample(Q example);

	int deleteByPrimaryKey(Object resourceid);

	int insert(E record);

	int insertSelective(E record);

	List<E> selectByExampleWithRowbounds(Q example, RowBounds rowBounds);

	List<E> selectByExample(Q example);

	E selectByPrimaryKey(Object resourceid);

	int updateByExampleSelective(@Param("record") E record, @Param("example") Q example);

	int updateByExample(@Param("record") E record, @Param("example") Q example);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKey(E record);
}
