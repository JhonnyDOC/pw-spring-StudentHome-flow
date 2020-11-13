package pe.edu.upc.studenthome.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calificaciones")
@IdClass(CalificacionId.class)
public class Calificacion {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "arrendador_id")
	private Arrendador arrendador;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
	
	@Id
	@JoinColumn(name = "fecha")
	private String fecha;
	
	
	@ManyToOne
	@JoinColumn(name = "puntaje_id")
	private Puntaje puntaje;
	
	@Column(name = "comentario", length = 40, nullable = false)
	private String comentario;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
