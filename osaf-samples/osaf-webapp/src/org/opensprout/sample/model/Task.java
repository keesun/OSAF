package org.opensprout.sample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seq_task", sequenceName = "seq_task", allocationSize = 1, initialValue = 1)
public class Task {

	@Id @GeneratedValue(generator="seq_task")
	private int id;
	private String name;
	private int type;	// TaskType type-not-safe enum.
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date started;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ended;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueto;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getEnded() {
		return ended;
	}
	public void setEnded(Date ended) {
		this.ended = ended;
	}
	public Date getDueto() {
		return dueto;
	}
	public void setDueto(Date dueto) {
		this.dueto = dueto;
	}
	
}
