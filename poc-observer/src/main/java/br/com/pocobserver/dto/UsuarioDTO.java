package br.com.pocobserver.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO do Usuário
 *
 * @author Bruno Eduardo
 */
public class UsuarioDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer idUsuario;

    /**
     * Nome
     */
    private String nmUsuario;

    /**
     * Data de nascimento
     */
    private LocalDate dtNascimento;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(final Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(final String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(final LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

}