package com.center.ropcenter.service;

import com.center.ropcenter.exception.ServerException;
import com.commons.model.Admin;
import com.commons.model.QTO.AdminQTO;

import java.util.List;

public interface AdminService {

    List<Admin> queryList(AdminQTO adminQTO) throws ServerException;

    Admin queryOne(AdminQTO adminQTO) throws ServerException;
}
