package br.com.pocobserver.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * ORM do Usuário
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@Entity
@Table(name = "usuario")
public class Usuario extends PanacheEntityBase {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    /**
     * Nome
     */
    @Column(name = "nm_usuario", nullable = false)
    private String nmUsuario;

    /**
     * Data de nascimento
     */
    @Column(name = "dt_nascimento")
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