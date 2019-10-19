package com.brandapp.model;

import androidx.lifecycle.MutableLiveData;

public class FetchDataTask extends
        TaskExecutor<FetchDataTask.RequestValues, FetchDataTask.ResponseValue> {

    void setRequestValue(RequestValues requestValue) {
        setRequestValues(requestValue);
    }

    void setCallback(UseCaseCallback<ResponseValue> useCaseCallback) {
        setUseCaseCallback(useCaseCallback);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        String result = "" + requestValues.getRequestValue();
        if ("1".equals(result)) {
            getUseCaseCallback().onSuccess(new ResponseValue("Hello " + result));
        } else {
            result += " Prasanna";
            getUseCaseCallback().onSuccess(new ResponseValue(result));
        }
    }

    static final class RequestValues implements TaskExecutor.RequestValues {
        private String mRequest;

        RequestValues(String result) {
            mRequest = result;
        }

        String getRequestValue() {
            return mRequest;
        }
    }

    class ResponseValue implements TaskExecutor.ResponseValue {
        private MutableLiveData<String> mResult = new MutableLiveData<>();
        private MutableLiveData<Integer> mResultInt = new MutableLiveData<>();

        ResponseValue(String result) {
            mResult.postValue(result);
        }

        ResponseValue(Integer result) {
            mResultInt.postValue(result);
        }

        MutableLiveData<String> getResult() {
            return mResult;
        }

        MutableLiveData<Integer> getIntResult() {
            return mResultInt;
        }
    }
}
