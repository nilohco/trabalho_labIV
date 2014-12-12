package ClubManager.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import ClubManager.Bean.AtletaTO;
import ClubManager.DAO.AtletaDAO;

@ManagedBean
@SessionScoped
public class AtletaControle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final String HibernateUtil = null;
	
	private AtletaTO to;
	private AtletaDAO dao;
	private DataModel tablemodel;
	private final EntityManager em = HibernateUtil.getEntityManager();
	
	
	
	public AtletaControle() {
		
	}
	public AtletaTO getTo() {
		return to;
	}
	public void setTo(AtletaTO to) {
		this.to = to;
	}
	public AtletaDAO getDao() {
		return dao;
	}
	public void setDao(AtletaDAO dao) {
		this.dao = dao;
	}
	public DataModel<AtletaTO> getTablemodel() {
		dao = new AtletaDAO(this.em);
		tablemodel = new ListDataModel<AtletaTO>(dao.getAtletas());
		
		
		return tablemodel;
	}
	public void setTablemodel(DataModel tablemodel) {
		this.tablemodel = tablemodel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getHibernateutil() {
		return HibernateUtil;
	}
	public EntityManager getEm() {
		return em;
	}
	
	public String salvaAtleta() {
		dao = new AtletaDAO(this.em);
		if (dao.SalvarAtleta()) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", ""));
			return "telaListar";
		} else {
			return "erro";
		}
	}

	public String editaAtleta() {
		dao = new AtletaDAO(this.em);
		if (dao.editarAtleta() != null) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
			return "telaListar";
		} else {
			return "erro";
		}
	}

	public String excluiAtleta() {
		dao = new InstituicaoDAO(this.em);
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
