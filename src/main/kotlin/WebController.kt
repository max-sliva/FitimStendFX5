import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import java.io.File

class WebController {
    @FXML lateinit var button1: Button // кнопка из интерфейса
    @FXML lateinit var webView: WebView
    fun initialize() { //ф-ия, срабатывающая при загрузке интерфейса,
//ассоциированного с этим контроллером
//        val webEngine = webView.getEngine()
//        val file = File(String(getClass().getResource("RateCalculatorHelp.html")))
        webView.getEngine().loadContent("<html>hello, world</html>", "text/html");
        var engine = WebEngine()
        engine = webView.getEngine();
        engine.load("file:///F:/KtlnProjects/FitimStendFX5/src/main/kotlin/index.html");

        println("Controller working")
        button1.setOnAction { //обработчик нажатия кнопки
            println("Button clicked!")
        }
    }
}