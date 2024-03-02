package com.talshavit.mylibrary;

import java.util.List;

public class AddCapitalsRequest {
    private List<CapitalInfo> capitals;

    public AddCapitalsRequest() {
    }

    public AddCapitalsRequest(List<CapitalInfo> capitals) {
        this.capitals = capitals;
    }

    public List<CapitalInfo> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<CapitalInfo> capitals) {
        this.capitals = capitals;
    }
}
