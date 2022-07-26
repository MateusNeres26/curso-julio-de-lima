package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.ref.WeakReference;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }
    public LoginPage informarASenha(String senha){
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListaDeProdutosPage submeterFormulariodeLogin(){
        navegador.findElement(By.name("action")).click();

    return new ListaDeProdutosPage(navegador);
    }

}
