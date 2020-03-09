package br.com.pocobserver.events.model;

import br.com.pocobserver.events.enumeration.EventEnum;

/**
 * Modelo de um Evento
 *
 * @author Bruno Eduardo
 */
public class Event {

    /**
     * Evento.
     * obrigatório
     */
    private EventEnum event;

    /**
     * Parâmetros/argumentos.
     * opcional
     */
    private Object[] args = {};

    /**
     * Função de callback do evento.
     * opcional
     */
    private CallbackFunction callback;

    /**
     * Setta o Evento e retorna o this
     *
     * @param event - Evento
     * @return this
     */
    public Event withEvent(final EventEnum event) {
        this.event = event;
        return this;
    }

    /**
     * Setta os Args e retorna o this
     *
     * @param args - Argumentos/parâmetros
     * @return this
     */
    public Event withArgs(final Object... args) {
        this.args = args;
        return this;
    }

    /**
     * Setta o Callback e retorna o this
     *
     * @param callback - Callback
     * @return this
     */
    public Event withCallback(final CallbackFunction callback) {
        this.callback = callback;
        return this;
    }

    public CallbackFunction getCallback() {
        return this.callback;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public EventEnum getEvent() {
        return this.event;
    }

}