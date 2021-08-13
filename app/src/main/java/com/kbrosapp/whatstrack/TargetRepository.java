package com.kbrosapp.whatstrack;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TargetRepository {

    private TargetsDao targetsDao;

    public TargetRepository(Application application){
        WhatsDatabase database = WhatsDatabase.getInstance(application);
        targetsDao=database.targetsDao();
    }

    public void insert(Target target){
        new InsertTargetAsyncTask(targetsDao).execute(target);
    }

    public void update(Target target){
        new UpdateTargetAsyncTask(targetsDao).execute(target);
    }

    public void delete(Target target){
        new DeleteTargetAsyncTask(targetsDao).execute(target);
    }

    public LiveData<List<Target>> getAllTargets(){
        LiveData<List<Target>> allTargets=targetsDao.getAllTargets();
        return allTargets;
    }

    public static class InsertTargetAsyncTask extends AsyncTask<Target,Void,Void> {
        private TargetsDao targetsDao;

        private InsertTargetAsyncTask(TargetsDao targetsDao){
            this.targetsDao=targetsDao;
        }

        @Override
        protected Void doInBackground(Target... targets) {
            targetsDao.insert(targets[0]);
            return null;
        }
    }

    public static class UpdateTargetAsyncTask extends AsyncTask<Target,Void,Void> {
        private TargetsDao targetsDao;

        private UpdateTargetAsyncTask(TargetsDao targetsDao){
            this.targetsDao=targetsDao;
        }

        @Override
        protected Void doInBackground(Target... targets) {
            targetsDao.update(targets[0]);
            return null;
        }
    }

    public static class DeleteTargetAsyncTask extends AsyncTask<Target,Void,Void> {
        private TargetsDao targetsDao;

        private DeleteTargetAsyncTask(TargetsDao targetsDao){
            this.targetsDao=targetsDao;
        }

        @Override
        protected Void doInBackground(Target... targets) {
            targetsDao.delete(targets[0]);
            return null;
        }
    }

}
