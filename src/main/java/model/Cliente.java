package model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name="Cliente")
@Table(name = "tbl_cliente")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="apellidoMaterno")
	private String apellidoMaterno;
	
	@Column(name="apellidoPaterno")
	private String apellidoPaterno;
	
	@Column(name="nombres")
	private String nombres;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cuenta Cuenta;
	
	@ManyToMany
	private Rol rol;


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno
				+ ", nombres=" + nombres + "]";
	}

	
}
