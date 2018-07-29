package com.example.android.latestintechnews;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {

    /**
     * Builds and returns a list of Article objects extracted from a JSON response, if possible
     * NOTE TO SELF: REMOVE SAMPLE JSON STRING AND ADD String jsonResponse TO PARAMETER LIST
     */
    public static ArrayList<Article> extractArticles() {
        String jsonResponse = "{\n" +
                "   \"response\":{\n" +
                "      \"status\":\"ok\",\n" +
                "      \"userTier\":\"developer\",\n" +
                "      \"total\":35954,\n" +
                "      \"startIndex\":1,\n" +
                "      \"pageSize\":10,\n" +
                "      \"currentPage\":1,\n" +
                "      \"pages\":3596,\n" +
                "      \"orderBy\":\"newest\",\n" +
                "      \"results\":[\n" +
                "         {\n" +
                "            \"id\":\"technology/2018/jul/27/fake-news-inquiry-data-misuse-deomcracy-at-risk-mps-conclude\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"technology\",\n" +
                "            \"sectionName\":\"Technology\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T17:03:29Z\",\n" +
                "            \"webTitle\":\"Democracy at risk due to fake news and data misuse, MPs conclude\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/technology/2018/jul/27/fake-news-inquiry-data-misuse-deomcracy-at-risk-mps-conclude\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/technology/2018/jul/27/fake-news-inquiry-data-misuse-deomcracy-at-risk-mps-conclude\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/jim-waterson\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Jim Waterson\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/jim-waterson\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/jim-waterson\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Jim Waterson is the Guardian's media editor. He was previously BuzzFeed's political editor.</p>\",\n" +
                "                  \"firstName\":\"Jim \",\n" +
                "                  \"lastName\":\"Waterson\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"us-news/2018/jul/27/h1b-visas-work-permits-donald-trump-rescind-immigrants\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"us-news\",\n" +
                "            \"sectionName\":\"US news\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T15:47:58Z\",\n" +
                "            \"webTitle\":\"Trump plans to rescind work permits for spouses of immigrants on H-1B visas\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/us-news/2018/jul/27/h1b-visas-work-permits-donald-trump-rescind-immigrants\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/us-news/2018/jul/27/h1b-visas-work-permits-donald-trump-rescind-immigrants\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/sabrina-siddiqui\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Sabrina Siddiqui\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/sabrina-siddiqui\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/sabrina-siddiqui\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Sabrina Siddiqui is a political reporter for Guardian US based in Washington DC. Twitter&nbsp;<a href=\\\"https://twitter.com/sabrinasiddiqui?lang=en\\\">@SabrinaSiddiqui</a><br></p>\",\n" +
                "                  \"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2016/3/2/1456914188675/SabrinaSiddiqui.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/09/Sabrina-Siddiqui,-L.png\",\n" +
                "                  \"firstName\":\" Siddiqui\",\n" +
                "                  \"lastName\":\"Sabrina\",\n" +
                "                  \"twitterHandle\":\"SabrinaSiddiqui\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"technology/2018/jul/27/tech-firms-fear-regulation-nightmare-if-mps-get-their-way\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"technology\",\n" +
                "            \"sectionName\":\"Technology\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T15:36:27Z\",\n" +
                "            \"webTitle\":\"Tech firms fear regulation nightmare if MPs get their way\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/technology/2018/jul/27/tech-firms-fear-regulation-nightmare-if-mps-get-their-way\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/technology/2018/jul/27/tech-firms-fear-regulation-nightmare-if-mps-get-their-way\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/alex-hern\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Alex Hern\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/alex-hern\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/alex-hern\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Alex Hern is a technology reporter for the Guardian.&nbsp;</p><p>Follow Alex on Twitter<br>@alexhern</p>\",\n" +
                "                  \"bylineImageUrl\":\"https://uploads.guim.co.uk/2017/06/07/Alex-Hern.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/06/Alex_Hern,_L.png\",\n" +
                "                  \"firstName\":\"hern\",\n" +
                "                  \"lastName\":\"alex\",\n" +
                "                  \"twitterHandle\":\"alexhern\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"society/2018/jul/27/stop-juul-e-cigarette-from-taking-off-among-kids-uk-told\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"society\",\n" +
                "            \"sectionName\":\"Society\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T15:34:07Z\",\n" +
                "            \"webTitle\":\"Stop 'super-cool' e-cigarette from taking off among kids, UK told\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/society/2018/jul/27/stop-juul-e-cigarette-from-taking-off-among-kids-uk-told\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/society/2018/jul/27/stop-juul-e-cigarette-from-taking-off-among-kids-uk-told\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/sarahboseley\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Sarah Boseley\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/sarahboseley\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/sarahboseley\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Sarah Boseley is the <a href=\\\"http://www.guardian.co.uk/society/health\\\">health editor of the Guardian</a>. She has won a number of awards for her work on HIV/Aids in Africa, including the One World Media award (twice) and the European section of the Lorenzo Natali prize, awarded by the European commission. She is also the author of <a href=\\\"http://bookshop.theguardian.com/shape-we-re-in.html\\\">The Shape We're In: How Junk Food and Diets Are Shortening Our Lives</a>, published by Guardian Faber</p>\",\n" +
                "                  \"bylineImageUrl\":\"https://uploads.guim.co.uk/2017/12/27/Sarah-Boseley.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/12/27/Sarah_Boseley,_R.png\",\n" +
                "                  \"firstName\":\"Sarah\",\n" +
                "                  \"lastName\":\"Boseley\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"lifeandstyle/lostinshowbiz/2018/jul/27/ban-fat-shaming-show-insatiable-netflix-its-critics-cry-but-none-of-them-have-seen-it\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"lifeandstyle\",\n" +
                "            \"sectionName\":\"Life and style\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T06:00:04Z\",\n" +
                "            \"webTitle\":\"Ban fat-shaming show Insatiable, its critics cry. But none of them have seen it\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/lifeandstyle/lostinshowbiz/2018/jul/27/ban-fat-shaming-show-insatiable-netflix-its-critics-cry-but-none-of-them-have-seen-it\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/lifeandstyle/lostinshowbiz/2018/jul/27/ban-fat-shaming-show-insatiable-netflix-its-critics-cry-but-none-of-them-have-seen-it\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/marinahyde\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Marina Hyde\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/marinahyde\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/marinahyde\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Marina Hyde is a Guardian columnist. Twitter <a href=\\\"https://twitter.com/MarinaHyde\\\">@MarinaHyde</a></p>\",\n" +
                "                  \"bylineImageUrl\":\"https://uploads.guim.co.uk/2018/01/10/Marina-Hyde.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2018/01/10/Marina_Hyde,_L.png\",\n" +
                "                  \"firstName\":\"Marina\",\n" +
                "                  \"lastName\":\"Hyde\",\n" +
                "                  \"twitterHandle\":\"MarinaHyde\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/lifestyle\",\n" +
                "            \"pillarName\":\"Lifestyle\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"environment/bike-blog/2018/jul/27/londons-tory-mayoral-candidates-are-stuck-in-the-past-on-cycling\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"environment\",\n" +
                "            \"sectionName\":\"Environment\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T06:00:04Z\",\n" +
                "            \"webTitle\":\"London's Tory mayoral candidates are stuck in the past on cycling\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/environment/bike-blog/2018/jul/27/londons-tory-mayoral-candidates-are-stuck-in-the-past-on-cycling\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/environment/bike-blog/2018/jul/27/londons-tory-mayoral-candidates-are-stuck-in-the-past-on-cycling\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/peterwalker\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Peter Walker\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/peterwalker\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/peterwalker\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Peter Walker is a political correspondent for the Guardian and author of Bike Nation: How Cycling Can Save the World</p>\",\n" +
                "                  \"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2007/09/28/peter_walker_140x140.jpg\",\n" +
                "                  \"firstName\":\"walker\",\n" +
                "                  \"lastName\":\"\",\n" +
                "                  \"twitterHandle\":\"peterwalker99\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"news/2018/jul/27/english-language-global-dominance\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"news\",\n" +
                "            \"sectionName\":\"News\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T05:00:03Z\",\n" +
                "            \"webTitle\":\"Behemoth, bully, thief: how the English language is taking over the planet\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/news/2018/jul/27/english-language-global-dominance\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/news/2018/jul/27/english-language-global-dominance\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/jacob-mikanowski\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Jacob Mikanowski\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/jacob-mikanowski\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/jacob-mikanowski\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Jacob Mikanowski is a freelance journalist and critic based in Berkeley, California</p>\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"media/2018/jul/26/what-is-shadow-banning-conservatives-twitter-trump\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"media\",\n" +
                "            \"sectionName\":\"Media\",\n" +
                "            \"webPublicationDate\":\"2018-07-27T01:22:02Z\",\n" +
                "            \"webTitle\":\"What is 'shadow banning', and why did Trump tweet about it?\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/media/2018/jul/26/what-is-shadow-banning-conservatives-twitter-trump\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/media/2018/jul/26/what-is-shadow-banning-conservatives-twitter-trump\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/wilson-jason\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Jason Wilson\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/wilson-jason\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/wilson-jason\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Jason Wilson is an Australian-born writer living in Portland, Oregon. Twitter&nbsp;<a href=\\\"https://twitter.com/jason_a_w\\\">@jason_a_w</a></p>\",\n" +
                "                  \"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/contributor/2014/11/24/1416835880685/Jason-Wilson.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/06/Jason-Wilson,-L.png\",\n" +
                "                  \"firstName\":\"Jason\",\n" +
                "                  \"lastName\":\"Wilson\",\n" +
                "                  \"twitterHandle\":\"jason_a_w\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"technology/2018/jul/26/amazon-profit-second-quarter-2018-advertising-cloud\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"technology\",\n" +
                "            \"sectionName\":\"Technology\",\n" +
                "            \"webPublicationDate\":\"2018-07-26T22:55:10Z\",\n" +
                "            \"webTitle\":\"Amazon posts record $2.5bn profit fueled by ad and cloud businesses\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/technology/2018/jul/26/amazon-profit-second-quarter-2018-advertising-cloud\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/technology/2018/jul/26/amazon-profit-second-quarter-2018-advertising-cloud\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/julia-carrie-wong\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Julia Carrie Wong\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/julia-carrie-wong\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/julia-carrie-wong\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Julia Carrie Wong is a technology reporter for Guardian US, based in San Francisco. <a href=\\\"https://pgp.theguardian.com/PublicKeys/Julia%20Wong.pub.txt\\\">Click here </a>for Julia 's public key. Twitter&nbsp;<a href=\\\"https://twitter.com/juliacarriew?lang=en\\\">@julliacarriew</a></p>\",\n" +
                "                  \"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2016/2/17/1455718053374/JuliaCarrieWong.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/06/Julia-Carrie-Wong,-L.png\",\n" +
                "                  \"firstName\":\"Julia Carrie\",\n" +
                "                  \"lastName\":\"Wong\",\n" +
                "                  \"emailAddress\":\"julia.wong@theguardian.com\",\n" +
                "                  \"twitterHandle\":\"juliacarriew\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/news\",\n" +
                "            \"pillarName\":\"News\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"id\":\"tv-and-radio/2018/jul/26/the-big-life-fix-review-can-tech-hipsters-help-a-disabled-man-snowboard-again\",\n" +
                "            \"type\":\"article\",\n" +
                "            \"sectionId\":\"tv-and-radio\",\n" +
                "            \"sectionName\":\"Television & radio\",\n" +
                "            \"webPublicationDate\":\"2018-07-26T20:00:46Z\",\n" +
                "            \"webTitle\":\"The Big Life Fix review â€“ can tech hipsters help a disabled man snowboard again?\",\n" +
                "            \"webUrl\":\"https://www.theguardian.com/tv-and-radio/2018/jul/26/the-big-life-fix-review-can-tech-hipsters-help-a-disabled-man-snowboard-again\",\n" +
                "            \"apiUrl\":\"https://content.guardianapis.com/tv-and-radio/2018/jul/26/the-big-life-fix-review-can-tech-hipsters-help-a-disabled-man-snowboard-again\",\n" +
                "            \"tags\":[\n" +
                "               {\n" +
                "                  \"id\":\"profile/samwollaston\",\n" +
                "                  \"type\":\"contributor\",\n" +
                "                  \"webTitle\":\"Sam Wollaston\",\n" +
                "                  \"webUrl\":\"https://www.theguardian.com/profile/samwollaston\",\n" +
                "                  \"apiUrl\":\"https://content.guardianapis.com/profile/samwollaston\",\n" +
                "                  \"references\":[\n" +
                "\n" +
                "                  ],\n" +
                "                  \"bio\":\"<p>Sam Wollaston is <a href=\\\"http://www.theguardian.com/culture/television\\\">TV critic for the Guardian</a>. You can follow him on Twitter at <a href=\\\"https://twitter.com/samwollaston\\\">@samwollaston</a></p>\",\n" +
                "                  \"bylineImageUrl\":\"https://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2014/4/17/1397749339384/SamWollaston.jpg\",\n" +
                "                  \"bylineLargeImageUrl\":\"https://uploads.guim.co.uk/2017/10/09/Sam-Wollaston,-L.png\",\n" +
                "                  \"firstName\":\"wollaston\",\n" +
                "                  \"lastName\":\"\",\n" +
                "                  \"twitterHandle\":\"samwollaston\"\n" +
                "               }\n" +
                "            ],\n" +
                "            \"isHosted\":false,\n" +
                "            \"pillarId\":\"pillar/arts\",\n" +
                "            \"pillarName\":\"Arts\"\n" +
                "         }\n" +
                "      ]\n" +
                "   }\n" +
                "}";

        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }

        ArrayList<Article> articles = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(jsonResponse);
            JSONObject response = root.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");

            for (int i = 0; i < results.length(); i++){
                JSONObject article = results.getJSONObject(i);
                String section = article.getString("sectionName");
                String publishDate = article.getString("webPublicationDate");
                String title = article.getString("webTitle");
                String url = article.getString("webUrl");
                JSONArray tags = article.getJSONArray("tags");
                String authorString = "Unknown";

                if(!tags.isNull(0)){
                    StringBuilder authorSB = new StringBuilder();
                    for (int j = 0; j < tags.length(); j++){
                        JSONObject author = tags.optJSONObject(j);
                        String authorName = author.getString("webTitle");
                        authorSB.append(authorName);
                        if (j < tags.length() - 1) {
                            authorSB.insert(authorName.length(), ", ");
                        }
                    }
                    authorString = authorSB.toString();
                }
                articles.add(new Article(title, section, url, authorString, publishDate));
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing JSON results", e);
        }

        return articles;
    }
}
