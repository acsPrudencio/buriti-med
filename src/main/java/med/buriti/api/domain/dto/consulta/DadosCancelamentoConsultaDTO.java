package med.buriti.api.domain.dto.consulta;

import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.enums.MotivoCancelamento;

public record DadosCancelamentoConsultaDTO(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamento motivo
) {
}
