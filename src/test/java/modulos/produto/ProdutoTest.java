package modulos.produto;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do módulo de produto")
public class ProdutoTest {
    @Test
    @DisplayName("Validar os limites proibidos do valor do Produto")
    public void testValidarLimitesProibidosValorProduto() {
        // Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        // port = 8080
        basePath = "/lojinha";

        // Obter o token do usuário admin
        String token = given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "  \"usuarioLogin\": \"admin\",\n" +
                    "  \"usuarioSenha\": \"admin\"\n" +
                    "}")
        .when()
            .post("/v2/login")
        .then()
            .extract()
                .path("data.token");

        // Tebtar inserir um produto com o valor 0.00, validar a mensagem de erro que foi apresentada e se o
        // status code retornado foi 422

        given()
            .contentType(ContentType.JSON)
            .header("token", token)
            .body("{\n" +
                    "  \"produtoNome\": \"Play Station 5\",\n" +
                    "  \"produtoValor\": 0.00,\n" +
                    "  \"produtoCores\": [\n" +
                    "    \"Preto\"\n" +
                    "  ],\n" +
                    "  \"produtoUrlMock\": \"\",\n" +
                    "  \"componentes\": [\n" +
                    "    {\n" +
                    "      \"componenteNome\": \"Controle\",\n" +
                    "      \"componenteQuantidade\": 1\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}")
        .when()
            .post("/v2/produtos")
        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }
}