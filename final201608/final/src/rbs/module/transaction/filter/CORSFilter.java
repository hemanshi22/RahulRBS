package rbs.module.transaction.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class CORSFilter implements ContainerResponseFilter {
	

    public ContainerResponse filter(ContainerRequest req, ContainerResponse abccbsContainerResponse) {
 
    	System.out.println("entering rest filter......"); 

        ResponseBuilder abccbsResponseBuilder = Response.fromResponse(abccbsContainerResponse.getResponse());
        
        // *(allow from all servers) OR http://crunchify.com/ OR http://example.com/
        abccbsResponseBuilder.header("Access-Control-Allow-Origin", "*")
        
        // As a part of the response to a request, which HTTP methods can be used during the actual request.
        .header("Access-Control-Allow-Methods", "API, GET, POST, PUT, UPDATE, OPTIONS, DELETE")
        
        // How long the results of a request can be cached in a result cache.
        .header("Access-Control-Max-Age", "151200")
        
        // As part of the response to a request, which HTTP headers can be used during the actual request.
        .header("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
 
        String abccbsheader = req.getHeaderValue("Access-Control-Request-Headers");
 
        if (null != abccbsheader && !abccbsheader.equals(null)) {
        	abccbsResponseBuilder.header("Access-Control-Allow-Headers", abccbsheader);
        }
 
        abccbsContainerResponse.setResponse(abccbsResponseBuilder.build());
        return abccbsContainerResponse;
    }
}