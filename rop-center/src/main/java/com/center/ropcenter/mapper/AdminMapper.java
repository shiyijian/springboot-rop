package com.center.ropcenter.mapper;

import com.commons.model.Admin;
import com.commons.model.QTO.AdminQTO;

import java.util.List;

public interface AdminMapper {
    /**
     *
     * @mbggenerated 2018-01-11
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-01-11
     */
    int insert(Admin record);

    /**
     *
     * @mbggenerated 2018-01-11
     */
    int insertSelective(Admin record);

    /**
     *
     * @mbggenerated 2018-01-11
     */
    Admin selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-01-11
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     *
     * @mbggenerated 2018-01-11
     */
    int updateByPrimaryKey(Admin record);

    /**
     * 查询多条数据
     * @param adminQTO
     * @return
     */
    List<Admin> queryList(AdminQTO adminQTO);

    /**
     * 查询单条数据
     * @param adminQTO
     * @return
     */
    Admin queryOne(AdminQTO adminQTO);
}