package com.app.mybatis.mapper;

import com.app.mybatis.entity.TbStudent;
import com.app.mybatis.entity.TbStudentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TbStudentMapper extends BaseMapper<TbStudent, TbStudentQuery> {
}