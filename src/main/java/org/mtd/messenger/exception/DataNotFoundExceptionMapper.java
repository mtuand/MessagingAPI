package org.mtd.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mtd.messenger.model.ErrorMessage;

/**
 * Exception Mapper for Data Not Found.  
 **/

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{
	
	@Override
	public Response toResponse(DataNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "MTD's error Code");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
