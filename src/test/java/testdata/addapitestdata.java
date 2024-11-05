package testdata;

import io.restassured.specification.ResponseSpecification;

public class addapitestdata {
	
	static pojo.AddplaceAPI ap;
	
	static pojo.location lo;
	
	
	public static pojo.AddplaceAPI addapipost(String name ,String Address, String Language)
	
	{
		ap =new pojo.AddplaceAPI();
		lo =new pojo.location();

	
		
		String[] type = { "shoe park",
			    "shop"};
		
		lo.setLat(33.427362);
		lo.setLng(-38.383494);
		
		ap.setLocation(lo);
		
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(Address);
		ap.setWebsite("http://google.com");
		ap.setLanguage(Language);
		ap.setTypes(type);
		
		return ap;
		
	}

}
