package util;

public enum Country {
	Vietnam("Vietnam"),
	Japan("Japan"),
	Other("Other");
	
	private String country;
	
	Country(String s){
		this.country = s;
	}
	
	public String toString() {
		return country;
	}
}
