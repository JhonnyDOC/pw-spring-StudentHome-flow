package pe.edu.upc.studenthome.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class CalificacionId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long arrendador;
	private Long estudiante;
	private String fecha;
	
	public CalificacionId() {
		
	}
	public CalificacionId(Long arrendador, Long estudiante, 
			String fecha) {
		super();
		this.arrendador = arrendador;
		this.estudiante = estudiante;
		this.fecha = fecha;
	
	}
	public Long getArrendador() {
		return arrendador;
	}
	public void setArrendador(Long arrendador) {
		this.arrendador = arrendador;
	}
	public Long getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Long estudiante) {
		this.estudiante = estudiante;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrendador, estudiante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        CalificacionId calificacionId = (CalificacionId) obj;
        if (this.arrendador != calificacionId.arrendador ||
        	this.fecha != calificacionId.fecha) 
        	return false;
        return this.estudiante == calificacionId.estudiante;
	}
	
	
}	
