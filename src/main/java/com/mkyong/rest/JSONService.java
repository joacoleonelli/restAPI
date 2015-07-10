package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.Book;


@Path("/json/book")
public class JSONService {

	@GET
	@Path("/get/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookInJSON(@PathParam("bookId") int bookId) {

		Book book = new Book();
		book.setEditionYear(1991L);
		book.setEditorial("Salamandra");
		book.setAuthor("J. K. Rowling");
		book.setTitle("Harry Potter and the chamber of secrets");

		return Response.status(200).entity(book).build();

	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBookInJSON(Book book) {

		String result = "Track saved : " + book;
		return Response.status(201).entity(result).build();
		
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBookInJSON(Book book) {

		String result = "Track saved : " + book;
		return Response.status(201).entity(result).build();
		
	}
	
	@DELETE
	@Path("/delete/{bookId}")
	public Response deleteBookInJSON(@PathParam("bookId") int bookId) {

		return Response.status(200).entity("Book with " + bookId + "is deleted").build();
		
	}
}