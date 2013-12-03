package net.sareweb.android.keeper.rest;

import net.sareweb.android.keeper.model.SystemInfo;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;


@Rest(rootUrl = "http://keeper.sareweb.net:3000", converters = GsonHttpMessageConverter.class)
public interface SystemInfoClient {
	
	 @Get("/system_info.json")
	 public abstract SystemInfo getSystemInfo();

}
