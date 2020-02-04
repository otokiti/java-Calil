package com.xrea.s8.otokiti.calil.entity;

/**
 * 蔵書情報.
 */
public final class BookEntity {

	// 書名
	private String title;
	// 出版社
	private String publisher;
	// ISBN
	private String isbn;
	// 出版年月日
	private String publicationDate;

	/**
	 * 書名の取得.
	 *
	 * @return 書名
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 書名の設定.
	 *
	 * @param title 書名
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * 出版社の取得.
	 *
	 * @return 出版社
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * 出版社の設定.
	 *
	 * @param publisher 出版社
	 */
	public void setPublisher(final String publisher) {
		this.publisher = publisher;
	}

	/**
	 * ISBNの取得.
	 *
	 * @return ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * ISBNの設定.
	 *
	 * @param isbn ISBN
	 */
	public void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 出版年月日の取得.
	 *
	 * @return 出版年月日
	 */
	public String getPublicationDate() {
		return publicationDate;
	}

	/**
	 * 出版年月日の設定.
	 *
	 * @param publicationDate 出版年月日
	 */
	public void setPublicationDate(final String publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((publicationDate == null) ? 0 : publicationDate.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
