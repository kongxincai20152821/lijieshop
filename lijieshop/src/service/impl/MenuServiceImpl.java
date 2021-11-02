package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.MenuDao;
import entity.Menu;
import service.MenuService;
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
	@Resource
	private MenuDao menuDao;
	@Override
	public Menu queryByMid(int mid) {
		return menuDao.queryByMid(mid);
	}

}
