package moninitor.impl;

import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import com.google.inject.Inject;
import moninitor.EsClusterStateCheck;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.ClusterService;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.cluster.service.InternalClusterService;

/**
 * Created by YQF on 2016/11/29.
 */
public class EsClusterStateCheckImpl implements EsClusterStateCheck {

    private  final Client clusterService;

    @Inject
    public EsClusterStateCheckImpl(Client clusterService) {
        this.clusterService = clusterService;
    }


    @Override
    public void available(Client client) {
        client.admin().cluster().prepareClusterStats().execute(new ActionListener<ClusterStatsResponse>() {
            @Override
            public void onResponse(ClusterStatsResponse clusterStatsNodeResponses) {
                // TODO: 2016/11/29 是否可以这样实现，响应去往何处？
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }
}
