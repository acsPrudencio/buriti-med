package med.buriti.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.buriti.api.domain.dto.consulta.DadosAgendamentoConsultaDTO;
import med.buriti.api.domain.dto.consulta.DadosCancelamentoConsultaDTO;
import med.buriti.api.domain.dto.consulta.DadosDetalhamentoConsultaDTO;
import med.buriti.api.service.consulta.AgendaDeConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultasService agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsultaDTO(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsultaDTO dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
