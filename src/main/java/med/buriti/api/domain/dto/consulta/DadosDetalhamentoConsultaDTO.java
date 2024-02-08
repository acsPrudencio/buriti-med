package med.buriti.api.domain.dto.consulta;

import med.buriti.api.domain.model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}