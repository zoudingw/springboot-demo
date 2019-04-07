package com.zdw.springboot.study.demo.dao;

import com.zdw.springboot.study.demo.entity.MyRight;
import com.zdw.springboot.study.demo.entity.RoleRight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author:zoudw
 * Since:JDK 7
 * Date:2019/3/15
 * Description:
 *
 * @Copyright:2018, zoudw@szinfinova.com All Rights Reserved
 */
@Mapper
public interface RoleRightDao {
   List<RoleRight> selectByPrimaryByRirghtId(Integer rightId);
    List<RoleRight> selectByPrimaryByRoleId(Integer roleId);
}
