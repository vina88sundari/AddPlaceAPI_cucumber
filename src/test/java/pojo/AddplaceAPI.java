package pojo;

public class AddplaceAPI {
	
	/*{
		  "location": {
		    "lat": -38.383494,
		    "lng": 33.427362
		  },
		  "accuracy": 50,
		  "name": "Frontline house",
		  "phone_number": "(+91) 983 893 3937",
		  "address": "29, side layout, cohen 09",
		  "types": [
		    "shoe park",
		    "shop"
		  ],
		  "website": "http://google.com",
		  "language": "French-IN"
		}*/
	
	
	private location location;
	
	private int accuracy;
	private String name ;
	private String phone_number;
	private String address;
	
	private String[] types;
	private String website;
	private String language;
	public location getLocation() {
		return location;
	}
	public void setLocation(location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	

}
