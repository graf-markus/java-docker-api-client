package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClearCacheParamTest {

	@Test
	public void testAll() {
		ClearCacheParam param = ClearCacheParam.all();
		assertEquals("all", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testAllBoolean() {
		ClearCacheParam param = ClearCacheParam.all(false);
		assertEquals("all", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testInUse() {
		ClearCacheParam param = ClearCacheParam.inUse();
		assertEquals("inuse", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testInUseBoolean() {
		ClearCacheParam param = ClearCacheParam.inUse(false);
		assertEquals("inuse", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testShared() {
		ClearCacheParam param = ClearCacheParam.shared();
		assertEquals("shared", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testSharedBoolean() {
		ClearCacheParam param = ClearCacheParam.shared(false);
		assertEquals("shared", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testIsPrivate() {
		ClearCacheParam param = ClearCacheParam.isPrivate();
		assertEquals("private", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testIsPrivateBoolean() {
		ClearCacheParam param = ClearCacheParam.isPrivate(false);
		assertEquals("private", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testKeepStorage() {
		ClearCacheParam param = ClearCacheParam.keepStorage(1);
		assertEquals("keep-storage", param.name());
	}

	@Test
	public void testWithId() {
		ClearCacheParam param = ClearCacheParam.id("test");
		assertEquals("id", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithParent() {
		ClearCacheParam param = ClearCacheParam.parent("test");
		assertEquals("parent", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithType() {
		ClearCacheParam param = ClearCacheParam.type("test");
		assertEquals("type", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithDescription() {
		ClearCacheParam param = ClearCacheParam.description("test");
		assertEquals("description", param.name());
		assertEquals("test", param.value());
	}

}
