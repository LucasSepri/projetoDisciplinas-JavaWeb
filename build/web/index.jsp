<!-- autor: Lucas Sepriano -->
<!DOCTYPE html>
<html>
    <head>
        <title>Página Inicial</title>
        <!-- biblioteca Alpine.js -->
        <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
        <!-- CSS e JavaScript do Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="WEB-INF/header.jspf" />

        <div class="container" x-data="appData()" x-init="loadData()">
            <!-- 
                x-data: Define um componente Alpine.js com os dados e funções.
                x-init: Executa a função 'loadData()' quando o componente é inicializado.
            -->
            <h1 class="mt-5">Dados do Aluno</h1>
            <div id="aluno-data" class="mt-4">
                <p><strong>RA:</strong> <span x-text="ra"></span></p>
                <!-- 
                    x-text: Vincula o conteúdo do elemento ao valor da variável 'ra'.
                    Quando 'ra' é atualizado, o conteúdo do elemento é atualizado automaticamente.
                -->
                <p><strong>Nome:</strong> <span x-text="nome"></span></p>
                <p><strong>Disciplinas Cursadas:</strong></p>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nome da Disciplina</th>
                        </tr>
                    </thead>
                    <tbody>
                    <template x-for="disciplina in disciplinas" :key="disciplina.Codigo">
                        <!-- 
                            x-for: Itera sobre o array 'disciplinas' e cria uma linha da tabela para cada disciplina.
                            :key: Define uma chave única para cada linha da tabela.
                        -->
                        <tr>
                            <td x-text="disciplina.Codigo"></td>
                            <!-- Vincula o conteúdo da célula à propriedade 'Codigo' da disciplina. -->
                            <td x-text="disciplina.Nome"></td>
                            <!-- Vincula o conteúdo da célula à propriedade 'Nome' da disciplina. -->
                        </tr>
                    </template>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- javascript -->
        <jsp:include page="WEB-INF/script.jspf" />
    </body>
</html>
