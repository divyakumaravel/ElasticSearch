package com.elastic.escompensationdemo.structuredLogging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.JsonWritingUtils;

import java.io.IOException;
import java.time.LocalDateTime;


public class StructuredLogProvider extends AbstractFieldJsonProvider<ILoggingEvent> {

    @Override
    public void writeTo(JsonGenerator generator, ILoggingEvent event) throws IOException {

        JsonWritingUtils.writeStringField(generator, "timeStamp", LocalDateTime.now().toString());
        JsonWritingUtils.writeStringField(generator, "level", event.getLevel().toString());
        JsonWritingUtils.writeStringField(generator, "message", event.getFormattedMessage());
        JsonWritingUtils.writeStringField(generator, "threadName", event.getThreadName());
        JsonWritingUtils.writeStringField(generator, "loggerName", event.getLoggerName());
        JsonWritingUtils.writeStringField(generator, "callingFileName", event.getCallerData()[0].getFileName());
        JsonWritingUtils.writeStringField(generator, "callingClass", event.getCallerData()[0].getClassName());
        JsonWritingUtils.writeStringField(generator, "callingMethod", event.getCallerData()[0].getMethodName());
        JsonWritingUtils.writeNumberField(generator, "callingLineNumber", event.getCallerData()[0].getLineNumber());
    }
}
