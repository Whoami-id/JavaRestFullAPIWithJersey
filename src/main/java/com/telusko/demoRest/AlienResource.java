
package com.telusko.demoRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

    AlienRepository repo = new AlienRepository();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAliens() {
        System.out.println("getAliens called");
        return repo.getAliens();
    }

    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // @Path("alien/{id}")
    // public Alien getAlien(@PathParam("id") final int id) {
    // System.out.println("getAliens called");
    // return repo.getAlien(id);
    // }

    @POST
    @Path("alien")
    @Consumes(MediaType.APPLICATION_XML)
    public Alien createAlien(final Alien a1) {
        System.out.println(a1);
        repo.create(a1);
        return a1;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("alien/{id}")
    public Alien getAlien(@PathParam("id") final int id) {
        System.out.println("getAliens called");
        return repo.getAlien(id);
    }

    @PUT
    @Path("alien")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Alien updateAlien(final Alien a1) {
        System.out.println(a1);
        if (repo.getAlien(a1.getId()).getId() == 0) {
            repo.create(a1);
        }
        repo.update(a1);
        return a1;
    }

    @DELETE
    @Path("alien/{id}")
    public Alien deleteAlien(@PathParam("id") final int id) {
        final Alien a = repo.getAlien(id);
        if (a.getId() != 0) {
            repo.delete(id);
        }
        return a;

    }

}
