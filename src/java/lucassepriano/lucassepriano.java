/* autor: Lucas Sepriano */
package lucassepriano;

import java.io.IOException;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lucassepriano.json")
public class lucassepriano extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String ra = "1290482212002";
    private String nome = "Lucas Sepriano";
    private Disciplina[] disciplinas = {
        new Disciplina("HSO003", "Ética e Responsabilidade Profissional"),
        new Disciplina("IBD002", "Banco de Dados"),
        new Disciplina("IES300", "Engenharia de Software III"),
        new Disciplina("ILP007", "Programação Orientada a Objetos"),
        new Disciplina("ILP512", "Linguagem de Programação IV - INTERNET"),
        new Disciplina("ISO200", "Sistemas Operacionais II"),
        new Disciplina("LIN400", "Inglês IV"),
        new Disciplina("TTG001", "Metodologia da Pesquisa Científico-Tecnológica")
    };

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject alunoJSON = Json.createObjectBuilder()
            .add("RA", ra)
            .add("Nome", nome)
            .add("DisciplinasCursadas", getDisciplinasJsonArray())
            .build();

        response.getWriter().write(alunoJSON.toString());
    }

    private JsonArray getDisciplinasJsonArray() {
        JsonArrayBuilder disciplinasArrayBuilder = Json.createArrayBuilder();
        for (Disciplina disciplina : disciplinas) {
            JsonObject disciplinaJSON = Json.createObjectBuilder()
                .add("Codigo", disciplina.getCodigo())
                .add("Nome", disciplina.getNome())
                .build();
            disciplinasArrayBuilder.add(disciplinaJSON);
        }
        return disciplinasArrayBuilder.build();
    }

    private class Disciplina {
        private String codigo;
        private String nome;

        public Disciplina(String codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }
    }
}
