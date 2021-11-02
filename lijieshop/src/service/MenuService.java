package service;

import entity.Menu;

public interface MenuService extends BaseService<Menu>{
	public Menu queryByMid(int mid);
}
