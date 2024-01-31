package med.buriti.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MotivoCancelamento {
    PACIENTE_DESISTIU("Paciente desistiu"),
    MEDICO_CANCELOU("Médico cancelou"),
    OUTROS("Outros");

    final String descricao;
}
