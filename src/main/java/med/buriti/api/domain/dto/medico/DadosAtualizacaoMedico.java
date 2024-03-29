package med.buriti.api.domain.dto.medico;
import jakarta.validation.constraints.NotNull;
import med.buriti.api.domain.dto.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
    @NotNull
    Long id,
    String nome,
    String telefone,
    DadosEndereco endereco) {
    }
