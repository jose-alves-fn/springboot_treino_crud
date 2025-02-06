package med.voll.api.paciente;

public record DadosListagemPaciente(String nome,
                                    String email,
                                    String cpf,
                                    String telefone) {

        // Como precisamos transformar a entidade que a o repositorio devolve num DTO de devolução, usamos um construtor dentro do DTO
        public DadosListagemPaciente(Paciente paciente) {
            this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
        }

}
