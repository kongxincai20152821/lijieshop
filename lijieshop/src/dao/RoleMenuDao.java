package dao;

import java.util.List;

import entity.RoleMenu;

public interface RoleMenuDao extends BaseDao<RoleMenu>{
    public List<RoleMenu> queryByRoleId(int roleId);
}
