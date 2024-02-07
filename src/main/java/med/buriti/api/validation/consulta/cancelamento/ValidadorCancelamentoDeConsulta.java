package med.buriti.api.validation.consulta.cancelamento;

import med.buriti.api.domain.dto.consulta.DadosCancelamentoConsultaDTO;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsultaDTO dados);

}
