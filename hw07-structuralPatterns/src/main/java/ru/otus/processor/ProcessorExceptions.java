package ru.otus.processor;

import ru.otus.model.Message;

import java.time.LocalDateTime;

public class ProcessorExceptions implements Processor {

    @Override
    public Message process(Message message) {
        int seconds = LocalDateTime.now().getSecond();
        if (seconds % 2 == 0) {
            throw new ProcessorException("ProcessorException");
        }
        return message;
    }

    public static class ProcessorException extends RuntimeException {
        public ProcessorException(String message) {
            super(message);
        }
    }

}
