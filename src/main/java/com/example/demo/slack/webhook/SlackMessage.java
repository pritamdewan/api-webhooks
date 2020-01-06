package com.example.demo.slack.webhook;

import java.io.Serializable;

public class SlackMessage implements Serializable {
 
	public SlackMessage() {
		
	}
	public SlackMessage(String user,String msg) {
		this.username = user;
		this.text = msg;
		
	}
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon_emoji() {
		return icon_emoji;
	}
	public void setIcon_emoji(String icon_emoji) {
		this.icon_emoji = icon_emoji;
	}
	private String username;
    private String text;
    private String icon_emoji=":twice:";
  }