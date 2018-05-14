package com.google.android.gms.samples.vision.barcodereader;

import android.os.Parcel;
import android.os.Parcelable;

public class DLPersonData implements Parcelable {

    private String firstName;// DAC 6
    private String lastName;//DCS 5
    private String address;//DAG 13
    private String city;// DAI 14
    private String state;//DAJ 15
    private String country;//DCG 19
    private String dlNo;//DCQ 17

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDlNo() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo = dlNo;
    }

    public DLPersonData() {
    }

    protected DLPersonData(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        address = in.readString();
        city = in.readString();
        state = in.readString();
        country = in.readString();
        dlNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(country);
        dest.writeString(dlNo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DLPersonData> CREATOR = new Creator<DLPersonData>() {
        @Override
        public DLPersonData createFromParcel(Parcel in) {
            return new DLPersonData(in);
        }

        @Override
        public DLPersonData[] newArray(int size) {
            return new DLPersonData[size];
        }
    };

    public DLPersonData getDLDataFromString(String dlRawData){
        String[] lines = dlRawData.split("\\r?\\n");
        DLPersonData dlPersonData = new DLPersonData();
        dlPersonData.setAddress(lines[13].replace("DAG",""));
        dlPersonData.setCity(lines[14].replace("DAI",""));
        dlPersonData.setCountry(lines[19].replace("DCG",""));
        dlPersonData.setDlNo(lines[17].replace("DAQ",""));
        dlPersonData.setFirstName(lines[6].replace("DAC",""));
        dlPersonData.setLastName(lines[5].replace("DCS",""));
        dlPersonData.setState(lines[15].replace("DAJ",""));
        return dlPersonData;
    }

    @Override
    public String toString() {
        return "DLPersonData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", dlNo='" + dlNo + '\'' +
                '}';
    }
}
