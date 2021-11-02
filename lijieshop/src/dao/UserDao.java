package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao extends BaseDao<User>{
	public List<User> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	public User queryUser(String username,String password);
}
