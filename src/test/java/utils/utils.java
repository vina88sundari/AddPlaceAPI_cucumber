package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {

	static RequestSpecification req;

	public static RequestSpecification requestspec() throws FileNotFoundException

	{

		if (req == null) {
			PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));

			req = new RequestSpecBuilder().setContentType("application/json")
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)).setAccept(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public static String apiprop(String base) throws IOException

	{

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\vinay\\eclipse-workspace\\CucumberAPI\\src\\test\\resources\\apiroutes.properties");
		prop.load(fis);
		return prop.getProperty(base);
	}

	public static void main(String[] args) throws IOException

	{
		System.out.println(apiprop("baseurl"));
		
		resource res= resource.valueOf("AddPlaceAPI");
		System.out.println(res.getresource());

	}
	
	public static String getjsonvalue(Response res,String key)
	
	{
		
		JsonPath js =new JsonPath(res.asString());
		return js.getString(key);
		
		
	}
	
	

}
