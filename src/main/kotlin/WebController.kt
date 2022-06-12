import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.layout.FlowPane
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import java.io.File
import java.net.URL
import org.json.JSONArray
import org.json.JSONObject

class WebController {
    @FXML lateinit var button1: Button // кнопка из интерфейса
    @FXML lateinit var webView: WebView
    @FXML lateinit var flowPaneWithButtons: FlowPane
    var pagesNumbersMap = mapOf<String, String>("1" to "HTML/index1.html", "2" to "HTML/floppy8.html")
    fun initialize() { //ф-ия, срабатывающая при загрузке интерфейса,
//ассоциированного с этим контроллером
//        val webEngine = webView.getEngine()
//        val file = File(String(getClass().getResource("RateCalculatorHelp.html")))
        webView.getEngine().loadContent("<html>hello, world</html>", "text/html");
        var engine = WebEngine()
        val url: URL = this.javaClass.getResource("HTML/index1.html")
        val url2: URL = this.javaClass.getResource("HTML/floppy8.html")
        webView.zoom = 1.5
        engine = webView.getEngine()
        engine.javaScriptEnabledProperty().set(true)
        engine.load(url2.toString())
        println("js = ${engine.isJavaScriptEnabled}")
//        configureArduinoConnect(engine, pagesNumbersMap)
        println("Controller working")
        button1.setOnAction { //обработчик нажатия кнопки
            println("Button clicked!")
            engine.load(URL("https://www.nvsu.ru").toString())
           // engine.executeScript("includeHTML()");
//            engine.executeScript("clickFunc()")
        }
    }

    //todo сделать загрузку объектов из settings.json в 2 хешмапа
    fun fromFileToJSON(dataName: String): JSONObject { //метод для чтения из файла в json-объект
        val str =  File("settings.json").readText(Charsets.UTF_8)
        // println("file data = $str")
        return JSONObject(str)
    }
}