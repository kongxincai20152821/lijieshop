package dao;

import entity.AdminRole;

public interface AdminRoleDao extends BaseDao<AdminRole>{
	public AdminRole query(int adminId,int userrole);
}
