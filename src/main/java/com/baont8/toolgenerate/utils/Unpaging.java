package com.baont8.toolgenerate.utils;

import java.util.Collection;

public class Unpaging<T> {
    private final Collection<T> content;

    public Unpaging(Collection<T> content) {
        this.content = content;
    }

	public Collection<T> getContent() {
		return content;
	}

}
