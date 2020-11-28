package pe.edu.upc.studenthome.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "rentas")
public class Renta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha_renta_inicio", nullable = false)
	//@Temporal(TemporalType.DATE)
	private String fechaRentaInicio;
	
	@Column(name = "fecha_renta_fin", nullable = false)
	//@Temporal(TemporalType.DATE)
	private String fechaRentaFin;
	
	@Column(name = "descripcion_renta",length = 150 ,nullable = false)
	private String descripcionRenta;
	
	@Column(name = "descuento", nullable = true)
	private Float descuento;
	
	@Column(name = "demora_pago", nullable = true)
	private Float demoraPago;
	
	@Column(name = "precio_parcial", nullable = false)
	private Float precioParcial;
	
	@Column(name = "precio_final", nullable = false)
	private Float precioFinal;
	
	@ManyToOne
	@JoinColumn(name = "arrendador_id")
	private Arrendador arrendador;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_uno_id")
	private Estudiante estudianteUno;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_dos_id")
	private Estudiante estudianteDos;
	
	@ManyToOne
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;
	
	@ManyToOne
	@JoinColumn(name = "tipo_comprobante_id")
	private TipoComprobante tipoComprobante;
	
	@ManyToOne
	@JoinColumn(name = "tipo_pago_id")
	private TipoPago tipoPago;
	
	@OneToMany(mappedBy = "renta")
	private List<DetalleRenta> detalleRentas;
	
	public Renta () {
		detalleRentas = new ArrayList<DetalleRenta>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaRentaInicio() {
		return fechaRentaInicio;
	}

	public void setFechaRentaInicio(String fechaRentaInicio) {
		this.fechaRentaInicio = fechaRentaInicio;
	}

	public String getFechaRentaFin() {
		return fechaRentaFin;
	}

	public void setFechaRentaFin(String fechaRentaFin) {
		this.fechaRentaFin = fechaRentaFin;
	}

	public String getDescripcionRenta() {
		return descripcionRenta;
	}

	public void setDescripcionRenta(String descripcionRenta) {
		this.descripcionRenta = descripcionRenta;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getDemoraPago() {
		return demoraPago;
	}

	public void setDemoraPago(Float demoraPago) {
		this.demoraPago = demoraPago;
	}

	public Float getPrecioParcial() {
		return precioParcial;
	}

	public void setPrecioParcial(Float precioParcial) {
		this.precioParcial = precioParcial;
	}

	public Float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Arrendador getArrendador() {
		return arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public List<DetalleRenta> getDetalleRentas() {
		return detalleRentas;
	}

	public void setDetalleRentas(List<DetalleRenta> detalleRentas) {
		this.detalleRentas = detalleRentas;
	}
	
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
	
}
