package pe.edu.cibertec.CL1.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpaciente;

    @Column(name = "nompaciente")
    private String nompaciente;

    @Column(name = "apepaciente")
    private String apepaciente;

    @Column(name = "docpaciente")
    private String docpaciente;

    @Column(name = "fecnacpaciente")
    private String fecnacpaciente;

    @Column(name = "emailpaciente")
    private String emailpaciente;

}
