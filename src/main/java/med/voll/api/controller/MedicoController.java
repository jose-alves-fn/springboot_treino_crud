package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repositorio;

    @PostMapping
    @Transactional // Precisa dessa anotação por conta de um método de escrita
    // Será preciso pegar o DTO e passar os dados para um objeto Medico
    // Esse preocsso em parte vai ser realizado na Clsse Medico

    // @RequestBody: foco no corpo da requisição
    // @Valid: aciona as validações presentes no DTO, caso alguma falhe será exibido um erro
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repositorio.save(new Medico(dados));
    }

    // Para cada elemento passado pelo findAll do repositório, vamos mapear para dentro de um novo objeto DTO.
    // Ao final devolveremos uma lista com somente os objetos encontrados.
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) { // O page já tem .map
        return repositorio.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repositorio.getReferenceById(dados.id()); // Achar o elemento médico pelo Id que chega na requisição
        medico.atualizarInformacoes(dados); // Usilizar método da Classe médico para atualizar os campos
    }

    // Exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
//         repositorio.deleteById(id);
        var medico = repositorio.getReferenceById(id);
        medico.excluir();
    }


}
