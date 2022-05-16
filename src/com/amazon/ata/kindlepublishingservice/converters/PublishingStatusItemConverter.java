package com.amazon.ata.kindlepublishingservice.converters;

import com.amazon.ata.kindlepublishingservice.dynamodb.models.PublishingStatusItem;
import com.amazon.ata.kindlepublishingservice.models.PublishingStatusRecord;

public class PublishingStatusItemConverter {

    private PublishingStatusItemConverter() {}

    public static PublishingStatusRecord toPublishingStatusRecord(PublishingStatusItem item) {
        return PublishingStatusRecord.builder()
                .withStatus(item.getStatus().toString())
                .withBookId(item.getBookId())
                .withStatusMessage(item.getStatusMessage())
                .build();
    }

}
