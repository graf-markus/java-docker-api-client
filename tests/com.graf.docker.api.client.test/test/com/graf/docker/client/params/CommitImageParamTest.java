package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommitImageParamTest {

	@Test
	public void testContainer() {
		CommitImageParam param = CommitImageParam.container("test");
		assertEquals("container", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testRepo() {
		CommitImageParam param = CommitImageParam.repo("test");
		assertEquals("repo", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testTag() {
		CommitImageParam param = CommitImageParam.tag("test");
		assertEquals("tag", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testComment() {
		CommitImageParam param = CommitImageParam.comment("test");
		assertEquals("comment", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testAuthor() {
		CommitImageParam param = CommitImageParam.author("test");
		assertEquals("author", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testPause() {
		CommitImageParam param = CommitImageParam.pause();
		assertEquals("pause", param.name());
		assertEquals("true", param.value());
	}

	@Test
	public void testPauseBoolean() {
		CommitImageParam param = CommitImageParam.pause(false);
		assertEquals("pause", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testChanges() {
		CommitImageParam param = CommitImageParam.changes("test");
		assertEquals("changes", param.name());
		assertEquals("test", param.value());
	}

}
