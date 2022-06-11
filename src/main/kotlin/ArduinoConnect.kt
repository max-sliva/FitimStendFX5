import javafx.application.Platform
import javafx.scene.web.WebEngine
import jssc.SerialPort
import jssc.SerialPortList
import java.net.URL
import kotlin.system.exitProcess

fun configureArduinoConnect(engine: WebEngine, pagesNumbersMap: Map<String, String>) {
    var serialPort: SerialPort?
    for (port in SerialPortList.getPortNames()) {
        println(port)
        serialPort = SerialPort(port)
        serialPort.openPort()
        serialPort.setParams(9600, 8, 1, 0)
        serialPort.addEventListener{
            if (it.isRXCHAR()) {// если есть данные для приема
                var str = serialPort.readString()
//убираем лишние символы (типа пробелов, которые могут быть в принятой строке)
                str = str.trim();
                println(str) //выводим принятую строку
                Platform.runLater{
                    val url: URL = Main.javaClass.getResource(pagesNumbersMap.get(str))
                    engine.load(url.toString())

                }
            }
        }
    }
}

