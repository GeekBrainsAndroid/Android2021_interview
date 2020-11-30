package ru.geekbrains.dip

import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.io.StringWriter
import java.io.Writer

class PersisterXml {
    fun convert(user: User): String{
        val serializer: Serializer = Persister()
        val writer: Writer = StringWriter()
        serializer.write(user, writer)
        return writer.toString()
    }
}