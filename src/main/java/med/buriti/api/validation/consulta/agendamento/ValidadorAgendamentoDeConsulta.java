package med.buriti.api.validation.consulta.agendamento;

import med.buriti.api.domain.dto.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsultaDTO dados);
}
