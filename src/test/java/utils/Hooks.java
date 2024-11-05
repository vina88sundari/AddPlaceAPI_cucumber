package utils;

import java.io.IOException;

import io.cucumber.java.Before;
import stepDefinations.AddplaceAPI;
import testdata.addapitestdata;

public class Hooks {
	
	@Before("@DeletePlace")
	public void adddeleteapi() throws IOException
	
	{
		AddplaceAPI sd =new AddplaceAPI();
		
		if (AddplaceAPI.place_id==null)
			
		{
		
			sd.add_place_payload_and_and("vina", "1213 Bond Street", "ENGLISH");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.is_added_in_the_with_http_request("vina","GetPlaceAPI","GET");
					
			
		}
		
	}

}
