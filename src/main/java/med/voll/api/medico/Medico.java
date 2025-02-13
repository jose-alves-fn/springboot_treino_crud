package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Entity(name = "Medico")
@Table(name = "medicos")

// Utilizando o Lombok para evitar a digitação de getters, seters, contructors, tostring...
@Getter
@NoArgsConstructor // para construtores padrão -> uma exigência da JPA
@AllArgsConstructor // para um construtor que recebe todos os campos
@EqualsAndHashCode(of = "id") // lombok gera um comparador equal e um código hash (um valor numérico) que representa o objeto

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    // Ao usar a anotação @Embedded, significa que se está incorporando uma classe (Endereco) como parte da entidade que a contém.
    // Não será criada uma nova tabela, uma vez que ela será verificada como parte da entidade original.
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
