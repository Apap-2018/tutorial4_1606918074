package com.apap.tutorial4.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="flight")
public class FlightModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max=50)
	@Column(name="origin", nullable=false)
	private String origin;
	
	@NotNull
	@Size(max=50)
	@Column(name="destination", nullable=false)
	private String destination;
	
	@NotNull
	@Column(name="time")
	private Date time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pilot_licenseNumber", referencedColumnName="license_number", nullable=false)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private PilotModel pilot;

}