package listener;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;

public class TestInitialization {

	 private static boolean isInit;

	    private static final Logger LOG = LogManager.getLogger(TestInitialization.class);

	    static {
	        isInit = false;
	    }

	    private TestInitialization() {

	    }

	    public static synchronized void init() {
	        if (!isInit) {
	            try {

	                String userDir = System.getProperty("user.dir");

	                TestConfiguration.readRunProperties(Paths.get(userDir, "src/main/java/resources/global.properties"));
	                
	                TestConfiguration.readConfig(Paths.get(userDir, "src/main/java/resources/global.properties"));


	                RestAssured.filters((request, response, filterContext) -> {
	                    //request logging
	                    String requestMsg = "-->  Request " + request.getMethod() + " " + request.getURI();

	                    Response next = filterContext.next(request, response);
	                    String responseBody = ((RestAssuredResponseImpl) next).getBody().asString().replace("\n", " ").replace(" ", "");
	                    String responseMsg = "<-- Response " + next.getStatusCode() + " " + responseBody;

//	                    LOG.info(requestMsg);
//	                    LOG.info(responseMsg);
	                

	                    return next;
	                });

	                isInit = true;
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);	
	            }
	        }
	    }
}
