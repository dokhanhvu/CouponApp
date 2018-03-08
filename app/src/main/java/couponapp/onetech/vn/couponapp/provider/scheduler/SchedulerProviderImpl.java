package couponapp.onetech.vn.couponapp.provider.scheduler;

import javax.inject.Inject;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by igneel on 3/7/2018.
 */

public class SchedulerProviderImpl implements SchedulerProvider{

    @Inject
    public SchedulerProviderImpl() {
    }

    @Override
    public <T> ObservableTransformer<T, T> observableIOScheduler() {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public <T> ObservableTransformer<T, T> observableComputationScheduler() {
        return upstream -> upstream
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
