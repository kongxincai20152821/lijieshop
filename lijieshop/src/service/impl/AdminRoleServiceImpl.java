package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AdminRoleDao;
import entity.AdminRole;
import service.AdminRoleService;
@Service("adminRoleService")
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole> implements AdminRoleService {
	@Resource
	private AdminRoleDao adminRoleDao;
	@Override
	public AdminRole query(int adminId, int userrole) {
		return adminRoleDao.query(adminId, userrole);
	}

}
