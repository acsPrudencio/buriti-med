package med.buriti.api.service.consulta;

import med.buriti.api.domain.dto.consulta.DadosAgendamentoConsultaDTO;
import med.buriti.api.domain.dto.consulta.DadosCancelamentoConsultaDTO;
import med.buriti.api.domain.model.Consulta;
import med.buriti.api.domain.model.Medico;
import med.buriti.api.repository.ConsultaRepository;
import med.buriti.api.repository.MedicoRepository;
import med.buriti.api.repository.PacienteRepository;
import med.buriti.api.validation.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsultaDTO dados) {

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dados) {
        if (dados.idMedico() != null) {
            Medico medicoReferenceById = medicoRepository.getReferenceById(dados.idMedico());
            if (medicoReferenceById == null)
                throw new ValidacaoException("Id do médico informado não existe!");
            return medicoReferenceById;
        }
        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data())
                .orElseThrow(() -> new ValidacaoException("Não existe médico com a especialidade informada!"));
    }

    public void cancelar(DadosCancelamentoConsultaDTO dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
