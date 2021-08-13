package com.kbrosapp.whatstrack;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TargetViewModel extends AndroidViewModel {

    private TargetRepository repository;


    public TargetViewModel(@NonNull Application application) {
        super(application);
        repository=new TargetRepository(application);
    }

    public void insert(Target target){
        repository.insert(target);
    }

    public void update(Target target){
        repository.update(target);
    }

    public void delete(Target target){
        repository.delete(target);
    }

    public LiveData<List<Target>> getAllTargets(){
        LiveData<List<Target>> allTargets=repository.getAllTargets();
        return allTargets;
    }


}
