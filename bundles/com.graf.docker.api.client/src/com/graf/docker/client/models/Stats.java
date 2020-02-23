package com.graf.docker.client.models;

import java.math.BigInteger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Stats {

	@SerializedName("active_file")
	private long activeFile;
	@SerializedName("total_active_file")
	private long totalActiveFile;
	@SerializedName("inactive_file")
	private long inactiveFile;
	@SerializedName("total_inactive_file")
	private long totalInactiveFile;
	@SerializedName("cache")
	private long cache;
	@SerializedName("total_cache")
	private long totalCache;
	@SerializedName("active_anon")
	private long activeAnon;
	@SerializedName("total_active_anon")
	private long totalActiveAnon;
	@SerializedName("inactive_anon")
	private long inactiveAnon;
	@SerializedName("total_inactive_anon")
	private long totalInactiveAnon;
	@SerializedName("hierarchical_memory_limit")
	private BigInteger hierarchicalMemoryLimit;
	@SerializedName("mapped_file")
	private long mappedFile;
	@SerializedName("total_mapped_file")
	private long totalMappedFile;
	@SerializedName("pgmajfault")
	private long pgmajfault;
	@SerializedName("total_pgmajfault")
	private long totalPgmajfault;
	@SerializedName("pgpgin")
	private long pgpgin;
	@SerializedName("total_pgpgin")
	private long totalPgpgin;
	@SerializedName("pgpgout")
	private long pgpgout;
	@SerializedName("total_pgpgout")
	private long totalPgpgout;
	@SerializedName("pgfault")
	private long pgfault;
	@SerializedName("total_pgfault")
	private long totalPgfault;
	@SerializedName("rss")
	private long rss;
	@SerializedName("total_rss")
	private long totalRss;
	@SerializedName("rss_huge")
	private long rssHuge;
	@SerializedName("total_rss_huge")
	private long totalRssHuge;
	@SerializedName("unevictable")
	private long unevictable;
	@SerializedName("total_unevictable")
	private long totalUnevictable;
	@SerializedName("total_writeback")
	private long totalWriteback;
	@SerializedName("writeback")
	private long writeback;

	public long getActiveFile() {
		return activeFile;
	}

	public long getTotalActiveFile() {
		return totalActiveFile;
	}

	public long getInactiveFile() {
		return inactiveFile;
	}

	public long getTotalInactiveFile() {
		return totalInactiveFile;
	}

	public long getCache() {
		return cache;
	}

	public long getTotalCache() {
		return totalCache;
	}

	public long getActiveAnon() {
		return activeAnon;
	}

	public long getTotalActiveAnon() {
		return totalActiveAnon;
	}

	public long getInactiveAnon() {
		return inactiveAnon;
	}

	public long getTotalInactiveAnon() {
		return totalInactiveAnon;
	}

	public BigInteger getHierarchicalMemoryLimit() {
		return hierarchicalMemoryLimit;
	}

	public long getMappedFile() {
		return mappedFile;
	}

	public long getTotalMappedFile() {
		return totalMappedFile;
	}

	public long getPgmajfault() {
		return pgmajfault;
	}

	public long getTotalPgmajfault() {
		return totalPgmajfault;
	}

	public long getPgpgin() {
		return pgpgin;
	}

	public long getTotalPgpgin() {
		return totalPgpgin;
	}

	public long getPgpgout() {
		return pgpgout;
	}

	public long getTotalPgpgout() {
		return totalPgpgout;
	}

	public long getPgfault() {
		return pgfault;
	}

	public long getTotalPgfault() {
		return totalPgfault;
	}

	public long getRss() {
		return rss;
	}

	public long getTotalRss() {
		return totalRss;
	}

	public long getRssHuge() {
		return rssHuge;
	}

	public long getTotalRssHuge() {
		return totalRssHuge;
	}

	public long getUnevictable() {
		return unevictable;
	}

	public long getTotalUnevictable() {
		return totalUnevictable;
	}

	public long getTotalWriteback() {
		return totalWriteback;
	}

	public long getWriteback() {
		return writeback;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
