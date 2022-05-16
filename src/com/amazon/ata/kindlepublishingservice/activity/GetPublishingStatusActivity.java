package com.amazon.ata.kindlepublishingservice.activity;

import com.amazon.ata.kindlepublishingservice.converters.PublishingStatusItemConverter;
import com.amazon.ata.kindlepublishingservice.dao.PublishingStatusDao;
import com.amazon.ata.kindlepublishingservice.dynamodb.models.PublishingStatusItem;
import com.amazon.ata.kindlepublishingservice.exceptions.PublishingStatusNotFoundException;
import com.amazon.ata.kindlepublishingservice.models.PublishingStatusRecord;
import com.amazon.ata.kindlepublishingservice.models.requests.GetPublishingStatusRequest;
import com.amazon.ata.kindlepublishingservice.models.response.GetPublishingStatusResponse;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.lambda.runtime.Context;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetPublishingStatusActivity {

    private PublishingStatusDao publishingStatusDao;

    @Inject
    public GetPublishingStatusActivity(PublishingStatusDao publishingStatusDao) {
        this.publishingStatusDao = publishingStatusDao;
    }

    public GetPublishingStatusResponse execute(GetPublishingStatusRequest publishingStatusRequest) {

        List<PublishingStatusItem> publishingStatusItemList = new ArrayList<>();

        try{ publishingStatusItemList = publishingStatusDao.getPublishingStatuses(publishingStatusRequest.getPublishingRecordId());
        } catch (PublishingStatusNotFoundException e) {
            throw e ;
        }

        List<PublishingStatusRecord> publishingStatusRecords = new ArrayList<>();

        for (PublishingStatusItem item: publishingStatusItemList) {
            publishingStatusRecords.add(PublishingStatusItemConverter.toPublishingStatusRecord(item));
        }


        return new GetPublishingStatusResponse(publishingStatusRecords);

    }
}
