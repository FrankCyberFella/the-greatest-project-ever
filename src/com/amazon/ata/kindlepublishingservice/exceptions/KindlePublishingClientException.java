package com.amazon.ata.kindlepublishingservice.exceptions;



public class KindlePublishingClientException extends RuntimeException {
    private static final long serialVersionUID = 3732983249073631046L;

    public KindlePublishingClientException() { super();
    }

    public KindlePublishingClientException(String message) {
        super(message);
    }

    public KindlePublishingClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public KindlePublishingClientException(Throwable cause) {
        super(cause);
    }
}
