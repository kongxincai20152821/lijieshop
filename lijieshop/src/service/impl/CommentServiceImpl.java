package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.CommentDao;
import entity.Comment;
import service.CommentService;
@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

	@Resource
	private CommentDao commentDao;
	@Override
	public List<Comment> queryByPage(int currentPage, int pageSize, String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("currentPage", (currentPage-1)*pageSize);
        map.put("pageSize", pageSize);
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return commentDao.queryByPage(map);
	}
	@Override
	public int getTotals(String qusername, String qpassword) {
		Map<String,Object> map=new HashMap<>();
        map.put("qusername", qusername);
        map.put("qpassword", qpassword);
		return commentDao.getTotals(map);
	}
	@Override
	public List<Comment> queryAllComment(int goods_id,int sp,int pageSize) {
		return commentDao.queryAllComment(goods_id,sp,pageSize);
	}
	@Override
	public int getCommentTotals(int goods_id) {
		return commentDao.getCommentTotals(goods_id);
	}

}
