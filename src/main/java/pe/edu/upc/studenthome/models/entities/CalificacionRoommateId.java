package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class CalificacionRoommateId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long estudianteUno;
	private Long estudianteDos;
	private String fecha;

	
	public CalificacionRoommateId() {
		
	}
	
	public CalificacionRoommateId(Long estudianteUno, Long estudianteDos,
			 					  String fecha) {
		super();
		this.estudianteUno = estudianteUno;
		this.estudianteDos = estudianteDos;
		this.fecha=fecha;

	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Long getEstudianteUno() {
		return estudianteUno;
	}

	public void setEstudianteUno(Long estudianteUno) {
		this.estudianteUno = estudianteUno;
	}

	public Long getEstudianteDos() {
		return estudianteDos;
	}

	public void setEstudianteDos(Long estudianteDos) {
		this.estudianteDos = estudianteDos;
	}
	



	@Override
	public int hashCode() {
		return Objects.hash(estudianteUno, estudianteDos, fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        CalificacionRoommateId calificacionRoommateId = (CalificacionRoommateId) obj;
        if (this.estudianteUno != calificacionRoommateId.estudianteUno ||
        		this.fecha != calificacionRoommateId.fecha ) 
        	return false;
        return this.estudianteDos == calificacionRoommateId.estudianteDos;
	}
	
	
}
