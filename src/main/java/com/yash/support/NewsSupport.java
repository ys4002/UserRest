package com.yash.support;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.yash.model.Agency;
import com.yash.model.AgencyFeed;
import com.yash.model.ApiResponse;
import com.yash.model.Category;
import com.yash.model.FeedData;
import com.yash.model.News;
import com.yash.service.service.MasterService;

/**
 * Support class with util methods
 * 
 * @author Yash
 *
 */

@Component
public class NewsSupport extends MasterService implements ISupport {
	
	public static List<String> categories = new ArrayList<String>();

	public void updateFeed(List<FeedData> data) {
		for (FeedData feed : data) {
			Category category = categoryService.findByCategoryTitle(feed.getCategory());
			category = category == null ? new Category(feed.getCategory()) : category;

			Agency agency = agencyService.findByAgencyName(feed.getAgency());
			agency = agency == null ? new Agency(feed.getAgency()) : agency;

			readFeed(feed.getUrl(), agency, category);
		}

	}

	private void readFeed(String url, Agency agency, Category category) {
		try {

			try (XmlReader reader = new XmlReader(new URL(url))) {

				SyndFeed feed = new SyndFeedInput().build(reader);
				agency.setAgencyLogo(feed.getImage().getUrl());

				agency = agencyService.save(agency);
				category = categoryService.save(category);
				AgencyFeed agencyFeed = agencyFeedService.findByAgencyRefAndCategoryRef(agency, category);
				agencyFeed = agencyFeed == null ? new AgencyFeed(url, agency, category) : agencyFeed;
				agencyFeed.setAgencyFeedUrl(url);
				agencyFeedService.save(agencyFeed);
				News news = null;
				for (SyndEntry entry : feed.getEntries()) {
					news = new News(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate(),
							entry.getLink(), agency, category);
					newsService.save(news);
				}
				System.out.println("Done");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateDatabase() {
		List<AgencyFeed> feedData = agencyFeedService.findAll();

		for (AgencyFeed data : feedData) {
			try {

				try (XmlReader reader = new XmlReader(new URL(data.getAgencyFeedUrl()))) {

					SyndFeed feed = new SyndFeedInput().build(reader);
					News news = null;
					for (SyndEntry entry : feed.getEntries()) {
						news = new News(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate(),
								entry.getLink(), data.getAgencyRef(), data.getCategoryRef());
						newsService.save(news);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (categories.size() > 0) {
			messagingTemplate
					.convertAndSend("/topic/reply", new ApiResponse<>(HttpStatus.OK.value(), "News Data",newsService.getNewsByCategory(categories)));

	
		}
	}
}
