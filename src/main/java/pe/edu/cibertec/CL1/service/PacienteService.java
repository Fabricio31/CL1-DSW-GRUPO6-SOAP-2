package pe.edu.cibertec.CL1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.CL1.model.Paciente;
import pe.edu.cibertec.CL1.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;



    //Metodo Listar Pacientes
    public List<Paciente> obtenerPaciente(){return pacienteRepository.findAll();}

    //Metodo Buscar Pacientes:
    public Paciente obtenerPacienteXId(Integer id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()){
            return null;
        }
        return paciente.get();
    }

    //Metodo Registrar Pacientes:
    public Paciente guardarPaciente(Paciente paciente){return pacienteRepository.save(paciente);}


    //Metodo Buscar Paciente X Nombre
    public List<Paciente> findByNompaciente(String nompaciente) {
        return pacienteRepository.findBynompaciente(nompaciente);
    }

    //Metodo Actualizar
}
