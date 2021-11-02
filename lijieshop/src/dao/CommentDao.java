package dao;

import java.util.List;
import java.util.Map;

import entity.Comment;

public interface CommentDao extends BaseDao<Comment>{
	public List<Comment> queryByPage(Map<String, Object> map);
	public int getTotals(Map<String, Object> map);
	
	public List<Comment> queryAllComment(int goods_id,int sp,int pageSize);
	public int getCommentTotals(int goods_id);
}
