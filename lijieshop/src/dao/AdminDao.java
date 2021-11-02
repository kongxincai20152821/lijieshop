package dao;

import java.util.List;
import java.util.Map;

import entity.Admin;

public interface AdminDao extends BaseDao<Admin>{
	public List<Admin> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	public Admin queryAdmin(String username,String password);
}
