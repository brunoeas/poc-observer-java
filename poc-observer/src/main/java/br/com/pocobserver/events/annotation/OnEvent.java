package br.com.pocobserver.events.annotation;

import br.com.pocobserver.events.enumeration.EventEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marcador para métodos que serão executados com algum evento
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnEvent {

    /**
     * @return Evento disparado que executa o método
     */
    EventEnum value();

}