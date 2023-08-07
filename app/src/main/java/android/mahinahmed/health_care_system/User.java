package android.mahinahmed.health_care_system;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String doctorName;
    private long appointmentDate;
    private String password;

    public User(String doctorName, long appointmentDate, String password) {
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.password = password;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public long getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(long appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(appointmentDate);
        String dateString = sdf.format(date);

        return "Doctor: " + doctorName + " - Date: " + dateString;
    }

    public void setId(int anInt) {
    }
}
