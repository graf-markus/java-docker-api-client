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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private long activeFile;
		private long totalActiveFile;
		private long inactiveFile;
		private long totalInactiveFile;
		private long cache;
		private long totalCache;
		private long activeAnon;
		private long totalActiveAnon;
		private long inactiveAnon;
		private long totalInactiveAnon;
		private BigInteger hierarchicalMemoryLimit;
		private long mappedFile;
		private long totalMappedFile;
		private long pgmajfault;
		private long totalPgmajfault;
		private long pgpgin;
		private long totalPgpgin;
		private long pgpgout;
		private long totalPgpgout;
		private long pgfault;
		private long totalPgfault;
		private long rss;
		private long totalRss;
		private long rssHuge;
		private long totalRssHuge;
		private long unevictable;
		private long totalUnevictable;
		private long totalWriteback;
		private long writeback;

		public Builder() {
		}

		Builder(long activeFile, long totalActiveFile, long inactiveFile, long totalInactiveFile, long cache,
				long totalCache, long activeAnon, long totalActiveAnon, long inactiveAnon, long totalInactiveAnon,
				BigInteger hierarchicalMemoryLimit, long mappedFile, long totalMappedFile, long pgmajfault,
				long totalPgmajfault, long pgpgin, long totalPgpgin, long pgpgout, long totalPgpgout, long pgfault,
				long totalPgfault, long rss, long totalRss, long rssHuge, long totalRssHuge, long unevictable,
				long totalUnevictable, long totalWriteback, long writeback) {
			this.activeFile = activeFile;
			this.totalActiveFile = totalActiveFile;
			this.inactiveFile = inactiveFile;
			this.totalInactiveFile = totalInactiveFile;
			this.cache = cache;
			this.totalCache = totalCache;
			this.activeAnon = activeAnon;
			this.totalActiveAnon = totalActiveAnon;
			this.inactiveAnon = inactiveAnon;
			this.totalInactiveAnon = totalInactiveAnon;
			this.hierarchicalMemoryLimit = hierarchicalMemoryLimit;
			this.mappedFile = mappedFile;
			this.totalMappedFile = totalMappedFile;
			this.pgmajfault = pgmajfault;
			this.totalPgmajfault = totalPgmajfault;
			this.pgpgin = pgpgin;
			this.totalPgpgin = totalPgpgin;
			this.pgpgout = pgpgout;
			this.totalPgpgout = totalPgpgout;
			this.pgfault = pgfault;
			this.totalPgfault = totalPgfault;
			this.rss = rss;
			this.totalRss = totalRss;
			this.rssHuge = rssHuge;
			this.totalRssHuge = totalRssHuge;
			this.unevictable = unevictable;
			this.totalUnevictable = totalUnevictable;
			this.totalWriteback = totalWriteback;
			this.writeback = writeback;
		}

		public Builder activeFile(long activeFile) {
			this.activeFile = activeFile;
			return Builder.this;
		}

		public Builder totalActiveFile(long totalActiveFile) {
			this.totalActiveFile = totalActiveFile;
			return Builder.this;
		}

		public Builder inactiveFile(long inactiveFile) {
			this.inactiveFile = inactiveFile;
			return Builder.this;
		}

		public Builder totalInactiveFile(long totalInactiveFile) {
			this.totalInactiveFile = totalInactiveFile;
			return Builder.this;
		}

		public Builder cache(long cache) {
			this.cache = cache;
			return Builder.this;
		}

		public Builder totalCache(long totalCache) {
			this.totalCache = totalCache;
			return Builder.this;
		}

		public Builder activeAnon(long activeAnon) {
			this.activeAnon = activeAnon;
			return Builder.this;
		}

		public Builder totalActiveAnon(long totalActiveAnon) {
			this.totalActiveAnon = totalActiveAnon;
			return Builder.this;
		}

		public Builder inactiveAnon(long inactiveAnon) {
			this.inactiveAnon = inactiveAnon;
			return Builder.this;
		}

		public Builder totalInactiveAnon(long totalInactiveAnon) {
			this.totalInactiveAnon = totalInactiveAnon;
			return Builder.this;
		}

		public Builder hierarchicalMemoryLimit(BigInteger hierarchicalMemoryLimit) {
			this.hierarchicalMemoryLimit = hierarchicalMemoryLimit;
			return Builder.this;
		}

		public Builder mappedFile(long mappedFile) {
			this.mappedFile = mappedFile;
			return Builder.this;
		}

		public Builder totalMappedFile(long totalMappedFile) {
			this.totalMappedFile = totalMappedFile;
			return Builder.this;
		}

		public Builder pgmajfault(long pgmajfault) {
			this.pgmajfault = pgmajfault;
			return Builder.this;
		}

		public Builder totalPgmajfault(long totalPgmajfault) {
			this.totalPgmajfault = totalPgmajfault;
			return Builder.this;
		}

		public Builder pgpgin(long pgpgin) {
			this.pgpgin = pgpgin;
			return Builder.this;
		}

		public Builder totalPgpgin(long totalPgpgin) {
			this.totalPgpgin = totalPgpgin;
			return Builder.this;
		}

		public Builder pgpgout(long pgpgout) {
			this.pgpgout = pgpgout;
			return Builder.this;
		}

		public Builder totalPgpgout(long totalPgpgout) {
			this.totalPgpgout = totalPgpgout;
			return Builder.this;
		}

		public Builder pgfault(long pgfault) {
			this.pgfault = pgfault;
			return Builder.this;
		}

		public Builder totalPgfault(long totalPgfault) {
			this.totalPgfault = totalPgfault;
			return Builder.this;
		}

		public Builder rss(long rss) {
			this.rss = rss;
			return Builder.this;
		}

		public Builder totalRss(long totalRss) {
			this.totalRss = totalRss;
			return Builder.this;
		}

		public Builder rssHuge(long rssHuge) {
			this.rssHuge = rssHuge;
			return Builder.this;
		}

		public Builder totalRssHuge(long totalRssHuge) {
			this.totalRssHuge = totalRssHuge;
			return Builder.this;
		}

		public Builder unevictable(long unevictable) {
			this.unevictable = unevictable;
			return Builder.this;
		}

		public Builder totalUnevictable(long totalUnevictable) {
			this.totalUnevictable = totalUnevictable;
			return Builder.this;
		}

		public Builder totalWriteback(long totalWriteback) {
			this.totalWriteback = totalWriteback;
			return Builder.this;
		}

		public Builder writeback(long writeback) {
			this.writeback = writeback;
			return Builder.this;
		}

		public Stats build() {

			return new Stats(this);
		}
	}

	private Stats(Builder builder) {
		this.activeFile = builder.activeFile;
		this.totalActiveFile = builder.totalActiveFile;
		this.inactiveFile = builder.inactiveFile;
		this.totalInactiveFile = builder.totalInactiveFile;
		this.cache = builder.cache;
		this.totalCache = builder.totalCache;
		this.activeAnon = builder.activeAnon;
		this.totalActiveAnon = builder.totalActiveAnon;
		this.inactiveAnon = builder.inactiveAnon;
		this.totalInactiveAnon = builder.totalInactiveAnon;
		this.hierarchicalMemoryLimit = builder.hierarchicalMemoryLimit;
		this.mappedFile = builder.mappedFile;
		this.totalMappedFile = builder.totalMappedFile;
		this.pgmajfault = builder.pgmajfault;
		this.totalPgmajfault = builder.totalPgmajfault;
		this.pgpgin = builder.pgpgin;
		this.totalPgpgin = builder.totalPgpgin;
		this.pgpgout = builder.pgpgout;
		this.totalPgpgout = builder.totalPgpgout;
		this.pgfault = builder.pgfault;
		this.totalPgfault = builder.totalPgfault;
		this.rss = builder.rss;
		this.totalRss = builder.totalRss;
		this.rssHuge = builder.rssHuge;
		this.totalRssHuge = builder.totalRssHuge;
		this.unevictable = builder.unevictable;
		this.totalUnevictable = builder.totalUnevictable;
		this.totalWriteback = builder.totalWriteback;
		this.writeback = builder.writeback;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
