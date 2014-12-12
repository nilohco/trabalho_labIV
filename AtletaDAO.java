package ClubManager.DAO;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import ClubManager.Bean.AtletaTO;

public class AtletaDAO implements Serializable {

	private static final String HibernateUtil = null;
	private AtletaTO to;
	private DataModel tablemodel;
	private final EntityManager em = HibernateUtil.getEntityManager();
	private List<AtletaTO> atletas;
	private AtletaDAO dao;
	
	
	public AtletaTO getTo() {
		return to;
	}
	public void setTo(AtletaTO to) {
		this.to = to;
	}
	public DataModel getTablemodel() {
		dao= new AtletaDAO(this.em);
		tablemodel = new ListDataModel(dao.getall());
		
		return tablemodel;
	}
	public void setTablemodel(DataModel tablemodel) {
		this.tablemodel = tablemodel;
	}
	public List<AtletaTO> getAtletas() {
		dao = new AtletaDAO(em);
		return atletas;
	}
	public void setAtletas(List<AtletaTO> atletas) {
		this.atletas = atletas;
	}
	public EntityManager getEm() {
		return em;
	}
	
	public String SalvarAtleta(){
		dao = new AtletaDAO(this.em);
		if (dao.SalvarAtleta(to)) {
		FacesContext contexte = FacesContext.getCurrentInstance();
		contexte.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", ""));
		return "ListarAtleta";
		}else{
			
			return "erro";
		}
		
	}
	
	
	public String editarAtleta(){
		dao = new AtletaDAO();
		if (dao.editarAtleta(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
		return "telaListar";	
			
		} else {
			return "erro";
		}
		
	}
	public String excluiAtleta() {
		dao = new AtletaDAO(this.em);
		if (dao.excluiAtleta(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Excluído com Sucesso!", ""));
			return "telaListar";
		} else {
			return "erro";
		}
	}
	
}
