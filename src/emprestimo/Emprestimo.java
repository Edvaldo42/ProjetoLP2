package emprestimo;

import java.time.LocalDate;

import exception.ItemNaoEncontradoException;
import item.Item;
import usuario.CrudUsuario;
import usuario.Usuario;

public class Emprestimo {

	private Usuario dono;
	private Usuario requerente;
	private String itemEmprestado;
	private LocalDate dataEmprestimo;
	private int periodo;
	
	public Emprestimo(CrudUsuario crudUsuario, String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, LocalDate data, int periodo) throws ItemNaoEncontradoException {
		this.dono = crudUsuario.buscaUsuario(nomeDono, telefoneDono);
		this.requerente = crudUsuario.buscaUsuario(nomeRequerente, telefoneRequerente);
		this.itemEmprestado = nomeItem;
		this.dataEmprestimo = data;
		this.periodo = periodo;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public Usuario getRequerente() {
		return requerente;
	}

	public void setRequerente(Usuario requerente) {
		this.requerente = requerente;
	}

	public String getItemEmprestado() {
		return itemEmprestado;
	}

	public void setItemEmprestado(String itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
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
