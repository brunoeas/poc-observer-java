package br.com.pocobserver.config;

import br.com.pocobserver.events.enumeration.EventEnum;
import br.com.pocobserver.events.model.Event;
import br.com.pocobserver.events.observable.EventObservable;
import br.com.pocobserver.events.observer.StartupObserver;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * Classe de configuração do ciclo de vida da aplicação
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@ApplicationScoped
public class LifecycleConfiguration {

    /**
     * Executa ao iniciar o back-end
     *
     * @param ev - Evento de Startup
     */
    void init(@Observes final StartupEvent ev) {
        final EventObservable eventObservable = EventObservable.getInstance();
        eventObservable.addObserver(new StartupObserver());
        eventObservable.notifyObservers(new Event().withEvent(EventEnum.STARTUP));
    }

}