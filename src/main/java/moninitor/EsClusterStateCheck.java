package moninitor;

import org.elasticsearch.client.Client;

/**
 * Created by YQF on 2016/11/29.
 */
public interface EsClusterStateCheck {
    public abstract void available(Client client);
}
