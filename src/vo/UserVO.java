package vo;

import java.sql.Timestamp;

public class UserVO {

	private int idx;
	private String name;
	private int age;
	private String country;
	private String birth;
	private Timestamp createDate;
	
	
	public UserVO() {};
	public UserVO(int idx, String name, int age, String country, String birth) {
		this.idx = idx;
		this.name = name;
		this.age = age;
		this.country = country;
		this.birth = birth;
	}
	public UserVO(int idx, String name, int age, String country, String birth, Timestamp createDate) {
		this.idx = idx;
		this.name = name;
		this.age = age;
		this.country = country;
		this.birth = birth;
		this.createDate = createDate;
	}

	
	/* Setter // Getter */
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp date) {
		this.createDate = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserVO [idx=");
		builder.append(idx);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", country=");
		builder.append(country);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", date=");
		builder.append(createDate);
		builder.append("]");
		return builder.toString();
	}
}
