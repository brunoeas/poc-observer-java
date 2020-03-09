package br.com.pocobserver.service;

import br.com.pocobserver.events.enumeration.EventEnum;
import br.com.pocobserver.events.model.Event;
import br.com.pocobserver.events.observable.EventObservable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * Service do Usuário
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioService {

    @GET
    public void findAll(@Suspended final AsyncResponse asyncResponse) {

        final EventObservable observable = EventObservable.getInstance();

        observable.notifyObservers(new Event()
            .withEvent(EventEnum.FINDALL_USUARIOS)
            .withCallback((data) -> asyncResponse.resume("pato tonto: " + data)));
    }

}