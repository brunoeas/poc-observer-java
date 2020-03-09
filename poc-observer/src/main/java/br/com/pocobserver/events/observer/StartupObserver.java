package br.com.pocobserver.events.observer;

import br.com.pocobserver.events.annotation.OnEvent;
import br.com.pocobserver.events.enumeration.EventEnum;
import br.com.pocobserver.events.observable.EventObservable;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Observer do evento de Startup da aplicação
 *
 * @author Bruno Eduardo
 */
public class StartupObserver extends EventObserver {

    /**
     * Busca todas as classes que extendem {@link EventObserver}, ou seja, que são Observers, e registra esses
     * Observers no Observable principal da aplicação
     */
    @OnEvent(EventEnum.STARTUP)
    public void registerObservers() throws IllegalAccessException, InstantiationException {

        final Reflections ref = new Reflections("br.com.pocobserver");

        final Set<Class<? extends EventObserver>> observerClassList = ref.getSubTypesOf(EventObserver.class);
        final List<EventObserver> observers = new ArrayList<>();

        for (Class<? extends EventObserver> observerClass : observerClassList) {
            if (observerClass.equals(StartupObserver.class)) {
                continue;
            }
            observers.add(observerClass.newInstance());
        }

        final EventObservable eventObservable = EventObservable.getInstance();
        observers.forEach(eventObservable::addObserver);
    }

}