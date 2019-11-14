package lambda

import com.amazonaws.services.lambda.runtime.events.SQSEvent;

object Main extends App {
    val message = "Hello World!"

    // Entry point for development, mock events and have main execute the correct handler.
    main(message)

    def main(message: String): Unit = {
        println(message)
    }

    def handleSQS(event: SQSEvent): Unit = {
        val messages = event.getRecords

        messages forEach { message =>
            println(message.getBody)
        }
    }
}