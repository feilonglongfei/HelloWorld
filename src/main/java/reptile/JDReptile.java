/**
 * 
 */
package reptile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author kl
 *
 */
public class JDReptile {
	
	private Map<String, String> cookies;
	org.jsoup.Connection connect = Jsoup.connect("https://trade.jd.com/shopping/order/getOrderInfo.action");

	public void getOrderList(){
		connect.url("https://order.jd.com/center/list.action");
		connect.cookies(this.getCookies());

		Document doc = this.getConnection(connect);
		System.out.println(doc);
	}
	
	public void getShopCarList(){
		connect.url("https://cart.jd.com/cart.action");
		connect.cookies(this.getCookies());

		Document doc = this.getConnection(connect);
		System.out.println(doc);
	}

	
	
	
		
	public void getOrderInfo(){
		connect.url("https://trade.jd.com/shopping/order/getOrderInfo.action");
		connect.cookies(this.getCookies());

		Document doc = this.getConnection(connect);
		System.out.println(doc);
	}
	
	public void submitOrder(){
		connect.url("https://order.jd.com/order/submitOrder.action");
		
		connect.cookies(this.getCookies());

		Document doc = this.getConnection(connect);
		System.out.println(doc);
		
	}
	
	public Document getConnection(Connection connect){
		try {
			return connect.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JDReptile jdReptile = new JDReptile();
//		jdReptile.getOrderList();
//		jdReptile.getShopCarList();
//		jdReptile.getOrderInfo();
		jdReptile.submitOrder();
	}

	public Map<String, String> getCookies() {
		if(this.cookies == null){
		this.cookies = new HashMap<String, String>();
		cookies.put("areaId", "19");
		cookies.put("mobilev", "html5");
		cookies.put("visitkey", "65199731072367559");
		cookies.put("mba_muid", "15047439754161492625836");
		cookies.put("unpl", "V2_ZzNsbUJfS0JwDxRVZxEOAjMfF14SV18cJV9BSH9LWVBnCkdaQlEUE2lJKFZ7GVQ1ZAISW15XQwl1CldVcxJcAWwHF21CZ0MUdAlEVH0QXANXMyJdQGdCJXUMR1F9HF4NYQcXXUVXRh12D0VQchtbNWMCG14VU0cWaVgTBH4FWQU0VA5VEVMQCXYMT1J7S1pVNQtACnJXRx0%3D");
		cookies.put("__jdv", "122270672|kong|t_1000317817_|adrealizable|199f46c0-9c6e-42a1-8af6-5c4d18d617f7-p_3119|1510535755223");
		cookies.put("_contrast_status", "side");
		cookies.put("mt_xid", "V2_52007VwMWU1heV1gXTx1ZBWADF1peX1FeFksebFI3ChNaDQ0CRhoeHwsZYgJBB0EIUl8fVU1fAmEERlNbXVcNHHkaXQVhHxJSQVhWSx9MEl0CbAMXYl9oUmofShxcDWMHF1ttWFReGw%3D%3D");
		cookies.put("wlfstk_smdl", "zhawfgqlmcxqoee3dla10rpsueczes6e");
		cookies.put("_jrda", "5");
		cookies.put("TrackID", "17WcZ31G4aYkWqoX5WS6U_V-_XV4X89PJs8Iw97crONyIfMZIvnFspDAS1uC0SKy-Axz_Wrz6_ZCPFhKR_XC9J--p_hmVrxdVmatCYZj03WM");
		cookies.put("pinId", "Yu0PyH1JH2bQ7VSURZ8jOA");
		cookies.put("pin", "feilonglongfei");
		cookies.put("unick", "-%E6%B4%9B-%E6%B4%9B-");
		cookies.put("_tp", "SQWgb8EkkOauca0mIG8SJA%3D%3D");
		cookies.put("_pst", "feilonglongfei");
		cookies.put("ceshi3.com", "201");
		cookies.put("ipLocation", "%u5e7f%u4e1c");
		cookies.put("cn", "32");
		cookies.put("ipLoc-djd", "19-1601-3633-0.138304596");
		cookies.put("_distM", "64823131446");
		cookies.put("thor", "0A360801134E166C3E7F18FE1F3E56390CA97431137348D3E023AB073BC90728B5776D685AFE4A4D147141322610693F474386DCD62382E0DD35590188F42FEC157635D206D9EE8256A08E7D6657DEDBCFC397684CF19C5C3609E1B1CFF19171421D37084320BD981D59A0A8AEA42684A981E8CF7A5A8A38D2F1AAE2FCD774B4DA31D123691F7B20BACA0A3FAD5EC1FA");
		cookies.put("__jda", "122270672.15047439754161492625836.1504743975.1510878607.1510886814.46");
		cookies.put("__jdb", "122270672.3.15047439754161492625836|46.1510886814");
		cookies.put("__jdc", "122270672");
		cookies.put("3AB9D23F7A4B3C9B", "NSKUNDPFQ7PN6GIQYBH42NSLVB3VFGHSLETWEQANNGEZHCIXLZKPDBG4E6JWWPWN43AP6CNFIC5BW3T22KLY4IMDOU");
		cookies.put("__jdu", "15047439754161492625836");
		}
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

}
