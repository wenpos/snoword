package common.module;

import com.google.inject.AbstractModule;
import moninitor.EsClusterStateCheck;
import moninitor.impl.EsClusterStateCheckImpl;

/**
 * Created by YQF on 2016/11/29.
 */
public class SnowordModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EsClusterStateCheck.class).to(EsClusterStateCheckImpl.class);
    }
}
