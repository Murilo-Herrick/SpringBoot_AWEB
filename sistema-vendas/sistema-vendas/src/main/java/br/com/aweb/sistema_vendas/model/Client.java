package br.com.aweb.sistema_vendas.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Clients")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(unique = true, nullable = false)
    @CPF
    private String cpf;

    @Nullable
    @Column(nullable = true)
    private String Telephone;

    @NotBlank
    @Column(nullable = false)
    private String street;

    @Nullable
    @Column(nullable = true)
    private Integer number;

    @Nullable
    @Column(nullable = true)
    private String complement;

    @NotBlank
    @Column(nullable = false)
    private String neighboorhood;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Length(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    private String uf;

    @NotBlank
    @Column(nullable = false)
    private String zipCode;
}
