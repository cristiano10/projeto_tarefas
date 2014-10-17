package br.com.caelum.tarefas.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {
	
	@Action(value="logout", results={
			@Result(name="ok", location="/login.jsp")
	})
	
	public String logoff(){
		
		//zera a sessão
		ActionContext.getContext().getSession().clear();
		return "ok";
	}

}
