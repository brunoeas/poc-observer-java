package br.com.pocobserver.events.model;

/**
 * Interface que representa a função/lambda que vai ser usada como callback no evento
 *
 * @author Bruno Eduardo
 */
@FunctionalInterface
public interface CallbackFunction {

    /**
     * Executa a função
     *
     * @param param - Parâmetro do callback
     */
    void exec(Object param);

}