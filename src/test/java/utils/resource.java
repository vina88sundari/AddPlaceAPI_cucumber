package utils;

public enum resource {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	UpdaePlaceAPI("/maps/api/place/update/json");
	
	private String url;
	

	resource(String url)
	
	
	{
		this.url =url;
		
	}

	
	public String getresource()
	
	{
		return url;
	}

}
