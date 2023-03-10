
        /*
         * Copyright 2016 Google LLC
         *
         * Licensed under the Apache License, Version 2.0 (the "License");
         * you may not use this file except in compliance with the License.
         * You may obtain a copy of the License at
         *
         * http://www.apache.org/licenses/LICENSE-2.0
         *
         * Unless required by applicable law or agreed to in writing, software
         * distributed under the License is distributed on an "AS IS" BASIS,
         * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
         * See the License for the specific language governing permissions and
         * limitations under the License.
         */

        package com.lbg.pubsubdemo;

// [START pubsub_quickstart_publisher]
// [START pubsub_publish]

        import com.google.api.core.ApiFuture;
        import com.google.cloud.pubsub.v1.Publisher;
        import com.google.protobuf.ByteString;
        import com.google.pubsub.v1.PubsubMessage;
        import com.google.pubsub.v1.TopicName;

        import java.io.IOException;
        import java.util.concurrent.ExecutionException;
        import java.util.concurrent.TimeUnit;

public class PublisherExample {
    public static void main(String... args) throws Exception {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "ddmn01-rskcda-bld-01-997c";
        String topicId = "dmn01-rsk-bld-01-psb-euwe2-csp-ds-load-staging";

        publisherExample(projectId, topicId);
    }

    public static void publisherExample(String projectId, String topicId)
            throws IOException, ExecutionException, InterruptedException {
        TopicName topicName = TopicName.of(projectId, topicId);

        Publisher publisher = null;
        try {
            // Create a publisher instance with default settings bound to the topic
            publisher = Publisher.newBuilder(topicName).build();

            String message = "Hello World!";
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            System.out.println("Published message ID: " + messageId);
        } finally {
            if (publisher != null) {
                // When finished with the publisher, shutdown to free up resources.
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }
}
