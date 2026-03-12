package org.example.Calendar.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class InfoCalendarResponse {
    private List<LocalTime> monday;
    private List<LocalTime> tuesday;
    private List<LocalTime> wednesday;
    private List<LocalTime> thursday;
    private List<LocalTime> friday;
    private List<LocalTime> saturday;
    private List<LocalTime> sunday;

    public void setMonday(List<LocalTime> monday) {
        this.monday = monday;

    }
    public void setTuesday(List<LocalTime> tuesday) {
        this.tuesday = tuesday;

    }
    public void setWednesday(List<LocalTime> wednesday) {
        this.wednesday = wednesday;

    }
    public void setThursday(List<LocalTime> thursday) {
        this.thursday = thursday;

    }
    public void setFriday(List<LocalTime> friday) {
        this.friday = friday;

    }
    public void setSaturday(List<LocalTime> saturday) {
        this.saturday = saturday;

    }
    public void setSunday(List<LocalTime> sunday) {
        this.sunday = sunday;

    }
}
