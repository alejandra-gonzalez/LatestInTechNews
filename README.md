# LatestInTechNews

This Android app uses a Loader to query The Guardian's API for news stories. Preferences are used to allow the user to sort and filter the stories that they wish to view.

Created for Udacity's Android Basics Nanodegree program. Check lists are derived from the project rubrics provided by Udacity.

## Stage 1 Check List
- [x] Main Activity that displays multiple news stories
- [x] Each list item displays the article's title, the section it belongs to, author name, and published date (the last two may not be available)
- [x] Whenever new news data is fetched from the API, the stories in the Main Activity are properly updated
- [x] Clicking on a news story opens the story on the user's browser
- [x] App queries The Guardian's API
- [x] The JSON response is parsed and relevant information is stored in the app
- [x] Empty View is present
- [x] App checks if the device is connected to the internet and responds appropriately
- [x] Networking operations are executed using a Loader

## Stage 2 Check List
- [x] Settings Activity is accessed from the Main Activity via a navigation drawer or from the toolbar menu
- [x] The current value of the preference is displayed below the preference itself
- [x] If the value of the preference is changed, then the value below the preference is updated immediately
- [x] All Strings are stored in the strings.xml file
