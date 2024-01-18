package med.buriti.api.domain.dto.paciente;

import jakarta.validation.Valid;
import med.buriti.api.domain.dto.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
