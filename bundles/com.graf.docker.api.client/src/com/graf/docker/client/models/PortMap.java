package com.graf.docker.client.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PortMap implements Map<String, List<PortBinding>> {

	private HashMap<String, List<PortBinding>> portBindings = new HashMap<>();

	@Override
	public int size() {
		return portBindings.size();
	}

	@Override
	public boolean isEmpty() {
		return portBindings.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return portBindings.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return portBindings.containsValue(value);
	}

	@Override
	public List<PortBinding> get(Object key) {
		return portBindings.get(key);
	}

	@Override
	public List<PortBinding> put(String key, List<PortBinding> value) {
		return portBindings.put(key, value);
	}

	@Override
	public List<PortBinding> remove(Object key) {
		return portBindings.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends List<PortBinding>> m) {
		portBindings.putAll(m);
	}

	@Override
	public void clear() {
		portBindings.clear();
	}

	@Override
	public Set<String> keySet() {
		return portBindings.keySet();
	}

	@Override
	public Collection<List<PortBinding>> values() {
		return portBindings.values();
	}

	@Override
	public Set<Entry<String, List<PortBinding>>> entrySet() {
		return portBindings.entrySet();
	}
}
