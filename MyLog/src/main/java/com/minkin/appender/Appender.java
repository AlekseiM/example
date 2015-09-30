package com.minkin.appender;

import com.minkin.Message;

public interface Appender {
	void makeWritten(Message message);

}
