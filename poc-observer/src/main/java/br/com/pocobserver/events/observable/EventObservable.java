package br.com.pocobserver.events.observable;

import java.util.Observable;

/**
 * Singleton do controlador de eventos.
 * Observable principal.
 *
 * @author Bruno Eduardo
 */
public class EventObservable extends Observable {

    /**
     * Instância do Singleton
     */
    private static EventObservable instance = null;

    /**
     * Construtor privado do Singleton
     */
    private EventObservable() {
        super();
        this.setChanged();
    }

    /**
     * @return Instância única do Singleton Observable
     */
    public static EventObservable getInstance() {
        if (EventObservable.instance == null) {
            EventObservable.instance = new EventObservable();
        }
        EventObservable.instance.setChanged();
        return EventObservable.instance;
    }

}