package dao.impl;

import org.springframework.stereotype.Repository;

import dao.RoleDao;
import entity.Role;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{
}
