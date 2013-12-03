package net.sareweb.android.keeper.model;

import java.util.Date;
import java.util.List;

public class SystemInfo {

	private String info_date;
	private List<Image> images;

	public String getInfo_date() {
		return info_date;
	}

	public void setInfo_date(String info_date) {
		this.info_date = info_date;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
