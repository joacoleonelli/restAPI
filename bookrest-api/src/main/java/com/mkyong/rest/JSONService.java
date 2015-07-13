package com.mkyong.rest;

import java.net.URI;
import java.util.Map;

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

@Path("/book")
public class JSONService {

	@GET
	@Path("/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookInJSON(@PathParam("bookId") String bookId) {
		Book book = BookManager.getInstance().getBook(bookId);
		if(book != null){
			return Response.ok().entity(book).build();
		}else{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
		Map<String, Book> books = BookManager.getInstance().getBooks();
		return Response.ok().entity(books).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBookInJSON(Book book) {
		String bookId = BookManager.getInstance().createBook(book);
		return Response.created(URI.create("book/" + bookId)).entity(book).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/bookId")
	public Response updateBookInJSON(@PathParam("bookId") String bookId, Book book) {
		boolean updated = BookManager.getInstance().updateBook(bookId, book);
		if(updated){
			return Response.ok().entity(book).build();
		}else{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("/{bookId}")
	public Response deleteBookInJSON(@PathParam("bookId") String bookId) {
		boolean deleted = BookManager.getInstance().deleteBook(bookId);
		if(deleted){
			return Response.ok().build();
		}else{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}