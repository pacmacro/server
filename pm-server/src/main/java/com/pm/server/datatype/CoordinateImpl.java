package com.pm.server.datatype;

public class CoordinateImpl implements Coordinate {

	double latitude;
	double longitude;

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return longitude;
	}

}
