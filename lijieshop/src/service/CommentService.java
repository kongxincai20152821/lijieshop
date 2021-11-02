package service;

import java.util.List;

import entity.Comment;


public interface CommentService extends BaseService<Comment>{
	public List<Comment> queryByPage(int currentPage,int pageSize,String qusername,String qpassword);
	public int getTotals(String qusername,String password);
	
	public List<Comment> queryAllComment(int goods_id,int sp,int pageSize);
	public int getCommentTotals(int goods_id);
}
