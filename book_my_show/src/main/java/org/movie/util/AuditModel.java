package org.movie.util;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class AuditModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATE_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime creadtedDate;
	@Column(name = "CREATE_DATE_TIME_upde")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedDate;
	@Column(name = "CREATE_DATE_TIME_lupdate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime lupdate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreadtedDate() {
		return creadtedDate;
	}

	public void setCreadtedDate(LocalDateTime creadtedDate) {
		this.creadtedDate = creadtedDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDateTime getLupdate() {
		return lupdate;
	}

	public void setLupdate(LocalDateTime lupdate) {
		this.lupdate = lupdate;
	}

}
