package med.voll.api.medico;

public record DadosListagemMedico(Long id,
                                  String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade) {

    // Como precisamos transformar a entidade que a o repositorio devolve num DTO de devolução, usamos um construtor dentro do DTO
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }


}
