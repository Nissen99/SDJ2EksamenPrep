package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.DataModel;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
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
}
