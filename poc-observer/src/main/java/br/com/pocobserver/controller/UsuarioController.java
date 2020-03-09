package br.com.pocobserver.controller;

import br.com.pocobserver.events.annotation.OnEvent;
import br.com.pocobserver.events.enumeration.EventEnum;
import br.com.pocobserver.events.observer.EventObserver;

import javax.enterprise.context.RequestScoped;

/**
 * Controller do Usuário
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@RequestScoped
public class UsuarioController extends EventObserver {

    @OnEvent(EventEnum.FINDALL_USUARIOS)
    public String findAllUsuarios() {
        return "batatinha";
    }

}