package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.DataModel;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TimestampViewModel implements PropertyChangeListener

{

    private StringProperty updateTimeStamp;
    private StringProperty numberOfUpdates;
    private DataModel model;


    public TimestampViewModel(DataModel model) {
        this.model = model;
        model.addPropertyChangeListener(this);
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("0");
    }

    public void updateTimestamp() {
        model.increaseNumberOfUpdates();
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
        numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(() -> updateTimestamp());

    }


}
