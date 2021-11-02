package service;

import entity.AdminRole;

public interface AdminRoleService extends BaseService<AdminRole>{
	public AdminRole query(int adminId,int userrole);
}
