package med.buriti.api.domain.dto.paciente;

import med.buriti.api.domain.model.Endereco;
import med.buriti.api.domain.model.Paciente;

public record DadosDetalhamentoPaciente(String nome, String email, String telefone, String cpf, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
