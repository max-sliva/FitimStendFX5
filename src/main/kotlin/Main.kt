import javafx.application.Application
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.WindowEvent

class Main : Application() {
    val layout = "mainWindow.fxml"
    override fun start(primaryStage: Stage?) {
        val fxmlLoader = FXMLLoader(Main::class.java.getResource(layout))
        val scene = Scene(fxmlLoader.load())
        primaryStage?.title = "Hello!"
        primaryStage?.scene = scene
//        primaryStage?.initStyle(StageStyle.UNDECORATED)
        primaryStage?.setMaximized(true)
        primaryStage?.show()
        primaryStage!!.setOnCloseRequest(object : EventHandler<WindowEvent?> {
            override fun handle(t: WindowEvent?) {
                Platform.exit()
                System.exit(0)
            }
        })
    }
    companion object { //специальный объект для запуска проекта в рамках фреймворка JavaFX
        @JvmStatic // его всегда оставляем одинаковым для всех проектов

        fun main(args: Array<String>) {
            launch(Main::class.java) // Main – имя запускного класса
        }
    }
}