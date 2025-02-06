package med.voll.api.medico;

public enum Especialidade {


    ORTOPEDIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    DERMATOLOGIA;




// Tentar receber de uma forma e transformar em outra

//    ORTOPEDIA("ortopedia"),
//    CARDIOLOGIA("cardiologia"),
//    GINECOLOGIA( "ginecologia"),
//    DERMATOLOGIA("dermatologia");

//    private String especialidadeAPI;
//
//    Especialidade(String especialidadeAPI) {
//        this.especialidadeAPI = especialidadeAPI;
//    }

//    public static Especialidade fromString(String text) {
//        for (Especialidade categoria : Especialidade.values()) {
//            if (categoria.especialidadeAPI.equalsIgnoreCase(text)) {
//                return categoria;
//            }
//        }
//        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
//    }

}
