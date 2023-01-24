package week9;

public class W8StudentMark {
	
	long id;
	String name;
	String surname;
	int mark;
	
	public W8StudentMark(long id, String name, String surname, int mark) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mark = mark;
	}
	
	public long getId() { return id; }
	public void setMark(long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname; } 
	public int getMark() { return mark; }
	public void setMark(int mark) { this.mark = mark; }

}
