package resources;

public enum APIResources {
	
	
	GetPlaceAPI("/api/location/");
	

	private String resource;
	APIResources(String resource) {
		
		this.resource = resource;
		
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
