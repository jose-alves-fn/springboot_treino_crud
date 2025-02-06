package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

// Validações via anotação do validation
// NotNull quando o campo não puder ser nulo mas poder ficar vazio, usado tbm quando não for string
// NotBlank não pode ser nulo e nem ficar vazio, usado para tipos string
public record DadosCadastroMedico(@NotBlank String nome,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  String telefone,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,6}")
                                  String crm,
                                  @NotNull
                                  Especialidade especialidade,
                                  @NotNull
                                  @Valid
                                  DadosEndereco endereco) {
}
