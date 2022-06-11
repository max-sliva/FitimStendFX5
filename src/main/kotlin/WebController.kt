import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import java.net.URL

class WebController {
    @FXML lateinit var button1: Button // кнопка из интерфейса
    @FXML lateinit var webView: WebView
    var pagesNumbersMap = mapOf<String, String>("1" to "HTML/index1.html", "2" to "HTML/index2.html")
    fun initialize() { //ф-ия, срабатывающая при загрузке интерфейса,
//ассоциированного с этим контроллером
//        val webEngine = webView.getEngine()
//        val file = File(String(getClass().getResource("RateCalculatorHelp.html")))
        webView.getEngine().loadContent("<html>hello, world</html>", "text/html");
        var engine = WebEngine()
        val url: URL = this.javaClass.getResource("HTML/index1.html")
        webView.zoom = 1.5
        engine = webView.getEngine()
        engine.load(url.toString())
        engine.javaScriptEnabledProperty().set(true)
        configureArduinoConnect(engine, pagesNumbersMap)
        println("Controller working")
        button1.setOnAction { //обработчик нажатия кнопки
            println("Button clicked!")
            engine.load(URL("https://www.nvsu.ru").toString())
        }
    }
}