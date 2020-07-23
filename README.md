This is the Rest Service with following Implementation:
1. Register user through /signup
2. Login to application which returns a token
3. Read FeedData -> Agency, Category, Feed Url
4. Insert into Agency, Category, AgencyFeed and News table -> Login required and token is validated
5. If Token not present then Unauthorized response returned
6. A TimerTask is started as soon as the application starts which Refreshes the News tables by pulling Rss FeedData from the AgencyFeed table.
7. News with unique links are stored. (TimerTask works at every 5 mins)
8. Rest Api for various News and Category related transactions like:
	-Fetch all categories
	-Fetch all news
	-update particular news clickCount
	-fetch news by category