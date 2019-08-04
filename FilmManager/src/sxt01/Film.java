package sxt01;

public class Film {
	private String name;
	private String director;
	private String actors;
	private int time;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public Film() {
		super();
	}
	public Film(String name, String director, String actors, int time) {
		super();
		this.name = name;
		this.director = director;
		this.actors = actors;
		this.time = time;
	}
	
	public void showInfo(int index) {
		System.out.println(index+"\t"+"¡¶"+this.getName()+"¡·"+"\t"+this.director+"\t"+this.actors+"\t"+this.time);
	}
	
}
