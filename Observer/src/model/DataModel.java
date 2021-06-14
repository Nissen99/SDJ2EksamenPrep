package model;

import util.PropertyChangeSubject;

public interface DataModel extends PropertyChangeSubject
{

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();
}
