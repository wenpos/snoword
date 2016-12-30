package client;


import com.google.inject.Inject;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.plugins.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

public class ClientFactory {

    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(ClientFactory.class);
    }

    private String  esIp="10.63.240.211";
    private static Client client;



    public  Client getClient() {
        if (client != null)
            return client;

        Settings settings = Settings.builder()
                .put("cluster.name", "elastic-debug").put("network.host", esIp).put("node.name", "debug-cli").build();
        try {
            client = TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(""), 9300));
        } catch (UnknownHostException e) {
            LOGGER.error("Can't connect es server" + e);
        }
        return client;
    }

}
