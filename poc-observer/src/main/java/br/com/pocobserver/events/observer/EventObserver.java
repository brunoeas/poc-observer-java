package br.com.pocobserver.events.observer;

import br.com.pocobserver.events.annotation.OnEvent;
import br.com.pocobserver.events.enumeration.EventEnum;
import br.com.pocobserver.events.model.Event;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

/**
 * Modelo de Observer para ser extendido
 * <p>
 * É importante que toda classe que extender esta tenha um construtor público e sem nenhum parâmetro
 *
 * @author Bruno Eduardo
 */
public abstract class EventObserver implements Observer {

    /**
     * Logger
     */
    private final static Logger LOGGER = Logger.getLogger(EventObserver.class.getName());

    /**
     * Converte o parâmetro recebido do Observable para um Event
     * e chama o método de atualização com o Evento
     */
    @Override
    public void update(final Observable o, final Object arg) {

        if (arg == null) {
            throw new NullPointerException();
        }

        if (!(arg instanceof Event)) {
            throw new IllegalArgumentException();
        }

        final Event event = (Event) arg;

        try {
            this.updateMethods(event);
        } catch (final Exception e) {
            LOGGER.log(Level.ERROR, "Ocorreu um erro ao executar um método de um evento\nevento: " + event.getEvent().name(), e);
        }
    }

    /**
     * Busca nas classes que extendem {@link EventObserver} os métodos anotados com @{@link OnEvent}
     * e executa eles filtrando pelo evento em ordem decrescente
     *
     * @param event - Evento
     */
    private void updateMethods(final Event event) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        for (int i = this.getClass().getMethods().length - 1; i >= 0; i--) {
            final Method method = this.getClass().getMethods()[i];

            if (!method.isAnnotationPresent(OnEvent.class)) {
                continue;
            }
            method.setAccessible(true);

            final OnEvent onEventAnnotation = method.getAnnotation(OnEvent.class);
            final EventEnum eventEnum = onEventAnnotation.value();

            if (!eventEnum.equals(event.getEvent())) {
                continue;
            }

            final Object methodReturn = method.invoke(this.getClass().newInstance(), event.getArgs());

            if (event.getCallback() != null) {
                event.getCallback().exec(methodReturn);
            }
        }
    }

}