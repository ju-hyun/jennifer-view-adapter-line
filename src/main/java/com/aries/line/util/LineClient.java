package com.aries.line.util;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.Properties;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import org.json.JSONObject;

import com.aries.line.entity.LineProp;
import com.aries.extension.util.LogUtil;

public class LineClient {
    /**
	 * Default connection time out value
	 */
	private final int CONNECTION_TIME_OUT	= 1000;
	
	/**
	 * Default encoding value
	 */
	private final String ENCODING			= "UTF-8";
	

	public LineClient(LineProp prop, String message, String pretext) {
        this.PROPERTIES = prop;
		this.TOKEN = prop.getLineToken();
        this.MESSAGE = message;
        this.PRETEXT = pretext;
	}

    private LineProp PROPERTIES;
    private String TOKEN;
    private String MESSAGE;
    private String PRETEXT;
    private final String API_URL = "https://notify-api.line.me/api/notify";

    
    public String push() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(API_URL);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setConnectTimeout(CONNECTION_TIME_OUT);
            conn.setRequestProperty("Authorization", "Bearer " + TOKEN);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setUseCaches(false);
			conn.setDoOutput(true);

            String message = String.format("%s%n%s", PRETEXT, MESSAGE);
            // 전송할 데이터 설정
            String payload = "message=" + message + this.setParameters(PROPERTIES);
            byte[] postData = payload.getBytes(ENCODING);

            // 데이터 전송
            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.write(postData);
            os.flush();
            os.close();

            // 응답 코드 확인
			InputStream in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			StringBuilder response = new StringBuilder();
			while ( (line = reader.readLine()) != null )
				response.append(line + "\n");
			
			reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            
            return jsonObject.getString("message");
		} catch(Exception ex){
			LogUtil.error("Error while pushing message. Reason : " + ex);
			return "";
		} finally{
			if(conn != null)
            conn.disconnect();
		}
    }

    private String setParameters(LineProp prop) {
        StringBuilder sb = new StringBuilder();
        if (prop.getStickerPackageId() != "" && prop.getStickerId() != "") {
            sb.append(String.format("&stickerPackageId=%s", prop.getStickerPackageId()));
            sb.append(String.format("&stickerId=%s", prop.getStickerId()));
        }   
        sb.append(String.format("&notificationDisabled=%s", prop.isNotificationDisabled()));

        return sb.toString();
    }
}
