package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel {

    private String lastUpdate;
    private int numberOfUpdates;

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public DataModelManager() {
        System.out.println("Ny DataModel");
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void increaseNumberOfUpdates() {
        numberOfUpdates++;
    }

    @Override
    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    public void recalculateData() {
        calcTimeStamp();
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);

        changeSupport.firePropertyChange("Update", lastUpdate, strDate);


        lastUpdate = strDate;
    }

    @Override public void addPropertyChangeListener(
        PropertyChangeListener listener)
    {
     changeSupport.addPropertyChangeListener(listener);
    }

    @Override public void removePropertyChangeListener(
        PropertyChangeListener listener)
    {
    changeSupport.removePropertyChangeListener(listener);
    }
}
