package com.center.ropcenter.manager.admin;

import com.center.ropcenter.action.Action;
import com.center.ropcenter.action.Request;
import com.center.ropcenter.action.RequestContext;
import com.center.ropcenter.exception.ServerException;
import com.center.ropcenter.service.AdminService;
import com.commons.constant.ActionEnum;
import com.commons.constant.ResponseCode;
import com.commons.model.Admin;
import com.commons.model.DTO.AdminDTO;
import com.commons.model.QTO.AdminQTO;
import com.commons.reponse.BaseResponse;
import com.commons.utils.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetAdminById implements Action {

    @Resource
    private AdminService adminService;

    @Override
    public BaseResponse execute(RequestContext context) {
        Request request = context.getRequest();

        Long adminId = (Long) request.getParam("adminId");

        if(adminId == null){
            return ResponseUtil.getErrorResponse(ResponseCode.BIZ_E_REQUEST_PARAMS_MISSING,"管理员id不能为空");
        }

        AdminDTO adminDTO = new AdminDTO();
        try {
            AdminQTO adminQTO = new AdminQTO();
            adminQTO.setId(adminId);

            Admin admin = adminService.queryOne(adminQTO);

            if(admin == null){
                return ResponseUtil.getErrorResponse(ResponseCode.BIZ_E_NOT_EXIT_RECORD,"管理员信息不存在");
            }

            BeanUtils.copyProperties(admin, adminDTO);
            adminDTO.setPassword(null);
            adminDTO.setGmtCreated(null);
            adminDTO.setGmtModified(null);
            adminDTO.setDeleteMark(null);
            adminDTO.setDeleteTimestamp(null);

        }catch (ServerException e){
            return ResponseUtil.getErrorResponse(e.getResponseCode(),e.getMessage());
        }

        return ResponseUtil.getSuccessResponse(adminDTO);
    }

    @Override
    public String getName() {
        return ActionEnum.GET_ADMINBYID.getActionName();
    }
}
