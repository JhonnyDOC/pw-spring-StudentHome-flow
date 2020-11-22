package pe.edu.upc.studenthome.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calificacion_roommates")
@IdClass(CalificacionRoommateId.class)
public class CalificacionRoommate {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudiante_uno_id")
	private Estudiante estudianteUno;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "estudiante_dos_id")
	private Estudiante estudianteDos;
	
	@Id
	@JoinColumn(name = "fecha")
	private String fecha;
	

	@ManyToOne
	@JoinColumn(name = "puntaje_id")
	private Puntaje puntaje;
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Column(name = "comentario", length = 50 ,nullable = false)
	private String comentario;


	public Estudiante getEstudianteUno() {
		return estudianteUno;
	}

	public void setEstudianteUno(Estudiante estudianteUno) {
		this.estudianteUno = estudianteUno;
	}

	public Estudiante getEstudianteDos() {
		return estudianteDos;
	}

	public void setEstudianteDos(Estudiante estudianteDos) {
		this.estudianteDos = estudianteDos;
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
