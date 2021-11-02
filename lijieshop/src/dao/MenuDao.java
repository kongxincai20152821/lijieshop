package dao;

import entity.Menu;

public interface MenuDao extends BaseDao<Menu>{
	public Menu queryByMid(int mid);
}
