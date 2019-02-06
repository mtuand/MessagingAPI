package org.mtd.javabrains.messenger.exception;


import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mtd.javabrains.messenger.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse(Throwable ex){
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "MTD's Generic Exception");
		return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(errorMessage).build();
	}
}
