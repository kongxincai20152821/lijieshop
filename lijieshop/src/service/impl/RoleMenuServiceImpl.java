package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.RoleMenuDao;
import entity.RoleMenu;
import service.RoleMenuService;
@Service("roleMenuService")
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

	@Resource
	private RoleMenuDao roleMenuDao;
	
	@Override
	public List<RoleMenu> queryByRoleId(int roleId) {
		return roleMenuDao.queryByRoleId(roleId);
	}
}
