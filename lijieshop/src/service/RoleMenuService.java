package service;

import java.util.List;

import entity.RoleMenu;

public interface RoleMenuService extends BaseService<RoleMenu>{
	public List<RoleMenu> queryByRoleId(int roleId);
}
