package bean;
public class MonBean{

	private String name;
	private int id;

	private String urlLongue;
	private String urlCourte;
	
	public MonBean () {
		this.name = "";
		this.id = 0;
		this.urlCourte = "";
		this.urlLongue = "";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlLongue() {
		return this.urlLongue;
	}

	public String getUrlCourte() {
		return this.urlCourte;
	}

	public void setUrlLongue( String urlLongue ) {
		this.urlLongue = urlLongue;
	}

	public void setUrlCourte( String urlCourte ) {
		this.urlCourte = urlCourte;
	}

}