package emprestimo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import exceptionsComplementares.ItemNaoEncontradoException;
import exceptionsUsuario.UsuarioInvalidoException;
import usuario.ControllerUsuario;
import usuario.Usuario;

public class Emprestimo {


	private Usuario dono;
	private Usuario requerente;
	private String itemEmprestado;
	private LocalDate dataEmprestimo;
	private int periodo;
	private LocalDate dataDevolucao;

	/**
	 * Construtor de Emprestimo
	 * 
	 * @param controllerUsuario
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param data
	 * @param periodo
	 * @throws ItemNaoEncontradoException
	 * @throws UsuarioInvalidoException
	 */
	public Emprestimo(ControllerUsuario controllerUsuario, String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String data, int periodo) throws ItemNaoEncontradoException, 
			UsuarioInvalidoException {
		
		if (periodo <= 0) {
			throw new IllegalArgumentException("Periodo precisa ser maior que 0");
		}
		
		this.dono = controllerUsuario.buscaUsuario(nomeDono, telefoneDono);
		this.requerente = controllerUsuario.buscaUsuario(nomeRequerente, telefoneRequerente);
		verificaCartao(periodo);
		this.itemEmprestado = nomeItem;
		this.dataEmprestimo = converteData(data);
		this.periodo = periodo;
		this.dataDevolucao = null;
	}

	private void verificaCartao(int periodo) {
		if (this.requerente.getCartao().equals("Caloteiro")) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}
		
		if (this.requerente.getCartao().equals("FreeRyder") && periodo > 5) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		
		if (this.requerente.getCartao().equals("Noob") && periodo > 7) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		
		if (this.requerente.getCartao().equals("BomAmigo") && periodo > 14) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
	}
	
	/**
	 * Retorna a data de devolucao do emprestimo
	 * 
	 * @return the dataDevolucao
	 */
	public String getDataDevolucao() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (this.dataDevolucao == null) {
			return "Emprestimo em andamento";
		}
		return this.dataDevolucao.format(formatter);
	}

	/**
	 * Estabelece a data devolucao do emprestimo
	 * 
	 * @param dataDevolucao
	 *            the dataDevolucao to set
	 */
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = converteData(dataDevolucao);
	}

	/**
	 * Coverte a data do emprestimo para uma data padrão
	 * 
	 * @param data
	 * @return
	 */
	private LocalDate converteData(String data) {
		StringBuilder sb = new StringBuilder(data);
		int i = 0;
		int qtdBarras = 0;
		while (i < data.length() && qtdBarras < 1) {
			if (data.charAt(i) == '/') {
				for (int j = 0; j < i-2; j++) {
					sb.deleteCharAt(j);
					data = sb.toString();
				}
				qtdBarras++;
			}
			i++;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataConvertida = LocalDate.parse(data, formatter);
		return dataConvertida;
	}

	/**
	 * Retorna o usuario que emprestou o item
	 * 
	 * @return
	 */
	public Usuario getDono() {
		return dono;
	}
	

	/**
	 * Estabelece o usuario que emprestou o item
	 * @param dono
	 */
	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	/**
	 * Retorna o usuario que pegou um item emprestado
	 * 
	 * @return
	 */
	public Usuario getRequerente() {
		return requerente;
	}

	/**
	 * Estabelece o usuario que pegou um item emprestado
	 * @param requerente
	 */
	public void setRequerente(Usuario requerente) {
		this.requerente = requerente;
	}

	/**
	 * Retorna o item que esta fazendo parte do emprestimo
	 * 
	 * @return
	 */
	public String getItemEmprestado() {
		return itemEmprestado;
	}

	/**
	 * Estabelece o item que esta fazendo parte do emprestimo
	 * @param itemEmprestado
	 */
	public void setItemEmprestado(String itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}

	/**
	 * Retorna a data de realizacao do emprestimo
	 * 
	 * @return
	 */
	public String getDataEmprestimo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataEmprestimo.format(formatter);
	}
	
	/**
	 * Estabelece a data de realizacao do emprestimo
	 * 
	 * @param dataEmprestimo
	 */
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = converteData(dataEmprestimo);
	}
	
	/**
	 * Retorna o tempo previsto para a duracao do emprestimo
	 *  
	 * @return
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * Estabele o tempo previsto para a duracao do emprestimo
	 * 
	 * @param periodo
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	/**
	 * Retorna o tempo real que um requerente ficou com um item
	 * 
	 * @return
	 */
	public int getTempoComItem() {
		Period tempoComItem = Period.between(this.dataEmprestimo, this.dataDevolucao);
		return tempoComItem.getDays();
	}
	
	/**
	 * Retorna quantos dias um requerente ficou com um item alem do periodo pre-definido
	 * 
	 * @return
	 */
	public int getAtraso() {
		int atraso;
		atraso = this.periodo - getTempoComItem();
		return atraso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EMPRESTIMO - De: " + dono.getNome() + ", Para: " + requerente.getNome() + ", " + itemEmprestado + ", "
				+ this.getDataEmprestimo() + ", " + periodo + " dias" + ", ENTREGA: " + this.getDataDevolucao();
	}

	/**
	 * Hash Code de Emprestimo
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		return result;
	}


	/**
	 * Metodo equals de emprestimo
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!itemEmprestado.equals(other.itemEmprestado))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		return true;
	}

}
