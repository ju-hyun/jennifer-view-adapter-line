package com.aries.line;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.aries.extension.data.EventData;
import com.aries.extension.handler.EventHandler;
import com.aries.extension.util.LogUtil;

import com.aries.line.entity.LineProp;
import com.aries.line.util.ConfUtil;
import com.aries.line.util.LineClient;

public class LineAdapter implements EventHandler{

    /**
	 * Format the date and time
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private final Map<String, Integer> EVENT_LEVEL = Map.of(
		"NORMAL", 1,
		"ERROR", 2,
		"FATAL", 3
	);

	public void on(EventData[] eventData) {

		LineProp lineProperties = ConfUtil.getProperties();

		for (EventData event : eventData) {
			if ( EVENT_LEVEL.get(event.eventLevel) >= EVENT_LEVEL.get(lineProperties.getEventLevel()) ) {
				String message = getBody(event);
				String pretext = getPreText(event);

				String result = new LineClient(lineProperties, message, pretext).push().trim();
				if(!result.trim().equalsIgnoreCase("ok"))
					LogUtil.error("Failed to push message to Line");
			}
		}
	}

    private String getBody(EventData event) {
        StringBuilder messageBody = new StringBuilder();
		messageBody.append(String.format("Domain ID: %d%n", event.domainId));
		messageBody.append(String.format("Domain Name: %s%n", event.domainName));
		messageBody.append(String.format("Instance Name: %s%n", event.instanceName));
		messageBody.append(String.format("Transaction ID: %d%n", event.txid));
		messageBody.append(String.format("Service Name: %s%n", event.serviceName));
		messageBody.append(String.format("Error Type: %s%n", event.errorType));
		messageBody.append(String.format("Error Level: %s%n", event.eventLevel));
		messageBody.append(String.format("Error Time: %s%n", sdf.format(new Date(event.time))));
		return messageBody.toString();
    }

    private String getPreText(EventData event) {
		StringBuilder pretext = new StringBuilder();
		pretext.append(String.format("The following event [%s] was caught by JENNIFER. %n",  event.errorType));
		pretext.append("Here are some additional details\n");
		return pretext.toString();
	}

    public static void main(String[] args) {
		EventData event = new EventData((short) 1004, new ArrayList<String>(), "제니퍼", System.currentTimeMillis(), 1000, "Groupware", "", "SERVICE_EXCEPTION", "", "FATAL", "", -1, "SYSTEM", "", "/service.jsp", -123123123, "", null);
		new LineAdapter()._on(new EventData[] { event });
	}

	public void _on(EventData[] eventData) {

		LineProp lineProperties = ConfUtil._getProperties();

		for (EventData event : eventData) {
			String message = getBody(event);
			String pretext = getPreText(event);

			String result = new LineClient(lineProperties, message, pretext).push().trim();
			if(!result.trim().equalsIgnoreCase("ok"))
				LogUtil.error("Failed to push message to Line");
		}
	}
}
