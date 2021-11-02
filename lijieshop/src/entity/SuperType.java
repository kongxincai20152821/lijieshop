package entity;

public class SuperType {
	private int stype_id;
	private String stype_name;

	public int getStype_id() {
		return stype_id;
	}

	public void setStype_id(int stype_id) {
		this.stype_id = stype_id;
	}

	public String getStype_name() {
		return stype_name;
	}

	public void setStype_name(String stype_name) {
		this.stype_name = stype_name;
	}

	public SuperType(int stype_id, String stype_name) {
		super();
		this.stype_id = stype_id;
		this.stype_name = stype_name;
	}

	public SuperType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SuperType [stype_id=" + stype_id + ", stype_name=" + stype_name + "]";
	}

}
