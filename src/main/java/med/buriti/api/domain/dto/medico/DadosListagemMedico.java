package med.buriti.api.domain.dto.medico;

import med.buriti.api.domain.enums.EspecialidadeEnum;
import med.buriti.api.domain.model.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade
)
{
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
