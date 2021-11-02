package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dao.CommentDao;
import entity.Comment;
@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{

	@Override
	public List<Comment> queryByPage(Map<String, Object> map) {
		return getSqlSession().selectList("Comment.queryByPage",map);
	}

	@Override
	public int getTotals(Map<String, Object> map) {
		return getSqlSession().selectOne("Comment.getTotals",map);
	}

	@Override
	public List<Comment> queryAllComment(int goods_id,int sp,int pageSize) {
	    Map<String,Object> map=new HashMap<>();
	    map.put("goods_id",goods_id);
	    map.put("sp",sp);
	    map.put("pageSize",pageSize);
		return getSqlSession().selectList("Comment.queryAllComment",map);
	}

	@Override
	public int getCommentTotals(int goods_id) {
		return getSqlSession().selectOne("Comment.getCommentTotals",goods_id);
	}

}
