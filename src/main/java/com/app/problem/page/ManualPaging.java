package com.app.problem.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.mybatis.entity.TbStudent;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: ManualPaging
 * @Description: 基于com.github.pagehelper分页插件的手动分页
 * @author lyn
 * @date 2020年3月15日
 *
 */
public class ManualPaging {
	public static void main(String[] args) {
		List<TbStudent> students=new ArrayList<>();
		for (int i = 0; i < 41; i++) {
			TbStudent student=new TbStudent();
			student.setId(i+1);
			student.setEmail("email"+(i+1));
			student.setPassword("password"+(i+1));
			student.setPhone("phone"+(i+1));
			student.setUsername("username"+(i+1));
			students.add(student);
		}
		PageInfo<TbStudent> pageInfo = PageHelperUtils.initPageInfo(2, 10, students);
		//PageInfo<TbStudent> pageInfo=new PageInfo<>(students);
		System.out.println(pageInfo.toString());
		List<TbStudent> list = pageInfo.getList();
		for (TbStudent tbStudent : list) {
			System.out.println(tbStudent);
		}
	}
}
