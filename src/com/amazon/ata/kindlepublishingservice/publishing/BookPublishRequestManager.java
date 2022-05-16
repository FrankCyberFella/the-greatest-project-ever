package com.amazon.ata.kindlepublishingservice.publishing;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.Queue;

public class BookPublishRequestManager {

    private Queue<BookPublishRequest> bookPublishRequests;

    @Inject
    public BookPublishRequestManager() {
        this.bookPublishRequests = new LinkedList<>();
    }

    public void addBookPublishRequest(BookPublishRequest bookPublishRequest) {
        bookPublishRequests.add(bookPublishRequest);
    }

    public BookPublishRequest getBookPublishRequestToProcess() {
        return bookPublishRequests.poll();
    }

}
