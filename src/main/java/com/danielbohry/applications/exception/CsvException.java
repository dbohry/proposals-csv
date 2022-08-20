package com.danielbohry.applications.exception;

public class CsvException extends RuntimeException {

  public CsvException(String message) {
    super(message);
  }

  public CsvException(String message, Exception reason) {
    super(message + ((reason == null)
        ? ""
        : " (" + reason + ")"));
  }

}
