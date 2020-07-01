package com.alamo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.alamo.facade.PessoaFacade;

/**
 * @author Marcos Moreira
 *
 */
public abstract class BaseBean {

	@Inject
	private SessionBean sessionBean;
	
//	@ManagedProperty("#{produtoFacade}")
//	private ProdutoFacade produtoFacade;
	
//	@ManagedProperty(value = "#{pessoaFacade}")
	@Autowired
	private PessoaFacade pessoaFacade;

	public SessionBean getSessionBean() {
		return sessionBean;
	}
	
//	public ProdutoFacade getProdutoFacade() {
//		return produtoFacade;
//	}	
	
	public PessoaFacade getPessoaFacade() {
		return pessoaFacade;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
    public void info(String texto) {
    	this.addTypeMessage(FacesMessage.SEVERITY_INFO, "Info", texto);
    }
     
    public void warn(String texto)  {
    	this.addTypeMessage(FacesMessage.SEVERITY_WARN, "Warning!", texto);
    }
     
    public void error(String texto) {
    	this.addTypeMessage(FacesMessage.SEVERITY_ERROR, "Error!", texto);
    }
     
    public void fatal(String texto) {
    	this.addTypeMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", texto);
    }
    
    public void addTypeMessage(Severity type, String summary, String texto) {
    	this.addMessage(null, new FacesMessage(type, summary, texto));
    }
    
    public void addMessage(String clientId, FacesMessage message) {
    	FacesContext.getCurrentInstance().addMessage(clientId, message);
    }
}
