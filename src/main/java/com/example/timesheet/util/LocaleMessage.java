package com.example.timesheet.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessage {
	
	@Autowired
	private MessageSource messageSource;
	
	private MessageSourceAccessor messageSourceAccessor;
	
	@PostConstruct
	private void init() {
		messageSourceAccessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
	}
	
	public String get(String code) {
		this.init();
		return messageSourceAccessor.getMessage(code);
	}
}
