package dao.impl;

import org.springframework.stereotype.Repository;

import dao.MenuDao;
import entity.Menu;
@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao{

	@Override
	public Menu queryByMid(int mid) {
		return getSqlSession().selectOne("Menu.queryByMid",mid);
	}
}
