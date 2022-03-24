package com.zoho.struts2.rest;

import java.util.Collection;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;

public class MessagesController implements ModelDriven<Object> {

	private static final long serialVersionUID = 89268916175477696L;
	private Message model = new Message();
	private String id;
	private Collection<Message> list;

	//GET /messages/1.json
	public HttpHeaders show() {
		return new DefaultHttpHeaders("show").disableCaching();
	}

	//GET /messages.json
	public HttpHeaders index() {
		list = MessageService.findAll();
		return new DefaultHttpHeaders("index").disableCaching();
	}

	//POST /messages.json
	public HttpHeaders create() {
		MessageService.save(model);
		return new DefaultHttpHeaders("create");
	}

	//Delete /messages/1.json
	public HttpHeaders destroy() {
		MessageService.remove(id);
		return new DefaultHttpHeaders("destroy");
	}

	

	//PUT /messages/1.json
	public HttpHeaders update() {
		MessageService.save(model);
		return new DefaultHttpHeaders("update");
	}

	

	public Object getModel() {
		return (list != null ? list : model);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id != null) {
			this.model = MessageService.find(id);
		}
		this.id = id;
	}
}
