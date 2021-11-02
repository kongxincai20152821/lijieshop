package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.RoleMenuDao;
import entity.RoleMenu;

@Repository("roleMenuDao")
public class RoleMenuDaoImpl extends BaseDaoImpl<RoleMenu> implements RoleMenuDao{

	@Override
	public List<RoleMenu> queryByRoleId(int roleId) {
		return getSqlSession().selectList("RoleMenu.queryByRoleId",roleId);
	}
}
