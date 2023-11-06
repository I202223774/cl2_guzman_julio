package model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="Cuenta")
@Table(name="tbl_cuenta")
@Getter
@Setter
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean activa;
	private String numeroCuenta;
	private Double saldo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cliente cliente;

	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	private TipoCuenta tipocuenta;
	

}
