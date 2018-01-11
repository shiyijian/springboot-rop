package com.commons.api;

import com.commons.model.DTO.AdminDTO;
import com.commons.reponse.Response;

public interface AdminRemote {

    Response<AdminDTO> getAdminByMobile(String mobile);

    Response<AdminDTO> getAdminById(Long adminId);
}
