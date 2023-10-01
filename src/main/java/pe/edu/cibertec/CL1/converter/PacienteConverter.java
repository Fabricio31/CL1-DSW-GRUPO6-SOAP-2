package pe.edu.cibertec.CL1.converter;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.CL1.model.Paciente;
import pe.edu.cibertec.ws.objects.Pacientews;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteConverter {

    //Metodos
    //Paciente es del model
    //Pacientews es del contrato

    public Paciente convertPacienteWsToPaciente(Pacientews pacientews){
        Paciente paciente = new Paciente();
        paciente.setIdpaciente(pacientews.getIdpaciente());
        paciente.setNompaciente(pacientews.getNompaciente());
        paciente.setApepaciente(pacientews.getApepaciente());
        paciente.setDocpaciente(pacientews.getDocpaciente());
        paciente.setFecnacpaciente(pacientews.getFecnacpaciente());
        paciente.setEmailpaciente(pacientews.getEmailpaciente());
        return paciente;
    }

    public Pacientews convertPacienteToPacienteWs(Paciente paciente){
        Pacientews pacientews = new Pacientews();
        pacientews.setIdpaciente(paciente.getIdpaciente());
        pacientews.setNompaciente(paciente.getNompaciente());
        pacientews.setApepaciente(paciente.getApepaciente());
        pacientews.setDocpaciente(paciente.getDocpaciente());
        pacientews.setFecnacpaciente(paciente.getFecnacpaciente());
        pacientews.setEmailpaciente(paciente.getEmailpaciente());
        return pacientews;
    }

    //Semana 3
    //Metodo que devuelve lista de pacientes
    public List<Paciente>convertPacienteWsToPaciente(List<Pacientews>pacientewsList){
        List<Paciente>pacienteList = new ArrayList<>();
            for (Pacientews pacientews: pacientewsList){
                pacienteList.add(convertPacienteWsToPaciente(pacientews));
            }
            return pacienteList;
    }
    //Metodo que devuelve arreglo
    public List<Pacientews>convertPacienteToPacientews(List<Paciente>pacienteList){
        List<Pacientews>pacientewsList = new ArrayList<>();
        for (Paciente paciente: pacienteList){
            pacientewsList.add(convertPacienteToPacienteWs(paciente));
        }
        return pacientewsList;
    }








}
