package med.buriti.api.domain.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.buriti.api.domain.dto.endereco.DadosEndereco;
import med.buriti.api.domain.enums.EspecialidadeEnum;

public record DadosCadastroMedico (
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EspecialidadeEnum especialidade,
        @NotNull @Valid
        DadosEndereco endereco
) {}
