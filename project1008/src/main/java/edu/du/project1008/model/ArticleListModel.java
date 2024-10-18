package edu.du.project1008.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListModel {

	private List<Article> articleList = Collections.emptyList();
	private int requestPage;
	private int totalPageCount;
	private int startRow;
	private int endRow;

	public boolean isHasArticle() {
		return !articleList.isEmpty();
	}
}
