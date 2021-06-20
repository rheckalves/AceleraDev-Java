package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.jogadores.Jogador;
import br.com.codenation.times.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	private ArrayList<Time> listaTimes = new ArrayList<>();
	private ArrayList<Jogador> listaJogadores = new ArrayList<>();

	private ArrayList<Jogador> retornaListaDeTodosJogadores() {
		ArrayList<Jogador> todosJogadores = new ArrayList<>();
		for (Time time : listaTimes) {
			todosJogadores.addAll(time.getListaJogadores());
		}
		return todosJogadores;
	}

	private ArrayList<Long> retornaIDsDeTodosJogadores() {
		ArrayList<Long> listaIds;
		ArrayList<Jogador> listaJogadores;
		listaJogadores = retornaListaDeTodosJogadores();
		listaIds = (ArrayList<Long>) listaJogadores.stream().map(Jogador::getId).collect(Collectors.toList());
		return listaIds;
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		timeExiste(id);
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		listaTimes.add(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		jogadorExiste(id);
		timeNaoExiste(idTime);
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		for (Time time : listaTimes) {
			if (time.getId().equals(idTime)) {
				time.adicionarJogador(jogador);
			}
		}
		listaJogadores.add(jogador);
	}

	private void jogadorExiste(Long idJogador) throws IdentificadorUtilizadoException {
		boolean resultado = retornaIDsDeTodosJogadores().contains(idJogador);
		if (resultado) {
			throw new IdentificadorUtilizadoException();
		}
	}

	private void jogadorNaoExiste(Long idJogador) throws JogadorNaoEncontradoException {
		boolean resultado = retornaIDsDeTodosJogadores().contains(idJogador);
		if (!resultado) {
			throw new JogadorNaoEncontradoException();
		}
	}

	private void timeNaoExiste(Long idTime) throws TimeNaoEncontradoException {
		boolean resultado = buscarTimes().contains(idTime);
		if (!resultado) {
			throw new TimeNaoEncontradoException();
		}
	}

	private void timeExiste(Long idTime) throws TimeNaoEncontradoException {
		boolean resultado = buscarTimes().contains(idTime);
		if (resultado) {
			throw new IdentificadorUtilizadoException();
		}
	}

	private void capitaoNaoExiste(Long idTime) throws CapitaoNaoInformadoException {
		boolean resultado = false;
		for (Time time : listaTimes) {
			if (idTime.equals(time.getId())) {
				resultado = time.getListaJogadores().stream().anyMatch(Jogador::getCapitao);
			}
		}
		if (!resultado) {
			throw new CapitaoNaoInformadoException();
		}
	}

	public void definirCapitao(Long idJogador) {
		jogadorNaoExiste(idJogador);
		ArrayList<Jogador> listaJogadores = retornaListaDeTodosJogadores();
		for (Jogador jogador : listaJogadores) {
			if (idJogador.equals(jogador.getId())) {
				jogador.setCapitao(true);
			}
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		timeNaoExiste(idTime);
		capitaoNaoExiste(idTime);
		Long capitao = null;
		for (Time time : listaTimes) {
			if (time.getId().equals(idTime)) {
				capitao = time.retornaCapitaoDoTime();
			}
		}
		return capitao;
	}



	public String buscarNomeJogador(Long idJogador) {
		jogadorNaoExiste(idJogador);
		String nomeJogador = "";
		ArrayList<Jogador> listaJogadores = retornaListaDeTodosJogadores();
		for (Jogador jogador : listaJogadores) {
			if (idJogador.equals(jogador.getId())) {
				nomeJogador = jogador.getNome();
			}
		}
		return nomeJogador;
	}

	public String buscarNomeTime(Long idTime) {
		timeNaoExiste(idTime);
		String nomeTime = "";
		for (Time time : listaTimes) {
			if (idTime.equals(time.getId())) {
				nomeTime = time.getNome();
			}
		}
		return nomeTime;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		timeNaoExiste(idTime);
		ArrayList<Long> listaIdsJogadores = new ArrayList<>();
		for (Time time : listaTimes) {
			if(idTime.equals(time.getId())) {
				listaIdsJogadores = (ArrayList<Long>) time.getListaJogadores().stream().map(Jogador::getId).collect(Collectors.toList());
			}
		}

		return listaIdsJogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		timeNaoExiste(idTime);
		Long idMelhorJogador = null;
		for (Time time : listaTimes) {
			if (time.getId().equals(idTime)) {
				idMelhorJogador = time.retornaMelhorJogador();
			}
		}
		return idMelhorJogador;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		timeNaoExiste(idTime);
		Long idJogadorMaisVelho = null;
		for (Time time : listaTimes) {
			if (time.getId().equals(idTime)) {
				idJogadorMaisVelho = time.retornaJogadorMaisVelho();
			}
		}
		return idJogadorMaisVelho;
	}

	public List<Long> buscarTimes() {
		List<Long> listaIdsTimes;
		listaIdsTimes = listaTimes.stream().map(Time::getId).collect(Collectors.toList());
		return listaIdsTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		timeNaoExiste(idTime);
		Long idJogadorMaiorSalario = null;
		for (Time time : listaTimes) {
			if (time.getId().equals(idTime)) {
				idJogadorMaiorSalario = time.retornaJogadorMaiorSalario();
			}
		}
		return idJogadorMaiorSalario;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		jogadorNaoExiste(idJogador);
		ArrayList<Jogador> listaJogadores = retornaListaDeTodosJogadores();
		BigDecimal salario = null;
		for (Jogador jogador : listaJogadores) {
			if (jogador.getId().equals(idJogador)) {
				salario = jogador.getSalario();
			}
		}
		return salario;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		ArrayList<Jogador> listaJogadores = retornaListaDeTodosJogadores();
		List<Long> topJogadoresIds = new ArrayList<>();
		listaJogadores.sort(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed());
		topJogadoresIds = listaJogadores.stream().map(Jogador::getId).collect(Collectors.toList());
		if (topJogadoresIds.isEmpty()) {
			return topJogadoresIds;
		}
		return topJogadoresIds.subList(0, top);
	}

}


