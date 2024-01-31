package med.buriti.api.domain.dto.consulta;

// Trecho de código suprimido

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.enums.EspecialidadeEnum;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultaDTO(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data,

        EspecialidadeEnum especialidade) {
}
