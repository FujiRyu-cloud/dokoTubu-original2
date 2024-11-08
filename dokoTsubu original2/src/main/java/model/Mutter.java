package model;

public class Mutter {
	private int id;
	private String name;
	private String text;
	
	public Mutter() {}
	
	public Mutter(String name,String text) {
		this.name = name;
		this.text = text;
	}
	
	public Mutter(int id,String name,String text) {
		this.id = id;
		this.name = name;
		this.text = text;
	}
	
	public int getId() {return id;}
	public String getName() {return name;}
	public String getText() {return text;}
}
