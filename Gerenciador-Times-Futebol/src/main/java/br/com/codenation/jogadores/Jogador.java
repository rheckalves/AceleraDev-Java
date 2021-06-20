package br.com.codenation.jogadores;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
    private final Long id;
    private final String nome;
    private final LocalDate dataNascimento;
    private final Integer nivelHabilidade;
    private final BigDecimal salario;
    private Boolean isCapitao = false;
    private final Integer idade = null;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public Integer getIdade() {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    public Boolean getCapitao() {
        return isCapitao;
    }

    public void setCapitao(Boolean capitao) {
        isCapitao = capitao;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

}
