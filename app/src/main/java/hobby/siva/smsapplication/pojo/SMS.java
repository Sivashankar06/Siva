package hobby.siva.smsapplication.pojo;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 13/03/19
 */
public class SMS {

    private String sender;
    private String messageBody;
    private String time;

    public SMS(String sender, String messageBody, String time) {
        this.sender = sender;
        this.messageBody = messageBody;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public long getTime() {
        return Long.parseLong(time);
    }
}