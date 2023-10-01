package pe.edu.cibertec.CL1.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.CL1.converter.PacienteConverter;
import pe.edu.cibertec.CL1.model.Paciente;
import pe.edu.cibertec.CL1.repository.PacienteRepository;
import pe.edu.cibertec.CL1.service.PacienteService;
import pe.edu.cibertec.ws.objects.*;

import java.util.List;

@Endpoint
public class PacienteEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";


    //Chat
    private final PacienteService pacienteService;

    @Autowired
    public PacienteEndPoint(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public FindPacienteByNompacienteResponse findPacienteByNompaciente(FindPacienteByNompacienteRequest request) {
        FindPacienteByNompacienteResponse response = new FindPacienteByNompacienteResponse();
        String nompaciente = request.getNompaciente();

        // Llamar al servicio de negocio para buscar pacientes por nompaciente
        List<Paciente> pacientes = pacienteService.findByNompaciente(nompaciente);

        // Convertir los objetos Paciente a Pacientews y agregarlos a la respuesta
        for (Paciente paciente : pacientes) {
            pe.edu.cibertec.ws.objects.Pacientews pacientews = new pe.edu.cibertec.ws.objects.Pacientews();
            pacientews.setIdpaciente(paciente.getIdpaciente());
            pacientews.setNompaciente(paciente.getNompaciente());
            pacientews.setApepaciente(paciente.getApepaciente());
            pacientews.setDocpaciente(paciente.getDocpaciente());
            pacientews.setFecnacpaciente(paciente.getFecnacpaciente());
            pacientews.setEmailpaciente(paciente.getEmailpaciente());
            response.getPaciente().add(pacientews);
        }

        return response;
    }
    //Chat


    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteConverter pacienteConverter;

    //GetPacienteResponse  --> devuelve un objeto
    //GetPacientesResponse --> devuelve un arreglo


    //Metodo para mostrar todos los pacientes
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPacientesRequest")
    @ResponsePayload
    public GetPacientesResponse getPacientes(@RequestPayload GetPacientesRequest request){
        GetPacientesResponse response = new GetPacientesResponse();
        List<Pacientews> pacientewsList = pacienteConverter.convertPacienteToPacientews(pacienteRepository.findAll());
        response.getPacientes().addAll(pacientewsList);
        return response;
    }
    //Asi solo el metodo de arriba no sirve de nada, para que se exponga y se pueda usar el
    //protocolo http colocar @PayLoadRoot(namespace="NamespaceUri") y localpart

    //Metodo para buscar x ID min 23 Semana 4
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPacienteRequest")
    @ResponsePayload
    public GetPacienteResponse getPacienteXId(@RequestPayload GetPacienteRequest request){
        GetPacienteResponse response = new GetPacienteResponse();
        Pacientews pacientews = pacienteConverter.convertPacienteToPacienteWs(pacienteRepository.findById(request.getId()).get());
        response.setPaciente(pacientews);
        return response;
    }

    //Metodo Registro
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postPacienteRequest")
    @ResponsePayload
    public PostPacienteResponse postPaciente(@RequestPayload PostPacienteRequest request){
        PostPacienteResponse response = new PostPacienteResponse();
        //Definiendo el objeto Paciente para el .save
        Paciente newPaciente = pacienteConverter.convertPacienteWsToPaciente(request.getPaciente());
        Pacientews newPacientews = pacienteConverter.convertPacienteToPacienteWs(pacienteRepository.save(newPaciente));
        response.setPaciente(newPacientews);
        return response;
    }









}
