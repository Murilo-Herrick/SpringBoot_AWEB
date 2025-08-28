package br.com.aweb.sistema_alunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome não pode estar em branco!")
    private String name;

    @NotNull
    @Positive(message = "A idade deve ser maior que zero!")
    private int age;

    @NotNull
    @Positive(message = "O ano do estudante deve ser maior que zero!")
    private int schoolYear;

    public Aluno() {

    }

    public Aluno(long id, @NotBlank String name, @NotNull @Positive int age, @NotNull @Positive int schoolYear) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.schoolYear = schoolYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

}
