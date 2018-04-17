package reptile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.Element;

public class XisaiReptile {

	Map<String, String> cookies;

	public void getPratice() {
		org.jsoup.Connection connect = Jsoup.connect("http://www.educity.cn/tiku/question_answer.aspx?q_id=4534");

		Map<String, String> cookies = new HashMap<String, String>();

		// cookies.put("pgv_pvid","595742920");
		// cookies.put("bdshare_firstime","1504765817601");
		// cookies.put("tikuPageView","backGroundColor","blue_1537950608246");
		// cookies.put("safedog-flow-item","");
		// cookies.put("__qc__k","");
		// cookies.put("csaiprovince","");
		// cookies.put("Hm_lvt_555d9dcffdcb317595de82b0fc125cdf","1509506839,1510305483,1510305559,1510536946");
		// cookies.put("Hm_lpvt_555d9dcffdcb317595de82b0fc125cdf","1510536961");

		cookies.put("ASP.NET_SessionId", "vk55rsq2txztfegvwi1bcnbx");
		cookies.put("__qc_wId", "292");
		cookies.put("kingwangname", "P13711373960");
		cookies.put("csaiuserid", "8354575");
		cookies.put("edu51cmmpass", "9c5cfa948a951dbc");
		// cookies.put("it119right","20");
		cookies.put("csairealname", "13711373960");
		connect.cookies(cookies);

		Document doc = null;
		try {
			doc = connect.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(doc);
	}

	public void setTestRecord() {
		org.jsoup.Connection connect = Jsoup.connect("http://www.educity.cn/tiku/paper_test.aspx?tp_id=31110");
		connect.cookies(this.getCookies());
		Document doc = null;
		try {
			doc = connect.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(doc);

	}

	public void setFavorite() {
		org.jsoup.Connection connect = Jsoup
				.connect("http://www.educity.cn/tiku/ajax/ajaxfavorite.aspx?tp_id=0&q_id=8239");
		connect.cookies(this.getCookies());

		Document doc = null;
		try {
			doc = connect.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(doc);
	}

	public void setDailyPractice() {
		try {
			org.jsoup.Connection connect = Jsoup.connect("http://www.educity.cn/tiku/dailyPractice");
			connect.cookies(this.getCookies());

			//set daily practice
			ArrayList<String> practiceList = new ArrayList<String>();
			for(int i=1; i<24; i++){
				String page = "1-".concat(String.valueOf(i));
				String practiceUrl = "http://www.educity.cn/tiku/dailyPractice".concat(page).concat(".html");
				connect.url(practiceUrl);
				Document docDailyPratices = connect.get();
				Elements dailyPractices = docDailyPratices.getElementsByClass("xyzy");
				
				for (int j = 0; j < dailyPractices.size(); j++) {
					String practicePage = dailyPractices.get(j).attr("href").toString();
					practiceList.add(practicePage.substring(2, 7));
//					break;
				}
			}
			
			
			//set favorite for every question
			String urlPractice = "http://www.educity.cn/tiku/paper_test.aspx?tp_id=";
			HashSet<String> questionSet = new HashSet<String>();
			String urlSetFavorite = "http://www.educity.cn/tiku/ajax/ajaxfavorite.aspx?";//tp_id=tpid&q_id=qid
			for(String practice : practiceList){
				ArrayList<String> questionPage = new ArrayList<String>();
				String testUrl = urlPractice.concat(practice).concat("&p=1&x=");
				connect.url(testUrl);
				Document docTest = connect.get();
				
//				Elements elementsLi =  docTest.getElementById("dt_xt_nav_1_0").getElementsByTag("ul").get(0).getElementsByTag("li");
				if(docTest.getElementsByClass("content_s").size() == 0){
					System.out.println(docTest);
					System.exit(0);
				}
				Elements elementsLi =  docTest.getElementsByClass("content_s").get(0).getElementsByTag("ul").get(0).getElementsByTag("li");
				for(org.jsoup.nodes.Element li : elementsLi){
					questionPage.add(li.attr("id").toString().replace("li_xt_", ""));
				}
				questionSet.addAll(questionPage);
				
				String urlFavoriteCurrent = urlSetFavorite.concat("tp_id=").concat(practice);
				for(String questionid : questionPage){
					connect.url(urlFavoriteCurrent.concat("&q_id=").concat(questionid));
				}
//				break;
			}
			
			//get favorite question and answer
			String urlFavorite = "http://www.educity.cn/tiku/question_answer.aspx?q_id=";
			ArrayList<String> questions = new ArrayList<String>();
			questions.addAll(questionSet);
			Collections.sort(questions);
			Iterator<String> iterator = questions.iterator();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\kl\\Desktop\\网络规划设计师收藏题目.txt"));
			
			
			while(iterator.hasNext()){
				String questionId = iterator.next();
				String urlFavoriteCurrent = urlFavorite.concat(questionId);
				connect.url(urlFavoriteCurrent);
				Document docFavorite = connect.get();
				
//				System.out.println(docFavorite);
				String question;
				ArrayList<String> images = new ArrayList<String>();
				String choice;
				String answer;
				String explain;
				
				question = docFavorite.getElementsByClass("ques_title").get(0).text();
				Elements elementImages = docFavorite.getElementsByClass("ques_title").get(0).getElementsByTag("img");
				if(!elementImages.isEmpty()){
					for(org.jsoup.nodes.Element image : elementImages){
						images.add(image.attr("src").toString());
					}
				}
				choice = docFavorite.getElementsByClass("chioce").get(0).text();
				Elements elementAnstwer = docFavorite.getElementById("analy").getElementsByAttributeValueMatching("style", "padding:12px;");
				answer = elementAnstwer.get(1).text();
				explain = elementAnstwer.get(2).text();
				
				writer.write(questionId.concat(")"));
				writer.newLine();
				writer.write(question);
				if(!images.isEmpty()){
					for(String image : images){
						writer.newLine();
						writer.write(image);
					}
				}
				writer.newLine();writer.newLine();
				writer.write(choice);
				writer.newLine();writer.newLine();
				writer.write("  answer : ".concat(answer));
				writer.newLine();
				writer.write("  explain : ".concat(explain));
				writer.newLine();writer.newLine();
				writer.write("---------------------------------------------------------------");
				writer.newLine();
//				break;
			}
			
//			System.out.println(questionSet);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println(docDailyPratices);

	}

	public void accessKnowledgePoint() {

		org.jsoup.Connection connect = Jsoup
				.connect("http://www.educity.cn/tiku/object_subclass.aspx?grade_id=2&type=News");
		connect.cookies(this.getCookies());

		Document doc = null;
		try {
			doc = connect.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(doc);
	}

	public Map<String, String> getCookies() {
		if (this.cookies == null) {
			this.cookies = new HashMap<String, String>();
			cookies.put("ASP.NET_SessionId", "vk55rsq2txztfegvwi1bcnbx");
			cookies.put("__qc_wId", "292");
			cookies.put("kingwangname", "P13711373960");
			cookies.put("csaiuserid", "8354575");
			cookies.put("edu51cmmpass", "9c5cfa948a951dbc");
			cookies.put("it119right", "10");
			cookies.put("csairealname", "13711373960");
		}
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	public static void main(String[] args) {
		XisaiReptile reptile = new XisaiReptile();
		// new XisaiReptile().getPratice();
		// new XisaiReptile().setFavorite();
		// new XisaiReptile().setTestRecord();
		// new XisaiReptile().accessKnowledgePoint();
		reptile.setDailyPractice();
	}

}
