package couponapp.onetech.vn.couponapp.provider.scheduler;

import io.reactivex.ObservableTransformer;

/**
 * Created by igneel on 3/7/2018.
 */

public interface SchedulerProvider {

    <T> ObservableTransformer<T, T> observableIOScheduler();

    <T> ObservableTransformer<T, T> observableComputationScheduler();
}
