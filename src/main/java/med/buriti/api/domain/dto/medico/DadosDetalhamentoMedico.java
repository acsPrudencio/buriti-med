package med.buriti.api.domain.dto.medico;

import med.buriti.api.domain.enums.EspecialidadeEnum;
import med.buriti.api.domain.model.Endereco;
import med.buriti.api.domain.model.Medico;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        EspecialidadeEnum especialidade,
        Endereco endereco) {
    public DadosDetalhamentoMedico (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());

    }
}
