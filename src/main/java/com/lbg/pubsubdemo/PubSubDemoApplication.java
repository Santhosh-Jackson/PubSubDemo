package com.lbg.pubsubdemo;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminSettings;
import com.google.pubsub.v1.TopicName;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.IOException;

@SpringBootApplication
public class PubSubDemoApplication {

    private static final Log LOGGER = LogFactory.getLog(PubSubDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PubSubDemoApplication.class, args);


//        String hostport = "localhost:8080";
//        ManagedChannel channel = ManagedChannelBuilder.forTarget(hostport).usePlaintext().build();
//        try {
//            TransportChannelProvider channelProvider =
//                    FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
//            CredentialsProvider credentialsProvider = NoCredentialsProvider.create();
//
//            // Set the channel and credentials provider when creating a `TopicAdminClient`.
//            // Similarly for SubscriptionAdminClient
//            TopicAdminClient topicClient =
//                    TopicAdminClient.create(
//                            TopicAdminSettings.newBuilder()
//                                    .setTransportChannelProvider(channelProvider)
//                                    .setCredentialsProvider(credentialsProvider)
//                                    .build());
//
//            TopicName topicName = TopicName.of("my-project-id", "my-topic-id");
//            // Set the channel and credentials provider when creating a `Publisher`.
//            // Similarly for Subscriber
//            Publisher publisher =
//                    Publisher.newBuilder(topicName)
//                            .setChannelProvider(channelProvider)
//                            .setCredentialsProvider(credentialsProvider)
//                            .build();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            channel.shutdown();
//        }

    }
//




}
