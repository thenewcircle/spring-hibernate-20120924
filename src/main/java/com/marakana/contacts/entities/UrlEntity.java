package com.marakana.contacts.entities;

public class UrlEntity extends BaseEntity {

	public String getUrl() {
		return getClass().getSimpleName().toLowerCase() + "?id=" + getId();
	}

}
