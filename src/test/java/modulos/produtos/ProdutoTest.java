package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes WEB do Modulo de Produtos")
public class ProdutoTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Vou maximizar a tela
        this.navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrão de 5 segundos

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }





    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComvalorIgualAZero(){
        //Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                    .informarASenha("admin")
                        .submeterFormulariodeLogin()
                            .acessarFormularioAdicaoNovoProduto()
                                .informarNomeDoProduto("Macbook Pro")
                                    .informarValorDoProduto("000")
                                        .informarCoresDoProduto("Preto, Branco")
                                            .submeterFormularioDeAdicaoComErro()
                                                .capturarMensagemApresentada();


        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Nao é permitido registrar um produto com valor acima de 7000")
    public void testNaoEPermitidoRegistrarProdutoComValorAcimaDe7000(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormulariodeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Play Station 5")
                .informarValorDoProduto("800000")
                .informarCoresDoProduto("Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na no limite de 0,010")
    public void testPossoAdicionarProdutosComValorDeUmCentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormulariodeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("001")
                .informarCoresDoProduto("Preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam no valor de 7000")
    public void testPossoAdicionarProdutosComValorDeSeteMilReais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormulariodeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Moto")
                .informarValorDoProduto("700000")
                .informarCoresDoProduto("Vermelho Sangue")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }


    @AfterEach
    public void afterEach(){
        navegador.quit();
    }


}
