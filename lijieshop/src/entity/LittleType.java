package entity;

public class LittleType {
	private int ltype_id;
	private int stype_id;
	private String stype_name;
	private String ltype_name;
	
	private SuperType superType;

	
	public String getStype_name() {
		return stype_name;
	}

	public void setStype_name(String stype_name) {
		this.stype_name = stype_name;
	}

	public int getLtype_id() {
		return ltype_id;
	}

	public void setLtype_id(int ltype_id) {
		this.ltype_id = ltype_id;
	}

	public int getStype_id() {
		return stype_id;
	}

	public void setStype_id(int stype_id) {
		this.stype_id = stype_id;
	}

	public String getLtype_name() {
		return ltype_name;
	}

	public void setLtype_name(String ltype_name) {
		this.ltype_name = ltype_name;
	}

	public LittleType(int ltype_id, int stype_id, String ltype_name) {
		super();
		this.ltype_id = ltype_id;
		this.stype_id = stype_id;
		this.ltype_name = ltype_name;
	}

	public LittleType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LittleType [ltype_id=" + ltype_id + ", stype_id=" + stype_id + ", ltype_name=" + ltype_name + "]";
	}

}
