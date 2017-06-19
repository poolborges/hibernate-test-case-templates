package org.hibernate.bugs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Table(name = "evmanager_event")
@Entity
public class Event  implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ev_id")
    private Long id;
    
    @Column(name="ev_title", nullable = false)
    private String title;

    @Column(name="ev_createat")
    @Temporal(TemporalType.TIMESTAMP )
    private Date createdAt;
    
    @Version
    @Column(name = "ev_version")
    private Long version;

    public Event() {
    }

    public Event(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
