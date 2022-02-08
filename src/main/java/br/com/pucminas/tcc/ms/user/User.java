package br.com.pucminas.tcc.ms.user;

import br.com.pucminas.tcc.ms.user.commons.AssertUtils;
import br.com.pucminas.tcc.ms.user.commons.converters.BooleanoCharConverter;
import br.com.pucminas.tcc.ms.user.commons.entities.AuditEntitySupport;
import br.com.pucminas.tcc.ms.user.commons.enums.BooleanoChar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Entity
@Table(name = "tab_usuario")
public class User extends AuditEntitySupport {

    @Id
    @EqualsAndHashCode.Include
    @SequenceGenerator(name = "SG_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_USUARIO")
    @Column(name = "IDT_USUARIO")
    private Long id;

    @NotBlank
    @Size(max = 80)
    @Column(name = "NM_USUARIO")
    private String name;

    @Email
    @Size(max = 50)
    @Column(name = "DS_EMAIL")
    private String mail;

    @JsonIgnore
    @NotBlank
    @Size(max = 120)
    @Column(name = "DS_SENHA")
    private String password;

    @Column(name = "FLG_ATIVO", nullable = false, columnDefinition = "VARCHAR(1)")
    @Convert(converter = BooleanoCharConverter.class)
    private BooleanoChar active = BooleanoChar.SIM;

    @ManyToOne
    @JoinColumn(name = "IDT_PERFIL", nullable = false)
    private Profile profile;

    public void passwordValidate(String confirmPassword) {
        AssertUtils.isTrue(this.password.equals(confirmPassword), "Senha e confirmação de senha precisam ser iguais");
    }

    public void mailValidated(String confirmMail) {
        AssertUtils.isTrue(this.mail.equals(confirmMail), "Email e confirmação de email precisam ser iguais");
    }
}
