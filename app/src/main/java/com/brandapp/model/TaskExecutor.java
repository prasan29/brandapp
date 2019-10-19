package com.brandapp.model;

/**
 * CLass for TaskExecutor.
 *
 * @param <Q> - RequestValues instance.
 * @param <P> - ResponseValue instance.
 */
public abstract class TaskExecutor<Q extends TaskExecutor.RequestValues,
        P extends TaskExecutor.ResponseValue> implements Runnable {

    private Q mRequestValues;

    private UseCaseCallback<P> mUseCaseCallback;

    /**
     * Method to get the requestValues instance.
     *
     * @return - RequestValues object.
     */
    private Q getRequestValues() {
        return mRequestValues;
    }

    /**
     * Method to set the RequestValues.
     *
     * @param requestValues - RequestValues object.
     */
    void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    /**
     * Method to fetch the UseCaseCallback instance.
     *
     * @return - UseCaseCallback instance.
     */
    UseCaseCallback<P> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    /**
     * Method to set the UseCaseCallback instance.
     * @param useCaseCallback - UseCaseCallback instance.
     */
    void setUseCaseCallback(UseCaseCallback<P> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    /**
     * Method to run the task.
     */
    @Override
    public void run() {
        executeUseCase(getRequestValues());
    }

    protected abstract void executeUseCase(Q requestValues);

    /**
     * Data passed to a request.
     */
    interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    interface ResponseValue {
    }

    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError();
    }
}
