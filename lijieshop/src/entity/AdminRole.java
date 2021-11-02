package entity;

public class AdminRole {
	
    public AdminRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
    private int aid;
    private int rid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public AdminRole(int id, int aid, int rid) {
		super();
		this.id = id;
		this.aid = aid;
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "AdminRole [id=" + id + ", aid=" + aid + ", rid=" + rid + "]";
	}
	
    
    
}
