package com.appventurez.project404.common.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

/**
 * Application context aware {@link ViewModel}.
 * <p>
 * Subclasses must have a constructor which accepts {@link Application} as the only parameter.
 * <p>
 */
public class BaseViewModel extends AndroidViewModel {



    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


}
