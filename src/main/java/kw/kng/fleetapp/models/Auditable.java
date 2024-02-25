package kw.kng.fleetapp.models;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedBy
    protected U createdby;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createddate;

    @LastModifiedBy
    protected U lastmodifiedby;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastmodifieddate;

	public U getCreatedby() {
		return createdby;
	}

	public void setCreatedby(U createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public U getLastmodifiedby() {
		return lastmodifiedby;
	}

	public void setLastmodifiedby(U lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}

	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

    
}