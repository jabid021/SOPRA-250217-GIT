package transport.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="arret")
public class Arret {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalTime heure;
	
	@ManyToOne
	@JoinColumn(name="station",nullable = false)
	private Station station;
	@ManyToOne
	@JoinColumn(name="transport",nullable = false)
	private Transport transport;

	
	
	public Arret() {}



	public Arret(LocalTime heure, Station station, Transport transport) {
		this.heure = heure;
		this.station = station;
		this.transport = transport;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalTime getHeure() {
		return heure;
	}



	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}



	public Station getStation() {
		return station;
	}



	public void setStation(Station station) {
		this.station = station;
	}



	public Transport getTransport() {
		return transport;
	}



	public void setTransport(Transport transport) {
		this.transport = transport;
	}



	@Override
	public String toString() {
		return "Arret [id=" + id + ", heure=" + heure + ", station=" + station + ", transport=" + transport + "]";
	}
	
}
