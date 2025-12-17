package modele;

public class Musique {
	 protected String id;
	 protected  String name;
	 protected  String type;
	 protected  String country;
	 public Musique(String id, String name, String type, String country ) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.country = country;
	}
	 public String getId() {
		 return id;
	 }
	 public void setId(String id) {
		 this.id = id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getType() {
		 return type;
	 }
	 public void setType(String type) {
		 this.type = type;
	 }
	 public String getCountry() {
		 return country;
	 }
	 public void setCountry(String country) {
		 this.country = country;
	 }
}
