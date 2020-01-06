package com.example.demo.slack.webhook;

public class Example {
	public static void main(String[] args) {
	      SlackMessage slackMessage = new SlackMessage("pritam.dewan","just testing");
	      SlackUtils.sendMessage(slackMessage);
	    }
}
