package com.stg.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MySerializer extends StdSerializer<User> {

	public MySerializer() {
		this(null);
	}

	protected MySerializer(Class<User> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(User value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub

	}

}
