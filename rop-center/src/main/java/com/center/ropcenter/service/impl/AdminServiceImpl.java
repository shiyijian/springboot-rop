package com.center.ropcenter.service.impl;

import com.center.ropcenter.exception.ServerException;
import com.center.ropcenter.mapper.AdminMapper;
import com.center.ropcenter.service.AdminService;
import com.center.ropcenter.utils.JsonUtil;
import com.commons.constant.ResponseCode;
import com.commons.model.Admin;
import com.commons.model.QTO.AdminQTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    private static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryList(AdminQTO adminQTO) throws ServerException{
        //入参校验
        if (adminQTO == null) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(adminQTO));
            throw new ServerException(ResponseCode.SYS_E_SQL_PARAM_INVALID, "invalid param");
        }

        try {
            return adminMapper.queryList(adminQTO);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerException(ResponseCode.SYS_E_SQL_QUERYLIST);
        }
    }

    @Override
    public Admin queryOne(AdminQTO adminQTO) throws ServerException{
        //入参校验
        if (adminQTO == null) {
            logger.error("invalid param, param:{}", JsonUtil.toJson(adminQTO));
            throw new ServerException(ResponseCode.SYS_E_SQL_PARAM_INVALID, "invalid param");
        }

        try {
            return adminMapper.queryOne(adminQTO);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerException(ResponseCode.SYS_E_SQL_QUERYONE);
        }
    }
}
