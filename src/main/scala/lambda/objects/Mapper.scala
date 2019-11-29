package lambda.objects

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.{DefaultScalaModule, ScalaObjectMapper}
import java.util.{Map => JMap}

import scala.jdk.CollectionConverters._

object Mapper {
    val objectMapper = new ObjectMapper() with ScalaObjectMapper
        objectMapper.registerModule(DefaultScalaModule)

    def map[T : Manifest](details: JMap[String, AnyRef]): T = {
        val jsonStr = objectMapper.writeValueAsString(details.asScala)
        objectMapper.readValue[T](jsonStr)
    }

    def toJson[T : Manifest](obj: T): String = {
        objectMapper.writeValueAsString(obj)
    }
}
