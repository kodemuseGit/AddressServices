package com.example.demo;

public class EventBus {
	private Long id;
	private String entityType;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EventBus [id=" + id + ", entityType=" + entityType + ", status=" + status + "]";
	}



}
