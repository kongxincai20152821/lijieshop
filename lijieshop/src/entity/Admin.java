package entity;

public class Admin {
	private int admin_id;
	private String ausername;
	private String apwd;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public Admin(int admin_id, String ausername, String apwd) {
		super();
		this.admin_id = admin_id;
		this.ausername = ausername;
		this.apwd = apwd;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
