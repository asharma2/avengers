package com.avengers.fc.service;

import java.util.Collection;

import com.avengers.fc.exception.ForecastException;
import com.avengers.fc.model.Data;

public interface ForecastService<D extends Data> {

	/**
	 * The function will process the time series data and calculate the standard
	 * deviation and store in cache
	 * 
	 * @param tsData
	 * @return
	 * @throws ForecastException
	 */
	D predictData(byte[] tsData) throws ForecastException;

	/**
	 * The function will process the time series data and calculate the standard
	 * deviation and store in cache
	 * 
	 * @param tsData
	 * @return
	 * @throws ForecastException
	 */
	D predictData(Collection<D> data) throws ForecastException;
	
	D ping() throws ForecastException;

}
