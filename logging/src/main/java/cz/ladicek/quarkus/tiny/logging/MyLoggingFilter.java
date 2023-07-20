package cz.ladicek.quarkus.tiny.logging;

import io.quarkus.logging.LoggingFilter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

@LoggingFilter(name = "my-filter")
public class MyLoggingFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return !record.getMessage().contains("IGNORE");
    }
}
